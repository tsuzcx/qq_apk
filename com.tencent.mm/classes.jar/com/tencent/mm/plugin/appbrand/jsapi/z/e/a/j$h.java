package com.tencent.mm.plugin.appbrand.jsapi.z.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$tryInit$1", "Lcom/tencent/mm/plugin/appbrand/dlna/IDlnaLogger;", "e", "", "tag", "", "msg", "i", "printErrStackTrace", "tr", "", "format", "luggage-xweb-ext_release"})
public final class j$h
  implements b
{
  public final void b(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(206498);
    k.h(paramString1, "tag");
    k.h(paramThrowable, "tr");
    k.h(paramString2, "format");
    ac.printErrStackTrace(paramString1, paramThrowable, paramString2, new Object[0]);
    AppMethodBeat.o(206498);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206500);
    k.h(paramString1, "tag");
    k.h(paramString2, "msg");
    ac.e(paramString1, paramString2);
    AppMethodBeat.o(206500);
  }
  
  public final void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206499);
    k.h(paramString1, "tag");
    k.h(paramString2, "msg");
    ac.i(paramString1, paramString2);
    AppMethodBeat.o(206499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.e.a.j.h
 * JD-Core Version:    0.7.0.1
 */