package com.tencent.e.i;

import java.util.concurrent.Future;

public abstract class b
  implements e, g, j, Runnable
{
  private Future daz;
  
  public final void a(Future paramFuture)
  {
    this.daz = paramFuture;
  }
  
  public boolean adf()
  {
    return true;
  }
  
  public boolean cancel()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.daz != null)
    {
      bool1 = bool2;
      if (!this.daz.isDone()) {
        bool1 = this.daz.cancel(false);
      }
    }
    return bool1;
  }
  
  public final void fog()
  {
    if ((this.daz != null) && (!this.daz.isCancelled())) {
      this.daz.get();
    }
  }
  
  public final boolean isDone()
  {
    if (this.daz == null) {
      return false;
    }
    return this.daz.isDone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.i.b
 * JD-Core Version:    0.7.0.1
 */