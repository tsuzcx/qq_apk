package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

final class x$2
  implements Iterator<String>
{
  Iterator<String> Cry;
  
  x$2(x paramx)
  {
    AppMethodBeat.i(121674);
    this.Cry = x.a(this.CsA).iterator();
    AppMethodBeat.o(121674);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(121675);
    boolean bool = this.Cry.hasNext();
    AppMethodBeat.o(121675);
    return bool;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(121676);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(121676);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.c.g.x.2
 * JD-Core Version:    0.7.0.1
 */