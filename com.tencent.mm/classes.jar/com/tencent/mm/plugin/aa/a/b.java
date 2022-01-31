package com.tencent.mm.plugin.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.aa.a.a.j;
import com.tencent.mm.plugin.aa.a.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
  implements com.tencent.mm.ai.f
{
  com.tencent.mm.vending.g.b gnD;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(40594);
    ab.i("MicroMsg.AAGetPaylistDetailLogic", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((j)paramm).goB;
      ab.i("MicroMsg.AAGetPaylistDetailLogic", "AAQueryDetailRes, onSceneEnd, retCode: %s", new Object[] { Integer.valueOf(paramString.cnK) });
      if (paramString.cnK == 0)
      {
        com.tencent.mm.vending.g.f.a(this.gnD, new Object[] { paramString });
        h.qsU.idkeyStat(407L, 6L, 1L, false);
        paramm = com.tencent.mm.plugin.aa.b.aoH().wJ(paramString.wjW);
        if (paramm != null)
        {
          paramm.field_status = paramString.state;
          com.tencent.mm.plugin.aa.b.aoH().b(paramm);
        }
        AppMethodBeat.o(40594);
        return;
      }
      if ((paramString.cnK > 0) && (!bo.isNullOrNil(paramString.kNv))) {
        this.gnD.cK(paramString.kNv);
      }
      for (;;)
      {
        h.qsU.idkeyStat(407L, 8L, 1L, false);
        AppMethodBeat.o(40594);
        return;
        this.gnD.cK(Boolean.FALSE);
      }
    }
    if (this.gnD != null) {
      this.gnD.cK(Boolean.FALSE);
    }
    h.qsU.idkeyStat(407L, 7L, 1L, false);
    AppMethodBeat.o(40594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.b
 * JD-Core Version:    0.7.0.1
 */