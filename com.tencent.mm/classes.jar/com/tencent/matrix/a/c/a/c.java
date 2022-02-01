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
  com.tencent.matrix.a.c.a cEj;
  private final LongSparseArray<com.tencent.matrix.trace.core.a> cEk;
  
  private LinkedList<b> a(Thread paramThread)
  {
    synchronized (this.cEk)
    {
      com.tencent.matrix.trace.core.a locala = (com.tencent.matrix.trace.core.a)this.cEk.get(paramThread.getId());
      if (locala != null) {
        this.cEk.remove(paramThread.getId());
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
            ??? = ((a)locala1).cEm;
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
  
  public final void Iq()
  {
    com.tencent.matrix.g.c.i("Matrix.LooperTaskMonitorPlugin", "onTurnOn", new Object[0]);
  }
  
  public final void Ir()
  {
    com.tencent.matrix.g.c.i("Matrix.LooperTaskMonitorPlugin", "onTurnOff", new Object[0]);
    LongSparseArray localLongSparseArray = this.cEk;
    int i = 0;
    try
    {
      while (i < this.cEk.size())
      {
        ((com.tencent.matrix.trace.core.a)this.cEk.valueAt(i)).onRelease();
        i += 1;
      }
      this.cEk.clear();
      return;
    }
    finally {}
  }
  
  public final int Is()
  {
    return 0;
  }
  
  public final void a(com.tencent.matrix.a.c.a parama)
  {
    com.tencent.matrix.g.c.i("Matrix.LooperTaskMonitorPlugin", "onInstall", new Object[0]);
    this.cEj = parama;
  }
  
  public final void bV(boolean paramBoolean)
  {
    if (this.cEj.cDE)
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
              synchronized (this.cEk)
              {
                if (this.cEk.get(localThread.getId()) == null) {
                  this.cEk.put(localThread.getId(), new com.tencent.matrix.trace.core.a(localLooper));
                }
              }
            }
            ??? = a(localThread);
            if ((this.cEj.cDF.cDH != null) && (!((List)???).isEmpty())) {
              this.cEj.cDF.cDH.a(localThread, (List)???);
            }
          }
        }
      }
    }
  }
  
  final class a
    extends a.a
  {
    HashMap<String, c.b> cEm;
    
    public final void dQ(String paramString)
    {
      if (this.cEl.cEj.isForeground()) {
        return;
      }
      super.dQ(paramString);
      int k = paramString.indexOf("to ");
      int j = paramString.lastIndexOf('@');
      int i = j;
      if (j < 0) {
        i = paramString.lastIndexOf(':');
      }
      i = Math.max(i - 60, k + 3);
      Thread.currentThread();
      String str = paramString.substring(i);
      c.b localb = (c.b)this.cEm.get(str);
      paramString = localb;
      if (localb == null)
      {
        paramString = new c.b(this.cEl);
        this.cEm.put(str, paramString);
      }
      paramString.cEn = str;
      if (paramString.cEo == null) {
        paramString.cEo = new long[1000];
      }
      i = paramString.count;
      paramString.cEo[(i % 1000)] = System.currentTimeMillis();
      paramString.count += 1;
    }
    
    public final boolean isValid()
    {
      return !this.cEl.cEj.isForeground();
    }
  }
  
  public final class b
  {
    String cEn;
    long[] cEo;
    int count;
    
    public b() {}
    
    public final boolean equals(Object paramObject)
    {
      return this.cEn.equals(paramObject);
    }
    
    public final int hashCode()
    {
      return this.cEn.hashCode();
    }
    
    public final String toString()
    {
      return this.cEn + "=" + this.count;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.c.a.c
 * JD-Core Version:    0.7.0.1
 */