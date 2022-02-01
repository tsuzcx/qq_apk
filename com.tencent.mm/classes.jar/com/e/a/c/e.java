package com.e.a.c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class e<E>
  extends n<E>
  implements Set<E>
{
  public final boolean add(E paramE)
  {
    boolean bool = false;
    int i = aA(paramE);
    if (i < 0) {
      return false;
    }
    Object localObject = this.cgb[i];
    this.cgb[i] = paramE;
    if (localObject == null) {
      bool = true;
    }
    bo(bool);
    return true;
  }
  
  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    int i = paramCollection.size();
    ensureCapacity(i);
    paramCollection = paramCollection.iterator();
    boolean bool = false;
    for (;;)
    {
      int j = i - 1;
      if (i > 0)
      {
        if (add(paramCollection.next()))
        {
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
  
  public final void clear()
  {
    super.clear();
    Object[] arrayOfObject = this.cgb;
    int j;
    for (int i = arrayOfObject.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      arrayOfObject[j] = null;
    }
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
    if (!(paramObject instanceof Set)) {}
    do
    {
      return false;
      paramObject = (Set)paramObject;
    } while (paramObject.size() != size());
    return containsAll(paramObject);
  }
  
  protected final void gm(int paramInt)
  {
    int i = this.cgb.length;
    Object[] arrayOfObject = this.cgb;
    this.cgb = new Object[paramInt];
    paramInt = i;
    for (;;)
    {
      i = paramInt - 1;
      if (paramInt > 0)
      {
        if ((arrayOfObject[i] != null) && (arrayOfObject[i] != cgd))
        {
          Object localObject = arrayOfObject[i];
          paramInt = aA(localObject);
          if (paramInt < 0) {
            o(this.cgb[(-paramInt - 1)], localObject);
          }
          this.cgb[paramInt] = localObject;
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
    a locala = new a();
    b(locala);
    return locala.h;
  }
  
  public final Iterator<E> iterator()
  {
    return new o(this);
  }
  
  public final boolean remove(Object paramObject)
  {
    int i = az(paramObject);
    if (i >= 0)
    {
      removeAt(i);
      return true;
    }
    return false;
  }
  
  public final boolean removeAll(Collection<?> paramCollection)
  {
    int i = paramCollection.size();
    paramCollection = paramCollection.iterator();
    boolean bool = false;
    for (;;)
    {
      int j = i - 1;
      if (i > 0)
      {
        if (remove(paramCollection.next()))
        {
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
  
  public final boolean retainAll(Collection<?> paramCollection)
  {
    int i = size();
    Iterator localIterator = iterator();
    boolean bool = false;
    for (;;)
    {
      int j = i - 1;
      if (i > 0)
      {
        if (!paramCollection.contains(localIterator.next()))
        {
          localIterator.remove();
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
  
  public final Object[] toArray()
  {
    Object[] arrayOfObject = new Object[size()];
    b(new t(arrayOfObject));
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
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
  
  final class a
    implements s<E>
  {
    int h;
    
    a() {}
    
    public final boolean av(E paramE)
    {
      this.h += e.this.cgc.ay(paramE);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.e.a.c.e
 * JD-Core Version:    0.7.0.1
 */