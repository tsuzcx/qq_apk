package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.g;

public final class k
  implements com.tencent.mm.am.h
{
  long msgId = -1L;
  com.tencent.mm.vending.g.b pGz;
  
  public final void init()
  {
    AppMethodBeat.i(63356);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1530, this);
    AppMethodBeat.o(63356);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(63358);
    Log.i("MicroMsg.CloseAALogic", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.aa.model.cgi.e)paramp).pGZ;
      Log.i("MicroMsg.CloseAALogic", "closeAA, response.retcode: %s", new Object[] { Integer.valueOf(paramString.hAV) });
      Log.d("MicroMsg.CloseAALogic", "closeAA, response.msgxml: %s", new Object[] { paramString.YzN });
      if (paramString.hAV == 0)
      {
        g.a(this.pGz, new Object[] { Boolean.TRUE });
        if ((!Util.isNullOrNil(paramString.YzN)) && (this.msgId > 0L) && (((com.tencent.mm.plugin.aa.model.cgi.e)paramp).scene == b.pGa)) {
          j.m(this.msgId, paramString.YzN);
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 21L, 1L, false);
        AppMethodBeat.o(63358);
        return;
      }
      if ((paramString.hAV > 0) && (!Util.isNullOrNil(paramString.wYI)))
      {
        this.pGz.gM(paramString.wYI);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 11L, 1L, false);
        AppMethodBeat.o(63358);
        return;
      }
      this.pGz.gM(Boolean.FALSE);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 23L, 1L, false);
      AppMethodBeat.o(63358);
      return;
    }
    this.pGz.gM(Boolean.FALSE);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 22L, 1L, false);
    AppMethodBeat.o(63358);
  }
  
  public final void unInit()
  {
    AppMethodBeat.i(63357);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(1530, this);
    AppMethodBeat.o(63357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.k
 * JD-Core Version:    0.7.0.1
 */