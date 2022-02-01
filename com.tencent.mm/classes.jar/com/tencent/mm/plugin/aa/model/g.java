package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.aa.model.cgi.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.a;
import com.tencent.mm.protocal.protobuf.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.g.b;

public final class g
  implements com.tencent.mm.al.g
{
  boolean hZA = false;
  b hZi;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(63334);
    ad.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.hZA = false;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((i)paramn).iak;
      ad.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(paramString.dcG), paramString.nTK });
      if (paramString.dcG == 0)
      {
        com.tencent.mm.vending.g.g.a(this.hZi, new Object[] { paramString });
        h.vKh.idkeyStat(407L, 9L, 1L, false);
        AppMethodBeat.o(63334);
        return;
      }
      if (this.hZi != null)
      {
        if ((paramString.Csu == null) || (paramString.Csu.dtM != 1) || (bt.isNullOrNil(paramString.Csu.nTQ)) || (bt.isNullOrNil(paramString.Csu.tfH)) || (bt.isNullOrNil(paramString.Csu.tfI)) || (bt.isNullOrNil(paramString.Csu.doh))) {
          break label232;
        }
        this.hZi.ea(paramString.Csu);
      }
      for (;;)
      {
        h.vKh.idkeyStat(407L, 11L, 1L, false);
        AppMethodBeat.o(63334);
        return;
        label232:
        if ((paramString.dcG > 0) && (!bt.isNullOrNil(paramString.nTK))) {
          this.hZi.ea(paramString.nTK);
        } else {
          this.hZi.ea(Boolean.FALSE);
        }
      }
    }
    if (this.hZi != null) {
      this.hZi.ea(Boolean.FALSE);
    }
    h.vKh.idkeyStat(407L, 10L, 1L, false);
    AppMethodBeat.o(63334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.g
 * JD-Core Version:    0.7.0.1
 */