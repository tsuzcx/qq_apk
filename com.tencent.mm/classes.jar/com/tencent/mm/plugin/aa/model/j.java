package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class j
  implements f
{
  com.tencent.mm.vending.g.b iVK;
  long msgId = -1L;
  
  public final void init()
  {
    AppMethodBeat.i(63356);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(1530, this);
    AppMethodBeat.o(63356);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(63358);
    ae.i("MicroMsg.CloseAALogic", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.aa.model.cgi.e)paramn).iWi;
      ae.i("MicroMsg.CloseAALogic", "closeAA, response.retcode: %s", new Object[] { Integer.valueOf(paramString.dmy) });
      ae.d("MicroMsg.CloseAALogic", "closeAA, response.msgxml: %s", new Object[] { paramString.FIg });
      if (paramString.dmy == 0)
      {
        com.tencent.mm.vending.g.g.a(this.iVK, new Object[] { Boolean.TRUE });
        if ((!bu.isNullOrNil(paramString.FIg)) && (this.msgId > 0L) && (((com.tencent.mm.plugin.aa.model.cgi.e)paramn).scene == a.iVk)) {
          i.i(this.msgId, paramString.FIg);
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(407L, 21L, 1L, false);
        AppMethodBeat.o(63358);
        return;
      }
      if ((paramString.dmy > 0) && (!bu.isNullOrNil(paramString.phe)))
      {
        this.iVK.ef(paramString.phe);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(407L, 11L, 1L, false);
        AppMethodBeat.o(63358);
        return;
      }
      this.iVK.ef(Boolean.FALSE);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(407L, 23L, 1L, false);
      AppMethodBeat.o(63358);
      return;
    }
    this.iVK.ef(Boolean.FALSE);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(407L, 22L, 1L, false);
    AppMethodBeat.o(63358);
  }
  
  public final void unInit()
  {
    AppMethodBeat.i(63357);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(1530, this);
    AppMethodBeat.o(63357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.j
 * JD-Core Version:    0.7.0.1
 */