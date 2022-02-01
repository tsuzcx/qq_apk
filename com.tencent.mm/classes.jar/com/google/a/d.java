package com.google.a;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class d<E>
  extends AbstractList<E>
  implements ae.e<E>
{
  boolean bNd = true;
  
  public void add(int paramInt, E paramE)
  {
    yL();
    super.add(paramInt, paramE);
  }
  
  public boolean add(E paramE)
  {
    yL();
    return super.add(paramE);
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    yL();
    return super.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    yL();
    return super.addAll(paramCollection);
  }
  
  public void clear()
  {
    yL();
    super.clear();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof List)) {
        return false;
      }
      if (!(paramObject instanceof RandomAccess)) {
        return super.equals(paramObject);
      }
      paramObject = (List)paramObject;
      int j = size();
      if (j != paramObject.size()) {
        return false;
      }
      int i = 0;
      while (i < j)
      {
        if (!get(i).equals(paramObject.get(i))) {
          return false;
        }
        i += 1;
      }
    }
  }
  
  public int hashCode()
  {
    int k = size();
    int j = 1;
    int i = 0;
    while (i < k)
    {
      j = j * 31 + get(i).hashCode();
      i += 1;
    }
    return j;
  }
  
  public E remove(int paramInt)
  {
    yL();
    return super.remove(paramInt);
  }
  
  public boolean remove(Object paramObject)
  {
    yL();
    return super.remove(paramObject);
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    yL();
    return super.removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    yL();
    return super.retainAll(paramCollection);
  }
  
  public E set(int paramInt, E paramE)
  {
    yL();
    return super.set(paramInt, paramE);
  }
  
  public boolean yJ()
  {
    return this.bNd;
  }
  
  public final void yK()
  {
    this.bNd = false;
  }
  
  protected final void yL()
  {
    if (!this.bNd) {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.d
 * JD-Core Version:    0.7.0.1
 */