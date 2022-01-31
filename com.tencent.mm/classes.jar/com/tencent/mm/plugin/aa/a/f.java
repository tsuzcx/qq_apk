package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.aa.a.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.a;
import com.tencent.mm.protocal.c.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.g.b;

public final class f
  implements com.tencent.mm.ah.f
{
  b eVG;
  boolean eVU = false;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.eVU = false;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((i)paramm).eWB;
      y.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(paramString.iHq), paramString.iHr });
      if (paramString.iHq == 0)
      {
        com.tencent.mm.vending.g.f.a(this.eVG, new Object[] { paramString });
        h.nFQ.a(407L, 9L, 1L, false);
        return;
      }
      if (this.eVG != null)
      {
        if ((paramString.srK == null) || (paramString.srK.bcw != 1) || (bk.bl(paramString.srK.iHx)) || (bk.bl(paramString.srK.lRE)) || (bk.bl(paramString.srK.lRF)) || (bk.bl(paramString.srK.bQZ))) {
          break label217;
        }
        this.eVG.cg(paramString.srK);
      }
      for (;;)
      {
        h.nFQ.a(407L, 11L, 1L, false);
        return;
        label217:
        if ((paramString.iHq > 0) && (!bk.bl(paramString.iHr))) {
          this.eVG.cg(paramString.iHr);
        } else {
          this.eVG.cg(Boolean.valueOf(false));
        }
      }
    }
    if (this.eVG != null) {
      this.eVG.cg(Boolean.valueOf(false));
    }
    h.nFQ.a(407L, 10L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.f
 * JD-Core Version:    0.7.0.1
 */