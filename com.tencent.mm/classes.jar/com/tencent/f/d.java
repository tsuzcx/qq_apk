package com.tencent.f;

public abstract class d<T extends e>
{
  private T[] MjS = fYL();
  private int lrx;
  private final Object mLock = new Object();
  
  private T fYO()
  {
    e locale = null;
    synchronized (this.mLock)
    {
      if (this.lrx > 0)
      {
        this.lrx -= 1;
        locale = this.MjS[this.lrx];
        this.MjS[this.lrx] = null;
      }
      return locale;
    }
  }
  
  public final void a(T paramT)
  {
    synchronized (this.mLock)
    {
      int i = this.MjS.length;
      if (this.lrx < i)
      {
        this.MjS[this.lrx] = paramT;
        this.lrx += 1;
      }
      return;
    }
  }
  
  protected abstract T[] fYL();
  
  protected abstract T fYM();
  
  public final T fYN()
  {
    e locale = fYO();
    if (locale == null) {
      return fYM();
    }
    locale.reset();
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.f.d
 * JD-Core Version:    0.7.0.1
 */