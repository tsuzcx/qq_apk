package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public final class j
  implements com.tencent.mm.an.i
{
  b mJR;
  long msgId = -1L;
  
  public final void init()
  {
    AppMethodBeat.i(63356);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(1530, this);
    AppMethodBeat.o(63356);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63358);
    Log.i("MicroMsg.CloseAALogic", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.aa.model.cgi.e)paramq).mKr;
      Log.i("MicroMsg.CloseAALogic", "closeAA, response.retcode: %s", new Object[] { Integer.valueOf(paramString.fwx) });
      Log.d("MicroMsg.CloseAALogic", "closeAA, response.msgxml: %s", new Object[] { paramString.RDk });
      if (paramString.fwx == 0)
      {
        g.a(this.mJR, new Object[] { Boolean.TRUE });
        if ((!Util.isNullOrNil(paramString.RDk)) && (this.msgId > 0L) && (((com.tencent.mm.plugin.aa.model.cgi.e)paramq).scene == a.mJr)) {
          i.k(this.msgId, paramString.RDk);
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(407L, 21L, 1L, false);
        AppMethodBeat.o(63358);
        return;
      }
      if ((paramString.fwx > 0) && (!Util.isNullOrNil(paramString.tVo)))
      {
        this.mJR.eo(paramString.tVo);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(407L, 11L, 1L, false);
        AppMethodBeat.o(63358);
        return;
      }
      this.mJR.eo(Boolean.FALSE);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(407L, 23L, 1L, false);
      AppMethodBeat.o(63358);
      return;
    }
    this.mJR.eo(Boolean.FALSE);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(407L, 22L, 1L, false);
    AppMethodBeat.o(63358);
  }
  
  public final void unInit()
  {
    AppMethodBeat.i(63357);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(1530, this);
    AppMethodBeat.o(63357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.j
 * JD-Core Version:    0.7.0.1
 */