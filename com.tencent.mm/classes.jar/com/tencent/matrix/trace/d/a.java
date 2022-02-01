package com.tencent.matrix.trace.d;

public final class a
{
  public int bCe;
  public int count = 1;
  public int dbJ;
  public int dbK;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.dbJ = paramInt1;
    this.dbK = paramInt2;
    this.bCe = paramInt3;
  }
  
  public final void bi(long paramLong)
  {
    this.count += 1;
    this.dbK = ((int)(this.dbK + paramLong));
  }
  
  public final String toString()
  {
    return this.bCe + "," + this.dbJ + "," + this.count + "," + this.dbK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.trace.d.a
 * JD-Core Version:    0.7.0.1
 */