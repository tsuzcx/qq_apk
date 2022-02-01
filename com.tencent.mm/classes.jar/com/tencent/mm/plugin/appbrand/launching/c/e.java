package com.tencent.mm.plugin.appbrand.launching.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "Lcom/tencent/mm/plugin/appbrand/launching/links/AbsLinkOpener;", "()V", "handleResult", "", "url", "", "parsed", "Landroid/net/Uri;", "scene", "", "statExtras", "Landroid/os/Bundle;", "result", "Lcom/tencent/mm/plugin/appbrand/launching/links/AbsLinkOpener$HandleResult;", "plugin-appbrand-integration_release"})
public final class e
  extends a
{
  protected final void a(String paramString, Uri paramUri, a.a parama)
  {
    AppMethodBeat.i(50791);
    p.h(parama, "result");
    Log.i("MicroMsg.AppBrand.DebugCmdLinkOpener", "handleResult url[" + paramString + "], result[" + parama.name() + ']');
    AppMethodBeat.o(50791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c.e
 * JD-Core Version:    0.7.0.1
 */