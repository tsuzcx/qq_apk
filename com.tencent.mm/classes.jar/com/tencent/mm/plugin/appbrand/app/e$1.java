package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.AppBrandOnOpReportStartEvent;
import com.tencent.mm.vending.g.f;

final class e$1
  implements com.tencent.mm.vending.c.a<Integer, Void>
{
  e$1(e parame, String paramString) {}
  
  private Integer auz()
  {
    AppMethodBeat.i(129238);
    if (!g.RJ().QU())
    {
      f.dQn().cK(new com.tencent.mm.model.b());
      AppMethodBeat.o(129238);
      return null;
    }
    AppBrandOpReportLogic.AppBrandOnOpReportStartEvent.CK(this.val$appId);
    com.tencent.mm.vending.g.b localb = f.dQs();
    g.RK().eHt.a(1345, new e.1.1(this, localb));
    AppMethodBeat.o(129238);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.e.1
 * JD-Core Version:    0.7.0.1
 */