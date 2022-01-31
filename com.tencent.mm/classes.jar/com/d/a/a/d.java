package com.d.a.a;

import android.content.Context;
import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

abstract class d
{
  boolean aVJ;
  private Collection<WeakReference<m>> aVK;
  private d.a aVL;
  boolean isRunning;
  private Handler mHandler;
  private Context ze;
  
  private void b(Context paramContext, m... paramVarArgs)
  {
    this.ze = paramContext;
    if (paramVarArgs == null) {
      this.aVK = null;
    }
    for (;;)
    {
      aa(paramContext);
      return;
      this.aVK = new LinkedList();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        m localm = paramVarArgs[i];
        this.aVK.add(new WeakReference(localm));
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
    pa();
    b(paramContext.getApplicationContext(), paramVarArgs);
    this.aVJ = true;
  }
  
  void a(Handler paramHandler, d.a parama)
  {
    try
    {
      stop();
      this.mHandler = paramHandler;
      this.aVL = parama;
      a(this.ze, this.mHandler, this.aVL);
      this.isRunning = true;
      return;
    }
    finally
    {
      paramHandler = finally;
      throw paramHandler;
    }
  }
  
  abstract void aa(Context paramContext);
  
  abstract void ab(Context paramContext);
  
  final void c(p paramp)
  {
    if (!this.isRunning) {}
    for (;;)
    {
      return;
      if (this.aVK != null)
      {
        Iterator localIterator = this.aVK.iterator();
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
  
  abstract void oX();
  
  final void pa()
  {
    try
    {
      if (this.aVJ)
      {
        stop();
        oX();
        this.aVJ = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void stop()
  {
    try
    {
      if (this.isRunning)
      {
        ab(this.ze);
        this.mHandler = null;
        this.aVL = null;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.d.a.a.d
 * JD-Core Version:    0.7.0.1
 */