package com.e.a.a.b;

import java.io.Serializable;
import javax.annotation.Nullable;

final class g<K, V>
  extends c<K, V>
  implements Serializable
{
  private K aIw;
  private V value;
  
  g(@Nullable K paramK, @Nullable V paramV)
  {
    this.aIw = paramK;
    this.value = paramV;
  }
  
  @Nullable
  public final K getKey()
  {
    return this.aIw;
  }
  
  @Nullable
  public final V getValue()
  {
    return this.value;
  }
  
  public final V setValue(V paramV)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.e.a.a.b.g
 * JD-Core Version:    0.7.0.1
 */