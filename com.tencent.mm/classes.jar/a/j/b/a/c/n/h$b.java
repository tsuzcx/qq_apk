package a.j.b.a.c.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ConcurrentModificationException;

final class h$b
  extends h.c<E>
{
  private final int CFh;
  
  public h$b(h paramh)
  {
    super((byte)0);
    AppMethodBeat.i(122951);
    this.CFh = h.a(paramh);
    AppMethodBeat.o(122951);
  }
  
  protected final E eoZ()
  {
    AppMethodBeat.i(122952);
    Object localObject = h.b(this.CFi);
    AppMethodBeat.o(122952);
    return localObject;
  }
  
  protected final void epa()
  {
    AppMethodBeat.i(122953);
    if (h.c(this.CFi) != this.CFh)
    {
      ConcurrentModificationException localConcurrentModificationException = new ConcurrentModificationException("ModCount: " + h.d(this.CFi) + "; expected: " + this.CFh);
      AppMethodBeat.o(122953);
      throw localConcurrentModificationException;
    }
    AppMethodBeat.o(122953);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(122954);
    epa();
    this.CFi.clear();
    AppMethodBeat.o(122954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.n.h.b
 * JD-Core Version:    0.7.0.1
 */