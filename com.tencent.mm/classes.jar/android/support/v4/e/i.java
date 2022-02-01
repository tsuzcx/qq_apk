package android.support.v4.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class i<K, V>
{
  i<K, V>.b OX;
  i<K, V>.c OY;
  i<K, V>.e OZ;
  
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
  
  protected abstract int E(Object paramObject);
  
  protected abstract int F(Object paramObject);
  
  protected abstract V a(int paramInt, V paramV);
  
  public final <T> T[] a(T[] paramArrayOfT, int paramInt)
  {
    int j = fs();
    if (paramArrayOfT.length < j) {
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j);
    }
    for (;;)
    {
      int i = 0;
      while (i < j)
      {
        paramArrayOfT[i] = z(i, paramInt);
        i += 1;
      }
      if (paramArrayOfT.length > j) {
        paramArrayOfT[j] = null;
      }
      return paramArrayOfT;
    }
  }
  
  protected abstract void aG(int paramInt);
  
  public final Object[] aK(int paramInt)
  {
    int j = fs();
    Object[] arrayOfObject = new Object[j];
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = z(i, paramInt);
      i += 1;
    }
    return arrayOfObject;
  }
  
  protected abstract void b(K paramK, V paramV);
  
  protected abstract int fs();
  
  protected abstract Map<K, V> ft();
  
  protected abstract void fu();
  
  public final Set<K> getKeySet()
  {
    if (this.OY == null) {
      this.OY = new c();
    }
    return this.OY;
  }
  
  protected abstract Object z(int paramInt1, int paramInt2);
  
  final class a<T>
    implements Iterator<T>
  {
    boolean Pa = false;
    final int fs;
    int mIndex;
    int mSize;
    
    a(int paramInt)
    {
      this.fs = paramInt;
      this.mSize = i.this.fs();
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
      Object localObject = i.this.z(this.mIndex, this.fs);
      this.mIndex += 1;
      this.Pa = true;
      return localObject;
    }
    
    public final void remove()
    {
      if (!this.Pa) {
        throw new IllegalStateException();
      }
      this.mIndex -= 1;
      this.mSize -= 1;
      this.Pa = false;
      i.this.aG(this.mIndex);
    }
  }
  
  final class b
    implements Set<Map.Entry<K, V>>
  {
    b() {}
    
    public final boolean addAll(Collection<? extends Map.Entry<K, V>> paramCollection)
    {
      int i = i.this.fs();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramCollection.next();
        i.this.b(localEntry.getKey(), localEntry.getValue());
      }
      return i != i.this.fs();
    }
    
    public final void clear()
    {
      i.this.fu();
    }
    
    public final boolean contains(Object paramObject)
    {
      if (!(paramObject instanceof Map.Entry)) {}
      int i;
      do
      {
        return false;
        paramObject = (Map.Entry)paramObject;
        i = i.this.E(paramObject.getKey());
      } while (i < 0);
      return d.equal(i.this.z(i, 1), paramObject.getValue());
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
      return i.a(this, paramObject);
    }
    
    public final int hashCode()
    {
      int j = i.this.fs() - 1;
      int i = 0;
      if (j >= 0)
      {
        Object localObject1 = i.this.z(j, 0);
        Object localObject2 = i.this.z(j, 1);
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
      return i.this.fs() == 0;
    }
    
    public final Iterator<Map.Entry<K, V>> iterator()
    {
      return new i.d(i.this);
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
      return i.this.fs();
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
      i.this.fu();
    }
    
    public final boolean contains(Object paramObject)
    {
      return i.this.E(paramObject) >= 0;
    }
    
    public final boolean containsAll(Collection<?> paramCollection)
    {
      Map localMap = i.this.ft();
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
      return i.a(this, paramObject);
    }
    
    public final int hashCode()
    {
      int i = i.this.fs() - 1;
      int j = 0;
      if (i >= 0)
      {
        Object localObject = i.this.z(i, 0);
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
      return i.this.fs() == 0;
    }
    
    public final Iterator<K> iterator()
    {
      return new i.a(i.this, 0);
    }
    
    public final boolean remove(Object paramObject)
    {
      int i = i.this.E(paramObject);
      if (i >= 0)
      {
        i.this.aG(i);
        return true;
      }
      return false;
    }
    
    public final boolean removeAll(Collection<?> paramCollection)
    {
      Map localMap = i.this.ft();
      int i = localMap.size();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        localMap.remove(paramCollection.next());
      }
      return i != localMap.size();
    }
    
    public final boolean retainAll(Collection<?> paramCollection)
    {
      return i.a(i.this.ft(), paramCollection);
    }
    
    public final int size()
    {
      return i.this.fs();
    }
    
    public final Object[] toArray()
    {
      return i.this.aK(0);
    }
    
    public final <T> T[] toArray(T[] paramArrayOfT)
    {
      return i.this.a(paramArrayOfT, 0);
    }
  }
  
  final class d
    implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V>
  {
    int Pc = i.this.fs() - 1;
    boolean Pd = false;
    int mIndex = -1;
    
    d() {}
    
    public final boolean equals(Object paramObject)
    {
      if (!this.Pd) {
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      }
      if (!(paramObject instanceof Map.Entry)) {}
      do
      {
        return false;
        paramObject = (Map.Entry)paramObject;
      } while ((!d.equal(paramObject.getKey(), i.this.z(this.mIndex, 0))) || (!d.equal(paramObject.getValue(), i.this.z(this.mIndex, 1))));
      return true;
    }
    
    public final K getKey()
    {
      if (!this.Pd) {
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      }
      return i.this.z(this.mIndex, 0);
    }
    
    public final V getValue()
    {
      if (!this.Pd) {
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      }
      return i.this.z(this.mIndex, 1);
    }
    
    public final boolean hasNext()
    {
      return this.mIndex < this.Pc;
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (!this.Pd) {
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      }
      Object localObject1 = i.this.z(this.mIndex, 0);
      Object localObject2 = i.this.z(this.mIndex, 1);
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
      if (!this.Pd) {
        throw new IllegalStateException();
      }
      i.this.aG(this.mIndex);
      this.mIndex -= 1;
      this.Pc -= 1;
      this.Pd = false;
    }
    
    public final V setValue(V paramV)
    {
      if (!this.Pd) {
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      }
      return i.this.a(this.mIndex, paramV);
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
      i.this.fu();
    }
    
    public final boolean contains(Object paramObject)
    {
      return i.this.F(paramObject) >= 0;
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
      return i.this.fs() == 0;
    }
    
    public final Iterator<V> iterator()
    {
      return new i.a(i.this, 1);
    }
    
    public final boolean remove(Object paramObject)
    {
      int i = i.this.F(paramObject);
      if (i >= 0)
      {
        i.this.aG(i);
        return true;
      }
      return false;
    }
    
    public final boolean removeAll(Collection<?> paramCollection)
    {
      int j = i.this.fs();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        int m = i;
        int k = j;
        if (paramCollection.contains(i.this.z(i, 1)))
        {
          i.this.aG(i);
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
      int j = i.this.fs();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        int m = i;
        int k = j;
        if (!paramCollection.contains(i.this.z(i, 1)))
        {
          i.this.aG(i);
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
      return i.this.fs();
    }
    
    public final Object[] toArray()
    {
      return i.this.aK(1);
    }
    
    public final <T> T[] toArray(T[] paramArrayOfT)
    {
      return i.this.a(paramArrayOfT, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.e.i
 * JD-Core Version:    0.7.0.1
 */