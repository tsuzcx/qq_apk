package com.tencent.mm.plugin.appbrand;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;

final class i$7
  implements i.b
{
  i$7(i parami, ConcurrentLinkedQueue paramConcurrentLinkedQueue, i.c paramc, i.b paramb) {}
  
  public final void done()
  {
    AppMethodBeat.i(86659);
    if (!this.gQf.remove(this.gQg))
    {
      d.e("MicroMsg.AppBrandRuntime", "[%s]prepare duplicate ready() called", new Object[] { this.gPY.mAppId });
      AppMethodBeat.o(86659);
      return;
    }
    if (this.gQf.isEmpty()) {
      this.gQh.done();
    }
    AppMethodBeat.o(86659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.7
 * JD-Core Version:    0.7.0.1
 */