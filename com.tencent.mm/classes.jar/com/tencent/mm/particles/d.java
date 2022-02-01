package com.tencent.mm.particles;

public final class d
{
  public final int iJr;
  public final int iJs;
  public final int iJt;
  public final int iJu;
  
  public d(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, paramInt1, paramInt2);
  }
  
  private d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.iJr = paramInt1;
    this.iJs = paramInt2;
    this.iJt = paramInt3;
    this.iJu = paramInt4;
  }
  
  protected final float ar(float paramFloat)
  {
    return this.iJr + (this.iJt - this.iJr) * paramFloat;
  }
  
  protected final float as(float paramFloat)
  {
    return this.iJs + (this.iJu - this.iJs) * paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.particles.d
 * JD-Core Version:    0.7.0.1
 */