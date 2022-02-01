package com.tencent.matrix.trace.d;

public final class a
{
  public int btK;
  public int cCx;
  public int cCy;
  public int count = 1;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.cCx = paramInt1;
    this.cCy = paramInt2;
    this.btK = paramInt3;
  }
  
  public final void aX(long paramLong)
  {
    this.count += 1;
    this.cCy = ((int)(this.cCy + paramLong));
  }
  
  public final String toString()
  {
    return this.btK + "," + this.cCx + "," + this.count + "," + this.cCy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.trace.d.a
 * JD-Core Version:    0.7.0.1
 */