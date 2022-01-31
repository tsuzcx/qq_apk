package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class b
  extends JceStruct
{
  static byte[] wMt;
  static byte[] wMu;
  static ArrayList<Integer> wMv;
  static ArrayList<byte[]> wMw;
  public int wMa = 0;
  public byte[] wMb = null;
  public String wMc = "";
  public byte[] wMd = null;
  public long wMe = 0L;
  public String wMf = "";
  public int wMg = 0;
  public String wMh = "";
  public int wMi = 0;
  public String wMj = "";
  public int wMk = 0;
  public int wMl = 0;
  public int wMm = 0;
  public ArrayList<Integer> wMn = null;
  public int wMo = 0;
  public boolean wMp = false;
  public int wMq = 0;
  public int wMr = 0;
  public ArrayList<byte[]> wMs = null;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    wMt = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    arrayOfByte = (byte[])new byte[1];
    wMu = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    wMv = new ArrayList();
    wMv.add(Integer.valueOf(0));
    wMw = new ArrayList();
    arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    wMw.add(arrayOfByte);
  }
  
  public final JceStruct newInit()
  {
    return new b();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.wMa = paramJceInputStream.read(this.wMa, 0, true);
    this.wMb = ((byte[])paramJceInputStream.read(wMt, 1, false));
    this.wMc = paramJceInputStream.readString(2, false);
    this.wMd = ((byte[])paramJceInputStream.read(wMu, 3, false));
    this.wMe = paramJceInputStream.read(this.wMe, 4, false);
    this.wMf = paramJceInputStream.readString(5, false);
    this.wMg = paramJceInputStream.read(this.wMg, 6, false);
    this.wMh = paramJceInputStream.readString(7, false);
    this.wMi = paramJceInputStream.read(this.wMi, 8, false);
    this.wMj = paramJceInputStream.readString(9, false);
    this.wMk = paramJceInputStream.read(this.wMk, 10, false);
    this.wMl = paramJceInputStream.read(this.wMl, 11, false);
    this.wMm = paramJceInputStream.read(this.wMm, 12, false);
    this.wMn = ((ArrayList)paramJceInputStream.read(wMv, 13, false));
    this.wMo = paramJceInputStream.read(this.wMo, 14, false);
    this.wMp = paramJceInputStream.read(this.wMp, 15, false);
    this.wMq = paramJceInputStream.read(this.wMq, 16, false);
    this.wMr = paramJceInputStream.read(this.wMr, 17, false);
    this.wMs = ((ArrayList)paramJceInputStream.read(wMw, 18, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.wMa, 0);
    if (this.wMb != null) {
      paramJceOutputStream.write(this.wMb, 1);
    }
    if (this.wMc != null) {
      paramJceOutputStream.write(this.wMc, 2);
    }
    if (this.wMd != null) {
      paramJceOutputStream.write(this.wMd, 3);
    }
    if (this.wMe != 0L) {
      paramJceOutputStream.write(this.wMe, 4);
    }
    if (this.wMf != null) {
      paramJceOutputStream.write(this.wMf, 5);
    }
    if (this.wMg != 0) {
      paramJceOutputStream.write(this.wMg, 6);
    }
    if (this.wMh != null) {
      paramJceOutputStream.write(this.wMh, 7);
    }
    if (this.wMi != 0) {
      paramJceOutputStream.write(this.wMi, 8);
    }
    if (this.wMj != null) {
      paramJceOutputStream.write(this.wMj, 9);
    }
    paramJceOutputStream.write(this.wMk, 10);
    if (this.wMl != 0) {
      paramJceOutputStream.write(this.wMl, 11);
    }
    if (this.wMm != 0) {
      paramJceOutputStream.write(this.wMm, 12);
    }
    if (this.wMn != null) {
      paramJceOutputStream.write(this.wMn, 13);
    }
    if (this.wMo != 0) {
      paramJceOutputStream.write(this.wMo, 14);
    }
    paramJceOutputStream.write(this.wMp, 15);
    if (this.wMq != 0) {
      paramJceOutputStream.write(this.wMq, 16);
    }
    paramJceOutputStream.write(this.wMr, 17);
    if (this.wMs != null) {
      paramJceOutputStream.write(this.wMs, 18);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.d.c.b.b
 * JD-Core Version:    0.7.0.1
 */