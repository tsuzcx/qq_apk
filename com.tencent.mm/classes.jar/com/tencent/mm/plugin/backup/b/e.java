package com.tencent.mm.plugin.backup.b;

public final class e
{
  public long hFA;
  public int hFu = -100;
  public int hFv;
  public int hFw;
  public int hFx;
  public long hFy;
  public long hFz;
  
  public final void B(int paramInt1, int paramInt2, int paramInt3)
  {
    this.hFu = paramInt1;
    this.hFv = paramInt2;
    this.hFw = paramInt3;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    this.hFu = paramInt1;
    this.hFv = paramInt2;
    this.hFw = paramInt3;
    this.hFy = paramLong1;
    this.hFz = paramLong2;
  }
  
  public final int atw()
  {
    if (this.hFz == 0L) {
      return 1;
    }
    double d = this.hFy * 100L / this.hFz;
    if (d <= 5.0D) {}
    for (d *= 4.0D;; d = (d - 5.0D) * 80.0D / 95.0D + 20.0D) {
      return (int)d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.e
 * JD-Core Version:    0.7.0.1
 */