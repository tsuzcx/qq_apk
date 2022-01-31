package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.sdk.platformtools.al;

final class k$2
  implements Runnable
{
  k$2(k paramk) {}
  
  public final void run()
  {
    AppMethodBeat.i(74748);
    if (this.hNh.hNg == null)
    {
      AppMethodBeat.o(74748);
      return;
    }
    long l = System.currentTimeMillis() - this.hNh.hNf;
    if (l < 3000L)
    {
      al.p(new k.2.1(this), 3000L - l);
      AppMethodBeat.o(74748);
      return;
    }
    this.hNh.hNg.dismiss();
    AppMethodBeat.o(74748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.k.2
 * JD-Core Version:    0.7.0.1
 */