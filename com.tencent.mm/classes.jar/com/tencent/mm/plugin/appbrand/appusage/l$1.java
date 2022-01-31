package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.protocal.c.ank;
import com.tencent.mm.sdk.platformtools.y;

final class l$1
  implements w.a
{
  l$1(l paraml) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && (paramb.ecF.ecN != null) && ((paramb.ecF.ecN instanceof ank)))
    {
      l.a(this.fIv, (ank)paramb.ecF.ecN);
      return 0;
    }
    y.e("MicroMsg.AppBrandLauncherListWAGameLogic", "doRequest() cgi return errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    l.a(this.fIv, null);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.l.1
 * JD-Core Version:    0.7.0.1
 */