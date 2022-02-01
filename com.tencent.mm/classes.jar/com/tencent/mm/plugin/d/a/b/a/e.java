package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;

public class e
  extends a
{
  static final String TAG;
  public static final String piU;
  public static final String piV;
  public static final String piW;
  public static final String piX;
  public byte piY;
  public byte piZ;
  public byte pja;
  public byte pjb;
  public byte[] pjc;
  public int pjd;
  public byte pje;
  public byte pjf;
  public byte[] pjg;
  
  static
  {
    AppMethodBeat.i(22582);
    TAG = e.class.getName();
    piU = h.phN;
    piV = h.phO;
    piW = h.phP;
    piX = h.phQ;
    AppMethodBeat.o(22582);
  }
  
  public e()
  {
    AppMethodBeat.i(22580);
    this.pie = null;
    this.pif = 8;
    this.phx = 16L;
    this.piY = 0;
    this.piZ = 0;
    this.pja = 0;
    this.pjb = 0;
    this.pjc = new byte[] { 0, 0 };
    this.pjd = -1;
    this.pje = 0;
    this.pjf = 0;
    this.pjg = null;
    AppMethodBeat.o(22580);
  }
  
  public final byte[] ckM()
  {
    AppMethodBeat.i(22581);
    byte[] arrayOfByte;
    if (this.pie.equalsIgnoreCase(piU))
    {
      arrayOfByte = new byte[3];
      System.arraycopy(Byte.valueOf(this.piY), 0, arrayOfByte, 0, 1);
      System.arraycopy(Byte.valueOf(this.piZ), 0, arrayOfByte, 1, 1);
      System.arraycopy(Byte.valueOf(this.pja), 0, arrayOfByte, 2, 1);
      AppMethodBeat.o(22581);
      return arrayOfByte;
    }
    if (this.pie.equalsIgnoreCase(piV))
    {
      arrayOfByte = new byte[1];
      System.arraycopy(Byte.valueOf(this.pjb), 0, arrayOfByte, 0, 1);
      AppMethodBeat.o(22581);
      return arrayOfByte;
    }
    if (this.pie.equalsIgnoreCase(piX))
    {
      arrayOfByte = new byte[this.pjd];
      byte b1 = (byte)(this.pjd & 0xFF);
      byte b2 = (byte)(this.pjd >> 8 & 0xFF);
      System.arraycopy(Byte.valueOf(b1), 0, arrayOfByte, 0, 1);
      System.arraycopy(Byte.valueOf(b2), 0, arrayOfByte, 1, 1);
      System.arraycopy(Byte.valueOf(this.pje), 0, arrayOfByte, 2, 1);
      if (this.pjd > 3) {
        System.arraycopy(this.pjg, 0, arrayOfByte, 3, this.pjd - 3);
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