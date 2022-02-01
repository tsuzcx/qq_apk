package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.aa.model.cgi.j;
import com.tencent.mm.protocal.protobuf.a;
import com.tencent.mm.protocal.protobuf.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public final class h
  implements com.tencent.mm.am.h
{
  b pGe;
  boolean pGv = false;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(63334);
    Log.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.pGv = false;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((j)paramp).pHj;
      Log.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(paramString.hAV), paramString.wYI });
      if (paramString.hAV == 0)
      {
        g.a(this.pGe, new Object[] { paramString });
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 9L, 1L, false);
        AppMethodBeat.o(63334);
        return;
      }
      if (this.pGe != null)
      {
        if ((paramString.YzY == null) || (paramString.YzY.eQp != 1) || (Util.isNullOrNil(paramString.YzY.wYO)) || (Util.isNullOrNil(paramString.YzY.rGU)) || (Util.isNullOrNil(paramString.YzY.right_button_wording)) || (Util.isNullOrNil(paramString.YzY.wording))) {
          break label232;
        }
        this.pGe.gM(paramString.YzY);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 11L, 1L, false);
        AppMethodBeat.o(63334);
        return;
        label232:
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
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 10L, 1L, false);
    AppMethodBeat.o(63334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.h
 * JD-Core Version:    0.7.0.1
 */