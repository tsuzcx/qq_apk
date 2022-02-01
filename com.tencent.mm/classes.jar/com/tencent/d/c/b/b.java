package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class b
  extends JceStruct
{
  static byte[] Mju;
  static byte[] Mjv;
  static ArrayList<Integer> Mjw;
  static ArrayList<byte[]> Mjx;
  public int Mjb = 0;
  public byte[] Mjc = null;
  public String Mjd = "";
  public byte[] Mje = null;
  public long Mjf = 0L;
  public String Mjg = "";
  public int Mjh = 0;
  public String Mji = "";
  public int Mjj = 0;
  public String Mjk = "";
  public int Mjl = 0;
  public int Mjm = 0;
  public int Mjn = 0;
  public ArrayList<Integer> Mjo = null;
  public int Mjp = 0;
  public boolean Mjq = false;
  public int Mjr = 0;
  public int Mjs = 0;
  public ArrayList<byte[]> Mjt = null;
  
  static
  {
    AppMethodBeat.i(138335);
    byte[] arrayOfByte = (byte[])new byte[1];
    Mju = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    arrayOfByte = (byte[])new byte[1];
    Mjv = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    Mjw = new ArrayList();
    Mjw.add(Integer.valueOf(0));
    Mjx = new ArrayList();
    arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    Mjx.add(arrayOfByte);
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
    this.Mjb = paramJceInputStream.read(this.Mjb, 0, true);
    this.Mjc = ((byte[])paramJceInputStream.read(Mju, 1, false));
    this.Mjd = paramJceInputStream.readString(2, false);
    this.Mje = ((byte[])paramJceInputStream.read(Mjv, 3, false));
    this.Mjf = paramJceInputStream.read(this.Mjf, 4, false);
    this.Mjg = paramJceInputStream.readString(5, false);
    this.Mjh = paramJceInputStream.read(this.Mjh, 6, false);
    this.Mji = paramJceInputStream.readString(7, false);
    this.Mjj = paramJceInputStream.read(this.Mjj, 8, false);
    this.Mjk = paramJceInputStream.readString(9, false);
    this.Mjl = paramJceInputStream.read(this.Mjl, 10, false);
    this.Mjm = paramJceInputStream.read(this.Mjm, 11, false);
    this.Mjn = paramJceInputStream.read(this.Mjn, 12, false);
    this.Mjo = ((ArrayList)paramJceInputStream.read(Mjw, 13, false));
    this.Mjp = paramJceInputStream.read(this.Mjp, 14, false);
    this.Mjq = paramJceInputStream.read(this.Mjq, 15, false);
    this.Mjr = paramJceInputStream.read(this.Mjr, 16, false);
    this.Mjs = paramJceInputStream.read(this.Mjs, 17, false);
    this.Mjt = ((ArrayList)paramJceInputStream.read(Mjx, 18, false));
    AppMethodBeat.o(138334);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138333);
    paramJceOutputStream.write(this.Mjb, 0);
    if (this.Mjc != null) {
      paramJceOutputStream.write(this.Mjc, 1);
    }
    if (this.Mjd != null) {
      paramJceOutputStream.write(this.Mjd, 2);
    }
    if (this.Mje != null) {
      paramJceOutputStream.write(this.Mje, 3);
    }
    if (this.Mjf != 0L) {
      paramJceOutputStream.write(this.Mjf, 4);
    }
    if (this.Mjg != null) {
      paramJceOutputStream.write(this.Mjg, 5);
    }
    if (this.Mjh != 0) {
      paramJceOutputStream.write(this.Mjh, 6);
    }
    if (this.Mji != null) {
      paramJceOutputStream.write(this.Mji, 7);
    }
    if (this.Mjj != 0) {
      paramJceOutputStream.write(this.Mjj, 8);
    }
    if (this.Mjk != null) {
      paramJceOutputStream.write(this.Mjk, 9);
    }
    paramJceOutputStream.write(this.Mjl, 10);
    if (this.Mjm != 0) {
      paramJceOutputStream.write(this.Mjm, 11);
    }
    if (this.Mjn != 0) {
      paramJceOutputStream.write(this.Mjn, 12);
    }
    if (this.Mjo != null) {
      paramJceOutputStream.write(this.Mjo, 13);
    }
    if (this.Mjp != 0) {
      paramJceOutputStream.write(this.Mjp, 14);
    }
    paramJceOutputStream.write(this.Mjq, 15);
    if (this.Mjr != 0) {
      paramJceOutputStream.write(this.Mjr, 16);
    }
    paramJceOutputStream.write(this.Mjs, 17);
    if (this.Mjt != null) {
      paramJceOutputStream.write(this.Mjt, 18);
    }
    AppMethodBeat.o(138333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.b.b
 * JD-Core Version:    0.7.0.1
 */