package com.tencent.mm.plugin.backup.b;

public final class e
{
  public int mqj = -100;
  public int mqk;
  public int mql;
  public int mqm;
  public long mqn;
  public long mqo;
  public long mqp;
  public long mqq;
  public long mqr;
  public long mqs;
  public long mqt;
  public long mqu;
  
  public final void O(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mqj = paramInt1;
    this.mqk = paramInt2;
    this.mql = paramInt3;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.mqj = paramInt1;
    this.mqk = paramInt2;
    this.mql = paramInt3;
    this.mqn = paramLong1;
    this.mqq = paramLong2;
    this.mqo = paramLong3;
    this.mqp = paramLong4;
  }
  
  public final int bwc()
  {
    if (this.mqq == 0L) {
      return 1;
    }
    double d = this.mqn * 100L / this.mqq;
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