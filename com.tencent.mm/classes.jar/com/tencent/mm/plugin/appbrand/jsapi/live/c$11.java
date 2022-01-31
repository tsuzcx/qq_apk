package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class c$11
  implements a.a
{
  c$11(c paramc, AppBrandLivePusherView paramAppBrandLivePusherView, String paramString) {}
  
  public final void ud(String paramString)
  {
    if (!bk.bl(paramString))
    {
      y.i("MicroMsg.JsApiInsertLivePusher.javayhu", "convertBackgroundImageToLocalPath, localPath:%s", new Object[] { paramString });
      Bundle localBundle = new Bundle();
      localBundle.putString("backgroundImage", paramString);
      this.gsm.u(localBundle);
      return;
    }
    y.i("MicroMsg.JsApiInsertLivePusher.javayhu", "convertBackgroundImageToLocalPath, load background image fail");
    paramString = new HashMap();
    paramString.put("url", this.val$url);
    this.gsm.a(10004, "load background image fail", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.c.11
 * JD-Core Version:    0.7.0.1
 */