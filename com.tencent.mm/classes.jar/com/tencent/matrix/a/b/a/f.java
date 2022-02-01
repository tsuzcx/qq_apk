package com.tencent.matrix.a.b.a;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.LongSparseArray;
import com.tencent.matrix.a.b.c;
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

public final class f
  extends a
{
  private final LongSparseArray<com.tencent.matrix.trace.core.a> cTl;
  
  private LinkedList<c> a(Thread paramThread)
  {
    synchronized (this.cTl)
    {
      com.tencent.matrix.trace.core.a locala = (com.tencent.matrix.trace.core.a)this.cTl.get(paramThread.getId());
      if (locala != null) {
        this.cTl.remove(paramThread.getId());
      }
      paramThread = new LinkedList();
      if (locala != null)
      {
        ??? = locala.listeners.iterator();
        while (((Iterator)???).hasNext())
        {
          a.a locala1 = (a.a)((Iterator)???).next();
          if ((locala1 instanceof b))
          {
            ??? = ((b)locala1).map;
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
  
  public final void Sf()
  {
    super.Sf();
    LongSparseArray localLongSparseArray = this.cTl;
    int i = 0;
    try
    {
      while (i < this.cTl.size())
      {
        ((com.tencent.matrix.trace.core.a)this.cTl.valueAt(i)).onRelease();
        i += 1;
      }
      this.cTl.clear();
      return;
    }
    finally {}
  }
  
  public final int Sg()
  {
    return 0;
  }
  
  public final void onForeground(boolean paramBoolean)
  {
    super.onForeground(paramBoolean);
    if (this.cSq.Sd())
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
              synchronized (this.cTl)
              {
                if (this.cTl.get(localThread.getId()) == null) {
                  this.cTl.put(localThread.getId(), new com.tencent.matrix.trace.core.a(localLooper));
                }
              }
            }
            ??? = a(localThread);
            if (!((List)???).isEmpty()) {
              this.cSq.a(localThread, (List)???);
            }
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(Thread paramThread, List<f.c> paramList);
  }
  
  final class b
    extends a.a
  {
    HashMap<String, f.c> map;
    
    public final void er(String paramString)
    {
      if (this.cTm.cSq.cSh) {
        return;
      }
      super.er(paramString);
      int k = paramString.indexOf("to ");
      int j = paramString.lastIndexOf('@');
      int i = j;
      if (j < 0) {
        i = paramString.lastIndexOf(':');
      }
      i = Math.max(i - 60, k + 3);
      Thread.currentThread();
      String str = paramString.substring(i);
      f.c localc = (f.c)this.map.get(str);
      paramString = localc;
      if (localc == null)
      {
        paramString = new f.c();
        this.map.put(str, paramString);
      }
      paramString.cTn = str;
      if (paramString.cTo == null) {
        paramString.cTo = new long[1000];
      }
      i = paramString.count;
      paramString.cTo[(i % 1000)] = System.currentTimeMillis();
      paramString.count += 1;
    }
    
    public final boolean isValid()
    {
      return !this.cTm.cSq.cSh;
    }
  }
  
  public static final class c
  {
    String cTn;
    long[] cTo;
    int count;
    
    public final boolean equals(Object paramObject)
    {
      if (this.cTn == null) {}
      while (!(paramObject instanceof String)) {
        return false;
      }
      return this.cTn.equals(paramObject);
    }
    
    public final int hashCode()
    {
      return this.cTn.hashCode();
    }
    
    public final String toString()
    {
      return this.cTn + "=" + this.count;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.a.b.a.f
 * JD-Core Version:    0.7.0.1
 */