/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.posttest1_pbo;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class mainjadwalolahraga {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String[]> jadwalOlahraga = new ArrayList<>();
        int pilihan;

        do {
            System.out.println("\n|=========================================|");
            System.out.println("|    Manajemen Jadwal Olahraga Pribadi    |");
            System.out.println("|=========================================|");
            System.out.println("| [1]. Tambah Jadwal Olahraga             |");
            System.out.println("| [2]. Lihat Jadwal Olahraga              |");
            System.out.println("| [3]. Update Jadwal Olahraga             |");
            System.out.println("| [4]. Hapus Jadwal Olahraga              |");
            System.out.println("| [5]. Keluar                             |");
            System.out.println("|=========================================|");
            System.out.print("Pilih menu (1/2/3/4/5): ");
            String inputMenu = input.nextLine();
            try {
                pilihan = Integer.parseInt(inputMenu);
            } catch (NumberFormatException e) {
                pilihan = -1;
            }

            switch (pilihan) {
                case 1:
                    // Menambah Jadwal
                    System.out.print("Masukkan Jenis Olahraga : ");
                    String jenis = input.nextLine();
                    System.out.print("Masukkan Durasi (contoh: 30 menit) : ");
                    String durasi = input.nextLine();
                    System.out.print("Masukkan Hari : ");
                    String hari = input.nextLine();

                    String[] dataBaru = {jenis, durasi, hari};
                    jadwalOlahraga.add(dataBaru);
                    System.out.println("==== Jadwal olahraga berhasil ditambahkan! ====");
                    break;

                case 2:
                    // Melihat Jadwal
                    System.out.println("\n|=========================================|");
                    System.out.println("|         Daftar Jadwal Olahraga          |");
                    System.out.println("|=========================================|");
                    if (jadwalOlahraga.isEmpty()) {
                        System.out.println("Belum ada jadwal yang tersimpan.");
                    } else {
                        for (int i = 0; i < jadwalOlahraga.size(); i++) {
                            String[] data = jadwalOlahraga.get(i);
                            System.out.println((i + 1) + ". " + data[0] + " | " + data[1] + " | " + data[2]);
                        }
                    }
                    break;

                case 3:
                    // Mengupdate Jadwal
                    System.out.print("Masukkan nomor jadwal yang akan diupdate: ");
                    String inputIdx = input.nextLine(); 
                    int idxUpdate;
                    
                    try {
                        idxUpdate = Integer.parseInt(inputIdx) - 1; 
                    } catch (NumberFormatException e) {
                        System.out.println("Input harus berupa angka!");
                        break; 
                    }
                    if (idxUpdate >= 0 && idxUpdate < jadwalOlahraga.size()) {
                        System.out.print("Masukkan Jenis Olahraga baru : ");
                        String jenisBaru = input.nextLine();
                        System.out.print("Masukkan Durasi baru : ");
                        String durasiBaru = input.nextLine();
                        System.out.print("Masukkan Hari baru : ");
                        String hariBaru = input.nextLine();

                        String[] dataUpdate = {jenisBaru, durasiBaru, hariBaru};
                        jadwalOlahraga.set(idxUpdate, dataUpdate);
                        System.out.println("==== Jadwal berhasil diupdate! ====");
                    } else {
                        System.out.println("Nomor tidak valid / tidak ada.");
                    }
                    break;

                case 4:
                    // Menghapus Jadwal
                    System.out.print("Masukkan nomor jadwal yang akan dihapus: ");
                    String inputIdxHapus = input.nextLine();
                    int idxHapus;
                    
                    try {
                        idxHapus = Integer.parseInt(inputIdxHapus) - 1; 
                    } catch (NumberFormatException e) {
                        System.out.println("Input harus berupa angka!");
                        break; 
                    }
                    if (idxHapus >= 0 && idxHapus < jadwalOlahraga.size()) {
                        jadwalOlahraga.remove(idxHapus);
                        System.out.println("==== Jadwal berhasil dihapus! ====");
                    } else {
                        System.out.println("Nomor tidak valid / tidak ada.");
                    }
                    break;

                case 5:
                    // Keluar dari program
                    System.out.println("==== Baiklah, terima kasih sudah menggunakan program ini ^-^ ====");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia, silahkan coba lagi.");
            }
        } while (pilihan != 5);
    }
}
