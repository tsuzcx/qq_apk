package com.tencent.mm.particles;

public final class d
{
  public final int mAd;
  public final int mAe;
  public final int mAf;
  public final int mAg;
  
  public d(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, paramInt1, paramInt2);
  }
  
  private d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mAd = paramInt1;
    this.mAe = paramInt2;
    this.mAf = paramInt3;
    this.mAg = paramInt4;
  }
  
  protected final float aA(float paramFloat)
  {
    return this.mAd + (this.mAf - this.mAd) * paramFloat;
  }
  
  protected final float aB(float paramFloat)
  {
    return this.mAe + (this.mAg - this.mAe) * paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.particles.d
 * JD-Core Version:    0.7.0.1
 */