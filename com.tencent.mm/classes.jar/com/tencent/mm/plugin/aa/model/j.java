package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class j
  implements com.tencent.mm.ak.i
{
  com.tencent.mm.vending.g.b jSE;
  long msgId = -1L;
  
  public final void init()
  {
    AppMethodBeat.i(63356);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(1530, this);
    AppMethodBeat.o(63356);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63358);
    Log.i("MicroMsg.CloseAALogic", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.aa.model.cgi.e)paramq).jTd;
      Log.i("MicroMsg.CloseAALogic", "closeAA, response.retcode: %s", new Object[] { Integer.valueOf(paramString.dDN) });
      Log.d("MicroMsg.CloseAALogic", "closeAA, response.msgxml: %s", new Object[] { paramString.KBu });
      if (paramString.dDN == 0)
      {
        com.tencent.mm.vending.g.g.a(this.jSE, new Object[] { Boolean.TRUE });
        if ((!Util.isNullOrNil(paramString.KBu)) && (this.msgId > 0L) && (((com.tencent.mm.plugin.aa.model.cgi.e)paramq).scene == a.jSe)) {
          i.i(this.msgId, paramString.KBu);
        }
        h.CyF.idkeyStat(407L, 21L, 1L, false);
        AppMethodBeat.o(63358);
        return;
      }
      if ((paramString.dDN > 0) && (!Util.isNullOrNil(paramString.qwn)))
      {
        this.jSE.ej(paramString.qwn);
        h.CyF.idkeyStat(407L, 11L, 1L, false);
        AppMethodBeat.o(63358);
        return;
      }
      this.jSE.ej(Boolean.FALSE);
      h.CyF.idkeyStat(407L, 23L, 1L, false);
      AppMethodBeat.o(63358);
      return;
    }
    this.jSE.ej(Boolean.FALSE);
    h.CyF.idkeyStat(407L, 22L, 1L, false);
    AppMethodBeat.o(63358);
  }
  
  public final void unInit()
  {
    AppMethodBeat.i(63357);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(1530, this);
    AppMethodBeat.o(63357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.j
 * JD-Core Version:    0.7.0.1
 */