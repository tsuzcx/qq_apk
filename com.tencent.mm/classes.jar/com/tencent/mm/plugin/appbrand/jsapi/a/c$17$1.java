package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.plugin.appbrand.y.b;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bpp;
import com.tencent.mm.sdk.platformtools.y;

final class c$17$1
  implements Runnable
{
  c$17$1(c.17 param17, bpp parambpp) {}
  
  public final void run()
  {
    c localc = this.gkJ.gkx;
    int i = this.gkI.status;
    y.i("MicroMsg.JsApiGetPhoneNumber", "handleSendVerifyCodeStatus:%d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      y.i("MicroMsg.JsApiGetPhoneNumber", "startSmsListener");
      if (localc.gkq != null)
      {
        localc.gkq.cancel();
        localc.gkq.start();
        if (localc.gkr == null) {
          localc.gkr = new com.tencent.mm.plugin.ag.a(localc.gkh.mContext);
        }
        localc.gkr.fiZ = localc.gkh.getContentView().getResources().getStringArray(y.b.appbrand_sms_content);
        localc.gkr.oiY = localc.gkw;
        e.a(localc.gkh.mAppId, new c.9(localc));
        boolean bool = com.tencent.mm.pluginsdk.permission.a.a((Activity)localc.gkh.mContext, "android.permission.READ_SMS", 128, "", "");
        if (bool) {
          e.vX(localc.gkh.mAppId);
        }
        if (!bool) {
          break label215;
        }
        y.i("MicroMsg.JsApiGetPhoneNumber", "request sms permission success");
      }
      for (;;)
      {
        localc.gkr.start();
        return;
        localc.gkq = new c.a(localc);
        break;
        label215:
        y.e("MicroMsg.JsApiGetPhoneNumber", "request sms permission fail");
      }
    }
    if ((i != 1) && (i == 2))
    {
      localc.tR(localc.gkh.getContentView().getResources().getString(y.j.app_brand_get_phone_number_send_verify_code_frequent));
      h.nFQ.f(14249, new Object[] { localc.gkh.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(localc.gku), Integer.valueOf(localc.gkv), Integer.valueOf(localc.gkt) });
      return;
    }
    localc.tR(localc.gkh.getContentView().getResources().getString(y.j.app_brand_get_phone_number_send_verify_code_fail));
    h.nFQ.f(14249, new Object[] { localc.gkh.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(localc.gku), Integer.valueOf(localc.gkv), Integer.valueOf(localc.gkt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c.17.1
 * JD-Core Version:    0.7.0.1
 */