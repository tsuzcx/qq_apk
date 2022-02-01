package com.google.b;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class bo<K, V>
  extends LinkedHashMap<K, V>
{
  private static final bo bZK;
  boolean bPc = true;
  
  static
  {
    bo localbo = new bo();
    bZK = localbo;
    localbo.bPc = false;
  }
  
  private void IB()
  {
    if (!this.bPc) {
      throw new UnsupportedOperationException();
    }
  }
  
  private static int aq(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return be.hashCode((byte[])paramObject);
    }
    if ((paramObject instanceof be.a)) {
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
    for (int i = 0; paramMap.hasNext(); i = (aq(localEntry.getValue()) ^ j) + i)
    {
      localEntry = (Map.Entry)paramMap.next();
      j = aq(localEntry.getKey());
    }
    return i;
  }
  
  public final void clear()
  {
    IB();
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
    IB();
    be.checkNotNull(paramK);
    be.checkNotNull(paramV);
    return super.put(paramK, paramV);
  }
  
  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    IB();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      be.checkNotNull(localObject);
      be.checkNotNull(paramMap.get(localObject));
    }
    super.putAll(paramMap);
  }
  
  public final V remove(Object paramObject)
  {
    IB();
    return super.remove(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.b.bo
 * JD-Core Version:    0.7.0.1
 */