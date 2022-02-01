package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.h.63;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;
import java.util.Map;

final class AppBrandSearchUI$2
  implements Runnable
{
  AppBrandSearchUI$2(AppBrandSearchUI paramAppBrandSearchUI, String paramString, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    AppMethodBeat.i(21133);
    if (this.nWC.IBw != null)
    {
      h localh = this.nWC.IBw;
      String str = this.nWD;
      int i = this.nWE;
      int j = this.nWF;
      int k = this.nWG;
      if (!localh.GBl)
      {
        Log.e("MicroMsg.JsApiHandler", "onSearchGuideDataReady fail, not ready");
        AppMethodBeat.o(21133);
        return;
      }
      Log.i("MicroMsg.JsApiHandler", "onSearchGuideDataReady success, ready");
      HashMap localHashMap = new HashMap();
      localHashMap.put("json", str);
      localHashMap.put("isCacheData", Integer.valueOf(i));
      localHashMap.put("isExpired", Integer.valueOf(j));
      localHashMap.put("isPreload", Integer.valueOf(k));
      MMHandlerThread.postToMainThread(new h.63(localh, n.a.b("onSearchGuideDataReady", localHashMap, localh.IRj, localh.zpY)));
    }
    AppMethodBeat.o(21133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI.2
 * JD-Core Version:    0.7.0.1
 */