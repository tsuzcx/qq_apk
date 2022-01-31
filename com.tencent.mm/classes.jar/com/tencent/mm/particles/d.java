package com.tencent.mm.particles;

public final class d
{
  public final int ghC;
  public final int ghD;
  public final int ghE;
  public final int ghF;
  
  public d(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, paramInt1, paramInt2);
  }
  
  private d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.ghC = paramInt1;
    this.ghD = paramInt2;
    this.ghE = paramInt3;
    this.ghF = paramInt4;
  }
  
  protected final float ak(float paramFloat)
  {
    return this.ghC + (this.ghE - this.ghC) * paramFloat;
  }
  
  protected final float al(float paramFloat)
  {
    return this.ghD + (this.ghF - this.ghD) * paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.particles.d
 * JD-Core Version:    0.7.0.1
 */