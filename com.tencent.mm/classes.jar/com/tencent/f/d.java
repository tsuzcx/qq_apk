package com.tencent.f;

public abstract class d<T extends e>
{
  private T[] ZQu = aCo(20);
  private final Object mLock = new Object();
  private int pCf;
  
  private T itu()
  {
    e locale = null;
    synchronized (this.mLock)
    {
      if (this.pCf > 0)
      {
        this.pCf -= 1;
        locale = this.ZQu[this.pCf];
        this.ZQu[this.pCf] = null;
      }
      return locale;
    }
  }
  
  public final void a(T paramT)
  {
    synchronized (this.mLock)
    {
      int i = this.ZQu.length;
      if (this.pCf < i)
      {
        this.ZQu[this.pCf] = paramT;
        this.pCf += 1;
      }
      return;
    }
  }
  
  protected abstract T[] aCo(int paramInt);
  
  protected abstract T its();
  
  public final T itt()
  {
    e locale = itu();
    if (locale == null) {
      return its();
    }
    locale.reset();
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.f.d
 * JD-Core Version:    0.7.0.1
 */