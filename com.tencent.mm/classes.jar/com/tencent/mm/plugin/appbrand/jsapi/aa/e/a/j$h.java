package com.tencent.mm.plugin.appbrand.jsapi.aa.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$tryInit$1", "Lcom/tencent/mm/plugin/appbrand/dlna/IDlnaLogger;", "e", "", "tag", "", "msg", "i", "printErrStackTrace", "tr", "", "format", "luggage-xweb-ext_release"})
public final class j$h
  implements b
{
  public final void b(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(195127);
    k.h(paramString1, "tag");
    k.h(paramThrowable, "tr");
    k.h(paramString2, "format");
    ad.printErrStackTrace(paramString1, paramThrowable, paramString2, new Object[0]);
    AppMethodBeat.o(195127);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195129);
    k.h(paramString1, "tag");
    k.h(paramString2, "msg");
    ad.e(paramString1, paramString2);
    AppMethodBeat.o(195129);
  }
  
  public final void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195128);
    k.h(paramString1, "tag");
    k.h(paramString2, "msg");
    ad.i(paramString1, paramString2);
    AppMethodBeat.o(195128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.j.h
 * JD-Core Version:    0.7.0.1
 */