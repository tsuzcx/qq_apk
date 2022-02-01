package com.tencent.mm.plugin.appbrand.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class a
  implements ac
{
  public final void a(Context paramContext, String paramString, dep paramdep)
  {
    AppMethodBeat.i(47476);
    if (TextUtils.isEmpty(paramString))
    {
      ad.w("MicroMsg.AppBrand.CustomizeExternalToolsHelper", "openWebViewActivity with empty url, stack:%s", new Object[] { Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(47476);
      return;
    }
    if (paramContext == null) {
      paramContext = aj.getContext();
    }
    for (;;)
    {
      Object localObject = new Intent().putExtra("rawUrl", paramString).putExtra(AppBrandProcessProxyUI.kpe, paramString);
      ((Intent)localObject).putExtra("rawUrl", paramString);
      if (!(paramContext instanceof Activity)) {
        ((Intent)localObject).addFlags(268435456);
      }
      if (paramdep != null)
      {
        ((Intent)localObject).putExtra("show_native_web_view", paramdep.HsQ);
        ((Intent)localObject).putExtra("KRightBtn", paramdep.HsR);
      }
      d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      AppMethodBeat.o(47476);
      return;
      localObject = com.tencent.mm.sdk.f.a.jq(paramContext);
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