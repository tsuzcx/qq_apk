package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.c.ajy;
import com.tencent.mm.sdk.platformtools.y;

final class l$3
  implements b.a
{
  l$3(l paraml) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    boolean bool;
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb.ecF.ecN == null)) {
      if (paramb.ecF.ecN == null)
      {
        bool = true;
        y.e("MicroMsg.RemoteDebugJsEngine", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(bool) });
      }
    }
    do
    {
      return;
      bool = false;
      break;
      paramString = (ajy)paramb.ecF.ecN;
      this.fSs.fSm.sK(paramString.tgF);
      y.i("MicroMsg.RemoteDebugJsEngine", "loginTicket %s", new Object[] { paramString.tgF });
    } while (!this.fSs.fSo.isOpen());
    l.a(this.fSs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.l.3
 * JD-Core Version:    0.7.0.1
 */