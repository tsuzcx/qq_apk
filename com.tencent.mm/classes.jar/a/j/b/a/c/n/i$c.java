package a.j.b.a.c.n;

import a.f.b.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class i$c<T>
  implements d, Iterator<T>
{
  private final T BNq;
  private boolean BNz;
  
  public i$c(T paramT)
  {
    this.BNq = paramT;
    this.BNz = true;
  }
  
  public final boolean hasNext()
  {
    return this.BNz;
  }
  
  public final T next()
  {
    AppMethodBeat.i(122967);
    if (this.BNz)
    {
      this.BNz = false;
      localObject = this.BNq;
      AppMethodBeat.o(122967);
      return localObject;
    }
    Object localObject = (Throwable)new NoSuchElementException();
    AppMethodBeat.o(122967);
    throw ((Throwable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.n.i.c
 * JD-Core Version:    0.7.0.1
 */