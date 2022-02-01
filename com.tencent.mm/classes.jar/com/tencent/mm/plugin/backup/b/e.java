package com.tencent.mm.plugin.backup.b;

public final class e
{
  public int nsJ = -100;
  public int nsK;
  public int nsL;
  public int nsM;
  public long nsN;
  public long nsO;
  public long nsP;
  public long nsQ;
  public long nsR;
  public long nsS;
  public long nsT;
  public long nsU;
  
  public final void R(int paramInt1, int paramInt2, int paramInt3)
  {
    this.nsJ = paramInt1;
    this.nsK = paramInt2;
    this.nsL = paramInt3;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.nsJ = paramInt1;
    this.nsK = paramInt2;
    this.nsL = paramInt3;
    this.nsN = paramLong1;
    this.nsQ = paramLong2;
    this.nsO = paramLong3;
    this.nsP = paramLong4;
  }
  
  public final int bHg()
  {
    if (this.nsQ == 0L) {
      return 1;
    }
    double d = this.nsN * 100L / this.nsQ;
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