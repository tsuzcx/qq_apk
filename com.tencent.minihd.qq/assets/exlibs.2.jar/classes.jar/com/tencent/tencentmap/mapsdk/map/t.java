package com.tencent.tencentmap.mapsdk.map;

import java.util.concurrent.Semaphore;

class t
{
  protected Semaphore a = new Semaphore(0, false);
  protected boolean b = true;
  protected volatile boolean c = true;
  Thread[] d = null;
  a e = null;
  private Runnable f = new Runnable()
  {
    public void run()
    {
      while (t.this.c) {
        t.this.d();
      }
    }
  };
  
  public t(int paramInt, a parama)
  {
    if (paramInt <= 0) {
      return;
    }
    this.d = new Thread[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      this.d[i] = new Thread(this.f);
      this.d[i].setDaemon(true);
      i += 1;
    }
    this.e = parama;
  }
  
  private void e()
  {
    this.b = false;
    this.a.release(100);
  }
  
  public void a()
  {
    if (this.d == null) {}
    for (;;)
    {
      return;
      int j = this.d.length;
      if (j != 0)
      {
        int i = 0;
        while (i < j)
        {
          if (this.d[i] != null) {
            this.d[i].start();
          }
          i += 1;
        }
      }
    }
  }
  
  protected void a(int paramInt)
  {
    if ((!this.b) || (this.a == null) || (this.a.availablePermits() > 100)) {
      return;
    }
    this.a.release(paramInt);
  }
  
  public void b()
  {
    this.c = false;
    if (this.d == null) {}
    do
    {
      return;
      e();
    } while (this.d.length != 0);
  }
  
  public void c()
  {
    this.c = false;
    if (this.d == null) {}
    int j;
    do
    {
      return;
      e();
      j = this.d.length;
    } while (j == 0);
    int i = 0;
    if (i < j) {
      if (this.d[i] != null) {}
    }
    for (;;)
    {
      i += 1;
      break;
      this.d[i].interrupt();
      try
      {
        this.d[i].join();
        label68:
        this.d[i] = null;
        continue;
        this.d = null;
        this.a = null;
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label68;
      }
    }
  }
  
  void d()
  {
    
    if (this.a == null) {}
    for (;;)
    {
      return;
      try
      {
        this.a.acquire();
        label18:
        if (this.e == null) {
          continue;
        }
        this.e.a();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label18;
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.t
 * JD-Core Version:    0.7.0.1
 */