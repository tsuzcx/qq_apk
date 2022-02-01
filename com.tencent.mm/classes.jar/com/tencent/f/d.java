package com.tencent.f;

public abstract class d<T extends e>
{
  private T[] KtR = fHu();
  private int kUz;
  private final Object mLock = new Object();
  
  private T fHx()
  {
    e locale = null;
    synchronized (this.mLock)
    {
      if (this.kUz > 0)
      {
        this.kUz -= 1;
        locale = this.KtR[this.kUz];
        this.KtR[this.kUz] = null;
      }
      return locale;
    }
  }
  
  public final void a(T paramT)
  {
    synchronized (this.mLock)
    {
      int i = this.KtR.length;
      if (this.kUz < i)
      {
        this.KtR[this.kUz] = paramT;
        this.kUz += 1;
      }
      return;
    }
  }
  
  protected abstract T[] fHu();
  
  protected abstract T fHv();
  
  public final T fHw()
  {
    e locale = fHx();
    if (locale == null) {
      return fHv();
    }
    locale.reset();
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.f.d
 * JD-Core Version:    0.7.0.1
 */