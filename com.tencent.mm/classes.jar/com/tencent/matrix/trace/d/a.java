package com.tencent.matrix.trace.d;

public final class a
{
  public int aVH;
  public int bRM;
  public int bRN;
  public int count = 1;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.bRM = paramInt1;
    this.bRN = paramInt2;
    this.aVH = paramInt3;
  }
  
  public final void az(long paramLong)
  {
    this.count += 1;
    this.bRN = ((int)(this.bRN + paramLong));
  }
  
  public final String toString()
  {
    return this.aVH + "," + this.bRM + "," + this.count + "," + this.bRN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.d.a
 * JD-Core Version:    0.7.0.1
 */