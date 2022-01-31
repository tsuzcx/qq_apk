package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.Intent;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.protocal.c.bsa;
import com.tencent.mm.protocal.c.et;
import com.tencent.mm.protocal.c.eu;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

final class AppBrandIDCardUI$1$1
  implements b.a
{
  AppBrandIDCardUI$1$1(AppBrandIDCardUI.1 param1) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    if ((AppBrandIDCardUI.d(this.hfl.hfk) != null) && (AppBrandIDCardUI.d(this.hfl.hfk).isShowing())) {
      AppBrandIDCardUI.d(this.hfl.hfk).dismiss();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb.ecF.ecN == null))
    {
      y.e("MicroMsg.AppBrandIDCardUI", "getIDCardInfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramb.ecF.ecN });
      paramString = new Intent();
      paramString.putExtra("intent_err_code", 40000);
      paramString.putExtra("intent_err_msg", "network err");
      this.hfl.hfk.setResult(1, paramString);
      this.hfl.hfk.finish();
      return;
    }
    paramString = (bsa)paramb.ecF.ecN;
    if (paramString.tHq == null)
    {
      y.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
      paramString = new Intent();
      paramString.putExtra("intent_err_code", 40000);
      paramString.putExtra("intent_err_msg", "network err");
      this.hfl.hfk.setResult(1, paramString);
      this.hfl.hfk.finish();
      return;
    }
    y.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response.err_code is %d", new Object[] { Integer.valueOf(paramString.tHq.bPH) });
    y.i("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status:%d", new Object[] { Integer.valueOf(paramString.tIC) });
    switch (paramString.tIC)
    {
    default: 
      y.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status error");
      return;
    case 0: 
      if (paramString.tHq.bPH != 0)
      {
        y.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is not ok");
        paramb = new Intent();
        paramb.putExtra("intent_err_code", paramString.tHq.bPH);
        paramb.putExtra("intent_err_msg", paramString.tHq.bPI);
        this.hfl.hfk.setResult(1, paramb);
        this.hfl.hfk.finish();
        return;
      }
      AppBrandIDCardUI.a(this.hfl.hfk, paramString);
      AppBrandIDCardUI.e(this.hfl.hfk);
      return;
    }
    y.i("MicroMsg.AppBrandIDCardUI", "showAlert errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramString.tHq.bPH), paramString.tHq.bPI });
    paramb = this.hfl;
    paramInt1 = paramString.tHq.bPH;
    String str = paramString.tHq.bPI;
    h.a(paramb.hfk, false, paramString.tID.desc, paramString.tID.title, paramb.hfk.getString(y.j.app_brand_idcard_show_alert_ok), "", new AppBrandIDCardUI.1.2(paramb, paramInt1, str), new AppBrandIDCardUI.1.3(paramb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1.1
 * JD-Core Version:    0.7.0.1
 */