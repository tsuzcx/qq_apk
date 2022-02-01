package com.h.a.c;

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
  protected transient V[] ecg;
  
  private boolean a(r<K, V> paramr)
  {
    Object[] arrayOfObject1 = this.ecx;
    Object[] arrayOfObject2 = this.ecg;
    int j;
    for (int i = arrayOfObject1.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((arrayOfObject1[j] != null) && (arrayOfObject1[j] != ecz) && (!paramr.z(arrayOfObject1[j], arrayOfObject2[j]))) {
          return false;
        }
      }
      else {
        return true;
      }
    }
  }
  
  private d<K, V> alp()
  {
    d locald = (d)super.alq();
    locald.ecg = ((Object[])this.ecg.clone());
    return locald;
  }
  
  protected final void bj(int paramInt)
  {
    this.ecg[paramInt] = null;
    super.bj(paramInt);
  }
  
  public final void clear()
  {
    if (size() != 0)
    {
      super.clear();
      Object[] arrayOfObject1 = this.ecx;
      Object[] arrayOfObject2 = this.ecg;
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
    Object[] arrayOfObject1 = this.ecx;
    Object[] arrayOfObject2 = this.ecg;
    if (paramObject == null) {}
    int j;
    for (int i = arrayOfObject2.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((arrayOfObject1[j] != null) && (arrayOfObject1[j] != ecz) && (paramObject == arrayOfObject2[j]))
        {
          return true;
          for (i = arrayOfObject2.length;; i = j)
          {
            j = i - 1;
            if (i <= 0) {
              break label108;
            }
            if ((arrayOfObject1[j] != null) && (arrayOfObject1[j] != ecz) && ((paramObject == arrayOfObject2[j]) || (paramObject.equals(arrayOfObject2[j])))) {
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
    return a(new c(paramObject));
  }
  
  public final V get(Object paramObject)
  {
    int i = bY(paramObject);
    if (i < 0) {
      return null;
    }
    return this.ecg[i];
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
  
  protected final int lU(int paramInt)
  {
    paramInt = super.lU(paramInt);
    this.ecg = ((Object[])new Object[paramInt]);
    return paramInt;
  }
  
  protected final void lV(int paramInt)
  {
    int i = this.ecx.length;
    Object[] arrayOfObject1 = this.ecx;
    Object[] arrayOfObject2 = this.ecg;
    this.ecx = new Object[paramInt];
    this.ecg = ((Object[])new Object[paramInt]);
    paramInt = i;
    for (;;)
    {
      i = paramInt - 1;
      if (paramInt > 0)
      {
        if ((arrayOfObject1[i] != null) && (arrayOfObject1[i] != ecz))
        {
          Object localObject = arrayOfObject1[i];
          paramInt = bZ(localObject);
          if (paramInt < 0) {
            A(this.ecx[(-paramInt - 1)], localObject);
          }
          this.ecx[paramInt] = localObject;
          this.ecg[paramInt] = arrayOfObject2[i];
          paramInt = i;
        }
      }
      else {
        return;
      }
      paramInt = i;
    }
  }
  
  public final V put(K paramK, V paramV)
  {
    if (paramK == null) {
      throw new NullPointerException("null keys not supported");
    }
    Object localObject1 = null;
    int k = bZ(paramK);
    int i;
    if (k < 0)
    {
      i = 1;
      int j = k;
      if (i != 0)
      {
        j = -k - 1;
        localObject1 = this.ecg[j];
      }
      Object localObject2 = this.ecx[j];
      this.ecx[j] = paramK;
      this.ecg[j] = paramV;
      if (i == 0) {
        if (localObject2 != null) {
          break label106;
        }
      }
    }
    label106:
    for (boolean bool = true;; bool = false)
    {
      cD(bool);
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
    int i = bY(paramObject);
    paramObject = localObject;
    if (i >= 0)
    {
      paramObject = this.ecg[i];
      bj(i);
    }
    return paramObject;
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
      if (d.this.ecg[this.index] != this.val) {
        throw new ConcurrentModificationException();
      }
      d.this.ecg[this.index] = paramV;
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
  
  static final class c<K, V>
    implements r<K, V>
  {
    private final Map<K, V> ecj;
    
    c(Map<K, V> paramMap)
    {
      this.ecj = paramMap;
    }
    
    public final boolean z(K paramK, V paramV)
    {
      paramK = this.ecj.get(paramK);
      return (paramK == paramV) || ((paramK != null) && (paramK.equals(paramV)));
    }
  }
  
  final class d
    implements r<K, V>
  {
    int h;
    
    d() {}
    
    public final boolean z(K paramK, V paramV)
    {
      int j = this.h;
      int k = d.this.ecy.bX(paramK);
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
    
    public final boolean bV(K paramK)
    {
      return d.this.contains(paramK);
    }
    
    public final boolean bW(K paramK)
    {
      return d.this.remove(paramK) != null;
    }
    
    public final Iterator<K> iterator()
    {
      return new o(d.this);
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
    
    public abstract boolean bV(E paramE);
    
    public abstract boolean bW(E paramE);
    
    public void clear()
    {
      d.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return bV(paramObject);
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
      return bW(paramObject);
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
    
    public final boolean bV(V paramV)
    {
      return d.this.containsValue(paramV);
    }
    
    public final boolean bW(V paramV)
    {
      Object[] arrayOfObject1 = d.this.ecg;
      Object[] arrayOfObject2 = d.this.ecx;
      int i = arrayOfObject1.length;
      boolean bool = false;
      for (;;)
      {
        int j = i - 1;
        if (i > 0)
        {
          if (((arrayOfObject2[j] != null) && (arrayOfObject2[j] != n.ecz) && (paramV == arrayOfObject1[j])) || ((arrayOfObject1[j] != null) && (arrayOfObject1[j].equals(paramV))))
          {
            d.this.bj(j);
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
    
    public final Iterator<V> iterator()
    {
      new c(d.this)
      {
        protected final V lX(int paramAnonymousInt)
        {
          return d.this.ecg[paramAnonymousInt];
        }
      };
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.h.a.c.d
 * JD-Core Version:    0.7.0.1
 */