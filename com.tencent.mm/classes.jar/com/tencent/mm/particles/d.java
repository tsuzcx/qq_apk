package com.tencent.mm.particles;

public final class d
{
  public final int ipU;
  public final int ipV;
  public final int ipW;
  public final int ipX;
  
  public d(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, paramInt1, paramInt2);
  }
  
  private d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.ipU = paramInt1;
    this.ipV = paramInt2;
    this.ipW = paramInt3;
    this.ipX = paramInt4;
  }
  
  protected final float ao(float paramFloat)
  {
    return this.ipU + (this.ipW - this.ipU) * paramFloat;
  }
  
  protected final float ap(float paramFloat)
  {
    return this.ipV + (this.ipX - this.ipV) * paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.particles.d
 * JD-Core Version:    0.7.0.1
 */