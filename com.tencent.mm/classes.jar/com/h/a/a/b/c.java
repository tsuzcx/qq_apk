package com.h.a.a.b;

import com.h.a.a.a.b;
import java.util.Map.Entry;

abstract class c<K, V>
  implements Map.Entry<K, V>
{
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      bool1 = bool2;
      if (b.equal(getKey(), paramObject.getKey()))
      {
        bool1 = bool2;
        if (b.equal(getValue(), paramObject.getValue())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public abstract K getKey();
  
  public abstract V getValue();
  
  public int hashCode()
  {
    int j = 0;
    Object localObject1 = getKey();
    Object localObject2 = getValue();
    int i;
    if (localObject1 == null)
    {
      i = 0;
      if (localObject2 != null) {
        break label36;
      }
    }
    for (;;)
    {
      return j ^ i;
      i = localObject1.hashCode();
      break;
      label36:
      j = localObject2.hashCode();
    }
  }
  
  public V setValue(V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    return getKey() + "=" + getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.h.a.a.b.c
 * JD-Core Version:    0.7.0.1
 */