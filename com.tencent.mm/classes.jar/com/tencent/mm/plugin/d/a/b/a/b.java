package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;
import com.tencent.mm.sdk.platformtools.Log;

public class b
  extends a
{
  static final String TAG;
  public static String pig;
  public static String pih;
  public static String pii;
  private final int pij = 1;
  private final int pik = 2;
  private final int pil = 4;
  private final int pim = 8;
  private final int pio = 16;
  b pip = null;
  a piq;
  int pir;
  
  static
  {
    AppMethodBeat.i(22572);
    TAG = b.class.getName();
    pig = h.phZ;
    pih = h.pia;
    pii = h.pib;
    AppMethodBeat.o(22572);
  }
  
  public b()
  {
    this.pie = null;
    this.pif = 2;
    this.phx = 8L;
  }
  
  static double O(byte[] paramArrayOfByte, int paramInt)
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
  
  public final byte[] ckM()
  {
    return null;
  }
  
  final class a
  {
    public boolean pis;
    public double pit;
    public int piu;
    public int piv;
    public int piw;
    public b.c pix;
    
    public a()
    {
      AppMethodBeat.i(22568);
      this.pis = false;
      this.pit = 0.0D;
      this.piu = 0;
      this.piv = 0;
      this.piw = 0;
      this.pix = new b.c();
      AppMethodBeat.o(22568);
    }
  }
  
  final class b
  {
    public double piA;
    public double piB;
    public boolean pis;
    public int piu;
    public int piv;
    public int piw;
    public b.c pix;
    public double piz;
    
    public b()
    {
      AppMethodBeat.i(22569);
      this.pis = false;
      this.piz = 0.0D;
      this.piA = 0.0D;
      this.piB = 0.0D;
      this.piu = 0;
      this.piv = 0;
      this.piw = 0;
      this.pix = new b.c();
      AppMethodBeat.o(22569);
    }
  }
  
  public static final class c
  {
    public int mDay = 0;
    public int mMonth = 0;
    public int mYear = 0;
    public int piC = 0;
    public int piD = 0;
    public int piE = 0;
    
    public final boolean P(byte[] paramArrayOfByte, int paramInt)
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
      this.piC = (paramArrayOfByte[(paramInt + 4)] & 0xFF);
      this.piD = (paramArrayOfByte[(paramInt + 5)] & 0xFF);
      this.piE = (paramArrayOfByte[(paramInt + 6)] & 0xFF);
      Log.d(b.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", new Object[] { Integer.valueOf(this.mYear), Integer.valueOf(this.mMonth), Integer.valueOf(this.mDay), Integer.valueOf(this.piC), Integer.valueOf(this.piD), Integer.valueOf(this.piE) });
      AppMethodBeat.o(22570);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */