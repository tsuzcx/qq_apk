package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.aa.model.a.d;
import com.tencent.mm.plugin.aa.model.cgi.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.a;
import com.tencent.mm.protocal.protobuf.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.g;

public final class b
  implements i
{
  com.tencent.mm.vending.g.b mJv;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63319);
    Log.i("MicroMsg.AAGetPaylistDetailLogic", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((k)paramq).mKD;
      Log.i("MicroMsg.AAGetPaylistDetailLogic", "AAQueryDetailRes, onSceneEnd, retCode: %s", new Object[] { Integer.valueOf(paramString.fwx) });
      if (paramString.fwx == 0)
      {
        g.a(this.mJv, new Object[] { paramString });
        h.IzE.idkeyStat(407L, 6L, 1L, false);
        paramq = com.tencent.mm.plugin.aa.b.bwh().aaj(paramString.RDi);
        if (paramq != null)
        {
          paramq.field_status = paramString.state;
          com.tencent.mm.plugin.aa.b.bwh().b(paramq);
        }
        AppMethodBeat.o(63319);
        return;
      }
      paramq = paramString.RDv;
      if ((paramq != null) && (paramq.cUP == 1)) {
        this.mJv.eo(paramq);
      }
      for (;;)
      {
        h.IzE.idkeyStat(407L, 8L, 1L, false);
        AppMethodBeat.o(63319);
        return;
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
    h.IzE.idkeyStat(407L, 7L, 1L, false);
    AppMethodBeat.o(63319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b
 * JD-Core Version:    0.7.0.1
 */