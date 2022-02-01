package com.tencent.mm.particles;

public final class d
{
  public final int hPA;
  public final int hPB;
  public final int hPC;
  public final int hPz;
  
  public d(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, paramInt1, paramInt2);
  }
  
  private d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.hPz = paramInt1;
    this.hPA = paramInt2;
    this.hPB = paramInt3;
    this.hPC = paramInt4;
  }
  
  protected final float ak(float paramFloat)
  {
    return this.hPz + (this.hPB - this.hPz) * paramFloat;
  }
  
  protected final float al(float paramFloat)
  {
    return this.hPA + (this.hPC - this.hPA) * paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.particles.d
 * JD-Core Version:    0.7.0.1
 */