package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

final class bn$3
  implements Runnable
{
  bn$3(bn parambn, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    AppMethodBeat.i(147529);
    Iterator localIterator = this.mkd.iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    AppMethodBeat.o(147529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bn.3
 * JD-Core Version:    0.7.0.1
 */