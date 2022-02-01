package com.tencent.matrix.trace.d;

public final class a
{
  public int blG;
  public int count = 1;
  public int dfL;
  public int dfM;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.dfL = paramInt1;
    this.dfM = paramInt2;
    this.blG = paramInt3;
  }
  
  public final void bu(long paramLong)
  {
    this.count += 1;
    this.dfM = ((int)(this.dfM + paramLong));
  }
  
  public final String toString()
  {
    return this.blG + "," + this.dfL + "," + this.count + "," + this.dfM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.d.a
 * JD-Core Version:    0.7.0.1
 */