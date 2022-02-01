package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;

public class e
  extends a
{
  static final String TAG;
  public static final String nru;
  public static final String nrv;
  public static final String nrw;
  public static final String nrx;
  public byte nrA;
  public byte nrB;
  public byte[] nrC;
  public int nrD;
  public byte nrE;
  public byte nrF;
  public byte[] nrG;
  public byte nry;
  public byte nrz;
  
  static
  {
    AppMethodBeat.i(22582);
    TAG = e.class.getName();
    nru = h.nqp;
    nrv = h.nqq;
    nrw = h.nqr;
    nrx = h.nqs;
    AppMethodBeat.o(22582);
  }
  
  public e()
  {
    AppMethodBeat.i(22580);
    this.nqF = null;
    this.nqG = 8;
    this.npZ = 16L;
    this.nry = 0;
    this.nrz = 0;
    this.nrA = 0;
    this.nrB = 0;
    this.nrC = new byte[] { 0, 0 };
    this.nrD = -1;
    this.nrE = 0;
    this.nrF = 0;
    this.nrG = null;
    AppMethodBeat.o(22580);
  }
  
  public final byte[] bIB()
  {
    AppMethodBeat.i(22581);
    byte[] arrayOfByte;
    if (this.nqF.equalsIgnoreCase(nru))
    {
      arrayOfByte = new byte[3];
      System.arraycopy(Byte.valueOf(this.nry), 0, arrayOfByte, 0, 1);
      System.arraycopy(Byte.valueOf(this.nrz), 0, arrayOfByte, 1, 1);
      System.arraycopy(Byte.valueOf(this.nrA), 0, arrayOfByte, 2, 1);
      AppMethodBeat.o(22581);
      return arrayOfByte;
    }
    if (this.nqF.equalsIgnoreCase(nrv))
    {
      arrayOfByte = new byte[1];
      System.arraycopy(Byte.valueOf(this.nrB), 0, arrayOfByte, 0, 1);
      AppMethodBeat.o(22581);
      return arrayOfByte;
    }
    if (this.nqF.equalsIgnoreCase(nrx))
    {
      arrayOfByte = new byte[this.nrD];
      byte b1 = (byte)(this.nrD & 0xFF);
      byte b2 = (byte)(this.nrD >> 8 & 0xFF);
      System.arraycopy(Byte.valueOf(b1), 0, arrayOfByte, 0, 1);
      System.arraycopy(Byte.valueOf(b2), 0, arrayOfByte, 1, 1);
      System.arraycopy(Byte.valueOf(this.nrE), 0, arrayOfByte, 2, 1);
      if (this.nrD > 3) {
        System.arraycopy(this.nrG, 0, arrayOfByte, 3, this.nrD - 3);
      }
      AppMethodBeat.o(22581);
      return arrayOfByte;
    }
    AppMethodBeat.o(22581);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a.e
 * JD-Core Version:    0.7.0.1
 */