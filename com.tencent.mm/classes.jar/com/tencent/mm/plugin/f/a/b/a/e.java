package com.tencent.mm.plugin.f.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.f.a.b.h;

public class e
  extends a
{
  static final String TAG;
  public static final String sld;
  public static final String sle;
  public static final String slf;
  public static final String slg;
  public byte slh;
  public byte sli;
  public byte slj;
  public byte slk;
  public byte[] sll;
  public int slm;
  public byte sln;
  public byte slo;
  public byte[] slp;
  
  static
  {
    AppMethodBeat.i(22582);
    TAG = e.class.getName();
    sld = h.sjY;
    sle = h.sjZ;
    slf = h.ska;
    slg = h.skb;
    AppMethodBeat.o(22582);
  }
  
  public e()
  {
    AppMethodBeat.i(22580);
    this.sko = null;
    this.skp = 8;
    this.sjI = 16L;
    this.slh = 0;
    this.sli = 0;
    this.slj = 0;
    this.slk = 0;
    this.sll = new byte[] { 0, 0 };
    this.slm = -1;
    this.sln = 0;
    this.slo = 0;
    this.slp = null;
    AppMethodBeat.o(22580);
  }
  
  public final byte[] cyh()
  {
    AppMethodBeat.i(22581);
    byte[] arrayOfByte;
    if (this.sko.equalsIgnoreCase(sld))
    {
      arrayOfByte = new byte[3];
      System.arraycopy(Byte.valueOf(this.slh), 0, arrayOfByte, 0, 1);
      System.arraycopy(Byte.valueOf(this.sli), 0, arrayOfByte, 1, 1);
      System.arraycopy(Byte.valueOf(this.slj), 0, arrayOfByte, 2, 1);
      AppMethodBeat.o(22581);
      return arrayOfByte;
    }
    if (this.sko.equalsIgnoreCase(sle))
    {
      arrayOfByte = new byte[1];
      System.arraycopy(Byte.valueOf(this.slk), 0, arrayOfByte, 0, 1);
      AppMethodBeat.o(22581);
      return arrayOfByte;
    }
    if (this.sko.equalsIgnoreCase(slg))
    {
      arrayOfByte = new byte[this.slm];
      byte b1 = (byte)(this.slm & 0xFF);
      byte b2 = (byte)(this.slm >> 8 & 0xFF);
      System.arraycopy(Byte.valueOf(b1), 0, arrayOfByte, 0, 1);
      System.arraycopy(Byte.valueOf(b2), 0, arrayOfByte, 1, 1);
      System.arraycopy(Byte.valueOf(this.sln), 0, arrayOfByte, 2, 1);
      if (this.slm > 3) {
        System.arraycopy(this.slp, 0, arrayOfByte, 3, this.slm - 3);
      }
      AppMethodBeat.o(22581);
      return arrayOfByte;
    }
    AppMethodBeat.o(22581);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.a.e
 * JD-Core Version:    0.7.0.1
 */