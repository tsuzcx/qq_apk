package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.g.d;

final class i$1
  implements Runnable
{
  i$1(i parami, c paramc, String paramString, i.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(108062);
    d.post(new i.1.1(this), "stopScanServices");
    AppMethodBeat.o(108062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.i.1
 * JD-Core Version:    0.7.0.1
 */