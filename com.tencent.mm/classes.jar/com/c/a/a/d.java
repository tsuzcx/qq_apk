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
  private Context FZ;
  boolean bOR;
  private Collection<WeakReference<m>> bOS;
  private a bOT;
  boolean isRunning;
  private Handler mHandler;
  
  private void b(Context paramContext, m... paramVarArgs)
  {
    this.FZ = paramContext;
    if (paramVarArgs == null) {
      this.bOS = null;
    }
    for (;;)
    {
      ar(paramContext);
      return;
      this.bOS = new LinkedList();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        m localm = paramVarArgs[i];
        this.bOS.add(new WeakReference(localm));
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
    yU();
    b(paramContext.getApplicationContext(), paramVarArgs);
    this.bOR = true;
  }
  
  void a(Handler paramHandler, a parama)
  {
    try
    {
      stop();
      this.mHandler = paramHandler;
      this.bOT = parama;
      a(this.FZ, this.mHandler, this.bOT);
      this.isRunning = true;
      return;
    }
    finally
    {
      paramHandler = finally;
      throw paramHandler;
    }
  }
  
  abstract void ar(Context paramContext);
  
  abstract void as(Context paramContext);
  
  final void c(p paramp)
  {
    if (!this.isRunning) {}
    for (;;)
    {
      return;
      if (this.bOS != null)
      {
        Iterator localIterator = this.bOS.iterator();
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
        as(this.FZ);
        this.mHandler = null;
        this.bOT = null;
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
  
  abstract void yR();
  
  final void yU()
  {
    try
    {
      if (this.bOR)
      {
        stop();
        yR();
        this.bOR = false;
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
    final long bOU;
    
    a(long paramLong)
    {
      AppMethodBeat.i(87918);
      this.bOU = Math.max(paramLong, 0L);
      AppMethodBeat.o(87918);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.d
 * JD-Core Version:    0.7.0.1
 */