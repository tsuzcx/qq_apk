package com.d.a.a.b;

import com.d.a.a.a.b;
import java.util.Iterator;

abstract class p<F, T>
  implements Iterator<T>
{
  private Iterator<? extends F> cjV;
  
  p(Iterator<? extends F> paramIterator)
  {
    this.cjV = ((Iterator)b.checkNotNull(paramIterator));
  }
  
  abstract T aw(F paramF);
  
  public final boolean hasNext()
  {
    return this.cjV.hasNext();
  }
  
  public final T next()
  {
    return aw(this.cjV.next());
  }
  
  public final void remove()
  {
    this.cjV.remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.a.b.p
 * JD-Core Version:    0.7.0.1
 */