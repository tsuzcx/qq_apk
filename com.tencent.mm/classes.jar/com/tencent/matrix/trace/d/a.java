package com.tencent.matrix.trace.d;

public final class a
{
  public int bCc;
  public int cLl;
  public int cLm;
  public int count = 1;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.cLl = paramInt1;
    this.cLm = paramInt2;
    this.bCc = paramInt3;
  }
  
  public final void aT(long paramLong)
  {
    this.count += 1;
    this.cLm = ((int)(this.cLm + paramLong));
  }
  
  public final String toString()
  {
    return this.bCc + "," + this.cLl + "," + this.count + "," + this.cLm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.d.a
 * JD-Core Version:    0.7.0.1
 */