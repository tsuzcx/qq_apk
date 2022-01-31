package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.clv;
import com.tencent.mm.protocal.c.clw;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class ad$2
  implements w.a
{
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    h.nFQ.a(368L, 40L, 1L, false);
    if (g.DK())
    {
      long l = bk.UX();
      g.DP().Dz().c(ac.a.usG, Long.valueOf(86400L + l));
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.WxaCommLibVersionChecker", "onResp, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      return 0;
    }
    try
    {
      ad.b(((clv)paramb.ecE.ecN).version, (clw)paramb.ecF.ecN, ad.a.fDg);
      return 0;
    }
    catch (RuntimeException paramString)
    {
      y.e("MicroMsg.WxaCommLibVersionChecker", "onResp, e %s", new Object[] { paramString });
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ad.2
 * JD-Core Version:    0.7.0.1
 */