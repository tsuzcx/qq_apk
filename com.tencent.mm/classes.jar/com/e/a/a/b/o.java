package com.e.a.a.b;

import com.e.a.a.a.a;
import java.util.AbstractSet;
import java.util.Collection;

abstract class o<E>
  extends AbstractSet<E>
{
  public boolean removeAll(Collection<?> paramCollection)
  {
    return a.a(this, paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return super.retainAll((Collection)a.checkNotNull(paramCollection));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.e.a.a.b.o
 * JD-Core Version:    0.7.0.1
 */