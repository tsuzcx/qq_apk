package com.google.android.exoplayer2;

public final class w$a
{
  public Object atW;
  public long auP;
  public int auk;
  public long[][] avA;
  public long avB;
  public Object avu;
  public long avv;
  public long[] avw;
  public int[] avx;
  public int[] avy;
  public int[] avz;
  
  public final boolean aD(int paramInt1, int paramInt2)
  {
    return paramInt2 < this.avy[paramInt1];
  }
  
  public final long aE(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= this.avA[paramInt1].length) {
      return -9223372036854775807L;
    }
    return this.avA[paramInt1][paramInt2];
  }
  
  public final boolean cD(int paramInt)
  {
    return (this.avx[paramInt] != -1) && (this.avz[paramInt] == this.avx[paramInt]);
  }
  
  public final int kX()
  {
    if (this.avw == null) {
      return 0;
    }
    return this.avw.length;
  }
  
  public final int y(long paramLong)
  {
    if (this.avw == null) {}
    int i;
    do
    {
      return -1;
      i = this.avw.length - 1;
      while ((i >= 0) && ((this.avw[i] == -9223372036854775808L) || (this.avw[i] > paramLong))) {
        i -= 1;
      }
    } while ((i < 0) || (cD(i)));
    return i;
  }
  
  public final int z(long paramLong)
  {
    int j;
    if (this.avw == null) {
      j = -1;
    }
    int i;
    do
    {
      return j;
      i = 0;
      while ((i < this.avw.length) && (this.avw[i] != -9223372036854775808L) && ((paramLong >= this.avw[i]) || (cD(i)))) {
        i += 1;
      }
      j = i;
    } while (i < this.avw.length);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.w.a
 * JD-Core Version:    0.7.0.1
 */