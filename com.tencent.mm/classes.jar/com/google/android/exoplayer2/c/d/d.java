package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
{
  public static a a(int paramInt, long[] paramArrayOfLong, int[] paramArrayOfInt, long paramLong)
  {
    AppMethodBeat.i(92074);
    int i1 = 8192 / paramInt;
    int k = paramArrayOfInt.length;
    int j = 0;
    int m;
    for (int i = 0; j < k; i = m + i)
    {
      m = x.bo(paramArrayOfInt[j], i1);
      j += 1;
    }
    long[] arrayOfLong1 = new long[i];
    int[] arrayOfInt1 = new int[i];
    int n = 0;
    long[] arrayOfLong2 = new long[i];
    int[] arrayOfInt2 = new int[i];
    k = 0;
    j = 0;
    i = 0;
    while (i < paramArrayOfInt.length)
    {
      m = paramArrayOfInt[i];
      long l = paramArrayOfLong[i];
      while (m > 0)
      {
        int i2 = Math.min(i1, m);
        arrayOfLong1[j] = l;
        arrayOfInt1[j] = (paramInt * i2);
        n = Math.max(n, arrayOfInt1[j]);
        arrayOfLong2[j] = (k * paramLong);
        arrayOfInt2[j] = 1;
        l += arrayOfInt1[j];
        k += i2;
        m -= i2;
        j += 1;
      }
      i += 1;
    }
    paramArrayOfLong = new a(arrayOfLong1, arrayOfInt1, n, arrayOfLong2, arrayOfInt2, (byte)0);
    AppMethodBeat.o(92074);
    return paramArrayOfLong;
  }
  
  public static final class a
  {
    public final int[] bhJ;
    public final int bnb;
    public final long[] bnc;
    public final int[] bnd;
    public final long[] offsets;
    
    private a(long[] paramArrayOfLong1, int[] paramArrayOfInt1, int paramInt, long[] paramArrayOfLong2, int[] paramArrayOfInt2)
    {
      this.offsets = paramArrayOfLong1;
      this.bhJ = paramArrayOfInt1;
      this.bnb = paramInt;
      this.bnc = paramArrayOfLong2;
      this.bnd = paramArrayOfInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.d
 * JD-Core Version:    0.7.0.1
 */