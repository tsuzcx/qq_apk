package com.tencent.matrix.trace.d;

public final class a
{
  public int brJ;
  public int count = 1;
  public int czG;
  public int czH;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.czG = paramInt1;
    this.czH = paramInt2;
    this.brJ = paramInt3;
  }
  
  public final void aT(long paramLong)
  {
    this.count += 1;
    this.czH = ((int)(this.czH + paramLong));
  }
  
  public final String toString()
  {
    return this.brJ + "," + this.czG + "," + this.count + "," + this.czH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.d.a
 * JD-Core Version:    0.7.0.1
 */