package com.c.a.c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d<K, V>
  extends n<K>
  implements Map<K, V>
{
  protected transient V[] cql;
  
  private d<K, V> Kt()
  {
    d locald = (d)super.Ku();
    locald.cql = ((Object[])this.cql.clone());
    return locald;
  }
  
  private boolean a(r<K, V> paramr)
  {
    Object[] arrayOfObject1 = this.cqC;
    Object[] arrayOfObject2 = this.cql;
    int j;
    for (int i = arrayOfObject1.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((arrayOfObject1[j] != null) && (arrayOfObject1[j] != cqE) && (!paramr.v(arrayOfObject1[j], arrayOfObject2[j]))) {
          return false;
        }
      }
      else {
        return true;
      }
    }
  }
  
  public final void clear()
  {
    if (size() != 0)
    {
      super.clear();
      Object[] arrayOfObject1 = this.cqC;
      Object[] arrayOfObject2 = this.cql;
      int j;
      for (int i = arrayOfObject1.length;; i = j)
      {
        j = i - 1;
        if (i <= 0) {
          break;
        }
        arrayOfObject1[j] = null;
        arrayOfObject2[j] = null;
      }
    }
  }
  
  public final boolean containsKey(Object paramObject)
  {
    return contains(paramObject);
  }
  
  public final boolean containsValue(Object paramObject)
  {
    Object[] arrayOfObject1 = this.cqC;
    Object[] arrayOfObject2 = this.cql;
    if (paramObject == null) {}
    int j;
    for (int i = arrayOfObject2.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((arrayOfObject1[j] != null) && (arrayOfObject1[j] != cqE) && (paramObject == arrayOfObject2[j]))
        {
          return true;
          for (i = arrayOfObject2.length;; i = j)
          {
            j = i - 1;
            if (i <= 0) {
              break label108;
            }
            if ((arrayOfObject1[j] != null) && (arrayOfObject1[j] != cqE) && ((paramObject == arrayOfObject2[j]) || (paramObject.equals(arrayOfObject2[j])))) {
              break;
            }
          }
        }
      }
      else {
        label108:
        return false;
      }
    }
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    return new b();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Map)) {}
    do
    {
      return false;
      paramObject = (Map)paramObject;
    } while (paramObject.size() != size());
    return a(new d.c(paramObject));
  }
  
  public final V get(Object paramObject)
  {
    int i = aH(paramObject);
    if (i < 0) {
      return null;
    }
    return this.cql[i];
  }
  
  public final int hashCode()
  {
    d locald = new d();
    a(locald);
    return locald.h;
  }
  
  protected final int hw(int paramInt)
  {
    paramInt = super.hw(paramInt);
    this.cql = ((Object[])new Object[paramInt]);
    return paramInt;
  }
  
  protected final void hx(int paramInt)
  {
    int i = this.cqC.length;
    Object[] arrayOfObject1 = this.cqC;
    Object[] arrayOfObject2 = this.cql;
    this.cqC = new Object[paramInt];
    this.cql = ((Object[])new Object[paramInt]);
    paramInt = i;
    for (;;)
    {
      i = paramInt - 1;
      if (paramInt > 0)
      {
        if ((arrayOfObject1[i] != null) && (arrayOfObject1[i] != cqE))
        {
          Object localObject = arrayOfObject1[i];
          paramInt = aI(localObject);
          if (paramInt < 0) {
            w(this.cqC[(-paramInt - 1)], localObject);
          }
          this.cqC[paramInt] = localObject;
          this.cql[paramInt] = arrayOfObject2[i];
          paramInt = i;
        }
      }
      else {
        return;
      }
      paramInt = i;
    }
  }
  
  public final Set<K> keySet()
  {
    return new e();
  }
  
  public final V put(K paramK, V paramV)
  {
    if (paramK == null) {
      throw new NullPointerException("null keys not supported");
    }
    Object localObject1 = null;
    int k = aI(paramK);
    int i;
    if (k < 0)
    {
      i = 1;
      int j = k;
      if (i != 0)
      {
        j = -k - 1;
        localObject1 = this.cql[j];
      }
      Object localObject2 = this.cqC[j];
      this.cqC[j] = paramK;
      this.cql[j] = paramV;
      if (i == 0) {
        if (localObject2 != null) {
          break label106;
        }
      }
    }
    label106:
    for (boolean bool = true;; bool = false)
    {
      bO(bool);
      return localObject1;
      i = 0;
      break;
    }
  }
  
  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    ensureCapacity(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public final V remove(Object paramObject)
  {
    Object localObject = null;
    int i = aH(paramObject);
    paramObject = localObject;
    if (i >= 0)
    {
      paramObject = this.cql[i];
      removeAt(i);
    }
    return paramObject;
  }
  
  protected final void removeAt(int paramInt)
  {
    this.cql[paramInt] = null;
    super.removeAt(paramInt);
  }
  
  public final Collection<V> values()
  {
    return new g();
  }
  
  final class a
    implements Map.Entry<K, V>
  {
    private final int index;
    private final K key;
    private V val;
    
    a(V paramV, int paramInt)
    {
      this.key = paramV;
      this.val = paramInt;
      int i;
      this.index = i;
    }
    
    public final K getKey()
    {
      return this.key;
    }
    
    public final V getValue()
    {
      return this.val;
    }
    
    public final V setValue(V paramV)
    {
      if (d.this.cql[this.index] != this.val) {
        throw new ConcurrentModificationException();
      }
      d.this.cql[this.index] = paramV;
      Object localObject = this.val;
      this.val = paramV;
      return localObject;
    }
  }
  
  public final class b
    extends d<K, V>.MapBackedView<Map.Entry<K, V>>
  {
    b()
    {
      super();
    }
    
    public final Iterator<Map.Entry<K, V>> iterator()
    {
      return new a(d.this);
    }
    
    final class a
      extends c<Map.Entry<K, V>>
    {
      a()
      {
        super();
      }
    }
  }
  
  final class d
    implements r<K, V>
  {
    int h;
    
    d() {}
    
    public final boolean v(K paramK, V paramV)
    {
      int j = this.h;
      int k = d.this.cqD.aG(paramK);
      if (paramV == null) {}
      for (int i = 0;; i = paramV.hashCode())
      {
        this.h = ((i ^ k) + j);
        return true;
      }
    }
  }
  
  public final class e
    extends d<K, V>.MapBackedView<K>
  {
    e()
    {
      super();
    }
    
    public final boolean aE(K paramK)
    {
      return d.this.contains(paramK);
    }
    
    public final Iterator<K> iterator()
    {
      return new o(d.this);
    }
    
    public final boolean removeElement(K paramK)
    {
      return d.this.remove(paramK) != null;
    }
  }
  
  abstract class f<E>
    implements Set<E>
  {
    f() {}
    
    public abstract boolean aE(E paramE);
    
    public boolean add(E paramE)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends E> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public void clear()
    {
      d.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return aE(paramObject);
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next())) {
          return false;
        }
      }
      return true;
    }
    
    public boolean isEmpty()
    {
      return d.this.isEmpty();
    }
    
    public abstract Iterator<E> iterator();
    
    public boolean remove(Object paramObject)
    {
      return removeElement(paramObject);
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      boolean bool = false;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (remove(paramCollection.next())) {
          bool = true;
        }
      }
      return bool;
    }
    
    public abstract boolean removeElement(E paramE);
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      boolean bool = false;
      Iterator localIterator = iterator();
      while (localIterator.hasNext()) {
        if (!paramCollection.contains(localIterator.next()))
        {
          localIterator.remove();
          bool = true;
        }
      }
      return bool;
    }
    
    public int size()
    {
      return d.this.size();
    }
    
    public Object[] toArray()
    {
      Object[] arrayOfObject = new Object[size()];
      Iterator localIterator = iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        arrayOfObject[i] = localIterator.next();
        i += 1;
      }
      return arrayOfObject;
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      int j = size();
      if (paramArrayOfT.length < j) {
        paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j);
      }
      for (;;)
      {
        Iterator localIterator = iterator();
        int i = 0;
        while (i < j)
        {
          paramArrayOfT[i] = localIterator.next();
          i += 1;
        }
        if (paramArrayOfT.length > j) {
          paramArrayOfT[j] = null;
        }
        return paramArrayOfT;
      }
    }
  }
  
  public final class g
    extends d<K, V>.MapBackedView<V>
  {
    protected g()
    {
      super();
    }
    
    public final boolean aE(V paramV)
    {
      return d.this.containsValue(paramV);
    }
    
    public final Iterator<V> iterator()
    {
      new c(d.this)
      {
        protected final V hz(int paramAnonymousInt)
        {
          return d.this.cql[paramAnonymousInt];
        }
      };
    }
    
    public final boolean removeElement(V paramV)
    {
      Object[] arrayOfObject1 = d.this.cql;
      Object[] arrayOfObject2 = d.this.cqC;
      int i = arrayOfObject1.length;
      boolean bool = false;
      for (;;)
      {
        int j = i - 1;
        if (i > 0)
        {
          if (((arrayOfObject2[j] != null) && (arrayOfObject2[j] != n.cqE) && (paramV == arrayOfObject1[j])) || ((arrayOfObject1[j] != null) && (arrayOfObject1[j].equals(paramV))))
          {
            d.this.removeAt(j);
            bool = true;
            i = j;
          }
        }
        else {
          return bool;
        }
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.c.a.c.d
 * JD-Core Version:    0.7.0.1
 */