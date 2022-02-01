package com.tencent.e.i;

import java.util.concurrent.Future;

public abstract class b
  implements e, g, j, Runnable
{
  private Future djn;
  
  public final void a(Future paramFuture)
  {
    this.djn = paramFuture;
  }
  
  public boolean ahh()
  {
    return true;
  }
  
  public boolean cancel()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.djn != null)
    {
      bool1 = bool2;
      if (!this.djn.isDone()) {
        bool1 = this.djn.cancel(false);
      }
    }
    return bool1;
  }
  
  public final void fVO()
  {
    if ((this.djn != null) && (!this.djn.isCancelled())) {
      this.djn.get();
    }
  }
  
  public final boolean isDone()
  {
    if (this.djn == null) {
      return false;
    }
    return this.djn.isDone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.e.i.b
 * JD-Core Version:    0.7.0.1
 */