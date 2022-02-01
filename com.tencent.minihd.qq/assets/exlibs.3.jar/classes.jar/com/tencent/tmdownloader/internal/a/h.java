package com.tencent.tmdownloader.internal.a;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class h
{
  protected static h g = null;
  protected final Comparator a = new i(this);
  final PriorityQueue b = new PriorityQueue(16, this.a);
  final ArrayList c = new ArrayList();
  final ArrayList d = new ArrayList();
  final Object e = new Object();
  final Object f = new Object();
  
  private h()
  {
    int j = f.a().c();
    int i = 0;
    while (i < j)
    {
      j localj = new j(this, i);
      this.d.add(localj);
      i += 1;
    }
  }
  
  public static h a()
  {
    if (g == null) {
      g = new h();
    }
    return g;
  }
  
  int a(g paramg)
  {
    synchronized (this.f)
    {
      this.b.add(paramg);
      synchronized (this.e)
      {
        this.e.notifyAll();
        int i = paramg.a();
        return i;
      }
    }
  }
  
  public g a(String paramString)
  {
    synchronized (this.f)
    {
      Iterator localIterator = this.c.iterator();
      g localg;
      while (localIterator.hasNext())
      {
        localg = (g)localIterator.next();
        if (localg.c().equals(paramString)) {
          return localg;
        }
      }
      localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        localg = (g)localIterator.next();
        if (localg.c().equals(paramString)) {
          return localg;
        }
      }
    }
    return null;
  }
  
  void a(int paramInt)
  {
    synchronized (this.f)
    {
      Iterator localIterator = this.c.iterator();
      g localg;
      while (localIterator.hasNext())
      {
        localg = (g)localIterator.next();
        if (localg.a() == paramInt)
        {
          localg.b();
          this.c.remove(localg);
          return;
        }
      }
      localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        localg = (g)localIterator.next();
        if (localg.a() == paramInt)
        {
          localg.b();
          this.b.remove(localg);
          return;
        }
      }
    }
  }
  
  boolean b()
  {
    for (;;)
    {
      synchronized (this.f)
      {
        if (this.b.size() > 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.a.h
 * JD-Core Version:    0.7.0.1
 */