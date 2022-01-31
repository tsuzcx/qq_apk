package com.tencent.mm.plugin.appbrand.jsapi.version;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.widget.b.b;
import com.tencent.mm.plugin.appbrand.widget.b.i;
import com.tencent.mm.plugin.appbrand.y.j;

final class JsApiUpdateApp$1$1
  implements Runnable
{
  JsApiUpdateApp$1$1(JsApiUpdateApp.1 param1) {}
  
  public final void run()
  {
    b localb = new b(this.gCx.gbW.getContext());
    localb.setCanceledOnTouchOutside(false);
    localb.setCancelable(false);
    Object localObject = this.gCx.gbW.getContext();
    int i;
    if (this.gCx.gbW.getRuntime().ZH())
    {
      i = y.j.app_brand_jsapi_update_app_need_reboot_wording_for_game;
      localb.setMessage(((Context)localObject).getString(i, new Object[] { this.gCx.gbW.getRuntime().aac().bJw }));
      localObject = new JsApiUpdateApp.1.1.1(this);
      if (this.gCx.gbW.getRuntime().aaa().fPS.fEM == 0) {
        break label169;
      }
      localb.a(y.j.app_brand_jsapi_update_app_dialog_confirm_for_debug, (DialogInterface.OnClickListener)localObject);
      localb.b(y.j.app_brand_jsapi_update_app_dialog_cancel_for_debug, new JsApiUpdateApp.1.1.2(this));
    }
    for (;;)
    {
      this.gCx.gbW.Zm().b(localb);
      return;
      i = y.j.app_brand_jsapi_update_app_need_reboot_wording_for_normal;
      break;
      label169:
      localb.a(y.j.app_brand_jsapi_update_app_dialog_confirm, (DialogInterface.OnClickListener)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp.1.1
 * JD-Core Version:    0.7.0.1
 */