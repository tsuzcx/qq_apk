package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class b
  extends JceStruct
{
  static byte[] LMv;
  static byte[] LMw;
  static ArrayList<Integer> LMx;
  static ArrayList<byte[]> LMy;
  public int LMc = 0;
  public byte[] LMd = null;
  public String LMe = "";
  public byte[] LMf = null;
  public long LMg = 0L;
  public String LMh = "";
  public int LMi = 0;
  public String LMj = "";
  public int LMk = 0;
  public String LMl = "";
  public int LMm = 0;
  public int LMn = 0;
  public int LMo = 0;
  public ArrayList<Integer> LMp = null;
  public int LMq = 0;
  public boolean LMr = false;
  public int LMs = 0;
  public int LMt = 0;
  public ArrayList<byte[]> LMu = null;
  
  static
  {
    AppMethodBeat.i(138335);
    byte[] arrayOfByte = (byte[])new byte[1];
    LMv = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    arrayOfByte = (byte[])new byte[1];
    LMw = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    LMx = new ArrayList();
    LMx.add(Integer.valueOf(0));
    LMy = new ArrayList();
    arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    LMy.add(arrayOfByte);
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
    this.LMc = paramJceInputStream.read(this.LMc, 0, true);
    this.LMd = ((byte[])paramJceInputStream.read(LMv, 1, false));
    this.LMe = paramJceInputStream.readString(2, false);
    this.LMf = ((byte[])paramJceInputStream.read(LMw, 3, false));
    this.LMg = paramJceInputStream.read(this.LMg, 4, false);
    this.LMh = paramJceInputStream.readString(5, false);
    this.LMi = paramJceInputStream.read(this.LMi, 6, false);
    this.LMj = paramJceInputStream.readString(7, false);
    this.LMk = paramJceInputStream.read(this.LMk, 8, false);
    this.LMl = paramJceInputStream.readString(9, false);
    this.LMm = paramJceInputStream.read(this.LMm, 10, false);
    this.LMn = paramJceInputStream.read(this.LMn, 11, false);
    this.LMo = paramJceInputStream.read(this.LMo, 12, false);
    this.LMp = ((ArrayList)paramJceInputStream.read(LMx, 13, false));
    this.LMq = paramJceInputStream.read(this.LMq, 14, false);
    this.LMr = paramJceInputStream.read(this.LMr, 15, false);
    this.LMs = paramJceInputStream.read(this.LMs, 16, false);
    this.LMt = paramJceInputStream.read(this.LMt, 17, false);
    this.LMu = ((ArrayList)paramJceInputStream.read(LMy, 18, false));
    AppMethodBeat.o(138334);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138333);
    paramJceOutputStream.write(this.LMc, 0);
    if (this.LMd != null) {
      paramJceOutputStream.write(this.LMd, 1);
    }
    if (this.LMe != null) {
      paramJceOutputStream.write(this.LMe, 2);
    }
    if (this.LMf != null) {
      paramJceOutputStream.write(this.LMf, 3);
    }
    if (this.LMg != 0L) {
      paramJceOutputStream.write(this.LMg, 4);
    }
    if (this.LMh != null) {
      paramJceOutputStream.write(this.LMh, 5);
    }
    if (this.LMi != 0) {
      paramJceOutputStream.write(this.LMi, 6);
    }
    if (this.LMj != null) {
      paramJceOutputStream.write(this.LMj, 7);
    }
    if (this.LMk != 0) {
      paramJceOutputStream.write(this.LMk, 8);
    }
    if (this.LMl != null) {
      paramJceOutputStream.write(this.LMl, 9);
    }
    paramJceOutputStream.write(this.LMm, 10);
    if (this.LMn != 0) {
      paramJceOutputStream.write(this.LMn, 11);
    }
    if (this.LMo != 0) {
      paramJceOutputStream.write(this.LMo, 12);
    }
    if (this.LMp != null) {
      paramJceOutputStream.write(this.LMp, 13);
    }
    if (this.LMq != 0) {
      paramJceOutputStream.write(this.LMq, 14);
    }
    paramJceOutputStream.write(this.LMr, 15);
    if (this.LMs != 0) {
      paramJceOutputStream.write(this.LMs, 16);
    }
    paramJceOutputStream.write(this.LMt, 17);
    if (this.LMu != null) {
      paramJceOutputStream.write(this.LMu, 18);
    }
    AppMethodBeat.o(138333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.b.b
 * JD-Core Version:    0.7.0.1
 */