package com.tencent.mm.model.gdpr;

import com.tencent.mm.ah.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.c.aga;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.cmp;
import com.tencent.mm.sdk.platformtools.y;

final class c$2$1
  implements b.a
{
  c$2$1(c.2 param2, com.tencent.mm.vending.g.b paramb) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.b paramb)
  {
    bly localbly = (bly)paramb.ecF.ecN;
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (localbly != null)) {
      i = 1;
    }
    while (i != 0)
    {
      paramString = (aga)paramb.ecF.ecN;
      if (paramString.tdR == null)
      {
        paramString.tdR = new cmp();
        paramString.tdR.bLB = -1;
      }
      y.i("MicroMsg.MPGdprPolicyUtil", "onGetAuthCgiBack, business(%s), appId(%s), back(%d %d)", new Object[] { this.dYD.dYA.dYw, this.dYD.val$appId, Integer.valueOf(paramString.tdR.bLB), Integer.valueOf(paramString.state) });
      if (paramString.tdR.bLB != 0)
      {
        this.dYD.dYz.hX(0);
        this.dYC.cg(Boolean.valueOf(false));
        return;
        i = 0;
      }
      else
      {
        if (paramString.state <= 0)
        {
          this.dYC.x(new Object[] { Boolean.valueOf(true) });
          return;
        }
        this.dYD.dYz.hX(0);
        this.dYC.cg(Boolean.valueOf(false));
        return;
      }
    }
    y.e("MicroMsg.MPGdprPolicyUtil", "onGetAuthCgiBack, business(%s), appId(%s), back(%d %d %s)", new Object[] { this.dYD.dYA.dYw, this.dYD.val$appId, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString });
    this.dYD.dYz.hX(0);
    this.dYC.cg(Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.gdpr.c.2.1
 * JD-Core Version:    0.7.0.1
 */