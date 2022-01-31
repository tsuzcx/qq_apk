package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.plugin.appbrand.page.b;
import com.tencent.mm.plugin.appbrand.page.b.a;

final class k$1
  implements Runnable
{
  k$1(k paramk, i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(74746);
    if (this.hNh.hNg != null) {
      this.hNh.hNg.dismiss();
    }
    this.hNh.hNg = b.E(this.gWQ).a(b.a.iuX);
    this.hNh.hNf = System.currentTimeMillis();
    AppMethodBeat.o(74746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.k.1
 * JD-Core Version:    0.7.0.1
 */