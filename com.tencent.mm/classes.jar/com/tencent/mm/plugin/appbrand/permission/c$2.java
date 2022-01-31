package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.c.arz;
import com.tencent.mm.sdk.platformtools.y;

final class c$2
  implements b.a
{
  c$2(c paramc) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb.ecF.ecN == null))
    {
      y.e("MicroMsg.AppBrandJsApiUserAuth", "checkAuth, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramb.ecF.ecN });
      c.anJ().B(c.a(this.gWJ), c.b(this.gWJ));
      c.c(this.gWJ).anM();
      return;
    }
    c.a(this.gWJ, (arz)paramb.ecF.ecN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.c.2
 * JD-Core Version:    0.7.0.1
 */