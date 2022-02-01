package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.aa.model.cgi.i;
import com.tencent.mm.protocal.protobuf.a;
import com.tencent.mm.protocal.protobuf.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vending.g.b;

public final class g
  implements f
{
  boolean iVG = false;
  b iVo;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(63334);
    ae.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.iVG = false;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((i)paramn).iWq;
      ae.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(paramString.dmy), paramString.phe });
      if (paramString.dmy == 0)
      {
        com.tencent.mm.vending.g.g.a(this.iVo, new Object[] { paramString });
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(407L, 9L, 1L, false);
        AppMethodBeat.o(63334);
        return;
      }
      if (this.iVo != null)
      {
        if ((paramString.FIq == null) || (paramString.FIq.dEu != 1) || (bu.isNullOrNil(paramString.FIq.phk)) || (bu.isNullOrNil(paramString.FIq.kCZ)) || (bu.isNullOrNil(paramString.FIq.kDa)) || (bu.isNullOrNil(paramString.FIq.dyI))) {
          break label232;
        }
        this.iVo.ef(paramString.FIq);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(407L, 11L, 1L, false);
        AppMethodBeat.o(63334);
        return;
        label232:
        if ((paramString.dmy > 0) && (!bu.isNullOrNil(paramString.phe))) {
          this.iVo.ef(paramString.phe);
        } else {
          this.iVo.ef(Boolean.FALSE);
        }
      }
    }
    if (this.iVo != null) {
      this.iVo.ef(Boolean.FALSE);
    }
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(407L, 10L, 1L, false);
    AppMethodBeat.o(63334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.g
 * JD-Core Version:    0.7.0.1
 */