package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class j
  implements com.tencent.mm.al.g
{
  com.tencent.mm.vending.g.b gUO;
  long msgId = -1L;
  
  public final void NX()
  {
    AppMethodBeat.i(63357);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(1530, this);
    AppMethodBeat.o(63357);
  }
  
  public final void init()
  {
    AppMethodBeat.i(63356);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(1530, this);
    AppMethodBeat.o(63356);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(63358);
    ad.i("MicroMsg.CloseAALogic", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.aa.model.cgi.e)paramn).iac;
      ad.i("MicroMsg.CloseAALogic", "closeAA, response.retcode: %s", new Object[] { Integer.valueOf(paramString.dcG) });
      ad.d("MicroMsg.CloseAALogic", "closeAA, response.msgxml: %s", new Object[] { paramString.Csk });
      if (paramString.dcG == 0)
      {
        com.tencent.mm.vending.g.g.a(this.gUO, new Object[] { Boolean.TRUE });
        if ((!bt.isNullOrNil(paramString.Csk)) && (this.msgId > 0L) && (((com.tencent.mm.plugin.aa.model.cgi.e)paramn).scene == a.hZe)) {
          i.i(this.msgId, paramString.Csk);
        }
        h.vKh.idkeyStat(407L, 21L, 1L, false);
        AppMethodBeat.o(63358);
        return;
      }
      if ((paramString.dcG > 0) && (!bt.isNullOrNil(paramString.nTK)))
      {
        this.gUO.ea(paramString.nTK);
        h.vKh.idkeyStat(407L, 11L, 1L, false);
        AppMethodBeat.o(63358);
        return;
      }
      this.gUO.ea(Boolean.FALSE);
      h.vKh.idkeyStat(407L, 23L, 1L, false);
      AppMethodBeat.o(63358);
      return;
    }
    this.gUO.ea(Boolean.FALSE);
    h.vKh.idkeyStat(407L, 22L, 1L, false);
    AppMethodBeat.o(63358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.j
 * JD-Core Version:    0.7.0.1
 */