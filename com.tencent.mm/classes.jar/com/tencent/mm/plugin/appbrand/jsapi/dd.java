package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.utils.e.a;
import com.tencent.mm.vfs.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"loadAppBrandImage", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "path", "", "md5", "onLoadCallback", "Lcom/tencent/mm/plugin/appbrand/utils/AppBrandFileLoadHelper$IOnLoadCallback;", "plugin-appbrand-integration_release"})
public final class dd
{
  public static final void a(e parame, String paramString, e.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(273272);
    p.k(parame, "component");
    p.k(paramString, "path");
    p.k(parama, "onLoadCallback");
    if ((n.M(paramString, "http://", false)) || (n.M(paramString, "https://", false)))
    {
      com.tencent.mm.plugin.appbrand.utils.e.a(parame, paramString, null, parama);
      AppMethodBeat.o(273272);
      return;
    }
    r localr = parame.getFileSystem();
    parame = localObject;
    if (localr != null)
    {
      paramString = localr.adL(paramString);
      parame = localObject;
      if (paramString != null) {
        parame = paramString.bOF();
      }
    }
    parama.dR(parame);
    AppMethodBeat.o(273272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.dd
 * JD-Core Version:    0.7.0.1
 */