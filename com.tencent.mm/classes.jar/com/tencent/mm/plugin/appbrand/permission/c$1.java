package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.c.aqz;
import com.tencent.mm.protocal.c.asb;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements b.a
{
  c$1(c paramc, int paramInt) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb.ecF.ecN == null)) {
      y.e("MicroMsg.AppBrandJsApiUserAuth", "setAuth, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramb.ecF.ecN });
    }
    while ((((asb)paramb.ecF.ecN).tnb.bLB != 0) || (1 != this.gWI)) {
      return;
    }
    y.i("MicroMsg.AppBrandJsApiUserAuth", "setAuth, add allow cache appId = %s, api = %s", new Object[] { c.a(this.gWJ), c.b(this.gWJ) });
    c.anJ().put(c.a(this.gWJ), c.b(this.gWJ));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.c.1
 * JD-Core Version:    0.7.0.1
 */