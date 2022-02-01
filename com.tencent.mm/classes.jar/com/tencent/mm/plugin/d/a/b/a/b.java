package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;
import com.tencent.mm.sdk.platformtools.ae;

public class b
  extends a
{
  static final String TAG;
  public static String nXj;
  public static String nXk;
  public static String nXl;
  private final int nXm = 1;
  private final int nXn = 2;
  private final int nXo = 4;
  private final int nXp = 8;
  private final int nXq = 16;
  b nXr = null;
  a nXs;
  int nXt;
  
  static
  {
    AppMethodBeat.i(22572);
    TAG = b.class.getName();
    nXj = h.nXd;
    nXk = h.nXe;
    nXl = h.nXf;
    AppMethodBeat.o(22572);
  }
  
  public b()
  {
    this.nXh = null;
    this.nXi = 2;
    this.nWB = 8L;
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
    ae.d(TAG, "hbyte=" + i + " hvalue=" + k + " value=" + paramInt + " exp=" + j);
    AppMethodBeat.o(22571);
    return d1 * d2;
  }
  
  public final byte[] bNM()
  {
    return null;
  }
  
  final class a
  {
    public boolean nXu;
    public double nXv;
    public int nXw;
    public int nXx;
    public int nXy;
    public b.c nXz;
    
    public a()
    {
      AppMethodBeat.i(22568);
      this.nXu = false;
      this.nXv = 0.0D;
      this.nXw = 0;
      this.nXx = 0;
      this.nXy = 0;
      this.nXz = new b.c();
      AppMethodBeat.o(22568);
    }
  }
  
  final class b
  {
    public double nXB;
    public double nXC;
    public double nXD;
    public boolean nXu;
    public int nXw;
    public int nXx;
    public int nXy;
    public b.c nXz;
    
    public b()
    {
      AppMethodBeat.i(22569);
      this.nXu = false;
      this.nXB = 0.0D;
      this.nXC = 0.0D;
      this.nXD = 0.0D;
      this.nXw = 0;
      this.nXx = 0;
      this.nXy = 0;
      this.nXz = new b.c();
      AppMethodBeat.o(22569);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */