package com.google.d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class bv<K, V>
  implements cl
{
  public volatile boolean dIE;
  public volatile d dTE;
  public c<K, V> dTF;
  private List<cb> dTG;
  final a<K, V> dTH;
  
  private bv(bt<K, V> parambt, d paramd, Map<K, V> paramMap)
  {
    this(new b(parambt), paramd, paramMap);
  }
  
  private bv(a<K, V> parama, d paramd, Map<K, V> paramMap)
  {
    this.dTH = parama;
    this.dIE = true;
    this.dTE = paramd;
    this.dTF = new c(this, paramMap);
    this.dTG = null;
  }
  
  private List<cb> a(c<K, V> paramc)
  {
    ArrayList localArrayList = new ArrayList();
    paramc = paramc.entrySet().iterator();
    while (paramc.hasNext())
    {
      Object localObject2 = (Map.Entry)paramc.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      localArrayList.add(this.dTH.r(localObject1, localObject2));
    }
    return localArrayList;
  }
  
  private c<K, V> aI(List<cb> paramList)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      cb localcb = (cb)paramList.next();
      this.dTH.a(localcb, localLinkedHashMap);
    }
    return new c(this, localLinkedHashMap);
  }
  
  public static <K, V> bv<K, V> c(bt<K, V> parambt)
  {
    return new bv(parambt, d.dTO, Collections.emptyMap());
  }
  
  public static <K, V> bv<K, V> d(bt<K, V> parambt)
  {
    return new bv(parambt, d.dTO, new LinkedHashMap());
  }
  
  public final void a(bv<K, V> parambv)
  {
    aiH().putAll(bw.g(parambv.aiG()));
  }
  
  public final Map<K, V> aiG()
  {
    if (this.dTE == d.dTP) {}
    try
    {
      if (this.dTE == d.dTP)
      {
        this.dTF = aI(this.dTG);
        this.dTE = d.dTQ;
      }
      return Collections.unmodifiableMap(this.dTF);
    }
    finally {}
  }
  
  public final Map<K, V> aiH()
  {
    if (this.dTE != d.dTO)
    {
      if (this.dTE == d.dTP) {
        this.dTF = aI(this.dTG);
      }
      this.dTG = null;
      this.dTE = d.dTO;
    }
    return this.dTF;
  }
  
  public final bv<K, V> aiI()
  {
    return new bv(this.dTH, d.dTO, bw.g(aiG()));
  }
  
  final List<cb> aiJ()
  {
    if (this.dTE == d.dTO) {}
    try
    {
      if (this.dTE == d.dTO)
      {
        this.dTG = a(this.dTF);
        this.dTE = d.dTQ;
      }
      return Collections.unmodifiableList(this.dTG);
    }
    finally {}
  }
  
  final List<cb> aiK()
  {
    if (this.dTE != d.dTP)
    {
      if (this.dTE == d.dTO) {
        this.dTG = a(this.dTF);
      }
      this.dTF = null;
      this.dTE = d.dTP;
    }
    return this.dTG;
  }
  
  public final void aiL()
  {
    if (!this.dIE) {
      throw new UnsupportedOperationException();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof bv)) {
      return false;
    }
    paramObject = (bv)paramObject;
    return bw.b(aiG(), paramObject.aiG());
  }
  
  public int hashCode()
  {
    return bw.f(aiG());
  }
  
  static abstract interface a<K, V>
  {
    public abstract void a(cb paramcb, Map<K, V> paramMap);
    
    public abstract cb aiM();
    
    public abstract cb r(K paramK, V paramV);
  }
  
  static final class b<K, V>
    implements bv.a<K, V>
  {
    private final bt<K, V> dTI;
    
    public b(bt<K, V> parambt)
    {
      this.dTI = parambt;
    }
    
    public final void a(cb paramcb, Map<K, V> paramMap)
    {
      paramcb = (bt)paramcb;
      paramMap.put(paramcb.key, paramcb.value);
    }
    
    public final cb aiM()
    {
      return this.dTI;
    }
    
    public final cb r(K paramK, V paramV)
    {
      return this.dTI.aiA().by(paramK).bz(paramV).aiE();
    }
  }
  
  public static final class c<K, V>
    implements Map<K, V>
  {
    private final cl dTJ;
    private final Map<K, V> dTK;
    
    public c(cl paramcl, Map<K, V> paramMap)
    {
      this.dTJ = paramcl;
      this.dTK = paramMap;
    }
    
    public final void clear()
    {
      this.dTJ.aiL();
      this.dTK.clear();
    }
    
    public final boolean containsKey(Object paramObject)
    {
      return this.dTK.containsKey(paramObject);
    }
    
    public final boolean containsValue(Object paramObject)
    {
      return this.dTK.containsValue(paramObject);
    }
    
    public final Set<Map.Entry<K, V>> entrySet()
    {
      return new c(this.dTJ, this.dTK.entrySet());
    }
    
    public final boolean equals(Object paramObject)
    {
      return this.dTK.equals(paramObject);
    }
    
    public final V get(Object paramObject)
    {
      return this.dTK.get(paramObject);
    }
    
    public final int hashCode()
    {
      return this.dTK.hashCode();
    }
    
    public final boolean isEmpty()
    {
      return this.dTK.isEmpty();
    }
    
    public final Set<K> keySet()
    {
      return new c(this.dTJ, this.dTK.keySet());
    }
    
    public final V put(K paramK, V paramV)
    {
      this.dTJ.aiL();
      bj.checkNotNull(paramK);
      bj.checkNotNull(paramV);
      return this.dTK.put(paramK, paramV);
    }
    
    public final void putAll(Map<? extends K, ? extends V> paramMap)
    {
      this.dTJ.aiL();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        bj.checkNotNull(localObject);
        bj.checkNotNull(paramMap.get(localObject));
      }
      this.dTK.putAll(paramMap);
    }
    
    public final V remove(Object paramObject)
    {
      this.dTJ.aiL();
      return this.dTK.remove(paramObject);
    }
    
    public final int size()
    {
      return this.dTK.size();
    }
    
    public final String toString()
    {
      return this.dTK.toString();
    }
    
    public final Collection<V> values()
    {
      return new a(this.dTJ, this.dTK.values());
    }
    
    static final class a<E>
      implements Collection<E>
    {
      private final cl dTJ;
      private final Collection<E> dTL;
      
      a(cl paramcl, Collection<E> paramCollection)
      {
        this.dTJ = paramcl;
        this.dTL = paramCollection;
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
        this.dTJ.aiL();
        this.dTL.clear();
      }
      
      public final boolean contains(Object paramObject)
      {
        return this.dTL.contains(paramObject);
      }
      
      public final boolean containsAll(Collection<?> paramCollection)
      {
        return this.dTL.containsAll(paramCollection);
      }
      
      public final boolean equals(Object paramObject)
      {
        return this.dTL.equals(paramObject);
      }
      
      public final int hashCode()
      {
        return this.dTL.hashCode();
      }
      
      public final boolean isEmpty()
      {
        return this.dTL.isEmpty();
      }
      
      public final Iterator<E> iterator()
      {
        return new bv.c.b(this.dTJ, this.dTL.iterator());
      }
      
      public final boolean remove(Object paramObject)
      {
        this.dTJ.aiL();
        return this.dTL.remove(paramObject);
      }
      
      public final boolean removeAll(Collection<?> paramCollection)
      {
        this.dTJ.aiL();
        return this.dTL.removeAll(paramCollection);
      }
      
      public final boolean retainAll(Collection<?> paramCollection)
      {
        this.dTJ.aiL();
        return this.dTL.retainAll(paramCollection);
      }
      
      public final int size()
      {
        return this.dTL.size();
      }
      
      public final Object[] toArray()
      {
        return this.dTL.toArray();
      }
      
      public final <T> T[] toArray(T[] paramArrayOfT)
      {
        return this.dTL.toArray(paramArrayOfT);
      }
      
      public final String toString()
      {
        return this.dTL.toString();
      }
    }
    
    static final class b<E>
      implements Iterator<E>
    {
      private final cl dTJ;
      private final Iterator<E> dTM;
      
      b(cl paramcl, Iterator<E> paramIterator)
      {
        this.dTJ = paramcl;
        this.dTM = paramIterator;
      }
      
      public final boolean equals(Object paramObject)
      {
        return this.dTM.equals(paramObject);
      }
      
      public final boolean hasNext()
      {
        return this.dTM.hasNext();
      }
      
      public final int hashCode()
      {
        return this.dTM.hashCode();
      }
      
      public final E next()
      {
        return this.dTM.next();
      }
      
      public final void remove()
      {
        this.dTJ.aiL();
        this.dTM.remove();
      }
      
      public final String toString()
      {
        return this.dTM.toString();
      }
    }
    
    static final class c<E>
      implements Set<E>
    {
      private final cl dTJ;
      private final Set<E> dTN;
      
      c(cl paramcl, Set<E> paramSet)
      {
        this.dTJ = paramcl;
        this.dTN = paramSet;
      }
      
      public final boolean add(E paramE)
      {
        this.dTJ.aiL();
        return this.dTN.add(paramE);
      }
      
      public final boolean addAll(Collection<? extends E> paramCollection)
      {
        this.dTJ.aiL();
        return this.dTN.addAll(paramCollection);
      }
      
      public final void clear()
      {
        this.dTJ.aiL();
        this.dTN.clear();
      }
      
      public final boolean contains(Object paramObject)
      {
        return this.dTN.contains(paramObject);
      }
      
      public final boolean containsAll(Collection<?> paramCollection)
      {
        return this.dTN.containsAll(paramCollection);
      }
      
      public final boolean equals(Object paramObject)
      {
        return this.dTN.equals(paramObject);
      }
      
      public final int hashCode()
      {
        return this.dTN.hashCode();
      }
      
      public final boolean isEmpty()
      {
        return this.dTN.isEmpty();
      }
      
      public final Iterator<E> iterator()
      {
        return new bv.c.b(this.dTJ, this.dTN.iterator());
      }
      
      public final boolean remove(Object paramObject)
      {
        this.dTJ.aiL();
        return this.dTN.remove(paramObject);
      }
      
      public final boolean removeAll(Collection<?> paramCollection)
      {
        this.dTJ.aiL();
        return this.dTN.removeAll(paramCollection);
      }
      
      public final boolean retainAll(Collection<?> paramCollection)
      {
        this.dTJ.aiL();
        return this.dTN.retainAll(paramCollection);
      }
      
      public final int size()
      {
        return this.dTN.size();
      }
      
      public final Object[] toArray()
      {
        return this.dTN.toArray();
      }
      
      public final <T> T[] toArray(T[] paramArrayOfT)
      {
        return this.dTN.toArray(paramArrayOfT);
      }
      
      public final String toString()
      {
        return this.dTN.toString();
      }
    }
  }
  
  public static enum d
  {
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.bv
 * JD-Core Version:    0.7.0.1
 */