package com.tencent.mm.plugin.backup.b;

public final class e
{
  public int uWg = -100;
  public int uWh;
  public int uWi;
  public int uWj;
  public long uWk;
  public long uWl;
  public long uWm;
  public long uWn;
  public long uWo;
  public long uWp;
  public long uWq;
  public long uWr;
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.uWg = paramInt1;
    this.uWh = paramInt2;
    this.uWi = paramInt3;
    this.uWk = paramLong1;
    this.uWn = paramLong2;
    this.uWl = paramLong3;
    this.uWm = paramLong4;
  }
  
  public final void ak(int paramInt1, int paramInt2, int paramInt3)
  {
    this.uWg = paramInt1;
    this.uWh = paramInt2;
    this.uWi = paramInt3;
  }
  
  public final int cUS()
  {
    if (this.uWn == 0L) {
      return 1;
    }
    double d = this.uWk * 100L / this.uWn;
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