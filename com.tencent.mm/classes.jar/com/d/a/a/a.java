package com.d.a.a;

import android.content.Context;
import android.os.Handler;

abstract class a
  extends d
  implements m
{
  private final d[] bWF;
  private final Handler[] bWG;
  private final d.a[] bWH;
  
  a(d... paramVarArgs)
  {
    this.bWF = paramVarArgs;
    this.bWG = new Handler[this.bWF.length];
    this.bWH = new d.a[this.bWG.length];
  }
  
  final void Ab()
  {
    d[] arrayOfd = this.bWF;
    int j = arrayOfd.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      arrayOfd[i].Ae();
      i += 1;
    }
  }
  
  void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    a(paramHandler, this.bWG);
    a(parama, this.bWH);
    int i = 0;
    for (;;)
    {
      if (i >= this.bWF.length) {
        return;
      }
      try
      {
        this.bWF[i].a(this.bWG[i], this.bWH[i]);
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
    d[] arrayOfd = this.bWF;
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
    paramContext = this.bWF;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.d.a.a.a
 * JD-Core Version:    0.7.0.1
 */