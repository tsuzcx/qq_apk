package com.d.a.b;

public final class j
  extends i
{
  public k ckI = k.ckN;
  int ckJ;
  int mIndex;
  
  public j(k paramk)
  {
    this(paramk, 0L, 0, null);
  }
  
  public j(k paramk, long paramLong)
  {
    this(paramk, paramLong, 0, null);
  }
  
  public j(k paramk, long paramLong, int paramInt, n paramn)
  {
    super(paramLong, paramn);
    this.ckI = paramk;
    this.ckJ = paramInt;
  }
  
  public final i Lg()
  {
    if (this.ckI == k.ckO) {
      return this.ckB.cks.aU(this.dI);
    }
    return this.ckB.cks.aT(this.dI);
  }
  
  public final String toString()
  {
    return String.format("%s@0x%08x", new Object[] { this.ckI.mName, Long.valueOf(this.dI) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.b.j
 * JD-Core Version:    0.7.0.1
 */