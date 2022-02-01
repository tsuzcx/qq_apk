package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;
import com.tencent.mm.sdk.platformtools.ad;

public class b
  extends a
{
  static final String TAG;
  public static String nRD;
  public static String nRE;
  public static String nRF;
  private final int nRG = 1;
  private final int nRH = 2;
  private final int nRI = 4;
  private final int nRJ = 8;
  private final int nRK = 16;
  b nRL = null;
  a nRM;
  int nRN;
  
  static
  {
    AppMethodBeat.i(22572);
    TAG = b.class.getName();
    nRD = h.nRx;
    nRE = h.nRy;
    nRF = h.nRz;
    AppMethodBeat.o(22572);
  }
  
  public b()
  {
    this.nRB = null;
    this.nRC = 2;
    this.nQV = 8L;
  }
  
  static double M(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(22571);
    int i = paramArrayOfByte[(paramInt + 1)] << 8 & 0xFF00;
    int j = (i >> 12) - 16;
    int k = i & 0xF00;
    paramInt = (paramArrayOfByte[paramInt] & 0xFF) + (0xFF00 & k);
    double d1 = paramInt;
    double d2 = Math.pow(10.0D, j);
    ad.d(TAG, "hbyte=" + i + " hvalue=" + k + " value=" + paramInt + " exp=" + j);
    AppMethodBeat.o(22571);
    return d1 * d2;
  }
  
  public final byte[] bMO()
  {
    return null;
  }
  
  final class a
  {
    public boolean nRO;
    public double nRP;
    public int nRQ;
    public int nRR;
    public int nRS;
    public b.c nRT;
    
    public a()
    {
      AppMethodBeat.i(22568);
      this.nRO = false;
      this.nRP = 0.0D;
      this.nRQ = 0;
      this.nRR = 0;
      this.nRS = 0;
      this.nRT = new b.c();
      AppMethodBeat.o(22568);
    }
  }
  
  final class b
  {
    public boolean nRO;
    public int nRQ;
    public int nRR;
    public int nRS;
    public b.c nRT;
    public double nRV;
    public double nRW;
    public double nRX;
    
    public b()
    {
      AppMethodBeat.i(22569);
      this.nRO = false;
      this.nRV = 0.0D;
      this.nRW = 0.0D;
      this.nRX = 0.0D;
      this.nRQ = 0;
      this.nRR = 0;
      this.nRS = 0;
      this.nRT = new b.c();
      AppMethodBeat.o(22569);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */