package com.tencent.mm.plugin.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class i
  implements com.tencent.mm.ai.f
{
  long cpO = -1L;
  com.tencent.mm.vending.g.b fsR;
  
  public final void aoR()
  {
    AppMethodBeat.i(40626);
    g.RM();
    g.RK().eHt.b(1530, this);
    AppMethodBeat.o(40626);
  }
  
  public final void init()
  {
    AppMethodBeat.i(40625);
    g.RM();
    g.RK().eHt.a(1530, this);
    AppMethodBeat.o(40625);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(40627);
    ab.i("MicroMsg.CloseAALogic", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.aa.a.a.e)paramm).gor;
      ab.i("MicroMsg.CloseAALogic", "closeAA, response.retcode: %s", new Object[] { Integer.valueOf(paramString.cnK) });
      ab.d("MicroMsg.CloseAALogic", "closeAA, response.msgxml: %s", new Object[] { paramString.wjY });
      if (paramString.cnK == 0)
      {
        com.tencent.mm.vending.g.f.a(this.fsR, new Object[] { Boolean.TRUE });
        if ((!bo.isNullOrNil(paramString.wjY)) && (this.cpO > 0L) && (((com.tencent.mm.plugin.aa.a.a.e)paramm).scene == a.gnz)) {
          h.h(this.cpO, paramString.wjY);
        }
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(407L, 21L, 1L, false);
        AppMethodBeat.o(40627);
        return;
      }
      if ((paramString.cnK > 0) && (!bo.isNullOrNil(paramString.kNv)))
      {
        this.fsR.cK(paramString.kNv);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(407L, 11L, 1L, false);
        AppMethodBeat.o(40627);
        return;
      }
      this.fsR.cK(Boolean.FALSE);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(407L, 23L, 1L, false);
      AppMethodBeat.o(40627);
      return;
    }
    this.fsR.cK(Boolean.FALSE);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(407L, 22L, 1L, false);
    AppMethodBeat.o(40627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.i
 * JD-Core Version:    0.7.0.1
 */