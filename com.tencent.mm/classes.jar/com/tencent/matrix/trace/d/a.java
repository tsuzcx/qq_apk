package com.tencent.matrix.trace.d;

public final class a
{
  public int bCc;
  public int cKC;
  public int cKD;
  public int count = 1;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.cKC = paramInt1;
    this.cKD = paramInt2;
    this.bCc = paramInt3;
  }
  
  public final void aT(long paramLong)
  {
    this.count += 1;
    this.cKD = ((int)(this.cKD + paramLong));
  }
  
  public final String toString()
  {
    return this.bCc + "," + this.cKC + "," + this.count + "," + this.cKD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.d.a
 * JD-Core Version:    0.7.0.1
 */