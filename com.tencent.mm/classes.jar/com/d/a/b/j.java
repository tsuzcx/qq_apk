package com.d.a.b;

public final class j
  extends i
{
  public k bWJ = k.bWO;
  int bWK;
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
    this.bWJ = paramk;
    this.bWK = paramInt;
  }
  
  public final i Aj()
  {
    if (this.bWJ == k.bWP) {
      return this.bWC.bWt.aJ(this.JV);
    }
    return this.bWC.bWt.aI(this.JV);
  }
  
  public final String toString()
  {
    return String.format("%s@0x%08x", new Object[] { this.bWJ.mName, Long.valueOf(this.JV) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.b.j
 * JD-Core Version:    0.7.0.1
 */