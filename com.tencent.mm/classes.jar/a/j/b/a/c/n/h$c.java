package a.j.b.a.c.n;

import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class h$c<T>
  implements Iterator<T>
{
  private boolean CFj;
  
  protected abstract T eoZ();
  
  protected abstract void epa();
  
  public final boolean hasNext()
  {
    return !this.CFj;
  }
  
  public final T next()
  {
    if (this.CFj) {
      throw new NoSuchElementException();
    }
    this.CFj = true;
    epa();
    return eoZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.n.h.c
 * JD-Core Version:    0.7.0.1
 */