package com.h.a.c;

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
    int i = bZ(paramE);
    if (i < 0) {
      return false;
    }
    Object localObject = this.ecx[i];
    this.ecx[i] = paramE;
    if (localObject == null) {
      bool = true;
    }
    cD(bool);
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
    Object[] arrayOfObject = this.ecx;
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
  
  public final Iterator<E> iterator()
  {
    return new o(this);
  }
  
  protected final void lV(int paramInt)
  {
    int i = this.ecx.length;
    Object[] arrayOfObject = this.ecx;
    this.ecx = new Object[paramInt];
    paramInt = i;
    for (;;)
    {
      i = paramInt - 1;
      if (paramInt > 0)
      {
        if ((arrayOfObject[i] != null) && (arrayOfObject[i] != ecz))
        {
          Object localObject = arrayOfObject[i];
          paramInt = bZ(localObject);
          if (paramInt < 0) {
            A(this.ecx[(-paramInt - 1)], localObject);
          }
          this.ecx[paramInt] = localObject;
          paramInt = i;
        }
      }
      else {
        return;
      }
      paramInt = i;
    }
  }
  
  public final boolean remove(Object paramObject)
  {
    int i = bY(paramObject);
    if (i >= 0)
    {
      bj(i);
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
    
    public final boolean bU(E paramE)
    {
      this.h += e.this.ecy.bX(paramE);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.h.a.c.e
 * JD-Core Version:    0.7.0.1
 */