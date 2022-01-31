package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

final class e$1
  implements Iterator<e.b>
{
  e$1(e parame, Iterator paramIterator1, Iterator paramIterator2) {}
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(70530);
    boolean bool = this.atX.hasNext();
    AppMethodBeat.o(70530);
    return bool;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(70531);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(70531);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.eclipsesource.a.e.1
 * JD-Core Version:    0.7.0.1
 */