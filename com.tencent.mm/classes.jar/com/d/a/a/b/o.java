package com.d.a.a.b;

import com.d.a.a.a.b;
import java.util.AbstractSet;
import java.util.Collection;

abstract class o<E>
  extends AbstractSet<E>
{
  public boolean removeAll(Collection<?> paramCollection)
  {
    return b.a(this, paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return super.retainAll((Collection)b.checkNotNull(paramCollection));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.a.b.o
 * JD-Core Version:    0.7.0.1
 */