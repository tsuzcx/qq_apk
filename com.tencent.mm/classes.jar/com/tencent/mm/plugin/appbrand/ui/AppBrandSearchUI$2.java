package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.53;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class AppBrandSearchUI$2
  implements Runnable
{
  AppBrandSearchUI$2(AppBrandSearchUI paramAppBrandSearchUI, String paramString, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    d locald;
    String str;
    int i;
    int j;
    if (AppBrandSearchUI.b(this.hdU) != null)
    {
      locald = AppBrandSearchUI.c(this.hdU);
      str = this.hdV;
      i = this.hdW;
      j = this.hdX;
      if (!locald.ready) {
        y.e("MicroMsg.JsApiHandler", "onSearchGuideDataReady fail, not ready");
      }
    }
    else
    {
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onSearchGuideDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", str);
    localHashMap.put("isCacheData", Integer.valueOf(i));
    localHashMap.put("isExpired", Integer.valueOf(j));
    ai.d(new d.53(locald, i.a.a("onSearchGuideDataReady", localHashMap, locald.rxI, locald.rxJ)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI.2
 * JD-Core Version:    0.7.0.1
 */