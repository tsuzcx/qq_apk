package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ListIterator;

final class x$1
  implements ListIterator<String>
{
  ListIterator<String> Csz;
  
  x$1(x paramx, int paramInt)
  {
    AppMethodBeat.i(121664);
    this.Csz = x.a(this.CsA).listIterator(this.val$index);
    AppMethodBeat.o(121664);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(121665);
    boolean bool = this.Csz.hasNext();
    AppMethodBeat.o(121665);
    return bool;
  }
  
  public final boolean hasPrevious()
  {
    AppMethodBeat.i(121666);
    boolean bool = this.Csz.hasPrevious();
    AppMethodBeat.o(121666);
    return bool;
  }
  
  public final int nextIndex()
  {
    AppMethodBeat.i(121667);
    int i = this.Csz.nextIndex();
    AppMethodBeat.o(121667);
    return i;
  }
  
  public final int previousIndex()
  {
    AppMethodBeat.i(121668);
    int i = this.Csz.previousIndex();
    AppMethodBeat.o(121668);
    return i;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(121669);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(121669);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.g.x.1
 * JD-Core Version:    0.7.0.1
 */