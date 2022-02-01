package com.tencent.matrix.a.b;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class o
{
  private static int M(long paramLong1, long paramLong2)
  {
    paramLong1 = Math.round(paramLong1 / paramLong2 * 100.0D);
    if (paramLong1 >= 100L) {
      return 100;
    }
    if (paramLong1 <= 0L) {
      return 0;
    }
    return (int)paramLong1;
  }
  
  public static c a(List<? extends a> paramList, long paramLong, o.a.a parama)
  {
    paramList = new ArrayList(paramList);
    if (!paramList.isEmpty())
    {
      parama = parama.gr("CURR_STAMP");
      if (parama.eRP - ((a)paramList.get(0)).eRP > 10L) {
        paramList.add(0, parama);
      }
    }
    Object localObject1 = new HashMap();
    long l1 = 0L;
    long l2 = -9223372036854775808L;
    Object localObject2;
    if (paramLong <= 0L)
    {
      localObject2 = paramList.iterator();
      l3 = -9223372036854775808L;
      l4 = l2;
      for (;;)
      {
        l2 = l1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (a)((Iterator)localObject2).next();
        l2 = l1;
        if (l4 != -9223372036854775808L)
        {
          l2 = l1;
          if (l4 < ((a)localObject3).eRP) {
            break;
          }
          l4 -= ((a)localObject3).eRP;
          l2 = l1 + l4;
          parama = (b)((Map)localObject1).get(((a)localObject3).key);
          paramList = parama;
          if (parama == null)
          {
            paramList = new b();
            ((Map)localObject1).put(((a)localObject3).key, paramList);
          }
          paramList.eUt = (l4 + paramList.eUt);
          l1 = paramList.eUu;
          paramList.eUu = (l3 - ((a)localObject3).eUs + l1);
        }
        l4 = ((a)localObject3).eRP;
        l3 = ((a)localObject3).eUs;
        l1 = l2;
      }
    }
    Object localObject3 = paramList.iterator();
    long l3 = -9223372036854775808L;
    long l4 = l2;
    for (;;)
    {
      l2 = l1;
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (a)((Iterator)localObject3).next();
        l2 = l1;
        if (l4 == -9223372036854775808L) {
          break label564;
        }
        l2 = l1;
        if (l4 >= ((a)localObject2).eRP)
        {
          l4 -= ((a)localObject2).eRP;
          if (l1 + l4 < paramLong) {
            break label481;
          }
          long l5 = paramLong - l1;
          l2 = l1 + l5;
          parama = (b)((Map)localObject1).get(((a)localObject2).key);
          paramList = parama;
          if (parama == null)
          {
            paramList = new b();
            ((Map)localObject1).put(((a)localObject2).key, paramList);
          }
          paramList.eUt += l5;
          float f = (float)paramList.eUu;
          paramList.eUu = (((float)(l3 - ((a)localObject2).eUs) * ((float)l5 / (float)l4) + f));
        }
      }
      paramList = new c();
      if (l2 > 0L) {
        break;
      }
      paramList.eSe = false;
      return paramList;
      label481:
      l2 = l1 + l4;
      parama = (b)((Map)localObject1).get(((a)localObject2).key);
      paramList = parama;
      if (parama == null)
      {
        paramList = new b();
        ((Map)localObject1).put(((a)localObject2).key, paramList);
      }
      paramList.eUt = (l4 + paramList.eUt);
      l1 = paramList.eUu;
      paramList.eUu = (l3 - ((a)localObject2).eUs + l1);
      label564:
      l4 = ((a)localObject2).eRP;
      l3 = ((a)localObject2).eUs;
      l1 = l2;
    }
    if (paramLong > l2) {
      paramList.eSe = false;
    }
    paramList.eUv = l2;
    parama = new ArrayList();
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = (String)((Map.Entry)localObject3).getKey();
      localObject3 = (b)((Map.Entry)localObject3).getValue();
      localObject2 = new o.c.a((String)localObject2, M(((b)localObject3).eUt, l2));
      ((o.c.a)localObject2).eUx = ((b)localObject3).eUu;
      parama.add(localObject2);
    }
    Collections.sort(parama, new Comparator() {});
    paramList.eUw = parama;
    return paramList;
  }
  
  public static void bg(List<?> paramList)
  {
    if (paramList == null) {}
    int j;
    int i;
    do
    {
      return;
      j = paramList.size();
      i = j / 2;
      j -= 1;
    } while (i >= j);
    paramList.subList(i, j).clear();
  }
  
  public static final class a
  {
    public final long eRP;
    public final long eUs;
    public final String key;
    
    public a(String paramString)
    {
      this.key = paramString;
      this.eRP = SystemClock.uptimeMillis();
      this.eUs = System.currentTimeMillis();
    }
    
    public a(String paramString, long paramLong)
    {
      this.key = paramString;
      this.eRP = paramLong;
      this.eUs = System.currentTimeMillis();
    }
    
    public static abstract interface a
    {
      public abstract o.a gr(String paramString);
    }
  }
  
  static final class b
  {
    long eUt;
    long eUu;
  }
  
  public static final class c
  {
    public boolean eSe = true;
    public long eUv;
    public List<a> eUw = Collections.emptyList();
    
    public static c axD()
    {
      c localc = new c();
      localc.eSe = false;
      return localc;
    }
    
    public final a axE()
    {
      if (this.eUw.size() > 0) {
        return (a)this.eUw.get(0);
      }
      return null;
    }
    
    public final a axF()
    {
      if (this.eUw.size() >= 2) {
        return (a)this.eUw.get(1);
      }
      return null;
    }
    
    public final int gB(String paramString)
    {
      Iterator localIterator = this.eUw.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if ((locala.key != null) && (locala.key.equals(paramString))) {
          return locala.ratio;
        }
      }
      return 0;
    }
    
    public static final class a
    {
      public long eUx = 0L;
      public final String key;
      public final int ratio;
      
      public a(String paramString, int paramInt)
      {
        this.key = paramString;
        this.ratio = paramInt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.b.o
 * JD-Core Version:    0.7.0.1
 */