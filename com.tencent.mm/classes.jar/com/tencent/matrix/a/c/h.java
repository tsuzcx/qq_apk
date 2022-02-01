package com.tencent.matrix.a.c;

import android.arch.a.c.a;
import android.os.SystemClock;
import android.support.v4.e.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class h
{
  public static void K(List<?> paramList)
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
  
  public static b a(List<? extends a> paramList, long paramLong)
  {
    Object localObject1 = new HashMap();
    long l1 = 0L;
    long l3;
    if (paramLong <= 0L)
    {
      paramList = paramList.iterator();
      l3 = -9223372036854775808L;
      l2 = l1;
      if (paramList.hasNext())
      {
        localObject2 = (a)paramList.next();
        l2 = l1;
        if (l3 != -9223372036854775808L)
        {
          l2 = l1;
          if (l3 < ((a)localObject2).cTi) {
            break label299;
          }
          l3 -= ((a)localObject2).cTi;
          l2 = l1 + l3;
          localObject3 = (Long)((Map)localObject1).get(((a)localObject2).key);
          str = ((a)localObject2).key;
          if (localObject3 != null) {
            break label155;
          }
        }
        label155:
        for (l1 = 0L;; l1 = ((Long)localObject3).longValue())
        {
          ((Map)localObject1).put(str, Long.valueOf(l1 + l3));
          l3 = ((a)localObject2).cTi;
          l1 = l2;
          break;
        }
      }
    }
    else
    {
      localObject2 = paramList.iterator();
      l3 = -9223372036854775808L;
      l2 = l1;
      if (((Iterator)localObject2).hasNext())
      {
        paramList = (a)((Iterator)localObject2).next();
        l2 = l1;
        if (l3 == -9223372036854775808L) {
          break label382;
        }
        l2 = l1;
        if (l3 >= paramList.cTi)
        {
          l3 -= paramList.cTi;
          if (l1 + l3 < paramLong) {
            break label330;
          }
          l3 = paramLong - l1;
          l2 = l1 + l3;
          localObject2 = (Long)((Map)localObject1).get(paramList.key);
          paramList = paramList.key;
          if (localObject2 != null) {
            break label321;
          }
        }
      }
    }
    label299:
    label321:
    for (l1 = 0L;; l1 = ((Long)localObject2).longValue())
    {
      ((Map)localObject1).put(paramList, Long.valueOf(l1 + l3));
      paramList = new b();
      if (l2 > 0L) {
        break;
      }
      paramList.cTq = false;
      return paramList;
    }
    label330:
    long l2 = l1 + l3;
    Object localObject3 = (Long)((Map)localObject1).get(paramList.key);
    String str = paramList.key;
    if (localObject3 == null) {}
    for (l1 = 0L;; l1 = ((Long)localObject3).longValue())
    {
      ((Map)localObject1).put(str, Long.valueOf(l1 + l3));
      label382:
      l3 = paramList.cTi;
      l1 = l2;
      break;
    }
    if (paramLong > l2) {
      paramList.cTq = false;
    }
    paramList.cUw = l2;
    new a() {};
    Object localObject2 = new ArrayList();
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      ((List)localObject2).add(new k((String)((Map.Entry)localObject3).getKey(), Integer.valueOf(p(((Long)((Map.Entry)localObject3).getValue()).longValue(), l2))));
    }
    Collections.sort((List)localObject2, new Comparator() {});
    paramList.cUx = ((List)localObject2);
    return paramList;
  }
  
  private static int p(long paramLong1, long paramLong2)
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
  
  public static class a
  {
    public final long cTi;
    public final String key;
    
    public a(String paramString)
    {
      this.key = paramString;
      this.cTi = SystemClock.uptimeMillis();
    }
  }
  
  public static final class b
  {
    public boolean cTq = true;
    public long cUw;
    public List<k<String, Integer>> cUx = Collections.emptyList();
    
    public final k<String, Integer> Ss()
    {
      if (this.cUx.size() > 0) {
        return (k)this.cUx.get(0);
      }
      return null;
    }
    
    public final int ex(String paramString)
    {
      Iterator localIterator = this.cUx.iterator();
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        if ((localk.first != null) && (((String)localk.first).equals(paramString)))
        {
          if (localk.second == null) {
            return 0;
          }
          return ((Integer)localk.second).intValue();
        }
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.a.c.h
 * JD-Core Version:    0.7.0.1
 */