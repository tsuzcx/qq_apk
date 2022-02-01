package com.tencent.mm.plugin.appbrand.jsapi.ad.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$tryInit$1", "Lcom/tencent/mm/plugin/appbrand/dlna/IDlnaLogger;", "e", "", "tag", "", "msg", "i", "printErrStackTrace", "tr", "", "format", "luggage-xweb-ext_release"})
public final class j$h
  implements b
{
  public final void b(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(220394);
    p.h(paramString1, "tag");
    p.h(paramThrowable, "tr");
    p.h(paramString2, "format");
    ae.printErrStackTrace(paramString1, paramThrowable, paramString2, new Object[0]);
    AppMethodBeat.o(220394);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220396);
    p.h(paramString1, "tag");
    p.h(paramString2, "msg");
    ae.e(paramString1, paramString2);
    AppMethodBeat.o(220396);
  }
  
  public final void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220395);
    p.h(paramString1, "tag");
    p.h(paramString2, "msg");
    ae.i(paramString1, paramString2);
    AppMethodBeat.o(220395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.e.a.j.h
 * JD-Core Version:    0.7.0.1
 */