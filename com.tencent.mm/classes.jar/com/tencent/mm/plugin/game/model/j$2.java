package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;

final class j$2
  implements Runnable
{
  j$2(j paramj, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(111248);
    synchronized (j.bGi())
    {
      Iterator localIterator = j.bGi().iterator();
      if (localIterator.hasNext()) {
        ((j.a)localIterator.next()).f(this.val$event, this.val$packageName, this.nmF);
      }
    }
    AppMethodBeat.o(111248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.j.2
 * JD-Core Version:    0.7.0.1
 */