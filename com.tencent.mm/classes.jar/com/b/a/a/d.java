package com.b.a.a;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

abstract class d
{
  boolean chu;
  private Collection<WeakReference<m>> chv;
  private a chw;
  boolean isRunning;
  private Context mAppContext;
  private Handler mHandler;
  
  private void b(Context paramContext, m... paramVarArgs)
  {
    this.mAppContext = paramContext;
    if (paramVarArgs == null) {
      this.chv = null;
    }
    for (;;)
    {
      au(paramContext);
      return;
      this.chv = new LinkedList();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        m localm = paramVarArgs[i];
        this.chv.add(new WeakReference(localm));
        i += 1;
      }
    }
  }
  
  abstract void IV();
  
  final void IY()
  {
    try
    {
      if (this.chu)
      {
        stop();
        IV();
        this.chu = false;
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
    IY();
    b(paramContext.getApplicationContext(), paramVarArgs);
    this.chu = true;
  }
  
  void a(Handler paramHandler, a parama)
  {
    try
    {
      stop();
      this.mHandler = paramHandler;
      this.chw = parama;
      a(this.mAppContext, this.mHandler, this.chw);
      this.isRunning = true;
      return;
    }
    finally
    {
      paramHandler = finally;
      throw paramHandler;
    }
  }
  
  abstract void au(Context paramContext);
  
  abstract void av(Context paramContext);
  
  final void c(p paramp)
  {
    if (!this.isRunning) {}
    for (;;)
    {
      return;
      if (this.chv != null)
      {
        Iterator localIterator = this.chv.iterator();
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
        av(this.mAppContext);
        this.mHandler = null;
        this.chw = null;
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
    final long chx;
    
    a(long paramLong)
    {
      AppMethodBeat.i(87918);
      this.chx = Math.max(paramLong, 0L);
      AppMethodBeat.o(87918);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */