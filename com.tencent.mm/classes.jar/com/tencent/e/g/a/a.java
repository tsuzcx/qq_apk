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
  private static final HashMap<String, g.a> ZwP = new HashMap();
  
  public void a(g paramg)
  {
    paramg = paramg.ZwD.ZwF;
    int i;
    do
    {
      i = paramg.get();
    } while (!paramg.compareAndSet(i, i - 1));
  }
  
  public void b(g paramg) {}
  
  public final g bDm(String paramString)
  {
    synchronized (ZwP)
    {
      g.a locala2 = (g.a)ZwP.get(paramString);
      g.a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new g.a(paramString, new AtomicInteger());
        ZwP.put(paramString, locala1);
      }
      return new g(locala1);
    }
  }
  
  public final void d(g paramg)
  {
    paramg = paramg.ZwD.ZwF;
    int i;
    do
    {
      i = paramg.get();
    } while (!paramg.compareAndSet(i, i + 1));
  }
  
  public final Map<String, Integer> ipW()
  {
    HashMap localHashMap2 = new HashMap();
    synchronized (ZwP)
    {
      Iterator localIterator = ZwP.values().iterator();
      while (localIterator.hasNext())
      {
        g.a locala = (g.a)localIterator.next();
        int i = locala.ZwF.get();
        if (i > 0) {
          localHashMap2.put(locala.key, Integer.valueOf(i));
        }
      }
    }
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.e.g.a.a
 * JD-Core Version:    0.7.0.1
 */