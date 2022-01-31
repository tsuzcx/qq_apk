package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.protocal.c.qa;
import com.tencent.mm.protocal.c.qb;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

final class c$18
  implements DialogInterface.OnClickListener
{
  c$18(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.JsApiGetPhoneNumber", "to verify sms");
    if ((!TextUtils.isEmpty(this.gkx.gko.getText())) && (this.gkx.gko.getText().length() == 6))
    {
      y.e("MicroMsg.JsApiGetPhoneNumber", "code is length is 6");
      paramDialogInterface.dismiss();
      this.gkx.aih();
      this.gkx.gkn.post(new c.18.1(this));
      paramDialogInterface = this.gkx;
      String str = this.gkx.gko.getText().toString();
      y.i("MicroMsg.JsApiGetPhoneNumber", "doVerifyCode");
      Object localObject = new b.a();
      ((b.a)localObject).ecH = new qa();
      ((b.a)localObject).ecI = new qb();
      ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/checkverifycode";
      ((b.a)localObject).ecG = 1010;
      ((b.a)localObject).ecJ = 0;
      ((b.a)localObject).ecK = 0;
      localObject = ((b.a)localObject).Kt();
      qa localqa = (qa)((com.tencent.mm.ah.b)localObject).ecE.ecN;
      localqa.bOL = paramDialogInterface.gkh.mAppId;
      localqa.bSe = paramDialogInterface.bSe;
      localqa.qyu = str;
      com.tencent.mm.ipcinvoker.wx_extension.b.a((com.tencent.mm.ah.b)localObject, new c.5(paramDialogInterface, h.b(paramDialogInterface.gkh.mContext, "", false, null)));
      return;
    }
    if ((!TextUtils.isEmpty(this.gkx.gko.getText())) && (this.gkx.gko.getText().length() < 6))
    {
      h.bC(this.gkx.gkh.mContext, this.gkx.gkh.getContentView().getResources().getString(y.j.app_brand_get_phone_number_verify_code_error_format));
      y.e("MicroMsg.JsApiGetPhoneNumber", "code is length is < 6");
      return;
    }
    y.e("MicroMsg.JsApiGetPhoneNumber", "code is empty");
    h.bC(this.gkx.gkh.mContext, this.gkx.gkh.getContentView().getResources().getString(y.j.app_brand_get_phone_number_verify_code_error_empty));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c.18
 * JD-Core Version:    0.7.0.1
 */