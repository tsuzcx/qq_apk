package a.j.b.a.c.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class h$a<T>
  implements Iterator<T>
{
  private static final a CFg;
  
  static
  {
    AppMethodBeat.i(122950);
    CFg = new a();
    AppMethodBeat.o(122950);
  }
  
  public static <T> a<T> eoY()
  {
    return CFg;
  }
  
  public final boolean hasNext()
  {
    return false;
  }
  
  public final T next()
  {
    AppMethodBeat.i(122948);
    NoSuchElementException localNoSuchElementException = new NoSuchElementException();
    AppMethodBeat.o(122948);
    throw localNoSuchElementException;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(122949);
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(122949);
    throw localIllegalStateException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.n.h.a
 * JD-Core Version:    0.7.0.1
 */