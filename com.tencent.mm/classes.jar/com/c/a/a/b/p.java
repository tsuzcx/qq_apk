package com.c.a.a.b;

import com.c.a.a.a.a;
import java.util.Iterator;

abstract class p<F, T>
  implements Iterator<T>
{
  final Iterator<? extends F> cov;
  
  p(Iterator<? extends F> paramIterator)
  {
    this.cov = ((Iterator)a.checkNotNull(paramIterator));
  }
  
  abstract T aA(F paramF);
  
  public final boolean hasNext()
  {
    return this.cov.hasNext();
  }
  
  public final T next()
  {
    return aA(this.cov.next());
  }
  
  public final void remove()
  {
    this.cov.remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.c.a.a.b.p
 * JD-Core Version:    0.7.0.1
 */