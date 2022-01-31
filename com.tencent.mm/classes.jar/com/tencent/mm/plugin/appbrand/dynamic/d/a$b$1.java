package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.c.aqz;
import com.tencent.mm.protocal.c.aro;
import com.tencent.mm.sdk.platformtools.y;

final class a$b$1
  implements b.a
{
  a$b$1(a.b paramb, c paramc, String paramString1, String paramString2) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    y.i("MicroMsg.IPCInvoke_DoAuthorize", "onSceneEnd errType[%d], errCode[%d] ,errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      a.b.b(this.dGE, false, "cgi fail");
    }
    while (paramb.ecF.ecN == null) {
      return;
    }
    paramString = (aro)paramb.ecF.ecN;
    paramInt1 = paramString.tnb.bLB;
    paramb = paramString.tnb.bLC;
    y.i("MicroMsg.IPCInvoke_DoAuthorize", "NetSceneJSAuthorize jsErrcode[%d], jsErrmsg[%s]", new Object[] { Integer.valueOf(paramInt1), paramb });
    if (paramInt1 == -12000)
    {
      a.b.a(this.fVf, this.fVe, a.b.tf(paramString.kVn), a.b.tf(paramString.suv), paramString.tab, new a.a()
      {
        public final void g(Bundle paramAnonymousBundle)
        {
          int i = paramAnonymousBundle.getInt("retCode");
          if (i == 0)
          {
            i = paramAnonymousBundle.getInt("resultCode");
            paramAnonymousBundle = paramAnonymousBundle.getBundle("resultData");
            a.b.a(a.b.1.this.fVf, a.b.1.this.fVe, a.b.1.this.val$appId, paramAnonymousBundle, i, a.b.1.this.dGE);
            return;
          }
          a.b.b(a.b.1.this.dGE, false, "deny");
          y.e("MicroMsg.IPCInvoke_DoAuthorize", "authorize fail, retCode[%d]", new Object[] { Integer.valueOf(i) });
        }
      });
      return;
    }
    if (paramInt1 == 0)
    {
      a.b.a(this.fVf, this.fVe);
      a.b.b(this.dGE, true, "");
      return;
    }
    y.e("MicroMsg.IPCInvoke_DoAuthorize", "onSceneEnd NetSceneJSAuthorize ERROR %s", new Object[] { paramb });
    a.b.b(this.dGE, false, paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a.b.1
 * JD-Core Version:    0.7.0.1
 */