package a.j.b.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

final class a$a<E>
  implements Iterator<E>
{
  private a<E> CFq;
  
  public a$a(a<E> parama)
  {
    this.CFq = parama;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(122979);
    if (a.a(this.CFq) > 0)
    {
      AppMethodBeat.o(122979);
      return true;
    }
    AppMethodBeat.o(122979);
    return false;
  }
  
  public final E next()
  {
    Object localObject = this.CFq.first;
    this.CFq = this.CFq.CFp;
    return localObject;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(122980);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(122980);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.d.a.a
 * JD-Core Version:    0.7.0.1
 */