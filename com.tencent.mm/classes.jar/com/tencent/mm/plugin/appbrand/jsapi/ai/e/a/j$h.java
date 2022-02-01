package com.tencent.mm.plugin.appbrand.jsapi.ai.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$tryInit$1", "Lcom/tencent/mm/plugin/appbrand/dlna/IDlnaLogger;", "e", "", "tag", "", "msg", "i", "printErrStackTrace", "tr", "", "format", "luggage-xweb-ext_release"})
public final class j$h
  implements b
{
  public final void a(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(226298);
    p.k(paramString1, "tag");
    p.k(paramThrowable, "tr");
    p.k(paramString2, "format");
    Log.printErrStackTrace(paramString1, paramThrowable, paramString2, new Object[0]);
    AppMethodBeat.o(226298);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(226302);
    p.k(paramString1, "tag");
    p.k(paramString2, "msg");
    Log.e(paramString1, paramString2);
    AppMethodBeat.o(226302);
  }
  
  public final void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(226300);
    p.k(paramString1, "tag");
    p.k(paramString2, "msg");
    Log.i(paramString1, paramString2);
    AppMethodBeat.o(226300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.j.h
 * JD-Core Version:    0.7.0.1
 */