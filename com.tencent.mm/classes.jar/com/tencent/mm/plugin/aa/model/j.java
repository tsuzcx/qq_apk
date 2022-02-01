package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class j
  implements com.tencent.mm.ak.g
{
  com.tencent.mm.vending.g.b hvn;
  long msgId = -1L;
  
  public final void init()
  {
    AppMethodBeat.i(63356);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(1530, this);
    AppMethodBeat.o(63356);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(63358);
    ac.i("MicroMsg.CloseAALogic", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.aa.model.cgi.e)paramn).iAf;
      ac.i("MicroMsg.CloseAALogic", "closeAA, response.retcode: %s", new Object[] { Integer.valueOf(paramString.dae) });
      ac.d("MicroMsg.CloseAALogic", "closeAA, response.msgxml: %s", new Object[] { paramString.DKC });
      if (paramString.dae == 0)
      {
        com.tencent.mm.vending.g.g.a(this.hvn, new Object[] { Boolean.TRUE });
        if ((!bs.isNullOrNil(paramString.DKC)) && (this.msgId > 0L) && (((com.tencent.mm.plugin.aa.model.cgi.e)paramn).scene == a.izi)) {
          i.i(this.msgId, paramString.DKC);
        }
        h.wUl.idkeyStat(407L, 21L, 1L, false);
        AppMethodBeat.o(63358);
        return;
      }
      if ((paramString.dae > 0) && (!bs.isNullOrNil(paramString.oxf)))
      {
        this.hvn.eb(paramString.oxf);
        h.wUl.idkeyStat(407L, 11L, 1L, false);
        AppMethodBeat.o(63358);
        return;
      }
      this.hvn.eb(Boolean.FALSE);
      h.wUl.idkeyStat(407L, 23L, 1L, false);
      AppMethodBeat.o(63358);
      return;
    }
    this.hvn.eb(Boolean.FALSE);
    h.wUl.idkeyStat(407L, 22L, 1L, false);
    AppMethodBeat.o(63358);
  }
  
  public final void unInit()
  {
    AppMethodBeat.i(63357);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(1530, this);
    AppMethodBeat.o(63357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.j
 * JD-Core Version:    0.7.0.1
 */