package com.d.a.a;

import android.os.Handler;
import android.util.SparseArray;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class z
{
  private static z bbY;
  private static final SparseArray<z> bbZ = new SparseArray();
  private final ExecutorService bca;
  private final Handler handler;
  
  private z(Handler paramHandler)
  {
    if (paramHandler != null) {}
    for (this.bca = null;; this.bca = Executors.newSingleThreadExecutor())
    {
      this.handler = paramHandler;
      return;
    }
  }
  
  static z b(Handler paramHandler)
  {
    if (paramHandler != null)
    {
      int i = paramHandler.getLooper().hashCode();
      z localz2 = (z)bbZ.get(i);
      z localz1 = localz2;
      if (localz2 == null)
      {
        localz1 = new z(paramHandler);
        bbZ.put(i, localz1);
      }
      return localz1;
    }
    if (bbY == null) {
      bbY = new z(null);
    }
    return bbY;
  }
  
  final void execute(Runnable paramRunnable)
  {
    if (this.handler != null)
    {
      this.handler.post(paramRunnable);
      return;
    }
    this.bca.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.d.a.a.z
 * JD-Core Version:    0.7.0.1
 */