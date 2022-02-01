package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;

public class e
  extends a
{
  static final String TAG;
  public static final String nSq;
  public static final String nSr;
  public static final String nSs;
  public static final String nSt;
  public byte nSA;
  public byte nSB;
  public byte[] nSC;
  public byte nSu;
  public byte nSv;
  public byte nSw;
  public byte nSx;
  public byte[] nSy;
  public int nSz;
  
  static
  {
    AppMethodBeat.i(22582);
    TAG = e.class.getName();
    nSq = h.nRl;
    nSr = h.nRm;
    nSs = h.nRn;
    nSt = h.nRo;
    AppMethodBeat.o(22582);
  }
  
  public e()
  {
    AppMethodBeat.i(22580);
    this.nRB = null;
    this.nRC = 8;
    this.nQV = 16L;
    this.nSu = 0;
    this.nSv = 0;
    this.nSw = 0;
    this.nSx = 0;
    this.nSy = new byte[] { 0, 0 };
    this.nSz = -1;
    this.nSA = 0;
    this.nSB = 0;
    this.nSC = null;
    AppMethodBeat.o(22580);
  }
  
  public final byte[] bMO()
  {
    AppMethodBeat.i(22581);
    byte[] arrayOfByte;
    if (this.nRB.equalsIgnoreCase(nSq))
    {
      arrayOfByte = new byte[3];
      System.arraycopy(Byte.valueOf(this.nSu), 0, arrayOfByte, 0, 1);
      System.arraycopy(Byte.valueOf(this.nSv), 0, arrayOfByte, 1, 1);
      System.arraycopy(Byte.valueOf(this.nSw), 0, arrayOfByte, 2, 1);
      AppMethodBeat.o(22581);
      return arrayOfByte;
    }
    if (this.nRB.equalsIgnoreCase(nSr))
    {
      arrayOfByte = new byte[1];
      System.arraycopy(Byte.valueOf(this.nSx), 0, arrayOfByte, 0, 1);
      AppMethodBeat.o(22581);
      return arrayOfByte;
    }
    if (this.nRB.equalsIgnoreCase(nSt))
    {
      arrayOfByte = new byte[this.nSz];
      byte b1 = (byte)(this.nSz & 0xFF);
      byte b2 = (byte)(this.nSz >> 8 & 0xFF);
      System.arraycopy(Byte.valueOf(b1), 0, arrayOfByte, 0, 1);
      System.arraycopy(Byte.valueOf(b2), 0, arrayOfByte, 1, 1);
      System.arraycopy(Byte.valueOf(this.nSA), 0, arrayOfByte, 2, 1);
      if (this.nSz > 3) {
        System.arraycopy(this.nSC, 0, arrayOfByte, 3, this.nSz - 3);
      }
      AppMethodBeat.o(22581);
      return arrayOfByte;
    }
    AppMethodBeat.o(22581);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a.e
 * JD-Core Version:    0.7.0.1
 */