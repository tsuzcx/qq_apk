package com.tencent.h;

public abstract class d<T extends e>
{
  private T[] ByD = dWS();
  private final Object mLock = new Object();
  private int qTI;
  
  private T dWV()
  {
    e locale = null;
    synchronized (this.mLock)
    {
      if (this.qTI > 0)
      {
        this.qTI -= 1;
        locale = this.ByD[this.qTI];
        this.ByD[this.qTI] = null;
      }
      return locale;
    }
  }
  
  public final void a(T paramT)
  {
    synchronized (this.mLock)
    {
      int i = this.ByD.length;
      if (this.qTI < i)
      {
        this.ByD[this.qTI] = paramT;
        this.qTI += 1;
      }
      return;
    }
  }
  
  protected abstract T[] dWS();
  
  protected abstract T dWT();
  
  public final T dWU()
  {
    e locale = dWV();
    if (locale == null) {
      return dWT();
    }
    locale.reset();
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.h.d
 * JD-Core Version:    0.7.0.1
 */