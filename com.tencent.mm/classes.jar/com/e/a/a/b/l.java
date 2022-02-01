package com.e.a.a.b;

import java.util.AbstractCollection;
import java.util.Map.Entry;
import javax.annotation.Nullable;

abstract class l<K, V>
  extends AbstractCollection<Map.Entry<K, V>>
{
  abstract k<K, V> Bb();
  
  public void clear()
  {
    Bb().clear();
  }
  
  public boolean contains(@Nullable Object paramObject)
  {
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      return Bb().l(paramObject.getKey(), paramObject.getValue());
    }
    return false;
  }
  
  public boolean remove(@Nullable Object paramObject)
  {
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      return Bb().remove(paramObject.getKey(), paramObject.getValue());
    }
    return false;
  }
  
  public int size()
  {
    return Bb().size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.e.a.a.b.l
 * JD-Core Version:    0.7.0.1
 */