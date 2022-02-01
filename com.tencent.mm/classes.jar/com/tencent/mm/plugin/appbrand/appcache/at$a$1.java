package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.luggage.sdk.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.task.n;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.c;

final class at$a$1
  implements Runnable
{
  at$a$1(at.a parama, WxaPkgWrappingInfo paramWxaPkgWrappingInfo) {}
  
  public final void run()
  {
    AppMethodBeat.i(44330);
    final b localb = new b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(247674);
        new at.b(at.a.1.this.nFU).bFz();
        AppMethodBeat.o(247674);
      }
    }, 2);
    h.e(n.qRS).c(new a() {}).ieF();
    h.e(n.qRT).c(new a() {}).ieF();
    AppMethodBeat.o(44330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.at.a.1
 * JD-Core Version:    0.7.0.1
 */