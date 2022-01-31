package com.tencent.luggage.sdk.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.page.v;

public final class c$3
  implements Runnable
{
  public c$3(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(140686);
    if (this.bDQ.iuy.getWebScrollY() == 0)
    {
      AppMethodBeat.o(140686);
      return;
    }
    c.a(this.bDQ);
    this.bDQ.iuy.setVerticalScrollBarEnabled(false);
    AppMethodBeat.o(140686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.3
 * JD-Core Version:    0.7.0.1
 */