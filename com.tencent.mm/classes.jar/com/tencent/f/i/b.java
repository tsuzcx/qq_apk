package com.tencent.f.i;

import java.util.concurrent.Future;

public abstract class b
  implements e, g, j, Runnable
{
  private Future dBz;
  
  public final void a(Future paramFuture)
  {
    this.dBz = paramFuture;
  }
  
  public boolean axI()
  {
    return true;
  }
  
  public boolean cancel()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.dBz != null)
    {
      bool1 = bool2;
      if (!this.dBz.isDone()) {
        bool1 = this.dBz.cancel(false);
      }
    }
    return bool1;
  }
  
  public final void hmy()
  {
    if ((this.dBz != null) && (!this.dBz.isCancelled())) {
      this.dBz.get();
    }
  }
  
  public final boolean isDone()
  {
    if (this.dBz == null) {
      return false;
    }
    return this.dBz.isDone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.f.i.b
 * JD-Core Version:    0.7.0.1
 */