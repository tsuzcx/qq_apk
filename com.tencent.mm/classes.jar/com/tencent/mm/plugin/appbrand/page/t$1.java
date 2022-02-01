package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

final class t$1
  implements Iterator<q>
{
  final ListIterator<q> kZs;
  
  t$1(t paramt)
  {
    AppMethodBeat.i(135020);
    this.kZs = t.b(this.kZt).listIterator();
    AppMethodBeat.o(135020);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(135021);
    boolean bool = this.kZs.hasNext();
    AppMethodBeat.o(135021);
    return bool;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(135022);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(135022);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.t.1
 * JD-Core Version:    0.7.0.1
 */