package com.google.android.exoplayer2;

public final class p
{
  public static final p auS = new p(1.0F, 1.0F);
  public final float auT;
  public final int auU;
  public final float pitch;
  
  public p(float paramFloat1, float paramFloat2)
  {
    this.auT = paramFloat1;
    this.pitch = paramFloat2;
    this.auU = Math.round(1000.0F * paramFloat1);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (p)paramObject;
    } while ((this.auT == paramObject.auT) && (this.pitch == paramObject.pitch));
    return false;
  }
  
  public final int hashCode()
  {
    return (Float.floatToRawIntBits(this.auT) + 527) * 31 + Float.floatToRawIntBits(this.pitch);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.p
 * JD-Core Version:    0.7.0.1
 */