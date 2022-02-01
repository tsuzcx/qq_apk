package com.google.b;

import java.util.Iterator;
import java.util.Map.Entry;

public final class bh
  extends bi
{
  public final boolean equals(Object paramObject)
  {
    throw null;
  }
  
  public final int hashCode()
  {
    throw null;
  }
  
  public final String toString()
  {
    throw null;
  }
  
  static final class a<K>
    implements Map.Entry<K, Object>
  {
    private Map.Entry<K, bh> bZw;
    
    private a(Map.Entry<K, bh> paramEntry)
    {
      this.bZw = paramEntry;
    }
    
    public final bh Iv()
    {
      return (bh)this.bZw.getValue();
    }
    
    public final K getKey()
    {
      return this.bZw.getKey();
    }
    
    public final Object getValue()
    {
      if ((bh)this.bZw.getValue() == null) {
        return null;
      }
      throw null;
    }
    
    public final Object setValue(Object paramObject)
    {
      if (!(paramObject instanceof bw)) {
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
      }
      return ((bh)this.bZw.getValue()).g((bw)paramObject);
    }
  }
  
  static final class b<K>
    implements Iterator<Map.Entry<K, Object>>
  {
    private Iterator<Map.Entry<K, Object>> bZx;
    
    public b(Iterator<Map.Entry<K, Object>> paramIterator)
    {
      this.bZx = paramIterator;
    }
    
    public final boolean hasNext()
    {
      return this.bZx.hasNext();
    }
    
    public final void remove()
    {
      this.bZx.remove();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.b.bh
 * JD-Core Version:    0.7.0.1
 */