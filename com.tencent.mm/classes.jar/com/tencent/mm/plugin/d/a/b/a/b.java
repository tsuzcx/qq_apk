package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;
import com.tencent.mm.sdk.platformtools.ad;

public class b
  extends a
{
  static final String TAG;
  public static String mOv;
  public static String mOw;
  public static String mOx;
  private final int mOA = 4;
  private final int mOB = 8;
  private final int mOC = 16;
  b mOD = null;
  a mOE;
  int mOF;
  private final int mOy = 1;
  private final int mOz = 2;
  
  static
  {
    AppMethodBeat.i(22572);
    TAG = b.class.getName();
    mOv = h.mOp;
    mOw = h.mOq;
    mOx = h.mOr;
    AppMethodBeat.o(22572);
  }
  
  public b()
  {
    this.mOt = null;
    this.mOu = 2;
    this.mNN = 8L;
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
    ad.d(TAG, "hbyte=" + i + " hvalue=" + k + " value=" + paramInt + " exp=" + j);
    AppMethodBeat.o(22571);
    return d1 * d2;
  }
  
  public final byte[] bBD()
  {
    return null;
  }
  
  final class a
  {
    public boolean mOG;
    public double mOH;
    public int mOI;
    public int mOJ;
    public int mOK;
    public b.c mOL;
    
    public a()
    {
      AppMethodBeat.i(22568);
      this.mOG = false;
      this.mOH = 0.0D;
      this.mOI = 0;
      this.mOJ = 0;
      this.mOK = 0;
      this.mOL = new b.c();
      AppMethodBeat.o(22568);
    }
  }
  
  final class b
  {
    public boolean mOG;
    public int mOI;
    public int mOJ;
    public int mOK;
    public b.c mOL;
    public double mON;
    public double mOO;
    public double mOP;
    
    public b()
    {
      AppMethodBeat.i(22569);
      this.mOG = false;
      this.mON = 0.0D;
      this.mOO = 0.0D;
      this.mOP = 0.0D;
      this.mOI = 0;
      this.mOJ = 0;
      this.mOK = 0;
      this.mOL = new b.c();
      AppMethodBeat.o(22569);
    }
  }
  
  public static final class c
  {
    public int mDay = 0;
    public int mMonth = 0;
    public int mOQ = 0;
    public int mOR = 0;
    public int mOS = 0;
    public int mYear = 0;
    
    public final boolean P(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(22570);
      String str = b.TAG;
      if (paramArrayOfByte == null) {}
      for (int i = 0;; i = paramArrayOfByte.length)
      {
        ad.d(str, "data size = %d, offset = %d, lenght = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(7) });
        if ((paramArrayOfByte != null) && (paramInt >= 0) && (paramArrayOfByte.length >= paramInt + 7)) {
          break;
        }
        ad.e(b.TAG, "data input error");
        AppMethodBeat.o(22570);
        return false;
      }
      this.mYear = ((paramArrayOfByte[paramInt] & 0xFF) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8));
      this.mMonth = (paramArrayOfByte[(paramInt + 2)] & 0xFF);
      this.mDay = (paramArrayOfByte[(paramInt + 3)] & 0xFF);
      this.mOQ = (paramArrayOfByte[(paramInt + 4)] & 0xFF);
      this.mOR = (paramArrayOfByte[(paramInt + 5)] & 0xFF);
      this.mOS = (paramArrayOfByte[(paramInt + 6)] & 0xFF);
      ad.d(b.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", new Object[] { Integer.valueOf(this.mYear), Integer.valueOf(this.mMonth), Integer.valueOf(this.mDay), Integer.valueOf(this.mOQ), Integer.valueOf(this.mOR), Integer.valueOf(this.mOS) });
      AppMethodBeat.o(22570);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */