package com.d.a.c;

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
  protected transient V[] bXN;
  
  private d<K, V> Aq()
  {
    d locald = (d)super.Ar();
    locald.bXN = ((Object[])this.bXN.clone());
    return locald;
  }
  
  private boolean a(r<K, V> paramr)
  {
    Object[] arrayOfObject1 = this.bYf;
    Object[] arrayOfObject2 = this.bXN;
    int j;
    for (int i = arrayOfObject1.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((arrayOfObject1[j] != null) && (arrayOfObject1[j] != bYh) && (!paramr.l(arrayOfObject1[j], arrayOfObject2[j]))) {
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
      Object[] arrayOfObject1 = this.bYf;
      Object[] arrayOfObject2 = this.bXN;
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
    Object[] arrayOfObject1 = this.bYf;
    Object[] arrayOfObject2 = this.bXN;
    if (paramObject == null) {}
    int j;
    for (int i = arrayOfObject2.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((arrayOfObject1[j] != null) && (arrayOfObject1[j] != bYh) && (paramObject == arrayOfObject2[j]))
        {
          return true;
          for (i = arrayOfObject2.length;; i = j)
          {
            j = i - 1;
            if (i <= 0) {
              break label108;
            }
            if ((arrayOfObject1[j] != null) && (arrayOfObject1[j] != bYh) && ((paramObject == arrayOfObject2[j]) || (paramObject.equals(arrayOfObject2[j])))) {
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
    int i = aw(paramObject);
    if (i < 0) {
      return null;
    }
    return this.bXN[i];
  }
  
  protected final int gx(int paramInt)
  {
    paramInt = super.gx(paramInt);
    this.bXN = ((Object[])new Object[paramInt]);
    return paramInt;
  }
  
  protected final void gy(int paramInt)
  {
    int i = this.bYf.length;
    Object[] arrayOfObject1 = this.bYf;
    Object[] arrayOfObject2 = this.bXN;
    this.bYf = new Object[paramInt];
    this.bXN = ((Object[])new Object[paramInt]);
    paramInt = i;
    for (;;)
    {
      i = paramInt - 1;
      if (paramInt > 0)
      {
        if ((arrayOfObject1[i] != null) && (arrayOfObject1[i] != bYh))
        {
          Object localObject = arrayOfObject1[i];
          paramInt = ax(localObject);
          if (paramInt < 0) {
            m(this.bYf[(-paramInt - 1)], localObject);
          }
          this.bYf[paramInt] = localObject;
          this.bXN[paramInt] = arrayOfObject2[i];
          paramInt = i;
        }
      }
      else {
        return;
      }
      paramInt = i;
    }
  }
  
  public final int hashCode()
  {
    d locald = new d();
    a(locald);
    return locald.h;
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
    int k = ax(paramK);
    int i;
    if (k < 0)
    {
      i = 1;
      int j = k;
      if (i != 0)
      {
        j = -k - 1;
        localObject1 = this.bXN[j];
      }
      Object localObject2 = this.bYf[j];
      this.bYf[j] = paramK;
      this.bXN[j] = paramV;
      if (i == 0) {
        if (localObject2 != null) {
          break label106;
        }
      }
    }
    label106:
    for (boolean bool = true;; bool = false)
    {
      bo(bool);
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
    int i = aw(paramObject);
    paramObject = localObject;
    if (i >= 0)
    {
      paramObject = this.bXN[i];
      removeAt(i);
    }
    return paramObject;
  }
  
  protected final void removeAt(int paramInt)
  {
    this.bXN[paramInt] = null;
    super.removeAt(paramInt);
  }
  
  public final Collection<V> values()
  {
    return new g();
  }
  
  final class a
    implements Map.Entry<K, V>
  {
    private final K aFP;
    private V bXO;
    private final int index;
    
    a(V paramV, int paramInt)
    {
      this.aFP = paramV;
      this.bXO = paramInt;
      int i;
      this.index = i;
    }
    
    public final K getKey()
    {
      return this.aFP;
    }
    
    public final V getValue()
    {
      return this.bXO;
    }
    
    public final V setValue(V paramV)
    {
      if (d.this.bXN[this.index] != this.bXO) {
        throw new ConcurrentModificationException();
      }
      d.this.bXN[this.index] = paramV;
      Object localObject = this.bXO;
      this.bXO = paramV;
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
    
    public final boolean l(K paramK, V paramV)
    {
      int j = this.h;
      int k = d.this.bYg.av(paramK);
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
    
    public final boolean at(K paramK)
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
    
    public boolean add(E paramE)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends E> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public abstract boolean at(E paramE);
    
    public void clear()
    {
      d.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return at(paramObject);
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
    
    public final boolean at(V paramV)
    {
      return d.this.containsValue(paramV);
    }
    
    public final Iterator<V> iterator()
    {
      new c(d.this)
      {
        protected final V gA(int paramAnonymousInt)
        {
          return d.this.bXN[paramAnonymousInt];
        }
      };
    }
    
    public final boolean removeElement(V paramV)
    {
      Object[] arrayOfObject1 = d.this.bXN;
      Object[] arrayOfObject2 = d.this.bYf;
      int i = arrayOfObject1.length;
      boolean bool = false;
      for (;;)
      {
        int j = i - 1;
        if (i > 0)
        {
          if (((arrayOfObject2[j] != null) && (arrayOfObject2[j] != n.bYh) && (paramV == arrayOfObject1[j])) || ((arrayOfObject1[j] != null) && (arrayOfObject1[j].equals(paramV))))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.c.d
 * JD-Core Version:    0.7.0.1
 */