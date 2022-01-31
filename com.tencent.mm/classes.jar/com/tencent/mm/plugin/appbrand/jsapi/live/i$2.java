package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class i$2
  implements a.a
{
  i$2(i parami, AppBrandLivePusherView paramAppBrandLivePusherView) {}
  
  public final void ud(String paramString)
  {
    if (!bk.bl(paramString))
    {
      y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "convertWatermarkImageToLocalPath, localPath:%s", new Object[] { paramString });
      Bundle localBundle = new Bundle();
      localBundle.putString("watermarkImage", paramString);
      this.gsm.u(localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.i.2
 * JD-Core Version:    0.7.0.1
 */