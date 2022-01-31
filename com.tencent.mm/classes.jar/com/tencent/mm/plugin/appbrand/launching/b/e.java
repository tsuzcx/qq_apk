package com.tencent.mm.plugin.appbrand.launching.b;

import a.f.b.j;
import a.l;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "Lcom/tencent/mm/plugin/appbrand/launching/links/AbsLinkOpener;", "()V", "handleResult", "", "url", "", "parsed", "Landroid/net/Uri;", "scene", "", "statExtras", "Landroid/os/Bundle;", "result", "Lcom/tencent/mm/plugin/appbrand/launching/links/AbsLinkOpener$HandleResult;", "plugin-appbrand-integration_release"})
public final class e
  extends a
{
  protected final void a(String paramString, Uri paramUri, a.a parama)
  {
    AppMethodBeat.i(134718);
    j.q(parama, "result");
    ab.i("MicroMsg.AppBrand.DebugCmdLinkOpener", "handleResult url[" + paramString + "], result[" + parama.name() + ']');
    AppMethodBeat.o(134718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.e
 * JD-Core Version:    0.7.0.1
 */