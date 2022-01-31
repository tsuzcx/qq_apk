package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.widget.Toast;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.protocal.c.bpl;
import com.tencent.mm.protocal.c.eu;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandIDCardUI$1$5
  implements b.a
{
  AppBrandIDCardUI$1$5(AppBrandIDCardUI.1 param1) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb.ecF.ecN == null))
    {
      y.e("MicroMsg.AppBrandIDCardUI", "sendSms cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramb.ecF.ecN });
      Toast.makeText(this.hfl.hfk, this.hfl.hfk.getString(y.j.app_brand_idcard_err_msg), 0).show();
      return;
    }
    paramString = (bpl)paramb.ecF.ecN;
    if (paramString.tHq != null)
    {
      y.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response.err_code:%d", new Object[] { Integer.valueOf(paramString.tHq.bPH) });
      if (paramString.tHq.bPH == 0)
      {
        AppBrandIDCardUI.b(this.hfl.hfk, paramString.tHr);
        y.i("MicroMsg.AppBrandIDCardUI", "send success, verifyToken:%s", new Object[] { paramString.tHr });
        return;
      }
      AppBrandIDCardUI.1.a(this.hfl, this.hfl.hfk.getString(y.j.app_brand_idcard_verify_send_sms_fail));
      return;
    }
    y.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response is null");
    AppBrandIDCardUI.1.a(this.hfl, this.hfl.hfk.getString(y.j.app_brand_idcard_verify_send_sms_fail));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1.5
 * JD-Core Version:    0.7.0.1
 */