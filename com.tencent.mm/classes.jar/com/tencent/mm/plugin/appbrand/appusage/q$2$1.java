package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.protocal.c.ang;
import com.tencent.mm.sdk.platformtools.y;

final class q$2$1
  implements w.a
{
  q$2$1(q.2 param2) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && (paramb.ecF.ecN != null) && ((paramb.ecF.ecN instanceof ang)))
    {
      q.a((ang)paramb.ecF.ecN);
      return 0;
    }
    y.e("MicroMsg.AppBrandNearbyLogic", "refresh() cgi return errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    q.a(null);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.q.2.1
 * JD-Core Version:    0.7.0.1
 */