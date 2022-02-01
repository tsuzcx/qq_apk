package com.tencent.mm.plugin.appbrand.jsapi.al.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$tryInit$1", "Lcom/tencent/mm/plugin/appbrand/dlna/IDlnaLogger;", "e", "", "tag", "", "msg", "i", "printErrStackTrace", "tr", "", "format", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$f
  implements b
{
  public final void a(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(327194);
    s.u(paramString1, "tag");
    s.u(paramThrowable, "tr");
    s.u(paramString2, "format");
    Log.printErrStackTrace(paramString1, paramThrowable, paramString2, new Object[0]);
    AppMethodBeat.o(327194);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(327204);
    s.u(paramString1, "tag");
    s.u(paramString2, "msg");
    Log.e(paramString1, paramString2);
    AppMethodBeat.o(327204);
  }
  
  public final void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(327199);
    s.u(paramString1, "tag");
    s.u(paramString2, "msg");
    Log.i(paramString1, paramString2);
    AppMethodBeat.o(327199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.e.a.i.f
 * JD-Core Version:    0.7.0.1
 */