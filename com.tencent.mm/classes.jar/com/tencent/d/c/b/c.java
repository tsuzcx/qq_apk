package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class c
  extends JceStruct
{
  static byte[] wMG;
  static byte[] wMH;
  public int ejS = 0;
  public int requestType = 0;
  public int wLO = 0;
  public byte[] wMA = null;
  public int wMB = 0;
  public long wMC = 0L;
  public byte[] wMD = null;
  public int wME = 0;
  public int wMF = 0;
  public int wMx = 0;
  public int wMy = 0;
  public int wMz = 0;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    wMG = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    arrayOfByte = (byte[])new byte[1];
    wMH = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
  }
  
  public final JceStruct newInit()
  {
    return new c();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.wMx = paramJceInputStream.read(this.wMx, 0, false);
    this.wLO = paramJceInputStream.read(this.wLO, 1, false);
    this.requestType = paramJceInputStream.read(this.requestType, 2, false);
    this.wMy = paramJceInputStream.read(this.wMy, 3, false);
    this.wMz = paramJceInputStream.read(this.wMz, 4, false);
    this.wMA = ((byte[])paramJceInputStream.read(wMG, 5, false));
    this.wMB = paramJceInputStream.read(this.wMB, 6, false);
    this.ejS = paramJceInputStream.read(this.ejS, 7, false);
    this.wMC = paramJceInputStream.read(this.wMC, 8, false);
    this.wMD = ((byte[])paramJceInputStream.read(wMH, 9, false));
    this.wME = paramJceInputStream.read(this.wME, 10, false);
    this.wMF = paramJceInputStream.read(this.wMF, 11, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.wMx != 0) {
      paramJceOutputStream.write(this.wMx, 0);
    }
    paramJceOutputStream.write(this.wLO, 1);
    paramJceOutputStream.write(this.requestType, 2);
    if (this.wMy != 0) {
      paramJceOutputStream.write(this.wMy, 3);
    }
    if (this.wMz != 0) {
      paramJceOutputStream.write(this.wMz, 4);
    }
    if (this.wMA != null) {
      paramJceOutputStream.write(this.wMA, 5);
    }
    if (this.wMB != 0) {
      paramJceOutputStream.write(this.wMB, 6);
    }
    if (this.ejS != 0) {
      paramJceOutputStream.write(this.ejS, 7);
    }
    if (this.wMC != 0L) {
      paramJceOutputStream.write(this.wMC, 8);
    }
    if (this.wMD != null) {
      paramJceOutputStream.write(this.wMD, 9);
    }
    if (this.wME != 0) {
      paramJceOutputStream.write(this.wME, 10);
    }
    if (this.wMF != 0) {
      paramJceOutputStream.write(this.wMF, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.c.b.c
 * JD-Core Version:    0.7.0.1
 */