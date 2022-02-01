package com.tencent.f;

public abstract class d<T extends e>
{
  private T[] MGP = gdk();
  private int lvX;
  private final Object mLock = new Object();
  
  private T gdn()
  {
    e locale = null;
    synchronized (this.mLock)
    {
      if (this.lvX > 0)
      {
        this.lvX -= 1;
        locale = this.MGP[this.lvX];
        this.MGP[this.lvX] = null;
      }
      return locale;
    }
  }
  
  public final void a(T paramT)
  {
    synchronized (this.mLock)
    {
      int i = this.MGP.length;
      if (this.lvX < i)
      {
        this.MGP[this.lvX] = paramT;
        this.lvX += 1;
      }
      return;
    }
  }
  
  protected abstract T[] gdk();
  
  protected abstract T gdl();
  
  public final T gdm()
  {
    e locale = gdn();
    if (locale == null) {
      return gdl();
    }
    locale.reset();
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.f.d
 * JD-Core Version:    0.7.0.1
 */