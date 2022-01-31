package com.google.android.exoplayer2;

public final class t
{
  public static final t auV = new t(0);
  public final int auW;
  
  public t(int paramInt)
  {
    this.auW = paramInt;
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
      paramObject = (t)paramObject;
    } while (this.auW == paramObject.auW);
    return false;
  }
  
  public final int hashCode()
  {
    return this.auW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.t
 * JD-Core Version:    0.7.0.1
 */