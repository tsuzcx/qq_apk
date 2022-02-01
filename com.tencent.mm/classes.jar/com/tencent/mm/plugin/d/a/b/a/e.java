package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;

public class e
  extends a
{
  static final String TAG;
  public static final String mPi;
  public static final String mPj;
  public static final String mPk;
  public static final String mPl;
  public byte mPm;
  public byte mPn;
  public byte mPo;
  public byte mPp;
  public byte[] mPq;
  public int mPr;
  public byte mPs;
  public byte mPt;
  public byte[] mPu;
  
  static
  {
    AppMethodBeat.i(22582);
    TAG = e.class.getName();
    mPi = h.mOd;
    mPj = h.mOe;
    mPk = h.mOf;
    mPl = h.mOg;
    AppMethodBeat.o(22582);
  }
  
  public e()
  {
    AppMethodBeat.i(22580);
    this.mOt = null;
    this.mOu = 8;
    this.mNN = 16L;
    this.mPm = 0;
    this.mPn = 0;
    this.mPo = 0;
    this.mPp = 0;
    this.mPq = new byte[] { 0, 0 };
    this.mPr = -1;
    this.mPs = 0;
    this.mPt = 0;
    this.mPu = null;
    AppMethodBeat.o(22580);
  }
  
  public final byte[] bBD()
  {
    AppMethodBeat.i(22581);
    byte[] arrayOfByte;
    if (this.mOt.equalsIgnoreCase(mPi))
    {
      arrayOfByte = new byte[3];
      System.arraycopy(Byte.valueOf(this.mPm), 0, arrayOfByte, 0, 1);
      System.arraycopy(Byte.valueOf(this.mPn), 0, arrayOfByte, 1, 1);
      System.arraycopy(Byte.valueOf(this.mPo), 0, arrayOfByte, 2, 1);
      AppMethodBeat.o(22581);
      return arrayOfByte;
    }
    if (this.mOt.equalsIgnoreCase(mPj))
    {
      arrayOfByte = new byte[1];
      System.arraycopy(Byte.valueOf(this.mPp), 0, arrayOfByte, 0, 1);
      AppMethodBeat.o(22581);
      return arrayOfByte;
    }
    if (this.mOt.equalsIgnoreCase(mPl))
    {
      arrayOfByte = new byte[this.mPr];
      byte b1 = (byte)(this.mPr & 0xFF);
      byte b2 = (byte)(this.mPr >> 8 & 0xFF);
      System.arraycopy(Byte.valueOf(b1), 0, arrayOfByte, 0, 1);
      System.arraycopy(Byte.valueOf(b2), 0, arrayOfByte, 1, 1);
      System.arraycopy(Byte.valueOf(this.mPs), 0, arrayOfByte, 2, 1);
      if (this.mPr > 3) {
        System.arraycopy(this.mPu, 0, arrayOfByte, 3, this.mPr - 3);
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