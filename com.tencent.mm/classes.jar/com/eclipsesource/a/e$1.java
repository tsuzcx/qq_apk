package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

final class e$1
  implements Iterator<e.b>
{
  e$1(e parame, Iterator paramIterator1, Iterator paramIterator2) {}
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(74717);
    boolean bool = this.aZQ.hasNext();
    AppMethodBeat.o(74717);
    return bool;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(74718);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(74718);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.a.e.1
 * JD-Core Version:    0.7.0.1
 */