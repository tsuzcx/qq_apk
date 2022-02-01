package com.tencent.mm.plugin.backup.b;

public final class e
{
  public int rKS = -100;
  public int rKT;
  public int rKU;
  public int rKV;
  public long rKW;
  public long rKX;
  public long rKY;
  public long rKZ;
  public long rLa;
  public long rLb;
  public long rLc;
  public long rLd;
  
  public final void T(int paramInt1, int paramInt2, int paramInt3)
  {
    this.rKS = paramInt1;
    this.rKT = paramInt2;
    this.rKU = paramInt3;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.rKS = paramInt1;
    this.rKT = paramInt2;
    this.rKU = paramInt3;
    this.rKW = paramLong1;
    this.rKZ = paramLong2;
    this.rKX = paramLong3;
    this.rKY = paramLong4;
  }
  
  public final int csi()
  {
    if (this.rKZ == 0L) {
      return 1;
    }
    double d = this.rKW * 100L / this.rKZ;
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