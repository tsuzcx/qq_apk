package com.google.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class an<K, V>
  implements bd
{
  volatile boolean bNd;
  volatile c bXT;
  b<K, V> bXU;
  List<at> bXV;
  final a<K, V> bXW;
  
  an(a<K, V> parama, c paramc, Map<K, V> paramMap)
  {
    this.bXW = parama;
    this.bNd = true;
    this.bXT = paramc;
    this.bXU = new b(this, paramMap);
    this.bXV = null;
  }
  
  private List<at> a(b<K, V> paramb)
  {
    ArrayList localArrayList = new ArrayList();
    paramb = paramb.entrySet().iterator();
    while (paramb.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramb.next();
      localEntry.getKey();
      localEntry.getValue();
      localArrayList.add(this.bXW.GZ());
    }
    return localArrayList;
  }
  
  final b<K, V> C(List<at> paramList)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramList.next();
    }
    return new b(this, localLinkedHashMap);
  }
  
  public final Map<K, V> GV()
  {
    if (this.bXT == c.bYd) {}
    try
    {
      if (this.bXT == c.bYd)
      {
        this.bXU = C(this.bXV);
        this.bXT = c.bYe;
      }
      return Collections.unmodifiableMap(this.bXU);
    }
    finally {}
  }
  
  final List<at> GW()
  {
    if (this.bXT == c.bYc) {}
    try
    {
      if (this.bXT == c.bYc)
      {
        this.bXV = a(this.bXU);
        this.bXT = c.bYe;
      }
      return Collections.unmodifiableList(this.bXV);
    }
    finally {}
  }
  
  final List<at> GX()
  {
    if (this.bXT != c.bYd)
    {
      if (this.bXT == c.bYc) {
        this.bXV = a(this.bXU);
      }
      this.bXU = null;
      this.bXT = c.bYd;
    }
    return this.bXV;
  }
  
  public final void GY()
  {
    if (!this.bNd) {
      throw new UnsupportedOperationException();
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof an)) {
      return false;
    }
    paramObject = (an)paramObject;
    return ao.b(GV(), paramObject.GV());
  }
  
  public final int hashCode()
  {
    return ao.c(GV());
  }
  
  static abstract interface a<K, V>
  {
    public abstract at GZ();
    
    public abstract at Ha();
  }
  
  static final class b<K, V>
    implements Map<K, V>
  {
    private final bd bXX;
    private final Map<K, V> bXY;
    
    b(bd parambd, Map<K, V> paramMap)
    {
      this.bXX = parambd;
      this.bXY = paramMap;
    }
    
    public final void clear()
    {
      this.bXX.GY();
      this.bXY.clear();
    }
    
    public final boolean containsKey(Object paramObject)
    {
      return this.bXY.containsKey(paramObject);
    }
    
    public final boolean containsValue(Object paramObject)
    {
      return this.bXY.containsValue(paramObject);
    }
    
    public final Set<Map.Entry<K, V>> entrySet()
    {
      return new c(this.bXX, this.bXY.entrySet());
    }
    
    public final boolean equals(Object paramObject)
    {
      return this.bXY.equals(paramObject);
    }
    
    public final V get(Object paramObject)
    {
      return this.bXY.get(paramObject);
    }
    
    public final int hashCode()
    {
      return this.bXY.hashCode();
    }
    
    public final boolean isEmpty()
    {
      return this.bXY.isEmpty();
    }
    
    public final Set<K> keySet()
    {
      return new c(this.bXX, this.bXY.keySet());
    }
    
    public final V put(K paramK, V paramV)
    {
      this.bXX.GY();
      ae.checkNotNull(paramK);
      ae.checkNotNull(paramV);
      return this.bXY.put(paramK, paramV);
    }
    
    public final void putAll(Map<? extends K, ? extends V> paramMap)
    {
      this.bXX.GY();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        ae.checkNotNull(localObject);
        ae.checkNotNull(paramMap.get(localObject));
      }
      this.bXY.putAll(paramMap);
    }
    
    public final V remove(Object paramObject)
    {
      this.bXX.GY();
      return this.bXY.remove(paramObject);
    }
    
    public final int size()
    {
      return this.bXY.size();
    }
    
    public final String toString()
    {
      return this.bXY.toString();
    }
    
    public final Collection<V> values()
    {
      return new a(this.bXX, this.bXY.values());
    }
    
    static final class a<E>
      implements Collection<E>
    {
      private final bd bXX;
      private final Collection<E> bXZ;
      
      a(bd parambd, Collection<E> paramCollection)
      {
        this.bXX = parambd;
        this.bXZ = paramCollection;
      }
      
      public final boolean add(E paramE)
      {
        throw new UnsupportedOperationException();
      }
      
      public final boolean addAll(Collection<? extends E> paramCollection)
      {
        throw new UnsupportedOperationException();
      }
      
      public final void clear()
      {
        this.bXX.GY();
        this.bXZ.clear();
      }
      
      public final boolean contains(Object paramObject)
      {
        return this.bXZ.contains(paramObject);
      }
      
      public final boolean containsAll(Collection<?> paramCollection)
      {
        return this.bXZ.containsAll(paramCollection);
      }
      
      public final boolean equals(Object paramObject)
      {
        return this.bXZ.equals(paramObject);
      }
      
      public final int hashCode()
      {
        return this.bXZ.hashCode();
      }
      
      public final boolean isEmpty()
      {
        return this.bXZ.isEmpty();
      }
      
      public final Iterator<E> iterator()
      {
        return new an.b.b(this.bXX, this.bXZ.iterator());
      }
      
      public final boolean remove(Object paramObject)
      {
        this.bXX.GY();
        return this.bXZ.remove(paramObject);
      }
      
      public final boolean removeAll(Collection<?> paramCollection)
      {
        this.bXX.GY();
        return this.bXZ.removeAll(paramCollection);
      }
      
      public final boolean retainAll(Collection<?> paramCollection)
      {
        this.bXX.GY();
        return this.bXZ.retainAll(paramCollection);
      }
      
      public final int size()
      {
        return this.bXZ.size();
      }
      
      public final Object[] toArray()
      {
        return this.bXZ.toArray();
      }
      
      public final <T> T[] toArray(T[] paramArrayOfT)
      {
        return this.bXZ.toArray(paramArrayOfT);
      }
      
      public final String toString()
      {
        return this.bXZ.toString();
      }
    }
    
    static final class b<E>
      implements Iterator<E>
    {
      private final bd bXX;
      private final Iterator<E> bYa;
      
      b(bd parambd, Iterator<E> paramIterator)
      {
        this.bXX = parambd;
        this.bYa = paramIterator;
      }
      
      public final boolean equals(Object paramObject)
      {
        return this.bYa.equals(paramObject);
      }
      
      public final boolean hasNext()
      {
        return this.bYa.hasNext();
      }
      
      public final int hashCode()
      {
        return this.bYa.hashCode();
      }
      
      public final E next()
      {
        return this.bYa.next();
      }
      
      public final void remove()
      {
        this.bXX.GY();
        this.bYa.remove();
      }
      
      public final String toString()
      {
        return this.bYa.toString();
      }
    }
    
    static final class c<E>
      implements Set<E>
    {
      private final bd bXX;
      private final Set<E> bYb;
      
      c(bd parambd, Set<E> paramSet)
      {
        this.bXX = parambd;
        this.bYb = paramSet;
      }
      
      public final boolean add(E paramE)
      {
        this.bXX.GY();
        return this.bYb.add(paramE);
      }
      
      public final boolean addAll(Collection<? extends E> paramCollection)
      {
        this.bXX.GY();
        return this.bYb.addAll(paramCollection);
      }
      
      public final void clear()
      {
        this.bXX.GY();
        this.bYb.clear();
      }
      
      public final boolean contains(Object paramObject)
      {
        return this.bYb.contains(paramObject);
      }
      
      public final boolean containsAll(Collection<?> paramCollection)
      {
        return this.bYb.containsAll(paramCollection);
      }
      
      public final boolean equals(Object paramObject)
      {
        return this.bYb.equals(paramObject);
      }
      
      public final int hashCode()
      {
        return this.bYb.hashCode();
      }
      
      public final boolean isEmpty()
      {
        return this.bYb.isEmpty();
      }
      
      public final Iterator<E> iterator()
      {
        return new an.b.b(this.bXX, this.bYb.iterator());
      }
      
      public final boolean remove(Object paramObject)
      {
        this.bXX.GY();
        return this.bYb.remove(paramObject);
      }
      
      public final boolean removeAll(Collection<?> paramCollection)
      {
        this.bXX.GY();
        return this.bYb.removeAll(paramCollection);
      }
      
      public final boolean retainAll(Collection<?> paramCollection)
      {
        this.bXX.GY();
        return this.bYb.retainAll(paramCollection);
      }
      
      public final int size()
      {
        return this.bYb.size();
      }
      
      public final Object[] toArray()
      {
        return this.bYb.toArray();
      }
      
      public final <T> T[] toArray(T[] paramArrayOfT)
      {
        return this.bYb.toArray(paramArrayOfT);
      }
      
      public final String toString()
      {
        return this.bYb.toString();
      }
    }
  }
  
  static enum c
  {
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.an
 * JD-Core Version:    0.7.0.1
 */