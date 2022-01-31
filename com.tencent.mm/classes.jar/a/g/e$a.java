package a.g;

import a.d.a.b;
import java.util.Iterator;

public final class e$a
  implements a.d.b.a.a, Iterator<R>
{
  private final Iterator<T> xoI;
  
  e$a()
  {
    this.xoI = localObject.xoG.iterator();
  }
  
  public final boolean hasNext()
  {
    return this.xoI.hasNext();
  }
  
  public final R next()
  {
    return this.xoJ.xoH.W(this.xoI.next());
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.g.e.a
 * JD-Core Version:    0.7.0.1
 */