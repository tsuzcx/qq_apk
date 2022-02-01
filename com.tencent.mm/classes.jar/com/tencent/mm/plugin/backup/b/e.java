package com.tencent.mm.plugin.backup.b;

public final class e
{
  public int oJc = -100;
  public int oJd;
  public int oJe;
  public int oJf;
  public long oJg;
  public long oJh;
  public long oJi;
  public long oJj;
  public long oJk;
  public long oJl;
  public long oJm;
  public long oJn;
  
  public final void S(int paramInt1, int paramInt2, int paramInt3)
  {
    this.oJc = paramInt1;
    this.oJd = paramInt2;
    this.oJe = paramInt3;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.oJc = paramInt1;
    this.oJd = paramInt2;
    this.oJe = paramInt3;
    this.oJg = paramLong1;
    this.oJj = paramLong2;
    this.oJh = paramLong3;
    this.oJi = paramLong4;
  }
  
  public final int ceV()
  {
    if (this.oJj == 0L) {
      return 1;
    }
    double d = this.oJg * 100L / this.oJj;
    if (d <= 5.0D) {}
    for (d *= 4.0D;; d = (d - 5.0D) * 80.0D / 95.0D + 20.0D) {
      return (int)d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.e
 * JD-Core Version:    0.7.0.1
 */