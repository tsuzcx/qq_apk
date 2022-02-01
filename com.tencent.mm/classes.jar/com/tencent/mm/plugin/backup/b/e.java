package com.tencent.mm.plugin.backup.b;

public final class e
{
  public int mSk = -100;
  public int mSl;
  public int mSm;
  public int mSn;
  public long mSp;
  public long mSq;
  public long mSr;
  public long mSs;
  public long mSt;
  public long mSu;
  public long mSv;
  public long mSw;
  
  public final void P(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mSk = paramInt1;
    this.mSl = paramInt2;
    this.mSm = paramInt3;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.mSk = paramInt1;
    this.mSl = paramInt2;
    this.mSm = paramInt3;
    this.mSp = paramLong1;
    this.mSs = paramLong2;
    this.mSq = paramLong3;
    this.mSr = paramLong4;
  }
  
  public final int bCY()
  {
    if (this.mSs == 0L) {
      return 1;
    }
    double d = this.mSp * 100L / this.mSs;
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