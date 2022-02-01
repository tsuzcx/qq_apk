package com.tencent.matrix.trace.d;

public final class a
{
  public int aOm;
  public int count = 1;
  public int ffa;
  public int ffb;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.ffa = paramInt1;
    this.ffb = paramInt2;
    this.aOm = paramInt3;
  }
  
  public final void dP(long paramLong)
  {
    this.count += 1;
    this.ffb = ((int)(this.ffb + paramLong));
  }
  
  public final String toString()
  {
    return this.aOm + "," + this.ffa + "," + this.count + "," + this.ffb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.trace.d.a
 * JD-Core Version:    0.7.0.1
 */