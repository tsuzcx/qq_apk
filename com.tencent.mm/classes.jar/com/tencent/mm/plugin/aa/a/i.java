package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class i
  implements com.tencent.mm.ah.f
{
  long bIt = -1L;
  com.tencent.mm.vending.g.b ecA;
  
  public final void Vt()
  {
    g.DQ();
    g.DO().dJT.b(1530, this);
  }
  
  public final void init()
  {
    g.DQ();
    g.DO().dJT.a(1530, this);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.CloseAALogic", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.aa.a.a.e)paramm).eWt;
      y.i("MicroMsg.CloseAALogic", "closeAA, response.retcode: %s", new Object[] { Integer.valueOf(paramString.iHq) });
      y.d("MicroMsg.CloseAALogic", "closeAA, response.msgxml: %s", new Object[] { paramString.srs });
      if (paramString.iHq == 0)
      {
        com.tencent.mm.vending.g.f.a(this.ecA, new Object[] { Boolean.valueOf(true) });
        if ((!bk.bl(paramString.srs)) && (this.bIt > 0L) && (((com.tencent.mm.plugin.aa.a.a.e)paramm).scene == a.eVC)) {
          h.j(this.bIt, paramString.srs);
        }
        com.tencent.mm.plugin.report.service.h.nFQ.a(407L, 21L, 1L, false);
        return;
      }
      if ((paramString.iHq > 0) && (!bk.bl(paramString.iHr)))
      {
        this.ecA.cg(paramString.iHr);
        com.tencent.mm.plugin.report.service.h.nFQ.a(407L, 11L, 1L, false);
        return;
      }
      this.ecA.cg(Boolean.valueOf(false));
      com.tencent.mm.plugin.report.service.h.nFQ.a(407L, 23L, 1L, false);
      return;
    }
    this.ecA.cg(Boolean.valueOf(false));
    com.tencent.mm.plugin.report.service.h.nFQ.a(407L, 22L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.i
 * JD-Core Version:    0.7.0.1
 */