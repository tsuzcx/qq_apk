package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.aa.a.a.j;
import com.tencent.mm.plugin.aa.a.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  implements com.tencent.mm.ah.f
{
  com.tencent.mm.vending.g.b eVG;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.AAGetPaylistDetailLogic", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((j)paramm).eWD;
      y.i("MicroMsg.AAGetPaylistDetailLogic", "AAQueryDetailRes, onSceneEnd, retCode: %s", new Object[] { Integer.valueOf(paramString.iHq) });
      if (paramString.iHq == 0)
      {
        com.tencent.mm.vending.g.f.a(this.eVG, new Object[] { paramString });
        h.nFQ.a(407L, 6L, 1L, false);
        paramm = com.tencent.mm.plugin.aa.b.Vj().pv(paramString.srq);
        if (paramm != null)
        {
          paramm.field_status = paramString.state;
          com.tencent.mm.plugin.aa.b.Vj().b(paramm);
        }
        return;
      }
      if ((paramString.iHq > 0) && (!bk.bl(paramString.iHr))) {
        this.eVG.cg(paramString.iHr);
      }
      for (;;)
      {
        h.nFQ.a(407L, 8L, 1L, false);
        return;
        this.eVG.cg(Boolean.valueOf(false));
      }
    }
    if (this.eVG != null) {
      this.eVG.cg(Boolean.valueOf(false));
    }
    h.nFQ.a(407L, 7L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.b
 * JD-Core Version:    0.7.0.1
 */