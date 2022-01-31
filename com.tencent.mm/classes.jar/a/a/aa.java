package a.a;

import a.f.b.a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/collections/IndexingIterator;", "T", "", "Lkotlin/collections/IndexedValue;", "iterator", "(Ljava/util/Iterator;)V", "index", "", "hasNext", "", "next", "kotlin-stdlib"})
public final class aa<T>
  implements a, Iterator<y<? extends T>>
{
  private final Iterator<T> BMB;
  private int index;
  
  public aa(Iterator<? extends T> paramIterator)
  {
    AppMethodBeat.i(56027);
    this.BMB = paramIterator;
    AppMethodBeat.o(56027);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(56025);
    boolean bool = this.BMB.hasNext();
    AppMethodBeat.o(56025);
    return bool;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(56028);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(56028);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.a.aa
 * JD-Core Version:    0.7.0.1
 */