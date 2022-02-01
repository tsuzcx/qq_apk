package com.google.d;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class d<E>
  extends AbstractList<E>
  implements bj.i<E>
{
  private boolean dIE = true;
  
  public boolean ZO()
  {
    return this.dIE;
  }
  
  public final void ZP()
  {
    this.dIE = false;
  }
  
  protected final void ZQ()
  {
    if (!this.dIE) {
      throw new UnsupportedOperationException();
    }
  }
  
  public void add(int paramInt, E paramE)
  {
    ZQ();
    super.add(paramInt, paramE);
  }
  
  public boolean add(E paramE)
  {
    ZQ();
    return super.add(paramE);
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    ZQ();
    return super.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    ZQ();
    return super.addAll(paramCollection);
  }
  
  public void clear()
  {
    ZQ();
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
    ZQ();
    return super.remove(paramInt);
  }
  
  public boolean remove(Object paramObject)
  {
    ZQ();
    return super.remove(paramObject);
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    ZQ();
    return super.removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    ZQ();
    return super.retainAll(paramCollection);
  }
  
  public E set(int paramInt, E paramE)
  {
    ZQ();
    return super.set(paramInt, paramE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.d
 * JD-Core Version:    0.7.0.1
 */