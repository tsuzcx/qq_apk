package com.e.a.b;

public final class j
  extends i
{
  public k ceE = k.ceJ;
  int ceF;
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
    this.ceE = paramk;
    this.ceF = paramInt;
  }
  
  public final i Bt()
  {
    if (this.ceE == k.ceK) {
      return this.cex.ceo.aF(this.MI);
    }
    return this.cex.ceo.aE(this.MI);
  }
  
  public final String toString()
  {
    return String.format("%s@0x%08x", new Object[] { this.ceE.mName, Long.valueOf(this.MI) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.e.a.b.j
 * JD-Core Version:    0.7.0.1
 */