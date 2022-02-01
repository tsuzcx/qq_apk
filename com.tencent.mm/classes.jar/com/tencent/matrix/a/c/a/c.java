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
  com.tencent.matrix.a.c.a cDC;
  private final LongSparseArray<com.tencent.matrix.trace.core.a> cDD;
  
  private LinkedList<b> a(Thread paramThread)
  {
    synchronized (this.cDD)
    {
      com.tencent.matrix.trace.core.a locala = (com.tencent.matrix.trace.core.a)this.cDD.get(paramThread.getId());
      if (locala != null) {
        this.cDD.remove(paramThread.getId());
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
            ??? = ((a)locala1).cDF;
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
  
  public final void Ii()
  {
    com.tencent.matrix.g.c.i("Matrix.LooperTaskMonitorPlugin", "onTurnOn", new Object[0]);
  }
  
  public final void Ij()
  {
    com.tencent.matrix.g.c.i("Matrix.LooperTaskMonitorPlugin", "onTurnOff", new Object[0]);
    LongSparseArray localLongSparseArray = this.cDD;
    int i = 0;
    try
    {
      while (i < this.cDD.size())
      {
        ((com.tencent.matrix.trace.core.a)this.cDD.valueAt(i)).onRelease();
        i += 1;
      }
      this.cDD.clear();
      return;
    }
    finally {}
  }
  
  public final int Ik()
  {
    return 0;
  }
  
  public final void a(com.tencent.matrix.a.c.a parama)
  {
    com.tencent.matrix.g.c.i("Matrix.LooperTaskMonitorPlugin", "onInstall", new Object[0]);
    this.cDC = parama;
  }
  
  public final void bV(boolean paramBoolean)
  {
    if (this.cDC.cCX)
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
              synchronized (this.cDD)
              {
                if (this.cDD.get(localThread.getId()) == null) {
                  this.cDD.put(localThread.getId(), new com.tencent.matrix.trace.core.a(localLooper));
                }
              }
            }
            ??? = a(localThread);
            if ((this.cDC.cCY.cDa != null) && (!((List)???).isEmpty())) {
              this.cDC.cCY.cDa.a(localThread, (List)???);
            }
          }
        }
      }
    }
  }
  
  final class a
    extends a.a
  {
    HashMap<String, c.b> cDF;
    
    public final void dN(String paramString)
    {
      if (this.cDE.cDC.isForeground()) {
        return;
      }
      super.dN(paramString);
      int k = paramString.indexOf("to ");
      int j = paramString.lastIndexOf('@');
      int i = j;
      if (j < 0) {
        i = paramString.lastIndexOf(':');
      }
      i = Math.max(i - 60, k + 3);
      Thread.currentThread();
      String str = paramString.substring(i);
      c.b localb = (c.b)this.cDF.get(str);
      paramString = localb;
      if (localb == null)
      {
        paramString = new c.b(this.cDE);
        this.cDF.put(str, paramString);
      }
      paramString.cDG = str;
      if (paramString.cDH == null) {
        paramString.cDH = new long[1000];
      }
      i = paramString.count;
      paramString.cDH[(i % 1000)] = System.currentTimeMillis();
      paramString.count += 1;
    }
    
    public final boolean isValid()
    {
      return !this.cDE.cDC.isForeground();
    }
  }
  
  public final class b
  {
    String cDG;
    long[] cDH;
    int count;
    
    public b() {}
    
    public final boolean equals(Object paramObject)
    {
      return this.cDG.equals(paramObject);
    }
    
    public final int hashCode()
    {
      return this.cDG.hashCode();
    }
    
    public final String toString()
    {
      return this.cDG + "=" + this.count;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.c.a.c
 * JD-Core Version:    0.7.0.1
 */