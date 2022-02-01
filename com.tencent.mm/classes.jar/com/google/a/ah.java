package com.google.a;

import java.util.Iterator;
import java.util.Map.Entry;

public final class ah
  extends ai
{
  private final aw bXE;
  
  public ah(aw paramaw, r paramr, g paramg)
  {
    super(paramr, paramg);
    this.bXE = paramaw;
  }
  
  public final aw GO()
  {
    return g(this.bXE);
  }
  
  public final boolean equals(Object paramObject)
  {
    return GO().equals(paramObject);
  }
  
  public final int hashCode()
  {
    return GO().hashCode();
  }
  
  public final String toString()
  {
    return GO().toString();
  }
  
  static final class a<K>
    implements Map.Entry<K, Object>
  {
    private Map.Entry<K, ah> bXF;
    
    private a(Map.Entry<K, ah> paramEntry)
    {
      this.bXF = paramEntry;
    }
    
    public final ah GP()
    {
      return (ah)this.bXF.getValue();
    }
    
    public final K getKey()
    {
      return this.bXF.getKey();
    }
    
    public final Object getValue()
    {
      ah localah = (ah)this.bXF.getValue();
      if (localah == null) {
        return null;
      }
      return localah.GO();
    }
    
    public final Object setValue(Object paramObject)
    {
      if (!(paramObject instanceof aw)) {
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
      }
      return ((ah)this.bXF.getValue()).h((aw)paramObject);
    }
  }
  
  static final class b<K>
    implements Iterator<Map.Entry<K, Object>>
  {
    private Iterator<Map.Entry<K, Object>> bXG;
    
    public b(Iterator<Map.Entry<K, Object>> paramIterator)
    {
      this.bXG = paramIterator;
    }
    
    public final boolean hasNext()
    {
      return this.bXG.hasNext();
    }
    
    public final void remove()
    {
      this.bXG.remove();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.ah
 * JD-Core Version:    0.7.0.1
 */