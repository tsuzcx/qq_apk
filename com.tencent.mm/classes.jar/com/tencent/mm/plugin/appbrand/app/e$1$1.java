package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.c;

final class e$1$1
  implements f
{
  e$1$1(e.1 param1, com.tencent.mm.vending.g.b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(129237);
    if (c.b(paramm, this.gSN.val$appId))
    {
      g.RK().eHt.b(1345, this);
      try
      {
        this.bDR.C(new Object[] { Integer.valueOf(c.f(paramm)) });
        AppMethodBeat.o(129237);
        return;
      }
      catch (Exception paramString)
      {
        this.bDR.cK(paramString);
      }
    }
    AppMethodBeat.o(129237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.e.1.1
 * JD-Core Version:    0.7.0.1
 */