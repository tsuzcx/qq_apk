package com.tencent.mm.plugin.g.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.g.a.b.h;
import com.tencent.mm.sdk.platformtools.Log;

public class b
  extends a
{
  static final String TAG;
  public static String vwp;
  public static String vwq;
  public static String vwr;
  private final int vws = 1;
  private final int vwt = 2;
  private final int vwu = 4;
  private final int vwv = 8;
  private final int vww = 16;
  b vwx = null;
  a vwy;
  int vwz;
  
  static
  {
    AppMethodBeat.i(22572);
    TAG = b.class.getName();
    vwp = h.vwj;
    vwq = h.vwk;
    vwr = h.vwl;
    AppMethodBeat.o(22572);
  }
  
  public b()
  {
    this.vwn = null;
    this.vwo = 2;
    this.vvH = 8L;
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
  
  public final byte[] daY()
  {
    return null;
  }
  
  final class a
  {
    public boolean vwA;
    public double vwB;
    public int vwC;
    public int vwD;
    public int vwE;
    public b.c vwF;
    
    public a()
    {
      AppMethodBeat.i(22568);
      this.vwA = false;
      this.vwB = 0.0D;
      this.vwC = 0;
      this.vwD = 0;
      this.vwE = 0;
      this.vwF = new b.c();
      AppMethodBeat.o(22568);
    }
  }
  
  final class b
  {
    public boolean vwA;
    public int vwC;
    public int vwD;
    public int vwE;
    public b.c vwF;
    public double vwH;
    public double vwI;
    public double vwJ;
    
    public b()
    {
      AppMethodBeat.i(22569);
      this.vwA = false;
      this.vwH = 0.0D;
      this.vwI = 0.0D;
      this.vwJ = 0.0D;
      this.vwC = 0;
      this.vwD = 0;
      this.vwE = 0;
      this.vwF = new b.c();
      AppMethodBeat.o(22569);
    }
  }
  
  public static final class c
  {
    public int mDay = 0;
    public int mMonth = 0;
    public int mYear = 0;
    public int vwK = 0;
    public int vwL = 0;
    public int vwM = 0;
    
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
      this.vwK = (paramArrayOfByte[(paramInt + 4)] & 0xFF);
      this.vwL = (paramArrayOfByte[(paramInt + 5)] & 0xFF);
      this.vwM = (paramArrayOfByte[(paramInt + 6)] & 0xFF);
      Log.d(b.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", new Object[] { Integer.valueOf(this.mYear), Integer.valueOf(this.mMonth), Integer.valueOf(this.mDay), Integer.valueOf(this.vwK), Integer.valueOf(this.vwL), Integer.valueOf(this.vwM) });
      AppMethodBeat.o(22570);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */