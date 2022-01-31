package com.tencent.mm.plugin.appbrand.jsapi;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cz;
import com.tencent.mm.g.b.a.cz.a;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.model.i;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/jsapi/JsApiGetMenuButtonBoundingClientRectWithReport$invoke$1$1"})
final class al$a
  implements Runnable
{
  al$a(long paramLong1, ak.a parama, String paramString, al paramal, r paramr, long paramLong2) {}
  
  public final void run()
  {
    AppMethodBeat.i(134640);
    cz localcz = new cz();
    Object localObject = a.EM(this.hxU.getAppId());
    if (localObject == null)
    {
      AppMethodBeat.o(134640);
      return;
    }
    localcz.ik(((QualitySessionRuntime)localObject).appId);
    localcz.a(cz.a.hm(((QualitySessionRuntime)localObject).iIF));
    localcz.fB(((QualitySessionRuntime)localObject).apptype);
    localcz.fC(this.hxQ);
    localcz.fD(((QualitySessionRuntime)localObject).scene);
    localObject = this.hxR;
    long l;
    if (localObject == null) {
      l = 0L;
    }
    for (;;)
    {
      localcz.fE(l);
      localcz.il(i.EJ(this.hxS));
      localcz.ake();
      AppMethodBeat.o(134640);
      return;
      switch (am.bLo[localObject.ordinal()])
      {
      default: 
        break;
      case 1: 
        l = 1L;
        break;
      case 2: 
        l = 2L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.a
 * JD-Core Version:    0.7.0.1
 */