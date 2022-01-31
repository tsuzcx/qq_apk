package android.support.v4.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class h<K, V>
{
  h<K, V>.b EY;
  h<K, V>.c EZ;
  h<K, V>.e Fa;
  
  public static <K, V> boolean a(Map<K, V> paramMap, Collection<?> paramCollection)
  {
    int i = paramMap.size();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext()) {
      if (!paramCollection.contains(localIterator.next())) {
        localIterator.remove();
      }
    }
    return i != paramMap.size();
  }
  
  public static <T> boolean a(Set<T> paramSet, Object paramObject)
  {
    if (paramSet == paramObject) {}
    for (;;)
    {
      return true;
      if ((paramObject instanceof Set))
      {
        paramObject = (Set)paramObject;
        try
        {
          if (paramSet.size() == paramObject.size())
          {
            boolean bool = paramSet.containsAll(paramObject);
            if (bool) {}
          }
          else
          {
            return false;
          }
        }
        catch (NullPointerException paramSet)
        {
          return false;
        }
        catch (ClassCastException paramSet)
        {
          return false;
        }
      }
    }
    return false;
  }
  
  protected abstract int C(Object paramObject);
  
  protected abstract int D(Object paramObject);
  
  protected abstract void ao(int paramInt);
  
  public final Object[] as(int paramInt)
  {
    int j = dw();
    Object[] arrayOfObject = new Object[j];
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = q(i, paramInt);
      i += 1;
    }
    return arrayOfObject;
  }
  
  protected abstract V b(int paramInt, V paramV);
  
  public final <T> T[] b(T[] paramArrayOfT, int paramInt)
  {
    int j = dw();
    if (paramArrayOfT.length < j) {
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j);
    }
    for (;;)
    {
      int i = 0;
      while (i < j)
      {
        paramArrayOfT[i] = q(i, paramInt);
        i += 1;
      }
      if (paramArrayOfT.length > j) {
        paramArrayOfT[j] = null;
      }
      return paramArrayOfT;
    }
  }
  
  protected abstract void c(K paramK, V paramV);
  
  protected abstract int dw();
  
  protected abstract Map<K, V> dx();
  
  protected abstract void dy();
  
  public final Set<K> getKeySet()
  {
    if (this.EZ == null) {
      this.EZ = new c();
    }
    return this.EZ;
  }
  
  protected abstract Object q(int paramInt1, int paramInt2);
  
  final class a<T>
    implements Iterator<T>
  {
    final int Fb;
    boolean Fc = false;
    int mIndex;
    int mSize;
    
    a(int paramInt)
    {
      this.Fb = paramInt;
      this.mSize = h.this.dw();
    }
    
    public final boolean hasNext()
    {
      return this.mIndex < this.mSize;
    }
    
    public final T next()
    {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      Object localObject = h.this.q(this.mIndex, this.Fb);
      this.mIndex += 1;
      this.Fc = true;
      return localObject;
    }
    
    public final void remove()
    {
      if (!this.Fc) {
        throw new IllegalStateException();
      }
      this.mIndex -= 1;
      this.mSize -= 1;
      this.Fc = false;
      h.this.ao(this.mIndex);
    }
  }
  
  final class b
    implements Set<Map.Entry<K, V>>
  {
    b() {}
    
    public final boolean addAll(Collection<? extends Map.Entry<K, V>> paramCollection)
    {
      int i = h.this.dw();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramCollection.next();
        h.this.c(localEntry.getKey(), localEntry.getValue());
      }
      return i != h.this.dw();
    }
    
    public final void clear()
    {
      h.this.dy();
    }
    
    public final boolean contains(Object paramObject)
    {
      if (!(paramObject instanceof Map.Entry)) {}
      int i;
      do
      {
        return false;
        paramObject = (Map.Entry)paramObject;
        i = h.this.C(paramObject.getKey());
      } while (i < 0);
      return c.equal(h.this.q(i, 1), paramObject.getValue());
    }
    
    public final boolean containsAll(Collection<?> paramCollection)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next())) {
          return false;
        }
      }
      return true;
    }
    
    public final boolean equals(Object paramObject)
    {
      return h.a(this, paramObject);
    }
    
    public final int hashCode()
    {
      int j = h.this.dw() - 1;
      int i = 0;
      if (j >= 0)
      {
        Object localObject1 = h.this.q(j, 0);
        Object localObject2 = h.this.q(j, 1);
        int k;
        if (localObject1 == null)
        {
          k = 0;
          label45:
          if (localObject2 != null) {
            break label76;
          }
        }
        label76:
        for (int m = 0;; m = localObject2.hashCode())
        {
          j -= 1;
          i += (m ^ k);
          break;
          k = localObject1.hashCode();
          break label45;
        }
      }
      return i;
    }
    
    public final boolean isEmpty()
    {
      return h.this.dw() == 0;
    }
    
    public final Iterator<Map.Entry<K, V>> iterator()
    {
      return new h.d(h.this);
    }
    
    public final boolean remove(Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    public final boolean removeAll(Collection<?> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public final boolean retainAll(Collection<?> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public final int size()
    {
      return h.this.dw();
    }
    
    public final Object[] toArray()
    {
      throw new UnsupportedOperationException();
    }
    
    public final <T> T[] toArray(T[] paramArrayOfT)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  final class c
    implements Set<K>
  {
    c() {}
    
    public final boolean add(K paramK)
    {
      throw new UnsupportedOperationException();
    }
    
    public final boolean addAll(Collection<? extends K> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public final void clear()
    {
      h.this.dy();
    }
    
    public final boolean contains(Object paramObject)
    {
      return h.this.C(paramObject) >= 0;
    }
    
    public final boolean containsAll(Collection<?> paramCollection)
    {
      Map localMap = h.this.dx();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!localMap.containsKey(paramCollection.next())) {
          return false;
        }
      }
      return true;
    }
    
    public final boolean equals(Object paramObject)
    {
      return h.a(this, paramObject);
    }
    
    public final int hashCode()
    {
      int i = h.this.dw() - 1;
      int j = 0;
      if (i >= 0)
      {
        Object localObject = h.this.q(i, 0);
        if (localObject == null) {}
        for (int k = 0;; k = localObject.hashCode())
        {
          j += k;
          i -= 1;
          break;
        }
      }
      return j;
    }
    
    public final boolean isEmpty()
    {
      return h.this.dw() == 0;
    }
    
    public final Iterator<K> iterator()
    {
      return new h.a(h.this, 0);
    }
    
    public final boolean remove(Object paramObject)
    {
      int i = h.this.C(paramObject);
      if (i >= 0)
      {
        h.this.ao(i);
        return true;
      }
      return false;
    }
    
    public final boolean removeAll(Collection<?> paramCollection)
    {
      Map localMap = h.this.dx();
      int i = localMap.size();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        localMap.remove(paramCollection.next());
      }
      return i != localMap.size();
    }
    
    public final boolean retainAll(Collection<?> paramCollection)
    {
      return h.a(h.this.dx(), paramCollection);
    }
    
    public final int size()
    {
      return h.this.dw();
    }
    
    public final Object[] toArray()
    {
      return h.this.as(0);
    }
    
    public final <T> T[] toArray(T[] paramArrayOfT)
    {
      return h.this.b(paramArrayOfT, 0);
    }
  }
  
  final class d
    implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V>
  {
    int Fe = h.this.dw() - 1;
    boolean Ff = false;
    int mIndex = -1;
    
    d() {}
    
    public final boolean equals(Object paramObject)
    {
      if (!this.Ff) {
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      }
      if (!(paramObject instanceof Map.Entry)) {}
      do
      {
        return false;
        paramObject = (Map.Entry)paramObject;
      } while ((!c.equal(paramObject.getKey(), h.this.q(this.mIndex, 0))) || (!c.equal(paramObject.getValue(), h.this.q(this.mIndex, 1))));
      return true;
    }
    
    public final K getKey()
    {
      if (!this.Ff) {
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      }
      return h.this.q(this.mIndex, 0);
    }
    
    public final V getValue()
    {
      if (!this.Ff) {
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      }
      return h.this.q(this.mIndex, 1);
    }
    
    public final boolean hasNext()
    {
      return this.mIndex < this.Fe;
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (!this.Ff) {
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      }
      Object localObject1 = h.this.q(this.mIndex, 0);
      Object localObject2 = h.this.q(this.mIndex, 1);
      int i;
      if (localObject1 == null)
      {
        i = 0;
        if (localObject2 != null) {
          break label69;
        }
      }
      for (;;)
      {
        return j ^ i;
        i = localObject1.hashCode();
        break;
        label69:
        j = localObject2.hashCode();
      }
    }
    
    public final void remove()
    {
      if (!this.Ff) {
        throw new IllegalStateException();
      }
      h.this.ao(this.mIndex);
      this.mIndex -= 1;
      this.Fe -= 1;
      this.Ff = false;
    }
    
    public final V setValue(V paramV)
    {
      if (!this.Ff) {
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      }
      return h.this.b(this.mIndex, paramV);
    }
    
    public final String toString()
    {
      return getKey() + "=" + getValue();
    }
  }
  
  final class e
    implements Collection<V>
  {
    e() {}
    
    public final boolean add(V paramV)
    {
      throw new UnsupportedOperationException();
    }
    
    public final boolean addAll(Collection<? extends V> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public final void clear()
    {
      h.this.dy();
    }
    
    public final boolean contains(Object paramObject)
    {
      return h.this.D(paramObject) >= 0;
    }
    
    public final boolean containsAll(Collection<?> paramCollection)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next())) {
          return false;
        }
      }
      return true;
    }
    
    public final boolean isEmpty()
    {
      return h.this.dw() == 0;
    }
    
    public final Iterator<V> iterator()
    {
      return new h.a(h.this, 1);
    }
    
    public final boolean remove(Object paramObject)
    {
      int i = h.this.D(paramObject);
      if (i >= 0)
      {
        h.this.ao(i);
        return true;
      }
      return false;
    }
    
    public final boolean removeAll(Collection<?> paramCollection)
    {
      int j = h.this.dw();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        int m = i;
        int k = j;
        if (paramCollection.contains(h.this.q(i, 1)))
        {
          h.this.ao(i);
          m = i - 1;
          k = j - 1;
          bool = true;
        }
        i = m + 1;
        j = k;
      }
      return bool;
    }
    
    public final boolean retainAll(Collection<?> paramCollection)
    {
      int j = h.this.dw();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        int m = i;
        int k = j;
        if (!paramCollection.contains(h.this.q(i, 1)))
        {
          h.this.ao(i);
          m = i - 1;
          k = j - 1;
          bool = true;
        }
        i = m + 1;
        j = k;
      }
      return bool;
    }
    
    public final int size()
    {
      return h.this.dw();
    }
    
    public final Object[] toArray()
    {
      return h.this.as(1);
    }
    
    public final <T> T[] toArray(T[] paramArrayOfT)
    {
      return h.this.b(paramArrayOfT, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.e.h
 * JD-Core Version:    0.7.0.1
 */