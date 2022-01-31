package com.tencent.mm.plugin.appbrand.dynamic.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.plugin.appbrand.t.n.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

final class e$4
  implements n.a
{
  e$4(WxaWidgetContext paramWxaWidgetContext) {}
  
  public final void bU(String paramString)
  {
    AppMethodBeat.i(10965);
    v.kS(15);
    af localaf = new af().fB(u.qn(this.hqD.getId()));
    localaf.cUl = u.qm(this.hqD.getId());
    localaf.cUh = 7L;
    localaf.cUj = 2L;
    localaf = localaf.fA(this.hqD.getId());
    localaf.cUi = System.currentTimeMillis();
    localaf.ake();
    h.qsU.idkeyStat(636L, 5L, 1L, false);
    ab.e("MicroMsg.PreloadOptimizer", "Inject External widget Script Failed: %s", new Object[] { paramString });
    AppMethodBeat.o(10965);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(141927);
    v.kS(14);
    paramString = new af().fB(u.qn(this.hqD.getId()));
    paramString.cUl = u.qm(this.hqD.getId());
    paramString.cUh = 7L;
    paramString.cUj = 1L;
    paramString = paramString.fA(this.hqD.getId());
    paramString.cUi = System.currentTimeMillis();
    paramString.fC(at.gU(ah.getContext())).ake();
    h.qsU.idkeyStat(636L, 4L, 1L, false);
    j.azD().Bc(this.hqD.getId());
    AppMethodBeat.o(141927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.e.4
 * JD-Core Version:    0.7.0.1
 */