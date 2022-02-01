package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.b;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class q$4
  implements m.b
{
  public q$4(q paramq) {}
  
  public final void a(String paramString, m.c paramc)
  {
    AppMethodBeat.i(197258);
    boolean bool = Boolean.parseBoolean(paramString);
    if (bool)
    {
      this.jAg.jAd.jAj = paramc.cYI;
      this.jAg.jAd.jAk = paramc.cYJ;
      this.jAg.jAd.hNZ = paramc;
    }
    ad.i("MicroMsg.AppBrandService", "notifyWxConfigReadyIfNeed end by AddonV8, applied=%b, hash=%d, reportWxConfigInjectEnd cost=%dms", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.jAg.aXC()), Long.valueOf(this.jAg.jAd.jAk - this.jAg.jAd.jAj) });
    this.jAg.a(this.jAg.jAd.jAi, this.jAg.jAd.jAj, this.jAg.jAd.jAk, this.jAg.jAd.hNZ);
    AppMethodBeat.o(197258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.4
 * JD-Core Version:    0.7.0.1
 */