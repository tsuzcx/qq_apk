package com.tencent.c.a.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class r
{
  private static r btO = null;
  private Map<Integer, q> btM = null;
  private int btN = 0;
  
  private r(Context paramContext)
  {
    this.btM.put(Integer.valueOf(1), new o(paramContext));
    this.btM.put(Integer.valueOf(2), new d(paramContext));
    this.btM.put(Integer.valueOf(4), new k(paramContext));
  }
  
  private a B(List<Integer> paramList)
  {
    if (paramList.size() > 0) {
      paramList = paramList.iterator();
    }
    Object localObject;
    do
    {
      do
      {
        if (!paramList.hasNext()) {
          return new a();
        }
        localObject = (Integer)paramList.next();
        localObject = (q)this.btM.get(localObject);
      } while (localObject == null);
      localObject = ((q)localObject).rE();
    } while (localObject == null);
    return localObject;
  }
  
  static r ap(Context paramContext)
  {
    try
    {
      if (btO == null) {
        btO = new r(paramContext);
      }
      paramContext = btO;
      return paramContext;
    }
    finally {}
  }
  
  final g A(List<Integer> paramList)
  {
    if (paramList.size() >= 0) {
      paramList = paramList.iterator();
    }
    Object localObject;
    do
    {
      do
      {
        if (!paramList.hasNext()) {
          return new g();
        }
        localObject = (Integer)paramList.next();
        localObject = (q)this.btM.get(localObject);
      } while (localObject == null);
      localObject = ((q)localObject).rD();
    } while ((localObject == null) || (!s.bG(((g)localObject).btu)));
    return localObject;
  }
  
  final void b(a parama)
  {
    Iterator localIterator = this.btM.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((q)((Map.Entry)localIterator.next()).getValue()).b(parama);
    }
  }
  
  final void b(g paramg)
  {
    Iterator localIterator = this.btM.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((q)((Map.Entry)localIterator.next()).getValue()).b(paramg);
    }
  }
  
  final g rD()
  {
    return A(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4) })));
  }
  
  final a rE()
  {
    return B(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(4) })));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.c.a.a.r
 * JD-Core Version:    0.7.0.1
 */