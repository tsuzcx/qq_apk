package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.plugin.ag.a.a;
import com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView;
import com.tencent.mm.sdk.platformtools.y;

final class c$10
  implements a.a
{
  c$10(c paramc) {}
  
  public final void tS(String paramString)
  {
    y.i("MicroMsg.JsApiGetPhoneNumber", "smsListener onchange");
    y.d("MicroMsg.JsApiGetPhoneNumber", "smsVerifyCode:%s", new Object[] { paramString });
    this.gkx.gko.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c.10
 * JD-Core Version:    0.7.0.1
 */