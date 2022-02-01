package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.b;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.sdk.platformtools.ad;

final class q$2
  implements m.b
{
  q$2(q paramq, String paramString) {}
  
  public final void a(String paramString, m.c paramc)
  {
    AppMethodBeat.i(176537);
    ad.i("MicroMsg.AppBrandService", "injectConfig end by AddonV8, cost=%dms, hash=%d", new Object[] { Long.valueOf(paramc.cYJ - paramc.cYI), Integer.valueOf(this.jAg.aXC()) });
    this.jAg.jAd = new q.a((byte)0);
    this.jAg.jAd.jAi = this.jAf;
    this.jAg.jAd.jAj = paramc.cYI;
    this.jAg.jAd.jAk = paramc.cYJ;
    this.jAg.jAd.hNZ = paramc;
    AppMethodBeat.o(176537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.2
 * JD-Core Version:    0.7.0.1
 */