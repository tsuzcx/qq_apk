package com.d.a.c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class f<E>
  extends o<E>
  implements Set<E>
{
  public final boolean add(E paramE)
  {
    boolean bool = false;
    int i = aF(paramE);
    if (i < 0) {
      return false;
    }
    Object localObject = this.cmf[i];
    this.cmf[i] = paramE;
    if (localObject == null) {
      bool = true;
    }
    bY(bool);
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
    Object[] arrayOfObject = this.cmf;
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
  
  public final int hashCode()
  {
    a locala = new a();
    b(locala);
    return locala.h;
  }
  
  protected final void iq(int paramInt)
  {
    int i = this.cmf.length;
    Object[] arrayOfObject = this.cmf;
    this.cmf = new Object[paramInt];
    paramInt = i;
    for (;;)
    {
      i = paramInt - 1;
      if (paramInt > 0)
      {
        if ((arrayOfObject[i] != null) && (arrayOfObject[i] != cmh))
        {
          Object localObject = arrayOfObject[i];
          paramInt = aF(localObject);
          if (paramInt < 0) {
            p(this.cmf[(-paramInt - 1)], localObject);
          }
          this.cmf[paramInt] = localObject;
          paramInt = i;
        }
      }
      else {
        return;
      }
      paramInt = i;
    }
  }
  
  public final Iterator<E> iterator()
  {
    return new p(this);
  }
  
  public final boolean remove(Object paramObject)
  {
    int i = aE(paramObject);
    if (i >= 0)
    {
      aK(i);
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
    b(new u(arrayOfObject));
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
    implements t<E>
  {
    int h;
    
    a() {}
    
    public final boolean az(E paramE)
    {
      this.h += f.this.cmg.aD(paramE);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.c.f
 * JD-Core Version:    0.7.0.1
 */