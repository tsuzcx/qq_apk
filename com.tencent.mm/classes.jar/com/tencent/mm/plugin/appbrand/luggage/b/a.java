package com.tencent.mm.plugin.appbrand.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.protocal.protobuf.dyq;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public final class a
  implements ag
{
  public final void a(Context paramContext, String paramString, dyq paramdyq)
  {
    AppMethodBeat.i(47476);
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrand.CustomizeExternalToolsHelper", "openWebViewActivity with empty url, stack:%s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(47476);
      return;
    }
    if (paramContext == null) {
      paramContext = MMApplicationContext.getContext();
    }
    for (;;)
    {
      Object localObject = new Intent().putExtra("rawUrl", paramString).putExtra(AppBrandProcessProxyUI.lwe, paramString);
      ((Intent)localObject).putExtra("rawUrl", paramString);
      if (!(paramContext instanceof Activity)) {
        ((Intent)localObject).addFlags(268435456);
      }
      if (paramdyq != null)
      {
        ((Intent)localObject).putExtra("show_native_web_view", paramdyq.MYd);
        ((Intent)localObject).putExtra("KRightBtn", paramdyq.MYe);
      }
      c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      AppMethodBeat.o(47476);
      return;
      localObject = AndroidContextUtil.castActivityOrNull(paramContext);
      if (localObject != null) {
        paramContext = (Context)localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.a
 * JD-Core Version:    0.7.0.1
 */