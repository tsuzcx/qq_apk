package com.d.a.c;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class e<K, V>
  extends o<K>
  implements Map<K, V>
{
  protected transient V[] clO;
  
  private e<K, V> Lo()
  {
    e locale = (e)super.Lp();
    locale.clO = ((Object[])this.clO.clone());
    return locale;
  }
  
  private boolean a(s<K, V> params)
  {
    Object[] arrayOfObject1 = this.cmf;
    Object[] arrayOfObject2 = this.clO;
    int j;
    for (int i = arrayOfObject1.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((arrayOfObject1[j] != null) && (arrayOfObject1[j] != cmh) && (!params.o(arrayOfObject1[j], arrayOfObject2[j]))) {
          return false;
        }
      }
      else {
        return true;
      }
    }
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream.defaultReadObject();
    int i = paramObjectInputStream.readInt();
    ip(i);
    while (i > 0)
    {
      put(paramObjectInputStream.readObject(), paramObjectInputStream.readObject());
      i -= 1;
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeInt(this._size);
    paramObjectOutputStream = new b(paramObjectOutputStream);
    if (!a(paramObjectOutputStream)) {
      throw paramObjectOutputStream.clI;
    }
  }
  
  protected final void aK(int paramInt)
  {
    this.clO[paramInt] = null;
    super.aK(paramInt);
  }
  
  public final void clear()
  {
    if (size() != 0)
    {
      super.clear();
      Object[] arrayOfObject1 = this.cmf;
      Object[] arrayOfObject2 = this.clO;
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
    Object[] arrayOfObject1 = this.cmf;
    Object[] arrayOfObject2 = this.clO;
    if (paramObject == null) {}
    int j;
    for (int i = arrayOfObject2.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((arrayOfObject1[j] != null) && (arrayOfObject1[j] != cmh) && (paramObject == arrayOfObject2[j]))
        {
          return true;
          for (i = arrayOfObject2.length;; i = j)
          {
            j = i - 1;
            if (i <= 0) {
              break label108;
            }
            if ((arrayOfObject1[j] != null) && (arrayOfObject1[j] != cmh) && ((paramObject == arrayOfObject2[j]) || (paramObject.equals(arrayOfObject2[j])))) {
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
    return a(new e.c(paramObject));
  }
  
  public final V get(Object paramObject)
  {
    int i = aE(paramObject);
    if (i < 0) {
      return null;
    }
    return this.clO[i];
  }
  
  public final int hashCode()
  {
    e.d locald = new e.d(this);
    a(locald);
    return locald.h;
  }
  
  protected final int ip(int paramInt)
  {
    paramInt = super.ip(paramInt);
    this.clO = ((Object[])new Object[paramInt]);
    return paramInt;
  }
  
  protected final void iq(int paramInt)
  {
    int i = this.cmf.length;
    Object[] arrayOfObject1 = this.cmf;
    Object[] arrayOfObject2 = this.clO;
    this.cmf = new Object[paramInt];
    this.clO = ((Object[])new Object[paramInt]);
    paramInt = i;
    for (;;)
    {
      i = paramInt - 1;
      if (paramInt > 0)
      {
        if ((arrayOfObject1[i] != null) && (arrayOfObject1[i] != cmh))
        {
          Object localObject = arrayOfObject1[i];
          paramInt = aF(localObject);
          if (paramInt < 0) {
            p(this.cmf[(-paramInt - 1)], localObject);
          }
          this.cmf[paramInt] = localObject;
          this.clO[paramInt] = arrayOfObject2[i];
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
    int k = aF(paramK);
    int i;
    if (k < 0)
    {
      i = 1;
      int j = k;
      if (i != 0)
      {
        j = -k - 1;
        localObject1 = this.clO[j];
      }
      Object localObject2 = this.cmf[j];
      this.cmf[j] = paramK;
      this.clO[j] = paramV;
      if (i == 0) {
        if (localObject2 != null) {
          break label106;
        }
      }
    }
    label106:
    for (boolean bool = true;; bool = false)
    {
      bY(bool);
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
    int i = aE(paramObject);
    paramObject = localObject;
    if (i >= 0)
    {
      paramObject = this.clO[i];
      aK(i);
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
      if (e.this.clO[this.index] != this.val) {
        throw new ConcurrentModificationException();
      }
      e.this.clO[this.index] = paramV;
      Object localObject = this.val;
      this.val = paramV;
      return localObject;
    }
  }
  
  public final class b
    extends e<K, V>.MapBackedView<Map.Entry<K, V>>
  {
    b()
    {
      super();
    }
    
    public final Iterator<Map.Entry<K, V>> iterator()
    {
      return new a(e.this);
    }
    
    final class a
      extends d<Map.Entry<K, V>>
    {
      a()
      {
        super();
      }
    }
  }
  
  public final class e
    extends e<K, V>.MapBackedView<K>
  {
    e()
    {
      super();
    }
    
    public final boolean aA(K paramK)
    {
      return e.this.contains(paramK);
    }
    
    public final boolean aB(K paramK)
    {
      return e.this.remove(paramK) != null;
    }
    
    public final Iterator<K> iterator()
    {
      return new p(e.this);
    }
  }
  
  public final class g
    extends e<K, V>.MapBackedView<V>
  {
    protected g()
    {
      super();
    }
    
    public final boolean aA(V paramV)
    {
      return e.this.containsValue(paramV);
    }
    
    public final boolean aB(V paramV)
    {
      Object[] arrayOfObject1 = e.this.clO;
      Object[] arrayOfObject2 = e.this.cmf;
      int i = arrayOfObject1.length;
      boolean bool = false;
      for (;;)
      {
        int j = i - 1;
        if (i > 0)
        {
          if (((arrayOfObject2[j] != null) && (arrayOfObject2[j] != o.cmh) && (paramV == arrayOfObject1[j])) || ((arrayOfObject1[j] != null) && (arrayOfObject1[j].equals(paramV))))
          {
            e.this.aK(j);
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
      new d(e.this)
      {
        protected final V it(int paramAnonymousInt)
        {
          return e.this.clO[paramAnonymousInt];
        }
      };
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.c.e
 * JD-Core Version:    0.7.0.1
 */