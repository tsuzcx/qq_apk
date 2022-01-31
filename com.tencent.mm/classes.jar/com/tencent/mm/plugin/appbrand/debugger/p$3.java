package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

final class p$3
  implements Runnable
{
  p$3(p paramp) {}
  
  public final void run()
  {
    AppMethodBeat.i(101859);
    LinkedList localLinkedList = new LinkedList();
    synchronized (p.a(this.hml).mLock)
    {
      localLinkedList.addAll(p.b(this.hml));
      p.b(this.hml).clear();
      p.c(this.hml);
      p.a(this.hml, localLinkedList);
      AppMethodBeat.o(101859);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.p.3
 * JD-Core Version:    0.7.0.1
 */