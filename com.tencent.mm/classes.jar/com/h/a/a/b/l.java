package com.h.a.a.b;

import java.util.AbstractCollection;
import java.util.Map.Entry;

abstract class l<K, V>
  extends AbstractCollection<Map.Entry<K, V>>
{
  abstract k<K, V> akP();
  
  public void clear()
  {
    akP().clear();
  }
  
  public boolean contains(Object paramObject)
  {
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      return akP().x(paramObject.getKey(), paramObject.getValue());
    }
    return false;
  }
  
  public boolean remove(Object paramObject)
  {
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      return akP().remove(paramObject.getKey(), paramObject.getValue());
    }
    return false;
  }
  
  public int size()
  {
    return akP().size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.h.a.a.b.l
 * JD-Core Version:    0.7.0.1
 */