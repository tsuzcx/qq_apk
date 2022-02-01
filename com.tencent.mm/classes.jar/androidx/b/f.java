package androidx.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class f<K, V>
{
  f<K, V>.b RZ;
  f<K, V>.c Sa;
  f<K, V>.e Sb;
  
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
  
  protected abstract Object B(int paramInt1, int paramInt2);
  
  protected abstract V b(int paramInt, V paramV);
  
  protected abstract void bf(int paramInt);
  
  public final Object[] bm(int paramInt)
  {
    int j = lh();
    Object[] arrayOfObject = new Object[j];
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = B(i, paramInt);
      i += 1;
    }
    return arrayOfObject;
  }
  
  public final <T> T[] c(T[] paramArrayOfT, int paramInt)
  {
    int j = lh();
    if (paramArrayOfT.length < j) {
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j);
    }
    for (;;)
    {
      int i = 0;
      while (i < j)
      {
        paramArrayOfT[i] = B(i, paramInt);
        i += 1;
      }
      if (paramArrayOfT.length > j) {
        paramArrayOfT[j] = null;
      }
      return paramArrayOfT;
    }
  }
  
  protected abstract void d(K paramK, V paramV);
  
  protected abstract int lh();
  
  protected abstract Map<K, V> li();
  
  protected abstract void lj();
  
  public final Set<K> ln()
  {
    if (this.Sa == null) {
      this.Sa = new c();
    }
    return this.Sa;
  }
  
  protected abstract int w(Object paramObject);
  
  protected abstract int x(Object paramObject);
  
  final class a<T>
    implements Iterator<T>
  {
    final int Sc;
    boolean Sd;
    int mIndex;
    int mSize;
    
    a(int paramInt)
    {
      AppMethodBeat.i(194528);
      this.Sd = false;
      this.Sc = paramInt;
      this.mSize = f.this.lh();
      AppMethodBeat.o(194528);
    }
    
    public final boolean hasNext()
    {
      return this.mIndex < this.mSize;
    }
    
    public final T next()
    {
      AppMethodBeat.i(194542);
      if (!hasNext())
      {
        localObject = new NoSuchElementException();
        AppMethodBeat.o(194542);
        throw ((Throwable)localObject);
      }
      Object localObject = f.this.B(this.mIndex, this.Sc);
      this.mIndex += 1;
      this.Sd = true;
      AppMethodBeat.o(194542);
      return localObject;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(194553);
      if (!this.Sd)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException();
        AppMethodBeat.o(194553);
        throw localIllegalStateException;
      }
      this.mIndex -= 1;
      this.mSize -= 1;
      this.Sd = false;
      f.this.bf(this.mIndex);
      AppMethodBeat.o(194553);
    }
  }
  
  final class b
    implements Set<Map.Entry<K, V>>
  {
    b() {}
    
    public final boolean addAll(Collection<? extends Map.Entry<K, V>> paramCollection)
    {
      AppMethodBeat.i(194548);
      int i = f.this.lh();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramCollection.next();
        f.this.d(localEntry.getKey(), localEntry.getValue());
      }
      if (i != f.this.lh())
      {
        AppMethodBeat.o(194548);
        return true;
      }
      AppMethodBeat.o(194548);
      return false;
    }
    
    public final void clear()
    {
      AppMethodBeat.i(194564);
      f.this.lj();
      AppMethodBeat.o(194564);
    }
    
    public final boolean contains(Object paramObject)
    {
      AppMethodBeat.i(194582);
      if (!(paramObject instanceof Map.Entry))
      {
        AppMethodBeat.o(194582);
        return false;
      }
      paramObject = (Map.Entry)paramObject;
      int i = f.this.w(paramObject.getKey());
      if (i < 0)
      {
        AppMethodBeat.o(194582);
        return false;
      }
      boolean bool = c.equal(f.this.B(i, 1), paramObject.getValue());
      AppMethodBeat.o(194582);
      return bool;
    }
    
    public final boolean containsAll(Collection<?> paramCollection)
    {
      AppMethodBeat.i(194596);
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next()))
        {
          AppMethodBeat.o(194596);
          return false;
        }
      }
      AppMethodBeat.o(194596);
      return true;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(194723);
      boolean bool = f.a(this, paramObject);
      AppMethodBeat.o(194723);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(194740);
      int j = f.this.lh() - 1;
      int i = 0;
      if (j >= 0)
      {
        Object localObject1 = f.this.B(j, 0);
        Object localObject2 = f.this.B(j, 1);
        int k;
        if (localObject1 == null)
        {
          k = 0;
          label50:
          if (localObject2 != null) {
            break label81;
          }
        }
        label81:
        for (int m = 0;; m = localObject2.hashCode())
        {
          j -= 1;
          i += (m ^ k);
          break;
          k = localObject1.hashCode();
          break label50;
        }
      }
      AppMethodBeat.o(194740);
      return i;
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(194608);
      if (f.this.lh() == 0)
      {
        AppMethodBeat.o(194608);
        return true;
      }
      AppMethodBeat.o(194608);
      return false;
    }
    
    public final Iterator<Map.Entry<K, V>> iterator()
    {
      AppMethodBeat.i(194623);
      f.d locald = new f.d(f.this);
      AppMethodBeat.o(194623);
      return locald;
    }
    
    public final boolean remove(Object paramObject)
    {
      AppMethodBeat.i(194637);
      paramObject = new UnsupportedOperationException();
      AppMethodBeat.o(194637);
      throw paramObject;
    }
    
    public final boolean removeAll(Collection<?> paramCollection)
    {
      AppMethodBeat.i(194656);
      paramCollection = new UnsupportedOperationException();
      AppMethodBeat.o(194656);
      throw paramCollection;
    }
    
    public final boolean retainAll(Collection<?> paramCollection)
    {
      AppMethodBeat.i(194667);
      paramCollection = new UnsupportedOperationException();
      AppMethodBeat.o(194667);
      throw paramCollection;
    }
    
    public final int size()
    {
      AppMethodBeat.i(194678);
      int i = f.this.lh();
      AppMethodBeat.o(194678);
      return i;
    }
    
    public final Object[] toArray()
    {
      AppMethodBeat.i(194695);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(194695);
      throw localUnsupportedOperationException;
    }
    
    public final <T> T[] toArray(T[] paramArrayOfT)
    {
      AppMethodBeat.i(194710);
      paramArrayOfT = new UnsupportedOperationException();
      AppMethodBeat.o(194710);
      throw paramArrayOfT;
    }
  }
  
  final class c
    implements Set<K>
  {
    c() {}
    
    public final boolean add(K paramK)
    {
      AppMethodBeat.i(194557);
      paramK = new UnsupportedOperationException();
      AppMethodBeat.o(194557);
      throw paramK;
    }
    
    public final boolean addAll(Collection<? extends K> paramCollection)
    {
      AppMethodBeat.i(194568);
      paramCollection = new UnsupportedOperationException();
      AppMethodBeat.o(194568);
      throw paramCollection;
    }
    
    public final void clear()
    {
      AppMethodBeat.i(194575);
      f.this.lj();
      AppMethodBeat.o(194575);
    }
    
    public final boolean contains(Object paramObject)
    {
      AppMethodBeat.i(194587);
      if (f.this.w(paramObject) >= 0)
      {
        AppMethodBeat.o(194587);
        return true;
      }
      AppMethodBeat.o(194587);
      return false;
    }
    
    public final boolean containsAll(Collection<?> paramCollection)
    {
      AppMethodBeat.i(194595);
      Map localMap = f.this.li();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!localMap.containsKey(paramCollection.next()))
        {
          AppMethodBeat.o(194595);
          return false;
        }
      }
      AppMethodBeat.o(194595);
      return true;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(194674);
      boolean bool = f.a(this, paramObject);
      AppMethodBeat.o(194674);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(194685);
      int i = f.this.lh() - 1;
      int j = 0;
      if (i >= 0)
      {
        Object localObject = f.this.B(i, 0);
        if (localObject == null) {}
        for (int k = 0;; k = localObject.hashCode())
        {
          j += k;
          i -= 1;
          break;
        }
      }
      AppMethodBeat.o(194685);
      return j;
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(194602);
      if (f.this.lh() == 0)
      {
        AppMethodBeat.o(194602);
        return true;
      }
      AppMethodBeat.o(194602);
      return false;
    }
    
    public final Iterator<K> iterator()
    {
      AppMethodBeat.i(194612);
      f.a locala = new f.a(f.this, 0);
      AppMethodBeat.o(194612);
      return locala;
    }
    
    public final boolean remove(Object paramObject)
    {
      AppMethodBeat.i(194622);
      int i = f.this.w(paramObject);
      if (i >= 0)
      {
        f.this.bf(i);
        AppMethodBeat.o(194622);
        return true;
      }
      AppMethodBeat.o(194622);
      return false;
    }
    
    public final boolean removeAll(Collection<?> paramCollection)
    {
      AppMethodBeat.i(194630);
      Map localMap = f.this.li();
      int i = localMap.size();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        localMap.remove(paramCollection.next());
      }
      if (i != localMap.size())
      {
        AppMethodBeat.o(194630);
        return true;
      }
      AppMethodBeat.o(194630);
      return false;
    }
    
    public final boolean retainAll(Collection<?> paramCollection)
    {
      AppMethodBeat.i(194639);
      boolean bool = f.a(f.this.li(), paramCollection);
      AppMethodBeat.o(194639);
      return bool;
    }
    
    public final int size()
    {
      AppMethodBeat.i(194649);
      int i = f.this.lh();
      AppMethodBeat.o(194649);
      return i;
    }
    
    public final Object[] toArray()
    {
      AppMethodBeat.i(194659);
      Object[] arrayOfObject = f.this.bm(0);
      AppMethodBeat.o(194659);
      return arrayOfObject;
    }
    
    public final <T> T[] toArray(T[] paramArrayOfT)
    {
      AppMethodBeat.i(194669);
      paramArrayOfT = f.this.c(paramArrayOfT, 0);
      AppMethodBeat.o(194669);
      return paramArrayOfT;
    }
  }
  
  final class d
    implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V>
  {
    boolean Sf;
    int mIndex;
    int uH;
    
    d()
    {
      AppMethodBeat.i(194560);
      this.Sf = false;
      this.uH = (f.this.lh() - 1);
      this.mIndex = -1;
      AppMethodBeat.o(194560);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(194647);
      if (!this.Sf)
      {
        paramObject = new IllegalStateException("This container does not support retaining Map.Entry objects");
        AppMethodBeat.o(194647);
        throw paramObject;
      }
      if (!(paramObject instanceof Map.Entry))
      {
        AppMethodBeat.o(194647);
        return false;
      }
      paramObject = (Map.Entry)paramObject;
      if ((c.equal(paramObject.getKey(), f.this.B(this.mIndex, 0))) && (c.equal(paramObject.getValue(), f.this.B(this.mIndex, 1))))
      {
        AppMethodBeat.o(194647);
        return true;
      }
      AppMethodBeat.o(194647);
      return false;
    }
    
    public final K getKey()
    {
      AppMethodBeat.i(194604);
      if (!this.Sf)
      {
        localObject = new IllegalStateException("This container does not support retaining Map.Entry objects");
        AppMethodBeat.o(194604);
        throw ((Throwable)localObject);
      }
      Object localObject = f.this.B(this.mIndex, 0);
      AppMethodBeat.o(194604);
      return localObject;
    }
    
    public final V getValue()
    {
      AppMethodBeat.i(194619);
      if (!this.Sf)
      {
        localObject = new IllegalStateException("This container does not support retaining Map.Entry objects");
        AppMethodBeat.o(194619);
        throw ((Throwable)localObject);
      }
      Object localObject = f.this.B(this.mIndex, 1);
      AppMethodBeat.o(194619);
      return localObject;
    }
    
    public final boolean hasNext()
    {
      return this.mIndex < this.uH;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(194666);
      if (!this.Sf)
      {
        localObject1 = new IllegalStateException("This container does not support retaining Map.Entry objects");
        AppMethodBeat.o(194666);
        throw ((Throwable)localObject1);
      }
      Object localObject1 = f.this.B(this.mIndex, 0);
      Object localObject2 = f.this.B(this.mIndex, 1);
      int i;
      if (localObject1 == null)
      {
        i = 0;
        if (localObject2 != null) {
          break label86;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(194666);
        return j ^ i;
        i = localObject1.hashCode();
        break;
        label86:
        j = localObject2.hashCode();
      }
    }
    
    public final void remove()
    {
      AppMethodBeat.i(194590);
      if (!this.Sf)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException();
        AppMethodBeat.o(194590);
        throw localIllegalStateException;
      }
      f.this.bf(this.mIndex);
      this.mIndex -= 1;
      this.uH -= 1;
      this.Sf = false;
      AppMethodBeat.o(194590);
    }
    
    public final V setValue(V paramV)
    {
      AppMethodBeat.i(194631);
      if (!this.Sf)
      {
        paramV = new IllegalStateException("This container does not support retaining Map.Entry objects");
        AppMethodBeat.o(194631);
        throw paramV;
      }
      paramV = f.this.b(this.mIndex, paramV);
      AppMethodBeat.o(194631);
      return paramV;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(194675);
      String str = getKey() + "=" + getValue();
      AppMethodBeat.o(194675);
      return str;
    }
  }
  
  final class e
    implements Collection<V>
  {
    e() {}
    
    public final boolean add(V paramV)
    {
      AppMethodBeat.i(194540);
      paramV = new UnsupportedOperationException();
      AppMethodBeat.o(194540);
      throw paramV;
    }
    
    public final boolean addAll(Collection<? extends V> paramCollection)
    {
      AppMethodBeat.i(194549);
      paramCollection = new UnsupportedOperationException();
      AppMethodBeat.o(194549);
      throw paramCollection;
    }
    
    public final void clear()
    {
      AppMethodBeat.i(194556);
      f.this.lj();
      AppMethodBeat.o(194556);
    }
    
    public final boolean contains(Object paramObject)
    {
      AppMethodBeat.i(194569);
      if (f.this.x(paramObject) >= 0)
      {
        AppMethodBeat.o(194569);
        return true;
      }
      AppMethodBeat.o(194569);
      return false;
    }
    
    public final boolean containsAll(Collection<?> paramCollection)
    {
      AppMethodBeat.i(194577);
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next()))
        {
          AppMethodBeat.o(194577);
          return false;
        }
      }
      AppMethodBeat.o(194577);
      return true;
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(194586);
      if (f.this.lh() == 0)
      {
        AppMethodBeat.o(194586);
        return true;
      }
      AppMethodBeat.o(194586);
      return false;
    }
    
    public final Iterator<V> iterator()
    {
      AppMethodBeat.i(194594);
      f.a locala = new f.a(f.this, 1);
      AppMethodBeat.o(194594);
      return locala;
    }
    
    public final boolean remove(Object paramObject)
    {
      AppMethodBeat.i(194603);
      int i = f.this.x(paramObject);
      if (i >= 0)
      {
        f.this.bf(i);
        AppMethodBeat.o(194603);
        return true;
      }
      AppMethodBeat.o(194603);
      return false;
    }
    
    public final boolean removeAll(Collection<?> paramCollection)
    {
      AppMethodBeat.i(194617);
      int j = f.this.lh();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        int m = i;
        int k = j;
        if (paramCollection.contains(f.this.B(i, 1)))
        {
          f.this.bf(i);
          m = i - 1;
          k = j - 1;
          bool = true;
        }
        i = m + 1;
        j = k;
      }
      AppMethodBeat.o(194617);
      return bool;
    }
    
    public final boolean retainAll(Collection<?> paramCollection)
    {
      AppMethodBeat.i(194625);
      int j = f.this.lh();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        int m = i;
        int k = j;
        if (!paramCollection.contains(f.this.B(i, 1)))
        {
          f.this.bf(i);
          m = i - 1;
          k = j - 1;
          bool = true;
        }
        i = m + 1;
        j = k;
      }
      AppMethodBeat.o(194625);
      return bool;
    }
    
    public final int size()
    {
      AppMethodBeat.i(194632);
      int i = f.this.lh();
      AppMethodBeat.o(194632);
      return i;
    }
    
    public final Object[] toArray()
    {
      AppMethodBeat.i(194642);
      Object[] arrayOfObject = f.this.bm(1);
      AppMethodBeat.o(194642);
      return arrayOfObject;
    }
    
    public final <T> T[] toArray(T[] paramArrayOfT)
    {
      AppMethodBeat.i(194653);
      paramArrayOfT = f.this.c(paramArrayOfT, 1);
      AppMethodBeat.o(194653);
      return paramArrayOfT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.b.f
 * JD-Core Version:    0.7.0.1
 */