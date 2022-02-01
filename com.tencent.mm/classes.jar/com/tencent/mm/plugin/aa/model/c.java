package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.aa.model.a.d;
import com.tencent.mm.plugin.aa.model.cgi.k;
import com.tencent.mm.protocal.protobuf.a;
import com.tencent.mm.protocal.protobuf.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.g;

public final class c
  implements com.tencent.mm.am.h
{
  com.tencent.mm.vending.g.b pGe;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(63319);
    Log.i("MicroMsg.AAGetPaylistDetailLogic", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((k)paramp).pHl;
      Log.i("MicroMsg.AAGetPaylistDetailLogic", "AAQueryDetailRes, onSceneEnd, retCode: %s", new Object[] { Integer.valueOf(paramString.hAV) });
      if (paramString.hAV == 0)
      {
        g.a(this.pGe, new Object[] { paramString });
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 6L, 1L, false);
        paramp = com.tencent.mm.plugin.aa.b.bVa().SD(paramString.YzL);
        if (paramp != null)
        {
          paramp.field_status = paramString.state;
          com.tencent.mm.plugin.aa.b.bVa().b(paramp);
        }
        AppMethodBeat.o(63319);
        return;
      }
      paramp = paramString.YzY;
      if ((paramp != null) && (paramp.eQp == 1)) {
        this.pGe.gM(paramp);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 8L, 1L, false);
        AppMethodBeat.o(63319);
        return;
        if ((paramString.hAV > 0) && (!Util.isNullOrNil(paramString.wYI))) {
          this.pGe.gM(paramString.wYI);
        } else {
          this.pGe.gM(Boolean.FALSE);
        }
      }
    }
    if (this.pGe != null) {
      this.pGe.gM(Boolean.FALSE);
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 7L, 1L, false);
    AppMethodBeat.o(63319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.c
 * JD-Core Version:    0.7.0.1
 */