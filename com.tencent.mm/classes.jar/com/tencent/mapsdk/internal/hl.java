package com.tencent.mapsdk.internal;

import javax.microedition.khronos.opengles.GL10;

public abstract class hl
{
  public static final long a = -1L;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  protected long e;
  protected int f;
  private long g;
  private boolean h;
  private long i;
  
  public hl(long paramLong)
  {
    this.e = paramLong;
    this.g = -1L;
    this.f = 0;
  }
  
  private void a(long paramLong)
  {
    this.i = paramLong;
  }
  
  private void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  private void e()
  {
    this.f = 2;
  }
  
  private boolean f()
  {
    return this.f == 1;
  }
  
  public final long a()
  {
    return this.e;
  }
  
  public void a(GL10 paramGL10)
  {
    if (this.f != 1) {}
    long l;
    do
    {
      return;
      if (this.g == -1L) {
        this.g = System.currentTimeMillis();
      }
      l = System.currentTimeMillis() - this.g;
    } while (this.i - l > 0L);
    l -= this.i;
    if (l >= this.e)
    {
      if (this.h) {
        d();
      }
      this.f = 2;
    }
    a(paramGL10, l);
  }
  
  protected abstract void a(GL10 paramGL10, long paramLong);
  
  public void b()
  {
    this.f = 1;
    this.g = -1L;
  }
  
  public boolean c()
  {
    return this.f == 2;
  }
  
  protected void d()
  {
    this.f = 1;
    this.g = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.hl
 * JD-Core Version:    0.7.0.1
 */