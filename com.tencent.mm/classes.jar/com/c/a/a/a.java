package com.c.a.a;

import android.content.Context;
import android.os.Handler;

abstract class a
  extends d
  implements m
{
  private final d[] bMs;
  private final Handler[] bMt;
  private final d.a[] bMu;
  
  a(d... paramVarArgs)
  {
    this.bMs = paramVarArgs;
    this.bMt = new Handler[this.bMs.length];
    this.bMu = new d.a[this.bMt.length];
  }
  
  void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    a(paramHandler, this.bMt);
    a(parama, this.bMu);
    int i = 0;
    for (;;)
    {
      if (i >= this.bMs.length) {
        return;
      }
      try
      {
        this.bMs[i].a(this.bMt[i], this.bMu[i]);
        label56:
        i += 1;
      }
      catch (Exception paramContext)
      {
        break label56;
      }
    }
  }
  
  abstract void a(Handler paramHandler, Handler[] paramArrayOfHandler);
  
  abstract void a(d.a parama, d.a[] paramArrayOfa);
  
  final void as(Context paramContext)
  {
    int i = 0;
    d[] arrayOfd = this.bMs;
    int j = arrayOfd.length;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      d locald = arrayOfd[i];
      try
      {
        locald.a(paramContext, new m[] { this });
        label38:
        i += 1;
      }
      catch (Exception localException)
      {
        break label38;
      }
    }
  }
  
  final void at(Context paramContext)
  {
    paramContext = this.bMs;
    int j = paramContext.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      paramContext[i].stop();
      i += 1;
    }
  }
  
  final void yE()
  {
    d[] arrayOfd = this.bMs;
    int j = arrayOfd.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      arrayOfd[i].yH();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */