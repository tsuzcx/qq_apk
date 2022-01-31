package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.c.aqz;
import com.tencent.mm.protocal.c.arm;
import com.tencent.mm.sdk.platformtools.y;

final class a$b$2
  implements b.a
{
  a$b$2(a.b paramb, c paramc, int paramInt, String paramString) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    y.d("MicroMsg.IPCInvoke_DoAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      a.b.b(this.dGE, false, "cgi fail");
    }
    while (paramb.ecF.ecN == null) {
      return;
    }
    if (this.fVh == 2)
    {
      a.b.b(this.dGE, false, "cgi fail");
      return;
    }
    paramString = (arm)paramb.ecF.ecN;
    paramInt1 = paramString.tnb.bLB;
    y.i("MicroMsg.IPCInvoke_DoAuthorize", "NetSceneJSAuthorizeConfirm jsErrcode[%d], jsErrmsg[%s]", new Object[] { Integer.valueOf(paramInt1), paramString.tnb.bLC });
    if (paramInt1 == 0)
    {
      a.b.a(this.fVf, this.fVe);
      a.b.b(this.dGE, true, "");
      return;
    }
    a.b.b(this.dGE, false, "cgi fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a.b.2
 * JD-Core Version:    0.7.0.1
 */