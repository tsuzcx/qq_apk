package com.tencent.mm.particles;

public final class d
{
  public final int pwN;
  public final int pwO;
  public final int pwP;
  public final int pwQ;
  
  public d(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, paramInt1, paramInt2);
  }
  
  private d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.pwN = paramInt1;
    this.pwO = paramInt2;
    this.pwP = paramInt3;
    this.pwQ = paramInt4;
  }
  
  protected final float by(float paramFloat)
  {
    return this.pwN + (this.pwP - this.pwN) * paramFloat;
  }
  
  protected final float bz(float paramFloat)
  {
    return this.pwO + (this.pwQ - this.pwO) * paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.particles.d
 * JD-Core Version:    0.7.0.1
 */