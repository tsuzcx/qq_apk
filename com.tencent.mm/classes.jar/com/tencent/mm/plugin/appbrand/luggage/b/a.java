package com.tencent.mm.plugin.appbrand.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.jsapi.aj;
import com.tencent.mm.protocal.protobuf.fcw;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public final class a
  implements aj
{
  public final void a(Context paramContext, String paramString1, String paramString2, fcw paramfcw)
  {
    AppMethodBeat.i(319878);
    if (TextUtils.isEmpty(paramString1))
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrand.CustomizeExternalToolsHelper", "openWebViewActivity with empty url, stack:%s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(319878);
      return;
    }
    Object localObject;
    int i;
    if (paramContext == null)
    {
      paramContext = MMApplicationContext.getContext();
      localObject = new Intent().putExtra("rawUrl", paramString1).putExtra(AppBrandProcessProxyUI.ruH, paramString1);
      ((Intent)localObject).putExtra("rawUrl", paramString1);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.CustomizeExternalToolsHelper", "orientation:%s", new Object[] { paramString2 });
      i = -1;
      if (!Util.isNullOrNil(paramString2))
      {
        if (!paramString2.equals("landscape")) {
          break label233;
        }
        i = 0;
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("screen_orientation", i);
      if (!(paramContext instanceof Activity)) {
        ((Intent)localObject).addFlags(268435456);
      }
      if (paramfcw != null)
      {
        ((Intent)localObject).putExtra("show_native_web_view", paramfcw.abCk);
        ((Intent)localObject).putExtra("KRightBtn", paramfcw.abCl);
        ((Intent)localObject).putExtra("geta8key_scene", paramfcw.scene);
        ((Intent)localObject).putExtra("geta8key_open_webview_appid", paramfcw.appId);
      }
      c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      AppMethodBeat.o(319878);
      return;
      localObject = AndroidContextUtil.castActivityOrNull(paramContext);
      if (localObject == null) {
        break;
      }
      paramContext = (Context)localObject;
      break;
      label233:
      if (paramString2.equals("portrait")) {
        i = 1;
      } else if (paramString2.equals("auto")) {
        i = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.a
 * JD-Core Version:    0.7.0.1
 */