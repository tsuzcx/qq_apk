package com.tencent.e.g.a;

import com.tencent.e.g.g;
import com.tencent.e.g.g.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a
  implements b
{
  private static final HashMap<String, g.a> Izq = new HashMap();
  
  public void a(g paramg)
  {
    paramg = paramg.Ize.Izg;
    int i;
    do
    {
      i = paramg.get();
    } while (!paramg.compareAndSet(i, i - 1));
  }
  
  public final g aOb(String paramString)
  {
    synchronized (Izq)
    {
      g.a locala2 = (g.a)Izq.get(paramString);
      g.a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new g.a(paramString, new AtomicInteger());
        Izq.put(paramString, locala1);
      }
      return new g(locala1);
    }
  }
  
  public void b(g paramg) {}
  
  public final void d(g paramg)
  {
    paramg = paramg.Ize.Izg;
    int i;
    do
    {
      i = paramg.get();
    } while (!paramg.compareAndSet(i, i + 1));
  }
  
  public final Map<String, Integer> fod()
  {
    HashMap localHashMap2 = new HashMap();
    synchronized (Izq)
    {
      Iterator localIterator = Izq.values().iterator();
      while (localIterator.hasNext())
      {
        g.a locala = (g.a)localIterator.next();
        int i = locala.Izg.get();
        if (i > 0) {
          localHashMap2.put(locala.key, Integer.valueOf(i));
        }
      }
    }
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.g.a.a
 * JD-Core Version:    0.7.0.1
 */