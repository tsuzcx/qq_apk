package com.tencent.mm.plugin.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.aa.a.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.a;
import com.tencent.mm.protocal.protobuf.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.b;

public final class f
  implements com.tencent.mm.ai.f
{
  b gnD;
  boolean gnR = false;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(40605);
    ab.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.gnR = false;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((i)paramm).goz;
      ab.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(paramString.cnK), paramString.kNv });
      if (paramString.cnK == 0)
      {
        com.tencent.mm.vending.g.f.a(this.gnD, new Object[] { paramString });
        h.qsU.idkeyStat(407L, 9L, 1L, false);
        AppMethodBeat.o(40605);
        return;
      }
      if (this.gnD != null)
      {
        if ((paramString.wkq == null) || (paramString.wkq.bsY != 1) || (bo.isNullOrNil(paramString.wkq.kNB)) || (bo.isNullOrNil(paramString.wkq.opC)) || (bo.isNullOrNil(paramString.wkq.opD)) || (bo.isNullOrNil(paramString.wkq.cyA))) {
          break label232;
        }
        this.gnD.cK(paramString.wkq);
      }
      for (;;)
      {
        h.qsU.idkeyStat(407L, 11L, 1L, false);
        AppMethodBeat.o(40605);
        return;
        label232:
        if ((paramString.cnK > 0) && (!bo.isNullOrNil(paramString.kNv))) {
          this.gnD.cK(paramString.kNv);
        } else {
          this.gnD.cK(Boolean.FALSE);
        }
      }
    }
    if (this.gnD != null) {
      this.gnD.cK(Boolean.FALSE);
    }
    h.qsU.idkeyStat(407L, 10L, 1L, false);
    AppMethodBeat.o(40605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.f
 * JD-Core Version:    0.7.0.1
 */