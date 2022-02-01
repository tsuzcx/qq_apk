package com.tencent.f;

public abstract class d<T extends e>
{
  private T[] IHG = fpm();
  private int ktk;
  private final Object mLock = new Object();
  
  private T fpp()
  {
    e locale = null;
    synchronized (this.mLock)
    {
      if (this.ktk > 0)
      {
        this.ktk -= 1;
        locale = this.IHG[this.ktk];
        this.IHG[this.ktk] = null;
      }
      return locale;
    }
  }
  
  public final void a(T paramT)
  {
    synchronized (this.mLock)
    {
      int i = this.IHG.length;
      if (this.ktk < i)
      {
        this.IHG[this.ktk] = paramT;
        this.ktk += 1;
      }
      return;
    }
  }
  
  protected abstract T[] fpm();
  
  protected abstract T fpn();
  
  public final T fpo()
  {
    e locale = fpp();
    if (locale == null) {
      return fpn();
    }
    locale.reset();
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.f.d
 * JD-Core Version:    0.7.0.1
 */