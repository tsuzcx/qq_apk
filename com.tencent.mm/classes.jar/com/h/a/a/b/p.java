package com.h.a.a.b;

import com.h.a.a.a.b;
import java.util.Iterator;

abstract class p<F, T>
  implements Iterator<T>
{
  private Iterator<? extends F> eaq;
  
  p(Iterator<? extends F> paramIterator)
  {
    this.eaq = ((Iterator)b.checkNotNull(paramIterator));
  }
  
  abstract T bR(F paramF);
  
  public final boolean hasNext()
  {
    return this.eaq.hasNext();
  }
  
  public final T next()
  {
    return bR(this.eaq.next());
  }
  
  public final void remove()
  {
    this.eaq.remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.h.a.a.b.p
 * JD-Core Version:    0.7.0.1
 */