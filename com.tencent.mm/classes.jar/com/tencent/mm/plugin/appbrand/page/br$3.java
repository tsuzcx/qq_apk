package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

final class br$3
  implements Runnable
{
  br$3(br parambr, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    AppMethodBeat.i(147529);
    Iterator localIterator = this.nuy.iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    AppMethodBeat.o(147529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.br.3
 * JD-Core Version:    0.7.0.1
 */