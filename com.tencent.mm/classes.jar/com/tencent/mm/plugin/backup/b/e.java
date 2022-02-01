package com.tencent.mm.plugin.backup.b;

public final class e
{
  public int nye = -100;
  public int nyf;
  public int nyg;
  public int nyh;
  public long nyi;
  public long nyj;
  public long nyk;
  public long nyl;
  public long nym;
  public long nyn;
  public long nyo;
  public long nyp;
  
  public final void R(int paramInt1, int paramInt2, int paramInt3)
  {
    this.nye = paramInt1;
    this.nyf = paramInt2;
    this.nyg = paramInt3;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.nye = paramInt1;
    this.nyf = paramInt2;
    this.nyg = paramInt3;
    this.nyi = paramLong1;
    this.nyl = paramLong2;
    this.nyj = paramLong3;
    this.nyk = paramLong4;
  }
  
  public final int bIe()
  {
    if (this.nyl == 0L) {
      return 1;
    }
    double d = this.nyi * 100L / this.nyl;
    if (d <= 5.0D) {}
    for (d *= 4.0D;; d = (d - 5.0D) * 80.0D / 95.0D + 20.0D) {
      return (int)d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.e
 * JD-Core Version:    0.7.0.1
 */