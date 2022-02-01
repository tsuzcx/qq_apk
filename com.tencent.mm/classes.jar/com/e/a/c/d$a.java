package com.e.a.c;

import java.util.ConcurrentModificationException;
import java.util.Map.Entry;

final class d$a
  implements Map.Entry<K, V>
{
  private final K aIw;
  private V cfK;
  private final int index;
  
  d$a(K paramK, V paramV, int paramInt)
  {
    this.aIw = paramV;
    this.cfK = paramInt;
    int i;
    this.index = i;
  }
  
  public final K getKey()
  {
    return this.aIw;
  }
  
  public final V getValue()
  {
    return this.cfK;
  }
  
  public final V setValue(V paramV)
  {
    if (this.cfL.cfJ[this.index] != this.cfK) {
      throw new ConcurrentModificationException();
    }
    this.cfL.cfJ[this.index] = paramV;
    Object localObject = this.cfK;
    this.cfK = paramV;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.c.d.a
 * JD-Core Version:    0.7.0.1
 */