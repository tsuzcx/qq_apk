package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.aa.model.a.d;
import com.tencent.mm.plugin.aa.model.cgi.j;
import com.tencent.mm.protocal.protobuf.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
  implements f
{
  com.tencent.mm.vending.g.b iVo;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(63319);
    ae.i("MicroMsg.AAGetPaylistDetailLogic", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((j)paramn).iWs;
      ae.i("MicroMsg.AAGetPaylistDetailLogic", "AAQueryDetailRes, onSceneEnd, retCode: %s", new Object[] { Integer.valueOf(paramString.dmy) });
      if (paramString.dmy == 0)
      {
        com.tencent.mm.vending.g.g.a(this.iVo, new Object[] { paramString });
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(407L, 6L, 1L, false);
        paramn = com.tencent.mm.plugin.aa.b.aRv().JF(paramString.FIe);
        if (paramn != null)
        {
          paramn.field_status = paramString.state;
          com.tencent.mm.plugin.aa.b.aRv().b(paramn);
        }
        AppMethodBeat.o(63319);
        return;
      }
      if ((paramString.dmy > 0) && (!bu.isNullOrNil(paramString.phe))) {
        this.iVo.ef(paramString.phe);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(407L, 8L, 1L, false);
        AppMethodBeat.o(63319);
        return;
        this.iVo.ef(Boolean.FALSE);
      }
    }
    if (this.iVo != null) {
      this.iVo.ef(Boolean.FALSE);
    }
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(407L, 7L, 1L, false);
    AppMethodBeat.o(63319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b
 * JD-Core Version:    0.7.0.1
 */