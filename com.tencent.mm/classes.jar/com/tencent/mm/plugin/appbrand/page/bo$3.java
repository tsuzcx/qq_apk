package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

final class bo$3
  implements Runnable
{
  bo$3(bo parambo, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    AppMethodBeat.i(147529);
    Iterator localIterator = this.mfI.iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    AppMethodBeat.o(147529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bo.3
 * JD-Core Version:    0.7.0.1
 */