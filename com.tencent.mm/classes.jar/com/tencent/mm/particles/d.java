package com.tencent.mm.particles;

public final class d
{
  public final int jIY;
  public final int jIZ;
  public final int jJa;
  public final int jJb;
  
  public d(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, paramInt1, paramInt2);
  }
  
  private d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jIY = paramInt1;
    this.jIZ = paramInt2;
    this.jJa = paramInt3;
    this.jJb = paramInt4;
  }
  
  protected final float aA(float paramFloat)
  {
    return this.jIY + (this.jJa - this.jIY) * paramFloat;
  }
  
  protected final float aB(float paramFloat)
  {
    return this.jIZ + (this.jJb - this.jIZ) * paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.particles.d
 * JD-Core Version:    0.7.0.1
 */