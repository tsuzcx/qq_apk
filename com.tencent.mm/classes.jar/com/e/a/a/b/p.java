package com.e.a.a.b;

import com.e.a.a.a.a;
import java.util.Iterator;

abstract class p<F, T>
  implements Iterator<T>
{
  final Iterator<? extends F> cdR;
  
  p(Iterator<? extends F> paramIterator)
  {
    this.cdR = ((Iterator)a.checkNotNull(paramIterator));
  }
  
  abstract T ar(F paramF);
  
  public final boolean hasNext()
  {
    return this.cdR.hasNext();
  }
  
  public final T next()
  {
    return ar(this.cdR.next());
  }
  
  public final void remove()
  {
    this.cdR.remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.b.p
 * JD-Core Version:    0.7.0.1
 */