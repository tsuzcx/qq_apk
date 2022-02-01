package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.aa.model.a.d;
import com.tencent.mm.plugin.aa.model.cgi.j;
import com.tencent.mm.protocal.protobuf.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  implements f
{
  com.tencent.mm.vending.g.b iSv;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(63319);
    ad.i("MicroMsg.AAGetPaylistDetailLogic", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((j)paramn).iTz;
      ad.i("MicroMsg.AAGetPaylistDetailLogic", "AAQueryDetailRes, onSceneEnd, retCode: %s", new Object[] { Integer.valueOf(paramString.dlw) });
      if (paramString.dlw == 0)
      {
        com.tencent.mm.vending.g.g.a(this.iSv, new Object[] { paramString });
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(407L, 6L, 1L, false);
        paramn = com.tencent.mm.plugin.aa.b.aQW().Jg(paramString.FpG);
        if (paramn != null)
        {
          paramn.field_status = paramString.state;
          com.tencent.mm.plugin.aa.b.aQW().b(paramn);
        }
        AppMethodBeat.o(63319);
        return;
      }
      if ((paramString.dlw > 0) && (!bt.isNullOrNil(paramString.paA))) {
        this.iSv.ee(paramString.paA);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(407L, 8L, 1L, false);
        AppMethodBeat.o(63319);
        return;
        this.iSv.ee(Boolean.FALSE);
      }
    }
    if (this.iSv != null) {
      this.iSv.ee(Boolean.FALSE);
    }
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(407L, 7L, 1L, false);
    AppMethodBeat.o(63319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b
 * JD-Core Version:    0.7.0.1
 */