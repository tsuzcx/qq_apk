package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;

public class e
  extends a
{
  static final String TAG;
  public static final String nXW;
  public static final String nXX;
  public static final String nXY;
  public static final String nXZ;
  public byte nYa;
  public byte nYb;
  public byte nYc;
  public byte nYd;
  public byte[] nYe;
  public int nYf;
  public byte nYg;
  public byte nYh;
  public byte[] nYi;
  
  static
  {
    AppMethodBeat.i(22582);
    TAG = e.class.getName();
    nXW = h.nWR;
    nXX = h.nWS;
    nXY = h.nWT;
    nXZ = h.nWU;
    AppMethodBeat.o(22582);
  }
  
  public e()
  {
    AppMethodBeat.i(22580);
    this.nXh = null;
    this.nXi = 8;
    this.nWB = 16L;
    this.nYa = 0;
    this.nYb = 0;
    this.nYc = 0;
    this.nYd = 0;
    this.nYe = new byte[] { 0, 0 };
    this.nYf = -1;
    this.nYg = 0;
    this.nYh = 0;
    this.nYi = null;
    AppMethodBeat.o(22580);
  }
  
  public final byte[] bNM()
  {
    AppMethodBeat.i(22581);
    byte[] arrayOfByte;
    if (this.nXh.equalsIgnoreCase(nXW))
    {
      arrayOfByte = new byte[3];
      System.arraycopy(Byte.valueOf(this.nYa), 0, arrayOfByte, 0, 1);
      System.arraycopy(Byte.valueOf(this.nYb), 0, arrayOfByte, 1, 1);
      System.arraycopy(Byte.valueOf(this.nYc), 0, arrayOfByte, 2, 1);
      AppMethodBeat.o(22581);
      return arrayOfByte;
    }
    if (this.nXh.equalsIgnoreCase(nXX))
    {
      arrayOfByte = new byte[1];
      System.arraycopy(Byte.valueOf(this.nYd), 0, arrayOfByte, 0, 1);
      AppMethodBeat.o(22581);
      return arrayOfByte;
    }
    if (this.nXh.equalsIgnoreCase(nXZ))
    {
      arrayOfByte = new byte[this.nYf];
      byte b1 = (byte)(this.nYf & 0xFF);
      byte b2 = (byte)(this.nYf >> 8 & 0xFF);
      System.arraycopy(Byte.valueOf(b1), 0, arrayOfByte, 0, 1);
      System.arraycopy(Byte.valueOf(b2), 0, arrayOfByte, 1, 1);
      System.arraycopy(Byte.valueOf(this.nYg), 0, arrayOfByte, 2, 1);
      if (this.nYf > 3) {
        System.arraycopy(this.nYi, 0, arrayOfByte, 3, this.nYf - 3);
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