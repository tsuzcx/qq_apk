package com.google.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ao<K, V>
  extends LinkedHashMap<K, V>
{
  private static final ao bYg;
  boolean bNd = true;
  
  static
  {
    ao localao = new ao();
    bYg = localao;
    localao.bNd = false;
  }
  
  ao() {}
  
  ao(Map<K, V> paramMap)
  {
    super(paramMap);
  }
  
  private static int at(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return ae.hashCode((byte[])paramObject);
    }
    if ((paramObject instanceof ae.a)) {
      throw new UnsupportedOperationException();
    }
    return paramObject.hashCode();
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
  
  static <K, V> int c(Map<K, V> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    Map.Entry localEntry;
    int j;
    for (int i = 0; paramMap.hasNext(); i = (at(localEntry.getValue()) ^ j) + i)
    {
      localEntry = (Map.Entry)paramMap.next();
      j = at(localEntry.getKey());
    }
    return i;
  }
  
  static <K, V> Map<K, V> d(Map<K, V> paramMap)
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
  
  final void GY()
  {
    if (!this.bNd) {
      throw new UnsupportedOperationException();
    }
  }
  
  public final void clear()
  {
    GY();
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
    return c(this);
  }
  
  public final V put(K paramK, V paramV)
  {
    GY();
    ae.checkNotNull(paramK);
    ae.checkNotNull(paramV);
    return super.put(paramK, paramV);
  }
  
  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    GY();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      ae.checkNotNull(localObject);
      ae.checkNotNull(paramMap.get(localObject));
    }
    super.putAll(paramMap);
  }
  
  public final V remove(Object paramObject)
  {
    GY();
    return super.remove(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.ao
 * JD-Core Version:    0.7.0.1
 */