package com.b.a.a;

import android.content.Context;
import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

abstract class d
{
  boolean bmr;
  private Collection<WeakReference<m>> bms;
  private d.a bmt;
  boolean isRunning;
  private Handler mHandler;
  private Context zF;
  
  private void b(Context paramContext, m... paramVarArgs)
  {
    this.zF = paramContext;
    if (paramVarArgs == null) {
      this.bms = null;
    }
    for (;;)
    {
      al(paramContext);
      return;
      this.bms = new LinkedList();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        m localm = paramVarArgs[i];
        this.bms.add(new WeakReference(localm));
        i += 1;
      }
    }
  }
  
  abstract void a(Context paramContext, Handler paramHandler, d.a parama);
  
  final void a(Context paramContext, m... paramVarArgs)
  {
    if (paramContext == null) {
      try
      {
        throw new Exception("Module: context cannot be null");
      }
      finally {}
    }
    tg();
    b(paramContext.getApplicationContext(), paramVarArgs);
    this.bmr = true;
  }
  
  void a(Handler paramHandler, d.a parama)
  {
    try
    {
      stop();
      this.mHandler = paramHandler;
      this.bmt = parama;
      a(this.zF, this.mHandler, this.bmt);
      this.isRunning = true;
      return;
    }
    finally
    {
      paramHandler = finally;
      throw paramHandler;
    }
  }
  
  abstract void al(Context paramContext);
  
  abstract void am(Context paramContext);
  
  final void c(p paramp)
  {
    if (!this.isRunning) {}
    for (;;)
    {
      return;
      if (this.bms != null)
      {
        Iterator localIterator = this.bms.iterator();
        while (localIterator.hasNext())
        {
          m localm = (m)((WeakReference)localIterator.next()).get();
          if (localm != null) {
            localm.a(paramp);
          }
        }
      }
    }
  }
  
  void stop()
  {
    try
    {
      if (this.isRunning)
      {
        am(this.zF);
        this.mHandler = null;
        this.bmt = null;
        this.isRunning = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  abstract void td();
  
  final void tg()
  {
    try
    {
      if (this.bmr)
      {
        stop();
        td();
        this.bmr = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */