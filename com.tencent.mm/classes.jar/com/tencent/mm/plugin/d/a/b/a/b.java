package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;
import com.tencent.mm.sdk.platformtools.ac;

public class b
  extends a
{
  static final String TAG;
  public static String nqH;
  public static String nqI;
  public static String nqJ;
  private final int nqK = 1;
  private final int nqL = 2;
  private final int nqM = 4;
  private final int nqN = 8;
  private final int nqO = 16;
  b nqP = null;
  a nqQ;
  int nqR;
  
  static
  {
    AppMethodBeat.i(22572);
    TAG = b.class.getName();
    nqH = h.nqB;
    nqI = h.nqC;
    nqJ = h.nqD;
    AppMethodBeat.o(22572);
  }
  
  public b()
  {
    this.nqF = null;
    this.nqG = 2;
    this.npZ = 8L;
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
    ac.d(TAG, "hbyte=" + i + " hvalue=" + k + " value=" + paramInt + " exp=" + j);
    AppMethodBeat.o(22571);
    return d1 * d2;
  }
  
  public final byte[] bIB()
  {
    return null;
  }
  
  final class a
  {
    public boolean nqS;
    public double nqT;
    public int nqU;
    public int nqV;
    public int nqW;
    public b.c nqX;
    
    public a()
    {
      AppMethodBeat.i(22568);
      this.nqS = false;
      this.nqT = 0.0D;
      this.nqU = 0;
      this.nqV = 0;
      this.nqW = 0;
      this.nqX = new b.c();
      AppMethodBeat.o(22568);
    }
  }
  
  final class b
  {
    public boolean nqS;
    public int nqU;
    public int nqV;
    public int nqW;
    public b.c nqX;
    public double nqZ;
    public double nra;
    public double nrb;
    
    public b()
    {
      AppMethodBeat.i(22569);
      this.nqS = false;
      this.nqZ = 0.0D;
      this.nra = 0.0D;
      this.nrb = 0.0D;
      this.nqU = 0;
      this.nqV = 0;
      this.nqW = 0;
      this.nqX = new b.c();
      AppMethodBeat.o(22569);
    }
  }
  
  public static final class c
  {
    public int mDay = 0;
    public int mMonth = 0;
    public int mYear = 0;
    public int nrc = 0;
    public int nrd = 0;
    public int nre = 0;
    
    public final boolean N(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(22570);
      String str = b.TAG;
      if (paramArrayOfByte == null) {}
      for (int i = 0;; i = paramArrayOfByte.length)
      {
        ac.d(str, "data size = %d, offset = %d, lenght = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(7) });
        if ((paramArrayOfByte != null) && (paramInt >= 0) && (paramArrayOfByte.length >= paramInt + 7)) {
          break;
        }
        ac.e(b.TAG, "data input error");
        AppMethodBeat.o(22570);
        return false;
      }
      this.mYear = ((paramArrayOfByte[paramInt] & 0xFF) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8));
      this.mMonth = (paramArrayOfByte[(paramInt + 2)] & 0xFF);
      this.mDay = (paramArrayOfByte[(paramInt + 3)] & 0xFF);
      this.nrc = (paramArrayOfByte[(paramInt + 4)] & 0xFF);
      this.nrd = (paramArrayOfByte[(paramInt + 5)] & 0xFF);
      this.nre = (paramArrayOfByte[(paramInt + 6)] & 0xFF);
      ac.d(b.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", new Object[] { Integer.valueOf(this.mYear), Integer.valueOf(this.mMonth), Integer.valueOf(this.mDay), Integer.valueOf(this.nrc), Integer.valueOf(this.nrd), Integer.valueOf(this.nre) });
      AppMethodBeat.o(22570);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */