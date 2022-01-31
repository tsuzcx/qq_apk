package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

final class MMToClientEvent$1
  implements Runnable
{
  MMToClientEvent$1(MMToClientEvent paramMMToClientEvent, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(86936);
    Iterator localIterator = this.hwy.iterator();
    while (localIterator.hasNext()) {
      ((MMToClientEvent.c)localIterator.next()).aZ(MMToClientEvent.a(this.hwz));
    }
    AppMethodBeat.o(86936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.1
 * JD-Core Version:    0.7.0.1
 */