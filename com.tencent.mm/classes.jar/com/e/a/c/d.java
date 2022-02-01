package com.e.a.c;

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
  protected transient V[] cfJ;
  
  private d<K, V> BB()
  {
    d locald = (d)super.BC();
    locald.cfJ = ((Object[])this.cfJ.clone());
    return locald;
  }
  
  private boolean a(r<K, V> paramr)
  {
    Object[] arrayOfObject1 = this.cgb;
    Object[] arrayOfObject2 = this.cfJ;
    int j;
    for (int i = arrayOfObject1.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((arrayOfObject1[j] != null) && (arrayOfObject1[j] != cgd) && (!paramr.n(arrayOfObject1[j], arrayOfObject2[j]))) {
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
      Object[] arrayOfObject1 = this.cgb;
      Object[] arrayOfObject2 = this.cfJ;
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
    Object[] arrayOfObject1 = this.cgb;
    Object[] arrayOfObject2 = this.cfJ;
    if (paramObject == null) {}
    int j;
    for (int i = arrayOfObject2.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((arrayOfObject1[j] != null) && (arrayOfObject1[j] != cgd) && (paramObject == arrayOfObject2[j]))
        {
          return true;
          for (i = arrayOfObject2.length;; i = j)
          {
            j = i - 1;
            if (i <= 0) {
              break label108;
            }
            if ((arrayOfObject1[j] != null) && (arrayOfObject1[j] != cgd) && ((paramObject == arrayOfObject2[j]) || (paramObject.equals(arrayOfObject2[j])))) {
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
    int i = az(paramObject);
    if (i < 0) {
      return null;
    }
    return this.cfJ[i];
  }
  
  protected final int gl(int paramInt)
  {
    paramInt = super.gl(paramInt);
    this.cfJ = ((Object[])new Object[paramInt]);
    return paramInt;
  }
  
  protected final void gm(int paramInt)
  {
    int i = this.cgb.length;
    Object[] arrayOfObject1 = this.cgb;
    Object[] arrayOfObject2 = this.cfJ;
    this.cgb = new Object[paramInt];
    this.cfJ = ((Object[])new Object[paramInt]);
    paramInt = i;
    for (;;)
    {
      i = paramInt - 1;
      if (paramInt > 0)
      {
        if ((arrayOfObject1[i] != null) && (arrayOfObject1[i] != cgd))
        {
          Object localObject = arrayOfObject1[i];
          paramInt = aA(localObject);
          if (paramInt < 0) {
            o(this.cgb[(-paramInt - 1)], localObject);
          }
          this.cgb[paramInt] = localObject;
          this.cfJ[paramInt] = arrayOfObject2[i];
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
    d.d locald = new d.d(this);
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
    int k = aA(paramK);
    int i;
    if (k < 0)
    {
      i = 1;
      int j = k;
      if (i != 0)
      {
        j = -k - 1;
        localObject1 = this.cfJ[j];
      }
      Object localObject2 = this.cgb[j];
      this.cgb[j] = paramK;
      this.cfJ[j] = paramV;
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
    int i = az(paramObject);
    paramObject = localObject;
    if (i >= 0)
    {
      paramObject = this.cfJ[i];
      removeAt(i);
    }
    return paramObject;
  }
  
  protected final void removeAt(int paramInt)
  {
    this.cfJ[paramInt] = null;
    super.removeAt(paramInt);
  }
  
  public final Collection<V> values()
  {
    return new g();
  }
  
  final class a
    implements Map.Entry<K, V>
  {
    private final K aIw;
    private V cfK;
    private final int index;
    
    a(V paramV, int paramInt)
    {
      this.aIw = paramV;
      this.cfK = paramInt;
      int i;
      this.index = i;
    }
    
    public final K getKey()
    {
      return this.aIw;
    }
    
    public final V getValue()
    {
      return this.cfK;
    }
    
    public final V setValue(V paramV)
    {
      if (d.this.cfJ[this.index] != this.cfK) {
        throw new ConcurrentModificationException();
      }
      d.this.cfJ[this.index] = paramV;
      Object localObject = this.cfK;
      this.cfK = paramV;
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
  
  public final class e
    extends d<K, V>.MapBackedView<K>
  {
    e()
    {
      super();
    }
    
    public final boolean aw(K paramK)
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
  
  public final class g
    extends d<K, V>.MapBackedView<V>
  {
    protected g()
    {
      super();
    }
    
    public final boolean aw(V paramV)
    {
      return d.this.containsValue(paramV);
    }
    
    public final Iterator<V> iterator()
    {
      new c(d.this)
      {
        protected final V go(int paramAnonymousInt)
        {
          return d.this.cfJ[paramAnonymousInt];
        }
      };
    }
    
    public final boolean removeElement(V paramV)
    {
      Object[] arrayOfObject1 = d.this.cfJ;
      Object[] arrayOfObject2 = d.this.cgb;
      int i = arrayOfObject1.length;
      boolean bool = false;
      for (;;)
      {
        int j = i - 1;
        if (i > 0)
        {
          if (((arrayOfObject2[j] != null) && (arrayOfObject2[j] != n.cgd) && (paramV == arrayOfObject1[j])) || ((arrayOfObject1[j] != null) && (arrayOfObject1[j].equals(paramV))))
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
 * Qualified Name:     com.e.a.c.d
 * JD-Core Version:    0.7.0.1
 */