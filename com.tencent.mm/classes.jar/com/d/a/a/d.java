package com.d.a.a;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

abstract class d
{
  private Context IR;
  boolean bWM;
  private Collection<WeakReference<m>> bWN;
  private a bWO;
  boolean isRunning;
  private Handler mHandler;
  
  private void b(Context paramContext, m... paramVarArgs)
  {
    this.IR = paramContext;
    if (paramVarArgs == null) {
      this.bWN = null;
    }
    for (;;)
    {
      as(paramContext);
      return;
      this.bWN = new LinkedList();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        m localm = paramVarArgs[i];
        this.bWN.add(new WeakReference(localm));
        i += 1;
      }
    }
  }
  
  abstract void Ab();
  
  final void Ae()
  {
    try
    {
      if (this.bWM)
      {
        stop();
        Ab();
        this.bWM = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
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
    Ae();
    b(paramContext.getApplicationContext(), paramVarArgs);
    this.bWM = true;
  }
  
  void a(Handler paramHandler, a parama)
  {
    try
    {
      stop();
      this.mHandler = paramHandler;
      this.bWO = parama;
      a(this.IR, this.mHandler, this.bWO);
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
      if (this.bWN != null)
      {
        Iterator localIterator = this.bWN.iterator();
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
        at(this.IR);
        this.mHandler = null;
        this.bWO = null;
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
  
  static class a
  {
    final long bWP;
    
    a(long paramLong)
    {
      AppMethodBeat.i(87918);
      this.bWP = Math.max(paramLong, 0L);
      AppMethodBeat.o(87918);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.d.a.a.d
 * JD-Core Version:    0.7.0.1
 */