package com.h.a.a.b;

import java.io.Serializable;

final class g<K, V>
  extends c<K, V>
  implements Serializable
{
  private K key;
  private V value;
  
  g(K paramK, V paramV)
  {
    this.key = paramK;
    this.value = paramV;
  }
  
  public final K getKey()
  {
    return this.key;
  }
  
  public final V getValue()
  {
    return this.value;
  }
  
  public final V setValue(V paramV)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.h.a.a.b.g
 * JD-Core Version:    0.7.0.1
 */