package com.e.a.c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

abstract class d$f<E>
  implements Set<E>
{
  d$f(d paramd) {}
  
  public boolean add(E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean aw(E paramE);
  
  public void clear()
  {
    this.cfL.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return aw(paramObject);
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
    return this.cfL.isEmpty();
  }
  
  public abstract Iterator<E> iterator();
  
  public boolean remove(Object paramObject)
  {
    return removeElement(paramObject);
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
  
  public abstract boolean removeElement(E paramE);
  
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
    return this.cfL.size();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.c.d.f
 * JD-Core Version:    0.7.0.1
 */