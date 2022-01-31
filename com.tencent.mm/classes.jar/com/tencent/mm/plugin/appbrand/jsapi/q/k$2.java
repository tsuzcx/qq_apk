package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.k.a;
import java.util.List;

final class k$2
  implements k.a
{
  k$2(k paramk) {}
  
  public final boolean j(Object... arg1)
  {
    AppMethodBeat.i(126398);
    synchronized (this.hZe.hZc)
    {
      if (this.hZe.hZc.isEmpty())
      {
        AppMethodBeat.o(126398);
        return false;
      }
      this.hZe.hZd.run();
      AppMethodBeat.o(126398);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.k.2
 * JD-Core Version:    0.7.0.1
 */