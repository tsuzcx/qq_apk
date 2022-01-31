package com.tencent.mm.plugin.appbrand.jsapi;

import android.net.Uri;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.sdk.platformtools.bk;
import java.net.URLDecoder;
import java.util.HashMap;

final class JsApiScanCode$1$1
  implements Runnable
{
  JsApiScanCode$1$1(JsApiScanCode.1 param1, JsApiScanCode.GetA8KeyTask paramGetA8KeyTask, HashMap paramHashMap) {}
  
  public final void run()
  {
    this.ghu.ahD();
    if (this.ghu.actionCode == 26)
    {
      Uri localUri = Uri.parse(this.ghu.ghy);
      String str = localUri.getQueryParameter("username");
      if (this.ghw.gbW.getRuntime().aaa().bFn.equals(str)) {
        this.ghv.put("path", URLDecoder.decode(bk.pm(localUri.getQueryParameter("path"))));
      }
    }
    this.ghw.gbW.C(this.ghw.dIS, this.ghw.ght.h("ok", this.ghv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode.1.1
 * JD-Core Version:    0.7.0.1
 */