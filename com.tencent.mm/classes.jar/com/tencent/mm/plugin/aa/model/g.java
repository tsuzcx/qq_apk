package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.aa.model.cgi.i;
import com.tencent.mm.protocal.protobuf.a;
import com.tencent.mm.protocal.protobuf.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.g.b;

public final class g
  implements f
{
  boolean iSN = false;
  b iSv;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(63334);
    ad.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.iSN = false;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((i)paramn).iTx;
      ad.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(paramString.dlw), paramString.paA });
      if (paramString.dlw == 0)
      {
        com.tencent.mm.vending.g.g.a(this.iSv, new Object[] { paramString });
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(407L, 9L, 1L, false);
        AppMethodBeat.o(63334);
        return;
      }
      if (this.iSv != null)
      {
        if ((paramString.FpS == null) || (paramString.FpS.dDp != 1) || (bt.isNullOrNil(paramString.FpS.paG)) || (bt.isNullOrNil(paramString.FpS.kzK)) || (bt.isNullOrNil(paramString.FpS.kzL)) || (bt.isNullOrNil(paramString.FpS.dxD))) {
          break label232;
        }
        this.iSv.ee(paramString.FpS);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(407L, 11L, 1L, false);
        AppMethodBeat.o(63334);
        return;
        label232:
        if ((paramString.dlw > 0) && (!bt.isNullOrNil(paramString.paA))) {
          this.iSv.ee(paramString.paA);
        } else {
          this.iSv.ee(Boolean.FALSE);
        }
      }
    }
    if (this.iSv != null) {
      this.iSv.ee(Boolean.FALSE);
    }
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(407L, 10L, 1L, false);
    AppMethodBeat.o(63334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.g
 * JD-Core Version:    0.7.0.1
 */