package com.google.d;

import java.util.Map.Entry;

final class bm$a<K>
  implements Map.Entry<K, Object>
{
  private Map.Entry<K, bm> dTg;
  
  private bm$a(Map.Entry<K, bm> paramEntry)
  {
    this.dTg = paramEntry;
  }
  
  public final bm ait()
  {
    return (bm)this.dTg.getValue();
  }
  
  public final K getKey()
  {
    return this.dTg.getKey();
  }
  
  public final Object getValue()
  {
    if ((bm)this.dTg.getValue() == null) {
      return null;
    }
    throw null;
  }
  
  public final Object setValue(Object paramObject)
  {
    if (!(paramObject instanceof ce)) {
      throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
    return ((bm)this.dTg.getValue()).f((ce)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.bm.a
 * JD-Core Version:    0.7.0.1
 */