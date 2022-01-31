package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "msg", "Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/MsgWrapper;", "kotlin.jvm.PlatformType", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "handleMsg"})
final class b$c
  implements d.a
{
  b$c(b paramb) {}
  
  public final boolean b(i parami)
  {
    AppMethodBeat.i(154570);
    if (j.e(parami.vrQ, "notifyPageInfo"))
    {
      ab.v(b.b(this.kdJ), "handleMsg " + parami.vrQ);
      b localb = this.kdJ;
      j.p(parami, "msg");
      b.a(localb, parami);
      AppMethodBeat.o(154570);
      return true;
    }
    AppMethodBeat.o(154570);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.b.c
 * JD-Core Version:    0.7.0.1
 */