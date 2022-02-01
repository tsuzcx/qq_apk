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
  f<K, V>.b zM;
  f<K, V>.c zN;
  f<K, V>.e zO;
  
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
  
  protected abstract V a(int paramInt, V paramV);
  
  public final <T> T[] a(T[] paramArrayOfT, int paramInt)
  {
    int j = eY();
    if (paramArrayOfT.length < j) {
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j);
    }
    for (;;)
    {
      int i = 0;
      while (i < j)
      {
        paramArrayOfT[i] = t(i, paramInt);
        i += 1;
      }
      if (paramArrayOfT.length > j) {
        paramArrayOfT[j] = null;
      }
      return paramArrayOfT;
    }
  }
  
  protected abstract void aG(int paramInt);
  
  public final Object[] aN(int paramInt)
  {
    int j = eY();
    Object[] arrayOfObject = new Object[j];
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = t(i, paramInt);
      i += 1;
    }
    return arrayOfObject;
  }
  
  protected abstract void b(K paramK, V paramV);
  
  protected abstract int eY();
  
  protected abstract Map<K, V> eZ();
  
  protected abstract void fa();
  
  public final Set<K> getKeySet()
  {
    if (this.zN == null) {
      this.zN = new c();
    }
    return this.zN;
  }
  
  protected abstract int o(Object paramObject);
  
  protected abstract int p(Object paramObject);
  
  protected abstract Object t(int paramInt1, int paramInt2);
  
  final class a<T>
    implements Iterator<T>
  {
    int mIndex;
    int mSize;
    final int zP;
    boolean zQ;
    
    a(int paramInt)
    {
      AppMethodBeat.i(210271);
      this.zQ = false;
      this.zP = paramInt;
      this.mSize = f.this.eY();
      AppMethodBeat.o(210271);
    }
    
    public final boolean hasNext()
    {
      return this.mIndex < this.mSize;
    }
    
    public final T next()
    {
      AppMethodBeat.i(210272);
      if (!hasNext())
      {
        localObject = new NoSuchElementException();
        AppMethodBeat.o(210272);
        throw ((Throwable)localObject);
      }
      Object localObject = f.this.t(this.mIndex, this.zP);
      this.mIndex += 1;
      this.zQ = true;
      AppMethodBeat.o(210272);
      return localObject;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(210274);
      if (!this.zQ)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException();
        AppMethodBeat.o(210274);
        throw localIllegalStateException;
      }
      this.mIndex -= 1;
      this.mSize -= 1;
      this.zQ = false;
      f.this.aG(this.mIndex);
      AppMethodBeat.o(210274);
    }
  }
  
  final class b
    implements Set<Map.Entry<K, V>>
  {
    b() {}
    
    public final boolean addAll(Collection<? extends Map.Entry<K, V>> paramCollection)
    {
      AppMethodBeat.i(210280);
      int i = f.this.eY();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramCollection.next();
        f.this.b(localEntry.getKey(), localEntry.getValue());
      }
      if (i != f.this.eY())
      {
        AppMethodBeat.o(210280);
        return true;
      }
      AppMethodBeat.o(210280);
      return false;
    }
    
    public final void clear()
    {
      AppMethodBeat.i(210281);
      f.this.fa();
      AppMethodBeat.o(210281);
    }
    
    public final boolean contains(Object paramObject)
    {
      AppMethodBeat.i(210283);
      if (!(paramObject instanceof Map.Entry))
      {
        AppMethodBeat.o(210283);
        return false;
      }
      paramObject = (Map.Entry)paramObject;
      int i = f.this.o(paramObject.getKey());
      if (i < 0)
      {
        AppMethodBeat.o(210283);
        return false;
      }
      boolean bool = c.equal(f.this.t(i, 1), paramObject.getValue());
      AppMethodBeat.o(210283);
      return bool;
    }
    
    public final boolean containsAll(Collection<?> paramCollection)
    {
      AppMethodBeat.i(210284);
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next()))
        {
          AppMethodBeat.o(210284);
          return false;
        }
      }
      AppMethodBeat.o(210284);
      return true;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(210296);
      boolean bool = f.a(this, paramObject);
      AppMethodBeat.o(210296);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(210298);
      int j = f.this.eY() - 1;
      int i = 0;
      if (j >= 0)
      {
        Object localObject1 = f.this.t(j, 0);
        Object localObject2 = f.this.t(j, 1);
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
      AppMethodBeat.o(210298);
      return i;
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(210286);
      if (f.this.eY() == 0)
      {
        AppMethodBeat.o(210286);
        return true;
      }
      AppMethodBeat.o(210286);
      return false;
    }
    
    public final Iterator<Map.Entry<K, V>> iterator()
    {
      AppMethodBeat.i(210287);
      f.d locald = new f.d(f.this);
      AppMethodBeat.o(210287);
      return locald;
    }
    
    public final boolean remove(Object paramObject)
    {
      AppMethodBeat.i(210289);
      paramObject = new UnsupportedOperationException();
      AppMethodBeat.o(210289);
      throw paramObject;
    }
    
    public final boolean removeAll(Collection<?> paramCollection)
    {
      AppMethodBeat.i(210291);
      paramCollection = new UnsupportedOperationException();
      AppMethodBeat.o(210291);
      throw paramCollection;
    }
    
    public final boolean retainAll(Collection<?> paramCollection)
    {
      AppMethodBeat.i(210292);
      paramCollection = new UnsupportedOperationException();
      AppMethodBeat.o(210292);
      throw paramCollection;
    }
    
    public final int size()
    {
      AppMethodBeat.i(210293);
      int i = f.this.eY();
      AppMethodBeat.o(210293);
      return i;
    }
    
    public final Object[] toArray()
    {
      AppMethodBeat.i(210294);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(210294);
      throw localUnsupportedOperationException;
    }
    
    public final <T> T[] toArray(T[] paramArrayOfT)
    {
      AppMethodBeat.i(210295);
      paramArrayOfT = new UnsupportedOperationException();
      AppMethodBeat.o(210295);
      throw paramArrayOfT;
    }
  }
  
  final class c
    implements Set<K>
  {
    c() {}
    
    public final boolean add(K paramK)
    {
      AppMethodBeat.i(210303);
      paramK = new UnsupportedOperationException();
      AppMethodBeat.o(210303);
      throw paramK;
    }
    
    public final boolean addAll(Collection<? extends K> paramCollection)
    {
      AppMethodBeat.i(210304);
      paramCollection = new UnsupportedOperationException();
      AppMethodBeat.o(210304);
      throw paramCollection;
    }
    
    public final void clear()
    {
      AppMethodBeat.i(210306);
      f.this.fa();
      AppMethodBeat.o(210306);
    }
    
    public final boolean contains(Object paramObject)
    {
      AppMethodBeat.i(210307);
      if (f.this.o(paramObject) >= 0)
      {
        AppMethodBeat.o(210307);
        return true;
      }
      AppMethodBeat.o(210307);
      return false;
    }
    
    public final boolean containsAll(Collection<?> paramCollection)
    {
      AppMethodBeat.i(210309);
      Map localMap = f.this.eZ();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!localMap.containsKey(paramCollection.next()))
        {
          AppMethodBeat.o(210309);
          return false;
        }
      }
      AppMethodBeat.o(210309);
      return true;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(210318);
      boolean bool = f.a(this, paramObject);
      AppMethodBeat.o(210318);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(210319);
      int i = f.this.eY() - 1;
      int j = 0;
      if (i >= 0)
      {
        Object localObject = f.this.t(i, 0);
        if (localObject == null) {}
        for (int k = 0;; k = localObject.hashCode())
        {
          j += k;
          i -= 1;
          break;
        }
      }
      AppMethodBeat.o(210319);
      return j;
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(210310);
      if (f.this.eY() == 0)
      {
        AppMethodBeat.o(210310);
        return true;
      }
      AppMethodBeat.o(210310);
      return false;
    }
    
    public final Iterator<K> iterator()
    {
      AppMethodBeat.i(210311);
      f.a locala = new f.a(f.this, 0);
      AppMethodBeat.o(210311);
      return locala;
    }
    
    public final boolean remove(Object paramObject)
    {
      AppMethodBeat.i(210312);
      int i = f.this.o(paramObject);
      if (i >= 0)
      {
        f.this.aG(i);
        AppMethodBeat.o(210312);
        return true;
      }
      AppMethodBeat.o(210312);
      return false;
    }
    
    public final boolean removeAll(Collection<?> paramCollection)
    {
      AppMethodBeat.i(210313);
      Map localMap = f.this.eZ();
      int i = localMap.size();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        localMap.remove(paramCollection.next());
      }
      if (i != localMap.size())
      {
        AppMethodBeat.o(210313);
        return true;
      }
      AppMethodBeat.o(210313);
      return false;
    }
    
    public final boolean retainAll(Collection<?> paramCollection)
    {
      AppMethodBeat.i(210314);
      boolean bool = f.a(f.this.eZ(), paramCollection);
      AppMethodBeat.o(210314);
      return bool;
    }
    
    public final int size()
    {
      AppMethodBeat.i(210315);
      int i = f.this.eY();
      AppMethodBeat.o(210315);
      return i;
    }
    
    public final Object[] toArray()
    {
      AppMethodBeat.i(210316);
      Object[] arrayOfObject = f.this.aN(0);
      AppMethodBeat.o(210316);
      return arrayOfObject;
    }
    
    public final <T> T[] toArray(T[] paramArrayOfT)
    {
      AppMethodBeat.i(210317);
      paramArrayOfT = f.this.a(paramArrayOfT, 0);
      AppMethodBeat.o(210317);
      return paramArrayOfT;
    }
  }
  
  final class d
    implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V>
  {
    int mIndex;
    int tI;
    boolean zS;
    
    d()
    {
      AppMethodBeat.i(210321);
      this.zS = false;
      this.tI = (f.this.eY() - 1);
      this.mIndex = -1;
      AppMethodBeat.o(210321);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(210328);
      if (!this.zS)
      {
        paramObject = new IllegalStateException("This container does not support retaining Map.Entry objects");
        AppMethodBeat.o(210328);
        throw paramObject;
      }
      if (!(paramObject instanceof Map.Entry))
      {
        AppMethodBeat.o(210328);
        return false;
      }
      paramObject = (Map.Entry)paramObject;
      if ((c.equal(paramObject.getKey(), f.this.t(this.mIndex, 0))) && (c.equal(paramObject.getValue(), f.this.t(this.mIndex, 1))))
      {
        AppMethodBeat.o(210328);
        return true;
      }
      AppMethodBeat.o(210328);
      return false;
    }
    
    public final K getKey()
    {
      AppMethodBeat.i(210325);
      if (!this.zS)
      {
        localObject = new IllegalStateException("This container does not support retaining Map.Entry objects");
        AppMethodBeat.o(210325);
        throw ((Throwable)localObject);
      }
      Object localObject = f.this.t(this.mIndex, 0);
      AppMethodBeat.o(210325);
      return localObject;
    }
    
    public final V getValue()
    {
      AppMethodBeat.i(210326);
      if (!this.zS)
      {
        localObject = new IllegalStateException("This container does not support retaining Map.Entry objects");
        AppMethodBeat.o(210326);
        throw ((Throwable)localObject);
      }
      Object localObject = f.this.t(this.mIndex, 1);
      AppMethodBeat.o(210326);
      return localObject;
    }
    
    public final boolean hasNext()
    {
      return this.mIndex < this.tI;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(210329);
      if (!this.zS)
      {
        localObject1 = new IllegalStateException("This container does not support retaining Map.Entry objects");
        AppMethodBeat.o(210329);
        throw ((Throwable)localObject1);
      }
      Object localObject1 = f.this.t(this.mIndex, 0);
      Object localObject2 = f.this.t(this.mIndex, 1);
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
        AppMethodBeat.o(210329);
        return j ^ i;
        i = localObject1.hashCode();
        break;
        label86:
        j = localObject2.hashCode();
      }
    }
    
    public final void remove()
    {
      AppMethodBeat.i(210323);
      if (!this.zS)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException();
        AppMethodBeat.o(210323);
        throw localIllegalStateException;
      }
      f.this.aG(this.mIndex);
      this.mIndex -= 1;
      this.tI -= 1;
      this.zS = false;
      AppMethodBeat.o(210323);
    }
    
    public final V setValue(V paramV)
    {
      AppMethodBeat.i(210327);
      if (!this.zS)
      {
        paramV = new IllegalStateException("This container does not support retaining Map.Entry objects");
        AppMethodBeat.o(210327);
        throw paramV;
      }
      paramV = f.this.a(this.mIndex, paramV);
      AppMethodBeat.o(210327);
      return paramV;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(210330);
      String str = getKey() + "=" + getValue();
      AppMethodBeat.o(210330);
      return str;
    }
  }
  
  final class e
    implements Collection<V>
  {
    e() {}
    
    public final boolean add(V paramV)
    {
      AppMethodBeat.i(210332);
      paramV = new UnsupportedOperationException();
      AppMethodBeat.o(210332);
      throw paramV;
    }
    
    public final boolean addAll(Collection<? extends V> paramCollection)
    {
      AppMethodBeat.i(210333);
      paramCollection = new UnsupportedOperationException();
      AppMethodBeat.o(210333);
      throw paramCollection;
    }
    
    public final void clear()
    {
      AppMethodBeat.i(210334);
      f.this.fa();
      AppMethodBeat.o(210334);
    }
    
    public final boolean contains(Object paramObject)
    {
      AppMethodBeat.i(210335);
      if (f.this.p(paramObject) >= 0)
      {
        AppMethodBeat.o(210335);
        return true;
      }
      AppMethodBeat.o(210335);
      return false;
    }
    
    public final boolean containsAll(Collection<?> paramCollection)
    {
      AppMethodBeat.i(210336);
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next()))
        {
          AppMethodBeat.o(210336);
          return false;
        }
      }
      AppMethodBeat.o(210336);
      return true;
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(210337);
      if (f.this.eY() == 0)
      {
        AppMethodBeat.o(210337);
        return true;
      }
      AppMethodBeat.o(210337);
      return false;
    }
    
    public final Iterator<V> iterator()
    {
      AppMethodBeat.i(210338);
      f.a locala = new f.a(f.this, 1);
      AppMethodBeat.o(210338);
      return locala;
    }
    
    public final boolean remove(Object paramObject)
    {
      AppMethodBeat.i(210339);
      int i = f.this.p(paramObject);
      if (i >= 0)
      {
        f.this.aG(i);
        AppMethodBeat.o(210339);
        return true;
      }
      AppMethodBeat.o(210339);
      return false;
    }
    
    public final boolean removeAll(Collection<?> paramCollection)
    {
      AppMethodBeat.i(210340);
      int j = f.this.eY();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        int m = i;
        int k = j;
        if (paramCollection.contains(f.this.t(i, 1)))
        {
          f.this.aG(i);
          m = i - 1;
          k = j - 1;
          bool = true;
        }
        i = m + 1;
        j = k;
      }
      AppMethodBeat.o(210340);
      return bool;
    }
    
    public final boolean retainAll(Collection<?> paramCollection)
    {
      AppMethodBeat.i(210341);
      int j = f.this.eY();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        int m = i;
        int k = j;
        if (!paramCollection.contains(f.this.t(i, 1)))
        {
          f.this.aG(i);
          m = i - 1;
          k = j - 1;
          bool = true;
        }
        i = m + 1;
        j = k;
      }
      AppMethodBeat.o(210341);
      return bool;
    }
    
    public final int size()
    {
      AppMethodBeat.i(210342);
      int i = f.this.eY();
      AppMethodBeat.o(210342);
      return i;
    }
    
    public final Object[] toArray()
    {
      AppMethodBeat.i(210344);
      Object[] arrayOfObject = f.this.aN(1);
      AppMethodBeat.o(210344);
      return arrayOfObject;
    }
    
    public final <T> T[] toArray(T[] paramArrayOfT)
    {
      AppMethodBeat.i(210345);
      paramArrayOfT = f.this.a(paramArrayOfT, 1);
      AppMethodBeat.o(210345);
      return paramArrayOfT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.b.f
 * JD-Core Version:    0.7.0.1
 */