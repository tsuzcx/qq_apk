package com.tencent.e.i;

import java.util.concurrent.Future;

public abstract class b
  implements e, g, j, Runnable
{
  private Future dkp;
  
  public final void a(Future paramFuture)
  {
    this.dkp = paramFuture;
  }
  
  public boolean ahw()
  {
    return true;
  }
  
  public boolean cancel()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.dkp != null)
    {
      bool1 = bool2;
      if (!this.dkp.isDone()) {
        bool1 = this.dkp.cancel(false);
      }
    }
    return bool1;
  }
  
  public final void gan()
  {
    if ((this.dkp != null) && (!this.dkp.isCancelled())) {
      this.dkp.get();
    }
  }
  
  public final boolean isDone()
  {
    if (this.dkp == null) {
      return false;
    }
    return this.dkp.isDone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.e.i.b
 * JD-Core Version:    0.7.0.1
 */