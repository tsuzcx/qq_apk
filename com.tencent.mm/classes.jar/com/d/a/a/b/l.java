package com.d.a.a.b;

import java.util.AbstractCollection;
import java.util.Map.Entry;
import javax.annotation.Nullable;

abstract class l<K, V>
  extends AbstractCollection<Map.Entry<K, V>>
{
  public void clear()
  {
    zD().clear();
  }
  
  public boolean contains(@Nullable Object paramObject)
  {
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      return zD().j(paramObject.getKey(), paramObject.getValue());
    }
    return false;
  }
  
  public boolean remove(@Nullable Object paramObject)
  {
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      return zD().remove(paramObject.getKey(), paramObject.getValue());
    }
    return false;
  }
  
  public int size()
  {
    return zD().size();
  }
  
  abstract k<K, V> zD();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.b.l
 * JD-Core Version:    0.7.0.1
 */