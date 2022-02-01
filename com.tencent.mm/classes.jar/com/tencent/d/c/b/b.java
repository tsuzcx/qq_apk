package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class b
  extends JceStruct
{
  static byte[] ZoC;
  static byte[] ZoD;
  static ArrayList<Integer> ZoE;
  static ArrayList<byte[]> ZoF;
  public int ZoA = 0;
  public ArrayList<byte[]> ZoB = null;
  public int Zoj = 0;
  public byte[] Zok = null;
  public String Zol = "";
  public byte[] Zom = null;
  public long Zon = 0L;
  public String Zoo = "";
  public int Zop = 0;
  public String Zoq = "";
  public int Zor = 0;
  public String Zos = "";
  public int Zot = 0;
  public int Zou = 0;
  public int Zov = 0;
  public ArrayList<Integer> Zow = null;
  public int Zox = 0;
  public boolean Zoy = false;
  public int Zoz = 0;
  
  static
  {
    AppMethodBeat.i(138335);
    byte[] arrayOfByte = (byte[])new byte[1];
    ZoC = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    arrayOfByte = (byte[])new byte[1];
    ZoD = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    ZoE = new ArrayList();
    ZoE.add(Integer.valueOf(0));
    ZoF = new ArrayList();
    arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    ZoF.add(arrayOfByte);
    AppMethodBeat.o(138335);
  }
  
  public final JceStruct newInit()
  {
    AppMethodBeat.i(138332);
    b localb = new b();
    AppMethodBeat.o(138332);
    return localb;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138334);
    this.Zoj = paramJceInputStream.read(this.Zoj, 0, true);
    this.Zok = ((byte[])paramJceInputStream.read(ZoC, 1, false));
    this.Zol = paramJceInputStream.readString(2, false);
    this.Zom = ((byte[])paramJceInputStream.read(ZoD, 3, false));
    this.Zon = paramJceInputStream.read(this.Zon, 4, false);
    this.Zoo = paramJceInputStream.readString(5, false);
    this.Zop = paramJceInputStream.read(this.Zop, 6, false);
    this.Zoq = paramJceInputStream.readString(7, false);
    this.Zor = paramJceInputStream.read(this.Zor, 8, false);
    this.Zos = paramJceInputStream.readString(9, false);
    this.Zot = paramJceInputStream.read(this.Zot, 10, false);
    this.Zou = paramJceInputStream.read(this.Zou, 11, false);
    this.Zov = paramJceInputStream.read(this.Zov, 12, false);
    this.Zow = ((ArrayList)paramJceInputStream.read(ZoE, 13, false));
    this.Zox = paramJceInputStream.read(this.Zox, 14, false);
    this.Zoy = paramJceInputStream.read(this.Zoy, 15, false);
    this.Zoz = paramJceInputStream.read(this.Zoz, 16, false);
    this.ZoA = paramJceInputStream.read(this.ZoA, 17, false);
    this.ZoB = ((ArrayList)paramJceInputStream.read(ZoF, 18, false));
    AppMethodBeat.o(138334);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138333);
    paramJceOutputStream.write(this.Zoj, 0);
    if (this.Zok != null) {
      paramJceOutputStream.write(this.Zok, 1);
    }
    if (this.Zol != null) {
      paramJceOutputStream.write(this.Zol, 2);
    }
    if (this.Zom != null) {
      paramJceOutputStream.write(this.Zom, 3);
    }
    if (this.Zon != 0L) {
      paramJceOutputStream.write(this.Zon, 4);
    }
    if (this.Zoo != null) {
      paramJceOutputStream.write(this.Zoo, 5);
    }
    if (this.Zop != 0) {
      paramJceOutputStream.write(this.Zop, 6);
    }
    if (this.Zoq != null) {
      paramJceOutputStream.write(this.Zoq, 7);
    }
    if (this.Zor != 0) {
      paramJceOutputStream.write(this.Zor, 8);
    }
    if (this.Zos != null) {
      paramJceOutputStream.write(this.Zos, 9);
    }
    paramJceOutputStream.write(this.Zot, 10);
    if (this.Zou != 0) {
      paramJceOutputStream.write(this.Zou, 11);
    }
    if (this.Zov != 0) {
      paramJceOutputStream.write(this.Zov, 12);
    }
    if (this.Zow != null) {
      paramJceOutputStream.write(this.Zow, 13);
    }
    if (this.Zox != 0) {
      paramJceOutputStream.write(this.Zox, 14);
    }
    paramJceOutputStream.write(this.Zoy, 15);
    if (this.Zoz != 0) {
      paramJceOutputStream.write(this.Zoz, 16);
    }
    paramJceOutputStream.write(this.ZoA, 17);
    if (this.ZoB != null) {
      paramJceOutputStream.write(this.ZoB, 18);
    }
    AppMethodBeat.o(138333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.b.b
 * JD-Core Version:    0.7.0.1
 */