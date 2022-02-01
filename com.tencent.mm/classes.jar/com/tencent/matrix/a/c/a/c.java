package com.tencent.matrix.a.c.a;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.LongSparseArray;
import com.tencent.matrix.a.c.a.b;
import com.tencent.matrix.a.c.a.c;
import com.tencent.matrix.trace.core.a.a;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class c
  implements a
{
  com.tencent.matrix.a.c.a csG;
  private final LongSparseArray<com.tencent.matrix.trace.core.a> csH;
  
  private LinkedList<b> a(Thread paramThread)
  {
    synchronized (this.csH)
    {
      com.tencent.matrix.trace.core.a locala = (com.tencent.matrix.trace.core.a)this.csH.get(paramThread.getId());
      if (locala != null) {
        this.csH.remove(paramThread.getId());
      }
      paramThread = new LinkedList();
      if (locala != null)
      {
        ??? = locala.listeners.iterator();
        while (((Iterator)???).hasNext())
        {
          a.a locala1 = (a.a)((Iterator)???).next();
          if ((locala1 instanceof a))
          {
            ??? = ((a)locala1).csJ;
            paramThread.addAll(((Map)???).values());
            ((Map)???).clear();
            Collections.sort(paramThread, new Comparator() {});
          }
        }
        locala.onRelease();
      }
      return paramThread;
    }
  }
  
  public final void GN()
  {
    com.tencent.matrix.g.c.i("Matrix.LooperTaskMonitorPlugin", "onTurnOn", new Object[0]);
  }
  
  public final void GO()
  {
    com.tencent.matrix.g.c.i("Matrix.LooperTaskMonitorPlugin", "onTurnOff", new Object[0]);
    LongSparseArray localLongSparseArray = this.csH;
    int i = 0;
    try
    {
      while (i < this.csH.size())
      {
        ((com.tencent.matrix.trace.core.a)this.csH.valueAt(i)).onRelease();
        i += 1;
      }
      this.csH.clear();
      return;
    }
    finally {}
  }
  
  public final int GP()
  {
    return 0;
  }
  
  public final void a(com.tencent.matrix.a.c.a parama)
  {
    com.tencent.matrix.g.c.i("Matrix.LooperTaskMonitorPlugin", "onInstall", new Object[0]);
    this.csG = parama;
  }
  
  public final void bT(boolean paramBoolean)
  {
    if (this.csG.csb)
    {
      Iterator localIterator = Thread.getAllStackTraces().keySet().iterator();
      while (localIterator.hasNext())
      {
        Thread localThread = (Thread)localIterator.next();
        if ((localThread instanceof HandlerThread))
        {
          Looper localLooper = ((HandlerThread)localThread).getLooper();
          if (localLooper != null)
          {
            if (!paramBoolean) {
              synchronized (this.csH)
              {
                if (this.csH.get(localThread.getId()) == null) {
                  this.csH.put(localThread.getId(), new com.tencent.matrix.trace.core.a(localLooper));
                }
              }
            }
            ??? = a(localThread);
            if ((this.csG.csc.cse != null) && (!((List)???).isEmpty())) {
              this.csG.csc.cse.a(localThread, (List)???);
            }
          }
        }
      }
    }
  }
  
  final class a
    extends a.a
  {
    HashMap<String, c.b> csJ;
    
    public final void cK(String paramString)
    {
      if (this.csI.csG.isForeground()) {
        return;
      }
      super.cK(paramString);
      int k = paramString.indexOf("to ");
      int j = paramString.lastIndexOf('@');
      int i = j;
      if (j < 0) {
        i = paramString.lastIndexOf(':');
      }
      i = Math.max(i - 60, k + 3);
      Thread.currentThread();
      String str = paramString.substring(i);
      c.b localb = (c.b)this.csJ.get(str);
      paramString = localb;
      if (localb == null)
      {
        paramString = new c.b(this.csI);
        this.csJ.put(str, paramString);
      }
      paramString.csK = str;
      if (paramString.csL == null) {
        paramString.csL = new long[1000];
      }
      i = paramString.count;
      paramString.csL[(i % 1000)] = System.currentTimeMillis();
      paramString.count += 1;
    }
    
    public final boolean isValid()
    {
      return !this.csI.csG.isForeground();
    }
  }
  
  public final class b
  {
    int count;
    String csK;
    long[] csL;
    
    public b() {}
    
    public final boolean equals(Object paramObject)
    {
      return this.csK.equals(paramObject);
    }
    
    public final int hashCode()
    {
      return this.csK.hashCode();
    }
    
    public final String toString()
    {
      return this.csK + "=" + this.count;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.c.a.c
 * JD-Core Version:    0.7.0.1
 */