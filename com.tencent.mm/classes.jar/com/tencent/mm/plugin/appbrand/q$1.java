package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.n.a;
import com.tencent.mm.plugin.appbrand.jsruntime.n.b;
import com.tencent.mm.sdk.platformtools.ad;

final class q$1
  implements n.a
{
  q$1(q paramq, String paramString) {}
  
  public final void a(n.b paramb)
  {
    AppMethodBeat.i(176536);
    ad.i("MicroMsg.AppBrandService", "injectConfig end by AddonDirectEvaluation, cost=%dms, hash=%d", new Object[] { Long.valueOf(paramb.cYJ - paramb.cYI), Integer.valueOf(this.jAg.aXC()) });
    this.jAg.jAd = new q.a((byte)0);
    this.jAg.jAd.jAi = this.jAf;
    this.jAg.jAd.jAj = paramb.cYI;
    this.jAg.jAd.jAk = paramb.cYJ;
    this.jAg.jAd.hNZ = paramb;
    AppMethodBeat.o(176536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.1
 * JD-Core Version:    0.7.0.1
 */