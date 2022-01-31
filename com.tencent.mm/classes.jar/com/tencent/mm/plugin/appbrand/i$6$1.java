package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

final class i$6$1
  implements Runnable
{
  i$6$1(i.6 param6) {}
  
  public final void run()
  {
    AppMethodBeat.i(86657);
    i locali = this.gQe.gPY;
    i.d locald = this.gQe.gQd;
    ConcurrentLinkedQueue localConcurrentLinkedQueue = new ConcurrentLinkedQueue(locali.gPU);
    locali.gPU = new LinkedList();
    Iterator localIterator = localConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      i.c localc = (i.c)localIterator.next();
      localc.gQk = new i.7(locali, localConcurrentLinkedQueue, localc, locald);
      localc.prepare();
    }
    AppMethodBeat.o(86657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.6.1
 * JD-Core Version:    0.7.0.1
 */