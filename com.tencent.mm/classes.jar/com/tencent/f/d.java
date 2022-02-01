package com.tencent.f;

public abstract class d<T extends e>
{
  private T[] ahUS = aJb(20);
  private int cqW;
  private final Object mLock = new Object();
  
  private T kcM()
  {
    e locale = null;
    synchronized (this.mLock)
    {
      if (this.cqW > 0)
      {
        this.cqW -= 1;
        locale = this.ahUS[this.cqW];
        this.ahUS[this.cqW] = null;
      }
      return locale;
    }
  }
  
  public final void a(T paramT)
  {
    synchronized (this.mLock)
    {
      int i = this.ahUS.length;
      if (this.cqW < i)
      {
        this.ahUS[this.cqW] = paramT;
        this.cqW += 1;
      }
      return;
    }
  }
  
  protected abstract T[] aJb(int paramInt);
  
  protected abstract T kcK();
  
  public final T kcL()
  {
    e locale = kcM();
    if (locale == null) {
      return kcK();
    }
    locale.reset();
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.f.d
 * JD-Core Version:    0.7.0.1
 */