package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.sdk.platformtools.ab;

final class a$2
  implements com.tencent.mm.plugin.appbrand.k.a.a
{
  a$2(a parama, h paramh) {}
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(114375);
    ab.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: module name: %s progress: %s", new Object[] { this.hTF.hTE, paramc.toString() });
    this.hTF.mTotalSize = paramc.awc();
    a.a.a(this.hxk, this.hTF.hwp, "progressUpdate", this.hTF.hTE, paramc.getProgress(), paramc.awb(), paramc.awc());
    AppMethodBeat.o(114375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h.a.2
 * JD-Core Version:    0.7.0.1
 */