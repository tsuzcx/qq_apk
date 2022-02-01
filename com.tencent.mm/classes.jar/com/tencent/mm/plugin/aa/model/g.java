package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.aa.model.cgi.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.a;
import com.tencent.mm.protocal.protobuf.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.b;

public final class g
  implements i
{
  boolean jSA = false;
  b jSi;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63334);
    Log.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.jSA = false;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((j)paramq).jTn;
      Log.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(paramString.dDN), paramString.qwn });
      if (paramString.dDN == 0)
      {
        com.tencent.mm.vending.g.g.a(this.jSi, new Object[] { paramString });
        h.CyF.idkeyStat(407L, 9L, 1L, false);
        AppMethodBeat.o(63334);
        return;
      }
      if (this.jSi != null)
      {
        if ((paramString.KBE == null) || (paramString.KBE.cSx != 1) || (Util.isNullOrNil(paramString.KBE.qwt)) || (Util.isNullOrNil(paramString.KBE.lHA)) || (Util.isNullOrNil(paramString.KBE.lHB)) || (Util.isNullOrNil(paramString.KBE.dQx))) {
          break label232;
        }
        this.jSi.ej(paramString.KBE);
      }
      for (;;)
      {
        h.CyF.idkeyStat(407L, 11L, 1L, false);
        AppMethodBeat.o(63334);
        return;
        label232:
        if ((paramString.dDN > 0) && (!Util.isNullOrNil(paramString.qwn))) {
          this.jSi.ej(paramString.qwn);
        } else {
          this.jSi.ej(Boolean.FALSE);
        }
      }
    }
    if (this.jSi != null) {
      this.jSi.ej(Boolean.FALSE);
    }
    h.CyF.idkeyStat(407L, 10L, 1L, false);
    AppMethodBeat.o(63334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.g
 * JD-Core Version:    0.7.0.1
 */