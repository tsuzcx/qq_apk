package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.view.View;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.qb;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.p;

final class c$5
  implements b.a
{
  c$5(c paramc, p paramp) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    this.gkz.dismiss();
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb.ecF.ecN == null))
    {
      y.e("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber checkVerifyCode cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramb.ecF.ecN });
      this.gkx.gkh.C(this.gkx.gfg, this.gkx.h("fail:checkVerifyCode cgi fail", null));
      h.nFQ.f(14249, new Object[] { this.gkx.gkh.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(this.gkx.gku), Integer.valueOf(this.gkx.gkv), Integer.valueOf(this.gkx.gkt) });
      return;
    }
    y.i("MicroMsg.JsApiGetPhoneNumber", "checkVerifyCode success");
    paramString = (qb)paramb.ecF.ecN;
    this.gkx.gkh.getContentView().post(new c.5.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c.5
 * JD-Core Version:    0.7.0.1
 */