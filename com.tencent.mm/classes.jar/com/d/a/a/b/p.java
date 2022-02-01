package com.d.a.a.b;

import com.d.a.a.a.a;
import java.util.Iterator;

abstract class p<F, T>
  implements Iterator<T>
{
  final Iterator<? extends F> bVW;
  
  p(Iterator<? extends F> paramIterator)
  {
    this.bVW = ((Iterator)a.checkNotNull(paramIterator));
  }
  
  abstract T ao(F paramF);
  
  public final boolean hasNext()
  {
    return this.bVW.hasNext();
  }
  
  public final T next()
  {
    return ao(this.bVW.next());
  }
  
  public final void remove()
  {
    this.bVW.remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.b.p
 * JD-Core Version:    0.7.0.1
 */