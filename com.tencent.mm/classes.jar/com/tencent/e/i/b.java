package com.tencent.e.i;

import java.util.concurrent.Future;

public abstract class b
  implements e, j, Runnable
{
  private Future fuk;
  
  public final void a(Future paramFuture)
  {
    this.fuk = paramFuture;
  }
  
  public boolean cancel()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.fuk != null)
    {
      bool1 = bool2;
      if (!this.fuk.isDone()) {
        bool1 = this.fuk.cancel(false);
      }
    }
    return bool1;
  }
  
  public final void ipZ()
  {
    if ((this.fuk != null) && (!this.fuk.isCancelled())) {
      this.fuk.get();
    }
  }
  
  public final boolean isDone()
  {
    if (this.fuk == null) {
      return false;
    }
    return this.fuk.isDone();
  }
  
  public boolean isLogging()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.e.i.b
 * JD-Core Version:    0.7.0.1
 */