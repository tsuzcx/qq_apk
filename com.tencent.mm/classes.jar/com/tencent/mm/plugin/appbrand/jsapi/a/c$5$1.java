package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.protocal.c.qb;
import com.tencent.mm.sdk.platformtools.y;

final class c$5$1
  implements Runnable
{
  c$5$1(c.5 param5, qb paramqb) {}
  
  public final void run()
  {
    if (this.gkA.status == 0)
    {
      y.d("MicroMsg.JsApiGetPhoneNumber", "encryptedData:%s, iv:%s", new Object[] { this.gkA.gkk, this.gkA.aJD });
      if (!TextUtils.isEmpty(this.gkA.gkk)) {
        this.gkB.gkx.gkk = this.gkA.gkk;
      }
      if (!TextUtils.isEmpty(this.gkA.aJD)) {
        this.gkB.gkx.aJD = this.gkA.aJD;
      }
    }
    c localc = this.gkB.gkx;
    int i = this.gkA.status;
    y.i("MicroMsg.JsApiGetPhoneNumber", "handleCheckVerifyCodeStatus:%d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(14249, new Object[] { localc.gkh.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(localc.gku), Integer.valueOf(localc.gkv), Integer.valueOf(localc.gkt) });
      localc.aif();
      return;
    }
    if (i == 1)
    {
      localc.tR(localc.gkh.getContentView().getResources().getString(y.j.app_brand_get_phone_number_send_verify_code_frequent));
      com.tencent.mm.plugin.report.service.h.nFQ.f(14249, new Object[] { localc.gkh.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(localc.gku), Integer.valueOf(localc.gkv), Integer.valueOf(localc.gkt) });
      return;
    }
    if ((i == 3) || (i == 4))
    {
      com.tencent.mm.ui.base.h.a(localc.gkh.mContext, localc.gkh.getContentView().getResources().getString(y.j.app_brand_get_phone_number_verify_code_error), "", false, new c.6(localc));
      return;
    }
    localc.tR(localc.gkh.getContentView().getResources().getString(y.j.app_brand_get_phone_number_verify_code_fail));
    com.tencent.mm.plugin.report.service.h.nFQ.f(14249, new Object[] { localc.gkh.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(localc.gku), Integer.valueOf(localc.gkv), Integer.valueOf(localc.gkt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c.5.1
 * JD-Core Version:    0.7.0.1
 */