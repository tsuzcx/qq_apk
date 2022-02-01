package com.d.a.a.b;

import java.io.Serializable;
import javax.annotation.Nullable;

final class g<K, V>
  extends c<K, V>
  implements Serializable
{
  private K aFP;
  private V value;
  
  g(@Nullable K paramK, @Nullable V paramV)
  {
    this.aFP = paramK;
    this.value = paramV;
  }
  
  @Nullable
  public final K getKey()
  {
    return this.aFP;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.b.g
 * JD-Core Version:    0.7.0.1
 */