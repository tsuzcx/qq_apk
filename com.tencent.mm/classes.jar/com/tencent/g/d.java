package com.tencent.g;

public abstract class d<T extends e>
{
  public final Object mLock = new Object();
  public int ofu;
  public T[] xbX = cRd();
  
  public abstract T[] cRd();
  
  public abstract T cRe();
  
  public final T cRf()
  {
    e locale = null;
    synchronized (this.mLock)
    {
      if (this.ofu > 0)
      {
        this.ofu -= 1;
        locale = this.xbX[this.ofu];
        this.xbX[this.ofu] = null;
      }
      return locale;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.g.d
 * JD-Core Version:    0.7.0.1
 */