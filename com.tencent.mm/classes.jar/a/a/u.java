package a.a;

import a.f.b.a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ListIterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/collections/EmptyIterator;", "", "", "()V", "hasNext", "", "hasPrevious", "next", "nextIndex", "", "previous", "previousIndex", "kotlin-stdlib"})
public final class u
  implements a, ListIterator
{
  public static final u BMw;
  
  static
  {
    AppMethodBeat.i(56184);
    BMw = new u();
    AppMethodBeat.o(56184);
  }
  
  public final boolean hasNext()
  {
    return false;
  }
  
  public final boolean hasPrevious()
  {
    return false;
  }
  
  public final int nextIndex()
  {
    return 0;
  }
  
  public final int previousIndex()
  {
    return -1;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(56185);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(56185);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.a.u
 * JD-Core Version:    0.7.0.1
 */