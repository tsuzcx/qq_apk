package com.google.d;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class bw<K, V>
  extends LinkedHashMap<K, V>
{
  private static final bw dTS;
  boolean dIE = true;
  
  static
  {
    bw localbw = new bw();
    dTS = localbw;
    localbw.dIE = false;
  }
  
  private bw() {}
  
  private bw(Map<K, V> paramMap)
  {
    super(paramMap);
  }
  
  public static <K, V> bw<K, V> aiN()
  {
    return dTS;
  }
  
  static <K, V> boolean b(Map<K, V> paramMap1, Map<K, V> paramMap2)
  {
    if (paramMap1 == paramMap2) {
      return true;
    }
    if (paramMap1.size() != paramMap2.size()) {
      return false;
    }
    paramMap1 = paramMap1.entrySet().iterator();
    while (paramMap1.hasNext())
    {
      Object localObject2 = (Map.Entry)paramMap1.next();
      if (!paramMap2.containsKey(((Map.Entry)localObject2).getKey())) {
        return false;
      }
      Object localObject1 = ((Map.Entry)localObject2).getValue();
      localObject2 = paramMap2.get(((Map.Entry)localObject2).getKey());
      if (((localObject1 instanceof byte[])) && ((localObject2 instanceof byte[]))) {}
      for (boolean bool = Arrays.equals((byte[])localObject1, (byte[])localObject2); !bool; bool = localObject1.equals(localObject2)) {
        return false;
      }
    }
    return true;
  }
  
  private static int bA(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return bj.hashCode((byte[])paramObject);
    }
    if ((paramObject instanceof bj.c)) {
      throw new UnsupportedOperationException();
    }
    return paramObject.hashCode();
  }
  
  static <K, V> int f(Map<K, V> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    Map.Entry localEntry;
    int j;
    for (int i = 0; paramMap.hasNext(); i = (bA(localEntry.getValue()) ^ j) + i)
    {
      localEntry = (Map.Entry)paramMap.next();
      j = bA(localEntry.getKey());
    }
    return i;
  }
  
  static <K, V> Map<K, V> g(Map<K, V> paramMap)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      Object localObject2 = paramMap.getKey();
      Object localObject1 = paramMap.getValue();
      paramMap = localObject1;
      if ((localObject1 instanceof byte[]))
      {
        paramMap = (byte[])localObject1;
        paramMap = Arrays.copyOf(paramMap, paramMap.length);
      }
      localLinkedHashMap.put(localObject2, paramMap);
    }
    return localLinkedHashMap;
  }
  
  final void aiL()
  {
    if (!this.dIE) {
      throw new UnsupportedOperationException();
    }
  }
  
  public final bw<K, V> aiO()
  {
    if (isEmpty()) {
      return new bw();
    }
    return new bw(this);
  }
  
  public final void clear()
  {
    aiL();
    super.clear();
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    if (isEmpty()) {
      return Collections.emptySet();
    }
    return super.entrySet();
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Map)) && (b(this, (Map)paramObject));
  }
  
  public final int hashCode()
  {
    return f(this);
  }
  
  public final V put(K paramK, V paramV)
  {
    aiL();
    bj.checkNotNull(paramK);
    bj.checkNotNull(paramV);
    return super.put(paramK, paramV);
  }
  
  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    aiL();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      bj.checkNotNull(localObject);
      bj.checkNotNull(paramMap.get(localObject));
    }
    super.putAll(paramMap);
  }
  
  public final V remove(Object paramObject)
  {
    aiL();
    return super.remove(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.bw
 * JD-Core Version:    0.7.0.1
 */