package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;

public class e
  extends a
{
  static final String TAG;
  public static final String jQf;
  public static final String jQg;
  public static final String jQh;
  public static final String jQi;
  public byte jQj;
  public byte jQk;
  public byte jQl;
  public byte jQm;
  public byte[] jQn;
  public int jQo;
  public byte jQp;
  public byte jQq;
  public byte[] jQr;
  
  static
  {
    AppMethodBeat.i(18471);
    TAG = e.class.getName();
    jQf = h.jPa;
    jQg = h.jPb;
    jQh = h.jPc;
    jQi = h.jPd;
    AppMethodBeat.o(18471);
  }
  
  public e()
  {
    AppMethodBeat.i(18469);
    this.jPq = null;
    this.jPr = 8;
    this.jOK = 16L;
    this.jQj = 0;
    this.jQk = 0;
    this.jQl = 0;
    this.jQm = 0;
    this.jQn = new byte[] { 0, 0 };
    this.jQo = -1;
    this.jQp = 0;
    this.jQq = 0;
    this.jQr = null;
    AppMethodBeat.o(18469);
  }
  
  public final byte[] aWb()
  {
    AppMethodBeat.i(18470);
    byte[] arrayOfByte;
    if (this.jPq.equalsIgnoreCase(jQf))
    {
      arrayOfByte = new byte[3];
      System.arraycopy(Byte.valueOf(this.jQj), 0, arrayOfByte, 0, 1);
      System.arraycopy(Byte.valueOf(this.jQk), 0, arrayOfByte, 1, 1);
      System.arraycopy(Byte.valueOf(this.jQl), 0, arrayOfByte, 2, 1);
      AppMethodBeat.o(18470);
      return arrayOfByte;
    }
    if (this.jPq.equalsIgnoreCase(jQg))
    {
      arrayOfByte = new byte[1];
      System.arraycopy(Byte.valueOf(this.jQm), 0, arrayOfByte, 0, 1);
      AppMethodBeat.o(18470);
      return arrayOfByte;
    }
    if (this.jPq.equalsIgnoreCase(jQi))
    {
      arrayOfByte = new byte[this.jQo];
      byte b1 = (byte)(this.jQo & 0xFF);
      byte b2 = (byte)(this.jQo >> 8 & 0xFF);
      System.arraycopy(Byte.valueOf(b1), 0, arrayOfByte, 0, 1);
      System.arraycopy(Byte.valueOf(b2), 0, arrayOfByte, 1, 1);
      System.arraycopy(Byte.valueOf(this.jQp), 0, arrayOfByte, 2, 1);
      if (this.jQo > 3) {
        System.arraycopy(this.jQr, 0, arrayOfByte, 3, this.jQo - 3);
      }
      AppMethodBeat.o(18470);
      return arrayOfByte;
    }
    AppMethodBeat.o(18470);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a.e
 * JD-Core Version:    0.7.0.1
 */