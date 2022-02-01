package com.tencent.mm.plugin.f.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.f.a.b.h;
import com.tencent.mm.sdk.platformtools.Log;

public class b
  extends a
{
  static final String TAG;
  public static String skq;
  public static String skr;
  public static String sks;
  int skA;
  private final int skt = 1;
  private final int sku = 2;
  private final int skv = 4;
  private final int skw = 8;
  private final int skx = 16;
  b sky = null;
  a skz;
  
  static
  {
    AppMethodBeat.i(22572);
    TAG = b.class.getName();
    skq = h.skk;
    skr = h.skl;
    sks = h.skm;
    AppMethodBeat.o(22572);
  }
  
  public b()
  {
    this.sko = null;
    this.skp = 2;
    this.sjI = 8L;
  }
  
  static double P(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(22571);
    int i = paramArrayOfByte[(paramInt + 1)] << 8 & 0xFF00;
    int j = (i >> 12) - 16;
    int k = i & 0xF00;
    paramInt = (paramArrayOfByte[paramInt] & 0xFF) + (0xFF00 & k);
    double d1 = paramInt;
    double d2 = Math.pow(10.0D, j);
    Log.d(TAG, "hbyte=" + i + " hvalue=" + k + " value=" + paramInt + " exp=" + j);
    AppMethodBeat.o(22571);
    return d1 * d2;
  }
  
  public final byte[] cyh()
  {
    return null;
  }
  
  final class a
  {
    public boolean skB;
    public double skC;
    public int skD;
    public int skE;
    public int skF;
    public b.c skG;
    
    public a()
    {
      AppMethodBeat.i(22568);
      this.skB = false;
      this.skC = 0.0D;
      this.skD = 0;
      this.skE = 0;
      this.skF = 0;
      this.skG = new b.c();
      AppMethodBeat.o(22568);
    }
  }
  
  final class b
  {
    public boolean skB;
    public int skD;
    public int skE;
    public int skF;
    public b.c skG;
    public double skI;
    public double skJ;
    public double skK;
    
    public b()
    {
      AppMethodBeat.i(22569);
      this.skB = false;
      this.skI = 0.0D;
      this.skJ = 0.0D;
      this.skK = 0.0D;
      this.skD = 0;
      this.skE = 0;
      this.skF = 0;
      this.skG = new b.c();
      AppMethodBeat.o(22569);
    }
  }
  
  public static final class c
  {
    public int mDay = 0;
    public int mMonth = 0;
    public int mYear = 0;
    public int skL = 0;
    public int skM = 0;
    public int skN = 0;
    
    public final boolean Q(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(22570);
      String str = b.TAG;
      if (paramArrayOfByte == null) {}
      for (int i = 0;; i = paramArrayOfByte.length)
      {
        Log.d(str, "data size = %d, offset = %d, lenght = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(7) });
        if ((paramArrayOfByte != null) && (paramInt >= 0) && (paramArrayOfByte.length >= paramInt + 7)) {
          break;
        }
        Log.e(b.TAG, "data input error");
        AppMethodBeat.o(22570);
        return false;
      }
      this.mYear = ((paramArrayOfByte[paramInt] & 0xFF) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8));
      this.mMonth = (paramArrayOfByte[(paramInt + 2)] & 0xFF);
      this.mDay = (paramArrayOfByte[(paramInt + 3)] & 0xFF);
      this.skL = (paramArrayOfByte[(paramInt + 4)] & 0xFF);
      this.skM = (paramArrayOfByte[(paramInt + 5)] & 0xFF);
      this.skN = (paramArrayOfByte[(paramInt + 6)] & 0xFF);
      Log.d(b.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", new Object[] { Integer.valueOf(this.mYear), Integer.valueOf(this.mMonth), Integer.valueOf(this.mDay), Integer.valueOf(this.skL), Integer.valueOf(this.skM), Integer.valueOf(this.skN) });
      AppMethodBeat.o(22570);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */