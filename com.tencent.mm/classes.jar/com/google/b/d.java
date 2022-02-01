package com.google.b;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class d<E>
  extends AbstractList<E>
  implements be.e<E>
{
  private boolean bPc = true;
  
  public boolean Ak()
  {
    return this.bPc;
  }
  
  public final void Al()
  {
    this.bPc = false;
  }
  
  protected final void Am()
  {
    if (!this.bPc) {
      throw new UnsupportedOperationException();
    }
  }
  
  public void add(int paramInt, E paramE)
  {
    Am();
    super.add(paramInt, paramE);
  }
  
  public boolean add(E paramE)
  {
    Am();
    return super.add(paramE);
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    Am();
    return super.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    Am();
    return super.addAll(paramCollection);
  }
  
  public void clear()
  {
    Am();
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
    Am();
    return super.remove(paramInt);
  }
  
  public boolean remove(Object paramObject)
  {
    Am();
    return super.remove(paramObject);
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    Am();
    return super.removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    Am();
    return super.retainAll(paramCollection);
  }
  
  public E set(int paramInt, E paramE)
  {
    Am();
    return super.set(paramInt, paramE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.d
 * JD-Core Version:    0.7.0.1
 */