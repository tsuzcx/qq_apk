package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.aa.model.cgi.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.a;
import com.tencent.mm.protocal.protobuf.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.b;

public final class g
  implements i
{
  boolean mJN = false;
  b mJv;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63334);
    Log.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.mJN = false;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((j)paramq).mKB;
      Log.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(paramString.fwx), paramString.tVo });
      if (paramString.fwx == 0)
      {
        com.tencent.mm.vending.g.g.a(this.mJv, new Object[] { paramString });
        h.IzE.idkeyStat(407L, 9L, 1L, false);
        AppMethodBeat.o(63334);
        return;
      }
      if (this.mJv != null)
      {
        if ((paramString.RDv == null) || (paramString.RDv.cUP != 1) || (Util.isNullOrNil(paramString.RDv.tVu)) || (Util.isNullOrNil(paramString.RDv.oDJ)) || (Util.isNullOrNil(paramString.RDv.oDK)) || (Util.isNullOrNil(paramString.RDv.wording))) {
          break label232;
        }
        this.mJv.eo(paramString.RDv);
      }
      for (;;)
      {
        h.IzE.idkeyStat(407L, 11L, 1L, false);
        AppMethodBeat.o(63334);
        return;
        label232:
        if ((paramString.fwx > 0) && (!Util.isNullOrNil(paramString.tVo))) {
          this.mJv.eo(paramString.tVo);
        } else {
          this.mJv.eo(Boolean.FALSE);
        }
      }
    }
    if (this.mJv != null) {
      this.mJv.eo(Boolean.FALSE);
    }
    h.IzE.idkeyStat(407L, 10L, 1L, false);
    AppMethodBeat.o(63334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.g
 * JD-Core Version:    0.7.0.1
 */