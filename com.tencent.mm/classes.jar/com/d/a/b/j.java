package com.d.a.b;

public final class j
  extends i
{
  public k bUr = k.bUw;
  int bUs;
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
    this.bUr = paramk;
    this.bUs = paramInt;
  }
  
  public final String toString()
  {
    return String.format("%s@0x%08x", new Object[] { this.bUr.mName, Long.valueOf(this.KQ) });
  }
  
  public final i zW()
  {
    if (this.bUr == k.bUx) {
      return this.bUk.bUb.aF(this.KQ);
    }
    return this.bUk.bUb.aE(this.KQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.b.j
 * JD-Core Version:    0.7.0.1
 */