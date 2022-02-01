package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.luggage.sdk.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.task.l;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.c;

final class au$a$1
  implements Runnable
{
  au$a$1(au.a parama, ICommLibReader paramICommLibReader) {}
  
  public final void run()
  {
    AppMethodBeat.i(44330);
    final b localb = new b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(320348);
        new au.b(au.a.1.this.qFN).ceW();
        AppMethodBeat.o(320348);
      }
    }, 2);
    h.e(l.tWw).c(new a() {}).jJM();
    h.e(l.tWx).c(new a() {}).jJM();
    AppMethodBeat.o(44330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.au.a.1
 * JD-Core Version:    0.7.0.1
 */