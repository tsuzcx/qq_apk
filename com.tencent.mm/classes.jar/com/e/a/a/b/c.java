package com.e.a.a.b;

import com.e.a.a.a.a;
import java.util.Map.Entry;
import javax.annotation.Nullable;

abstract class c<K, V>
  implements Map.Entry<K, V>
{
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      bool1 = bool2;
      if (a.equal(getKey(), paramObject.getKey()))
      {
        bool1 = bool2;
        if (a.equal(getValue(), paramObject.getValue())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.e.a.a.b.c
 * JD-Core Version:    0.7.0.1
 */