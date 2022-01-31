package com.b.a.a;

import android.content.Context;
import android.os.Handler;

abstract class a
  extends d
  implements m
{
  private final d[] bmk;
  private final Handler[] bml;
  private final d.a[] bmm;
  
  a(d... paramVarArgs)
  {
    this.bmk = paramVarArgs;
    this.bml = new Handler[this.bmk.length];
    this.bmm = new d.a[this.bml.length];
  }
  
  void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    a(paramHandler, this.bml);
    a(parama, this.bmm);
    int i = 0;
    for (;;)
    {
      if (i >= this.bmk.length) {
        return;
      }
      try
      {
        this.bmk[i].a(this.bml[i], this.bmm[i]);
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
  
  final void al(Context paramContext)
  {
    int i = 0;
    d[] arrayOfd = this.bmk;
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
  
  final void am(Context paramContext)
  {
    paramContext = this.bmk;
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
  
  final void td()
  {
    d[] arrayOfd = this.bmk;
    int j = arrayOfd.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      arrayOfd[i].tg();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */