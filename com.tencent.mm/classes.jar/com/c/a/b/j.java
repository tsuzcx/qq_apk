package com.c.a.b;

public final class j
  extends i
{
  public k cpi = k.cpn;
  int cpj;
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
    this.cpi = paramk;
    this.cpj = paramInt;
  }
  
  public final i Km()
  {
    if (this.cpi == k.cpo) {
      return this.cpb.coS.aS(this.MS);
    }
    return this.cpb.coS.aR(this.MS);
  }
  
  public final String toString()
  {
    return String.format("%s@0x%08x", new Object[] { this.cpi.mName, Long.valueOf(this.MS) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.c.a.b.j
 * JD-Core Version:    0.7.0.1
 */