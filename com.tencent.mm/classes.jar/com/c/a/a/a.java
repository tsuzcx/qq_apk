package com.c.a.a;

import android.content.Context;
import android.os.Handler;

abstract class a
  extends d
  implements m
{
  private final d[] bOK;
  private final Handler[] bOL;
  private final d.a[] bOM;
  
  a(d... paramVarArgs)
  {
    this.bOK = paramVarArgs;
    this.bOL = new Handler[this.bOK.length];
    this.bOM = new d.a[this.bOL.length];
  }
  
  void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    a(paramHandler, this.bOL);
    a(parama, this.bOM);
    int i = 0;
    for (;;)
    {
      if (i >= this.bOK.length) {
        return;
      }
      try
      {
        this.bOK[i].a(this.bOL[i], this.bOM[i]);
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
  
  final void ar(Context paramContext)
  {
    int i = 0;
    d[] arrayOfd = this.bOK;
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
  
  final void as(Context paramContext)
  {
    paramContext = this.bOK;
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
  
  final void yR()
  {
    d[] arrayOfd = this.bOK;
    int j = arrayOfd.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      arrayOfd[i].yU();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */