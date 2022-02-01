package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.aa.model.a.d;
import com.tencent.mm.plugin.aa.model.cgi.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class b
  implements com.tencent.mm.ak.g
{
  com.tencent.mm.vending.g.b izm;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(63319);
    ac.i("MicroMsg.AAGetPaylistDetailLogic", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((j)paramn).iAp;
      ac.i("MicroMsg.AAGetPaylistDetailLogic", "AAQueryDetailRes, onSceneEnd, retCode: %s", new Object[] { Integer.valueOf(paramString.dae) });
      if (paramString.dae == 0)
      {
        com.tencent.mm.vending.g.g.a(this.izm, new Object[] { paramString });
        h.wUl.idkeyStat(407L, 6L, 1L, false);
        paramn = com.tencent.mm.plugin.aa.b.aNK().FR(paramString.DKA);
        if (paramn != null)
        {
          paramn.field_status = paramString.state;
          com.tencent.mm.plugin.aa.b.aNK().b(paramn);
        }
        AppMethodBeat.o(63319);
        return;
      }
      if ((paramString.dae > 0) && (!bs.isNullOrNil(paramString.oxf))) {
        this.izm.eb(paramString.oxf);
      }
      for (;;)
      {
        h.wUl.idkeyStat(407L, 8L, 1L, false);
        AppMethodBeat.o(63319);
        return;
        this.izm.eb(Boolean.FALSE);
      }
    }
    if (this.izm != null) {
      this.izm.eb(Boolean.FALSE);
    }
    h.wUl.idkeyStat(407L, 7L, 1L, false);
    AppMethodBeat.o(63319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b
 * JD-Core Version:    0.7.0.1
 */