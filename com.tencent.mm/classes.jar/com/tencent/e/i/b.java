package com.tencent.e.i;

import java.util.concurrent.Future;

public abstract class b
  implements e, g, j, Runnable
{
  private Future cXV;
  
  public final void a(Future paramFuture)
  {
    this.cXV = paramFuture;
  }
  
  public boolean aev()
  {
    return true;
  }
  
  public boolean cancel()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.cXV != null)
    {
      bool1 = bool2;
      if (!this.cXV.isDone()) {
        bool1 = this.cXV.cancel(false);
      }
    }
    return bool1;
  }
  
  public final void fEw()
  {
    if ((this.cXV != null) && (!this.cXV.isCancelled())) {
      this.cXV.get();
    }
  }
  
  public final boolean isDone()
  {
    if (this.cXV == null) {
      return false;
    }
    return this.cXV.isDone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.e.i.b
 * JD-Core Version:    0.7.0.1
 */