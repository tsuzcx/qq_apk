package com.tencent.mm.particles;

public final class d
{
  public final int iMk;
  public final int iMl;
  public final int iMm;
  public final int iMn;
  
  public d(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, paramInt1, paramInt2);
  }
  
  private d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.iMk = paramInt1;
    this.iMl = paramInt2;
    this.iMm = paramInt3;
    this.iMn = paramInt4;
  }
  
  protected final float ar(float paramFloat)
  {
    return this.iMk + (this.iMm - this.iMk) * paramFloat;
  }
  
  protected final float as(float paramFloat)
  {
    return this.iMl + (this.iMn - this.iMl) * paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.particles.d
 * JD-Core Version:    0.7.0.1
 */