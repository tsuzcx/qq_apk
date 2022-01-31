package com.tencent.e.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends JceStruct
{
  static byte[] Bke;
  static byte[] Bkf;
  public int BjV = 0;
  public int BjW = 0;
  public int BjX = 0;
  public byte[] BjY = null;
  public int BjZ = 0;
  public int Bjn = 0;
  public long Bka = 0L;
  public byte[] Bkb = null;
  public int Bkc = 0;
  public int Bkd = 0;
  public int fzZ = 0;
  public int requestType = 0;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    Bke = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    arrayOfByte = (byte[])new byte[1];
    Bkf = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
  }
  
  public final JceStruct newInit()
  {
    AppMethodBeat.i(114495);
    c localc = new c();
    AppMethodBeat.o(114495);
    return localc;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(114497);
    this.BjV = paramJceInputStream.read(this.BjV, 0, false);
    this.Bjn = paramJceInputStream.read(this.Bjn, 1, false);
    this.requestType = paramJceInputStream.read(this.requestType, 2, false);
    this.BjW = paramJceInputStream.read(this.BjW, 3, false);
    this.BjX = paramJceInputStream.read(this.BjX, 4, false);
    this.BjY = ((byte[])paramJceInputStream.read(Bke, 5, false));
    this.BjZ = paramJceInputStream.read(this.BjZ, 6, false);
    this.fzZ = paramJceInputStream.read(this.fzZ, 7, false);
    this.Bka = paramJceInputStream.read(this.Bka, 8, false);
    this.Bkb = ((byte[])paramJceInputStream.read(Bkf, 9, false));
    this.Bkc = paramJceInputStream.read(this.Bkc, 10, false);
    this.Bkd = paramJceInputStream.read(this.Bkd, 11, false);
    AppMethodBeat.o(114497);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(114496);
    if (this.BjV != 0) {
      paramJceOutputStream.write(this.BjV, 0);
    }
    paramJceOutputStream.write(this.Bjn, 1);
    paramJceOutputStream.write(this.requestType, 2);
    if (this.BjW != 0) {
      paramJceOutputStream.write(this.BjW, 3);
    }
    if (this.BjX != 0) {
      paramJceOutputStream.write(this.BjX, 4);
    }
    if (this.BjY != null) {
      paramJceOutputStream.write(this.BjY, 5);
    }
    if (this.BjZ != 0) {
      paramJceOutputStream.write(this.BjZ, 6);
    }
    if (this.fzZ != 0) {
      paramJceOutputStream.write(this.fzZ, 7);
    }
    if (this.Bka != 0L) {
      paramJceOutputStream.write(this.Bka, 8);
    }
    if (this.Bkb != null) {
      paramJceOutputStream.write(this.Bkb, 9);
    }
    if (this.Bkc != 0) {
      paramJceOutputStream.write(this.Bkc, 10);
    }
    if (this.Bkd != 0) {
      paramJceOutputStream.write(this.Bkd, 11);
    }
    AppMethodBeat.o(114496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.c.b.c
 * JD-Core Version:    0.7.0.1
 */