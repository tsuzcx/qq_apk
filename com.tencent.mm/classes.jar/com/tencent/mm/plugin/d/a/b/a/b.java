package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;
import com.tencent.mm.sdk.platformtools.ab;

public class b
  extends a
{
  static final String TAG;
  public static String jPs;
  public static String jPt;
  public static String jPu;
  b.b jPA = null;
  b.a jPB;
  int jPC;
  private final int jPv = 1;
  private final int jPw = 2;
  private final int jPx = 4;
  private final int jPy = 8;
  private final int jPz = 16;
  
  static
  {
    AppMethodBeat.i(18461);
    TAG = b.class.getName();
    jPs = h.jPm;
    jPt = h.jPn;
    jPu = h.jPo;
    AppMethodBeat.o(18461);
  }
  
  public b()
  {
    this.jPq = null;
    this.jPr = 2;
    this.jOK = 8L;
  }
  
  static double K(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(18460);
    int i = paramArrayOfByte[(paramInt + 1)] << 8 & 0xFF00;
    int j = (i >> 12) - 16;
    int k = i & 0xF00;
    paramInt = (paramArrayOfByte[paramInt] & 0xFF) + (0xFF00 & k);
    double d1 = paramInt;
    double d2 = Math.pow(10.0D, j);
    ab.d(TAG, "hbyte=" + i + " hvalue=" + k + " value=" + paramInt + " exp=" + j);
    AppMethodBeat.o(18460);
    return d1 * d2;
  }
  
  public final byte[] aWb()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */