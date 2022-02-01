package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

final class b$1
  implements Iterator<h>
{
  b$1(b paramb, Iterator paramIterator) {}
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(74684);
    boolean bool = this.cBM.hasNext();
    AppMethodBeat.o(74684);
    return bool;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(74685);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(74685);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.eclipsesource.a.b.1
 * JD-Core Version:    0.7.0.1
 */