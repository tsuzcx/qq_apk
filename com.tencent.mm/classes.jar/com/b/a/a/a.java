package com.b.a.a;

import android.content.Context;
import android.os.Handler;

abstract class a
  extends d
  implements m
{
  private final d[] chn;
  private final Handler[] cho;
  private final d.a[] chp;
  
  a(d... paramVarArgs)
  {
    this.chn = paramVarArgs;
    this.cho = new Handler[this.chn.length];
    this.chp = new d.a[this.cho.length];
  }
  
  final void IV()
  {
    d[] arrayOfd = this.chn;
    int j = arrayOfd.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      arrayOfd[i].IY();
      i += 1;
    }
  }
  
  void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    a(paramHandler, this.cho);
    a(parama, this.chp);
    int i = 0;
    for (;;)
    {
      if (i >= this.chn.length) {
        return;
      }
      try
      {
        this.chn[i].a(this.cho[i], this.chp[i]);
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
  
  final void au(Context paramContext)
  {
    int i = 0;
    d[] arrayOfd = this.chn;
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
  
  final void av(Context paramContext)
  {
    paramContext = this.chn;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */