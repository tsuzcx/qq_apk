package com.google.android.exoplayer2.source;

public final class f$b
{
  public static final b aIl = new b(-1, -1, -1);
  public final int aIm;
  public final int aIn;
  public final int aIo;
  
  public f$b(int paramInt)
  {
    this(paramInt, -1, -1);
  }
  
  public f$b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.aIm = paramInt1;
    this.aIn = paramInt2;
    this.aIo = paramInt3;
  }
  
  public final b dg(int paramInt)
  {
    if (this.aIm == paramInt) {
      return this;
    }
    return new b(paramInt, this.aIn, this.aIo);
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
      paramObject = (b)paramObject;
    } while ((this.aIm == paramObject.aIm) && (this.aIn == paramObject.aIn) && (this.aIo == paramObject.aIo));
    return false;
  }
  
  public final int hashCode()
  {
    return ((this.aIm + 527) * 31 + this.aIn) * 31 + this.aIo;
  }
  
  public final boolean mG()
  {
    return this.aIn != -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.f.b
 * JD-Core Version:    0.7.0.1
 */