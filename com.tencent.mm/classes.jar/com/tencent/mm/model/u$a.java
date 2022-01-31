package com.tencent.mm.model;

import java.util.concurrent.ConcurrentHashMap;

final class u$a<K, V>
  extends ConcurrentHashMap<K, V>
{
  public final boolean containsValue(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    return super.containsValue(paramObject);
  }
  
  public final V get(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return super.get(paramObject);
  }
  
  public final V put(K paramK, V paramV)
  {
    if (paramK == null) {
      return null;
    }
    if (paramV == null) {
      return super.remove(paramK);
    }
    return super.put(paramK, paramV);
  }
  
  public final V remove(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return super.remove(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.u.a
 * JD-Core Version:    0.7.0.1
 */