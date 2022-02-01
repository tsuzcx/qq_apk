package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.aa.model.cgi.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.a;
import com.tencent.mm.protocal.protobuf.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vending.g.b;

public final class g
  implements com.tencent.mm.ak.g
{
  boolean izE = false;
  b izm;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(63334);
    ac.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.izE = false;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((i)paramn).iAn;
      ac.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(paramString.dae), paramString.oxf });
      if (paramString.dae == 0)
      {
        com.tencent.mm.vending.g.g.a(this.izm, new Object[] { paramString });
        h.wUl.idkeyStat(407L, 9L, 1L, false);
        AppMethodBeat.o(63334);
        return;
      }
      if (this.izm != null)
      {
        if ((paramString.DKM == null) || (paramString.DKM.drx != 1) || (bs.isNullOrNil(paramString.DKM.oxl)) || (bs.isNullOrNil(paramString.DKM.unW)) || (bs.isNullOrNil(paramString.DKM.unX)) || (bs.isNullOrNil(paramString.DKM.dlQ))) {
          break label232;
        }
        this.izm.eb(paramString.DKM);
      }
      for (;;)
      {
        h.wUl.idkeyStat(407L, 11L, 1L, false);
        AppMethodBeat.o(63334);
        return;
        label232:
        if ((paramString.dae > 0) && (!bs.isNullOrNil(paramString.oxf))) {
          this.izm.eb(paramString.oxf);
        } else {
          this.izm.eb(Boolean.FALSE);
        }
      }
    }
    if (this.izm != null) {
      this.izm.eb(Boolean.FALSE);
    }
    h.wUl.idkeyStat(407L, 10L, 1L, false);
    AppMethodBeat.o(63334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.g
 * JD-Core Version:    0.7.0.1
 */