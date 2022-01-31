package com.d.a.a;

import android.content.Context;
import android.os.Handler;

abstract class a
  extends d
  implements m
{
  private final d[] aVC;
  private final Handler[] aVD;
  private final d.a[] aVE;
  
  a(d... paramVarArgs)
  {
    this.aVC = paramVarArgs;
    this.aVD = new Handler[this.aVC.length];
    this.aVE = new d.a[this.aVD.length];
  }
  
  void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    a(paramHandler, this.aVD);
    a(parama, this.aVE);
    int i = 0;
    for (;;)
    {
      if (i >= this.aVC.length) {
        return;
      }
      try
      {
        this.aVC[i].a(this.aVD[i], this.aVE[i]);
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
  
  final void aa(Context paramContext)
  {
    int i = 0;
    d[] arrayOfd = this.aVC;
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
  
  final void ab(Context paramContext)
  {
    paramContext = this.aVC;
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
  
  final void oX()
  {
    d[] arrayOfd = this.aVC;
    int j = arrayOfd.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      arrayOfd[i].pa();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.d.a.a.a
 * JD-Core Version:    0.7.0.1
 */