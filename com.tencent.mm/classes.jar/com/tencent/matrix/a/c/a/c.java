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
  com.tencent.matrix.a.c.a cvy;
  private final LongSparseArray<com.tencent.matrix.trace.core.a> cvz;
  
  private LinkedList<b> a(Thread paramThread)
  {
    synchronized (this.cvz)
    {
      com.tencent.matrix.trace.core.a locala = (com.tencent.matrix.trace.core.a)this.cvz.get(paramThread.getId());
      if (locala != null) {
        this.cvz.remove(paramThread.getId());
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
            ??? = ((a)locala1).cvB;
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
  
  public final void Hc()
  {
    com.tencent.matrix.g.c.i("Matrix.LooperTaskMonitorPlugin", "onTurnOn", new Object[0]);
  }
  
  public final void Hd()
  {
    com.tencent.matrix.g.c.i("Matrix.LooperTaskMonitorPlugin", "onTurnOff", new Object[0]);
    LongSparseArray localLongSparseArray = this.cvz;
    int i = 0;
    try
    {
      while (i < this.cvz.size())
      {
        ((com.tencent.matrix.trace.core.a)this.cvz.valueAt(i)).onRelease();
        i += 1;
      }
      this.cvz.clear();
      return;
    }
    finally {}
  }
  
  public final int He()
  {
    return 0;
  }
  
  public final void a(com.tencent.matrix.a.c.a parama)
  {
    com.tencent.matrix.g.c.i("Matrix.LooperTaskMonitorPlugin", "onInstall", new Object[0]);
    this.cvy = parama;
  }
  
  public final void bS(boolean paramBoolean)
  {
    if (this.cvy.cuT)
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
              synchronized (this.cvz)
              {
                if (this.cvz.get(localThread.getId()) == null) {
                  this.cvz.put(localThread.getId(), new com.tencent.matrix.trace.core.a(localLooper));
                }
              }
            }
            ??? = a(localThread);
            if ((this.cvy.cuU.cuW != null) && (!((List)???).isEmpty())) {
              this.cvy.cuU.cuW.a(localThread, (List)???);
            }
          }
        }
      }
    }
  }
  
  final class a
    extends a.a
  {
    HashMap<String, c.b> cvB;
    
    public final void cV(String paramString)
    {
      if (this.cvA.cvy.isForeground()) {
        return;
      }
      super.cV(paramString);
      int k = paramString.indexOf("to ");
      int j = paramString.lastIndexOf('@');
      int i = j;
      if (j < 0) {
        i = paramString.lastIndexOf(':');
      }
      i = Math.max(i - 60, k + 3);
      Thread.currentThread();
      String str = paramString.substring(i);
      c.b localb = (c.b)this.cvB.get(str);
      paramString = localb;
      if (localb == null)
      {
        paramString = new c.b(this.cvA);
        this.cvB.put(str, paramString);
      }
      paramString.cvC = str;
      if (paramString.cvD == null) {
        paramString.cvD = new long[1000];
      }
      i = paramString.count;
      paramString.cvD[(i % 1000)] = System.currentTimeMillis();
      paramString.count += 1;
    }
    
    public final boolean isValid()
    {
      return !this.cvA.cvy.isForeground();
    }
  }
  
  public final class b
  {
    int count;
    String cvC;
    long[] cvD;
    
    public b() {}
    
    public final boolean equals(Object paramObject)
    {
      return this.cvC.equals(paramObject);
    }
    
    public final int hashCode()
    {
      return this.cvC.hashCode();
    }
    
    public final String toString()
    {
      return this.cvC + "=" + this.count;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.c.a.c
 * JD-Core Version:    0.7.0.1
 */