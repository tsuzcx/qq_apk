package com.tencent.mm.plugin.backup.b;

public final class e
{
  public int jyN = -100;
  public int jyO;
  public int jyP;
  public int jyQ;
  public long jyR;
  public long jyS;
  public long jyT;
  public long jyU;
  public long jyV;
  public long jyW;
  public long jyX;
  
  public final void N(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jyN = paramInt1;
    this.jyO = paramInt2;
    this.jyP = paramInt3;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.jyN = paramInt1;
    this.jyO = paramInt2;
    this.jyP = paramInt3;
    this.jyR = paramLong1;
    this.jyU = paramLong2;
    this.jyS = paramLong3;
    this.jyT = paramLong4;
  }
  
  public final int aSU()
  {
    if (this.jyU == 0L) {
      return 1;
    }
    double d = this.jyR * 100L / this.jyU;
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