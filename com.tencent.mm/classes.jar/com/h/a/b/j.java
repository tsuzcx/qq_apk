package com.h.a.b;

public final class j
  extends i
{
  public k ebd = k.ebi;
  int ebe;
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
    this.ebd = paramk;
    this.ebe = paramInt;
  }
  
  public final i alh()
  {
    if (this.ebd == k.ebj) {
      return this.eaW.eaN.dn(this.dI);
    }
    return this.eaW.eaN.dm(this.dI);
  }
  
  public final String toString()
  {
    return String.format("%s@0x%08x", new Object[] { this.ebd.mName, Long.valueOf(this.dI) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.h.a.b.j
 * JD-Core Version:    0.7.0.1
 */