package com.tencent.g;

public abstract class d<T extends e>
{
  private T[] SoP = asA(20);
  private int mCS;
  private final Object mLock = new Object();
  
  private T hpP()
  {
    e locale = null;
    synchronized (this.mLock)
    {
      if (this.mCS > 0)
      {
        this.mCS -= 1;
        locale = this.SoP[this.mCS];
        this.SoP[this.mCS] = null;
      }
      return locale;
    }
  }
  
  public final void a(T paramT)
  {
    synchronized (this.mLock)
    {
      int i = this.SoP.length;
      if (this.mCS < i)
      {
        this.SoP[this.mCS] = paramT;
        this.mCS += 1;
      }
      return;
    }
  }
  
  protected abstract T[] asA(int paramInt);
  
  protected abstract T hpN();
  
  public final T hpO()
  {
    e locale = hpP();
    if (locale == null) {
      return hpN();
    }
    locale.reset();
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.g.d
 * JD-Core Version:    0.7.0.1
 */