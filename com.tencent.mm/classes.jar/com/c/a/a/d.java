package com.c.a.a;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

abstract class d
{
  private Context GX;
  private Collection<WeakReference<m>> bMA;
  private a bMB;
  boolean bMz;
  boolean isRunning;
  private Handler mHandler;
  
  private void b(Context paramContext, m... paramVarArgs)
  {
    this.GX = paramContext;
    if (paramVarArgs == null) {
      this.bMA = null;
    }
    for (;;)
    {
      as(paramContext);
      return;
      this.bMA = new LinkedList();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        m localm = paramVarArgs[i];
        this.bMA.add(new WeakReference(localm));
        i += 1;
      }
    }
  }
  
  abstract void a(Context paramContext, Handler paramHandler, a parama);
  
  final void a(Context paramContext, m... paramVarArgs)
  {
    if (paramContext == null) {
      try
      {
        throw new Exception("Module: context cannot be null");
      }
      finally {}
    }
    yH();
    b(paramContext.getApplicationContext(), paramVarArgs);
    this.bMz = true;
  }
  
  void a(Handler paramHandler, a parama)
  {
    try
    {
      stop();
      this.mHandler = paramHandler;
      this.bMB = parama;
      a(this.GX, this.mHandler, this.bMB);
      this.isRunning = true;
      return;
    }
    finally
    {
      paramHandler = finally;
      throw paramHandler;
    }
  }
  
  abstract void as(Context paramContext);
  
  abstract void at(Context paramContext);
  
  final void c(p paramp)
  {
    if (!this.isRunning) {}
    for (;;)
    {
      return;
      if (this.bMA != null)
      {
        Iterator localIterator = this.bMA.iterator();
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
        at(this.GX);
        this.mHandler = null;
        this.bMB = null;
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
  
  abstract void yE();
  
  final void yH()
  {
    try
    {
      if (this.bMz)
      {
        stop();
        yE();
        this.bMz = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static class a
  {
    final long bMC;
    
    a(long paramLong)
    {
      AppMethodBeat.i(87918);
      this.bMC = Math.max(paramLong, 0L);
      AppMethodBeat.o(87918);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.d
 * JD-Core Version:    0.7.0.1
 */