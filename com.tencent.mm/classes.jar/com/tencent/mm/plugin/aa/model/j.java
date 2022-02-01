package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class j
  implements f
{
  com.tencent.mm.vending.g.b iSR;
  long msgId = -1L;
  
  public final void init()
  {
    AppMethodBeat.i(63356);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(1530, this);
    AppMethodBeat.o(63356);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(63358);
    ad.i("MicroMsg.CloseAALogic", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.aa.model.cgi.e)paramn).iTp;
      ad.i("MicroMsg.CloseAALogic", "closeAA, response.retcode: %s", new Object[] { Integer.valueOf(paramString.dlw) });
      ad.d("MicroMsg.CloseAALogic", "closeAA, response.msgxml: %s", new Object[] { paramString.FpI });
      if (paramString.dlw == 0)
      {
        com.tencent.mm.vending.g.g.a(this.iSR, new Object[] { Boolean.TRUE });
        if ((!bt.isNullOrNil(paramString.FpI)) && (this.msgId > 0L) && (((com.tencent.mm.plugin.aa.model.cgi.e)paramn).scene == a.iSr)) {
          i.i(this.msgId, paramString.FpI);
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(407L, 21L, 1L, false);
        AppMethodBeat.o(63358);
        return;
      }
      if ((paramString.dlw > 0) && (!bt.isNullOrNil(paramString.paA)))
      {
        this.iSR.ee(paramString.paA);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(407L, 11L, 1L, false);
        AppMethodBeat.o(63358);
        return;
      }
      this.iSR.ee(Boolean.FALSE);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(407L, 23L, 1L, false);
      AppMethodBeat.o(63358);
      return;
    }
    this.iSR.ee(Boolean.FALSE);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(407L, 22L, 1L, false);
    AppMethodBeat.o(63358);
  }
  
  public final void unInit()
  {
    AppMethodBeat.i(63357);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(1530, this);
    AppMethodBeat.o(63357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.j
 * JD-Core Version:    0.7.0.1
 */