package com.tencent.mm.plugin.appbrand.jsapi.webview;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.scanner.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandWebViewQRCodeReportHelper;", "", "()V", "appendParamsForPreviewImg", "", "result", "Landroid/os/Bundle;", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "reportQrCode", "isShowEntry", "", "codeType", "", "codeStr", "", "isWebView", "isClick", "url", "plugin-appbrand-integration_release"})
public final class e
{
  public static final e pGh;
  
  static
  {
    AppMethodBeat.i(269275);
    pGh = new e();
    AppMethodBeat.o(269275);
  }
  
  public static void a(Bundle paramBundle, ad paramad)
  {
    AppMethodBeat.i(269274);
    p.k(paramBundle, "result");
    if (paramad == null)
    {
      AppMethodBeat.o(269274);
      return;
    }
    paramBundle.putString("wxappPathWithQuery", paramad.cec());
    AppBrandRuntime localAppBrandRuntime = paramad.getRuntime();
    Object localObject = localAppBrandRuntime;
    if (!(localAppBrandRuntime instanceof t)) {
      localObject = null;
    }
    localObject = (t)localObject;
    if (localObject != null)
    {
      localObject = ((t)localObject).bDy();
      if (localObject != null)
      {
        localObject = ((AppBrandInitConfigWC)localObject).Qw();
        if (localObject != null) {
          break label138;
        }
      }
    }
    localObject = "";
    label138:
    for (;;)
    {
      localAppBrandRuntime = paramad.getRuntime();
      paramad = localAppBrandRuntime;
      if (!(localAppBrandRuntime instanceof t)) {
        paramad = null;
      }
      paramad = (t)paramad;
      if (paramad != null) {}
      for (int i = paramad.bDC();; i = 0)
      {
        paramBundle.putString("wxappSessionId", (String)localObject);
        paramBundle.putInt("wxappScene", i);
        AppMethodBeat.o(269274);
        return;
      }
    }
  }
  
  public static void a(ad paramad, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2)
  {
    AppMethodBeat.i(269273);
    if (paramad == null)
    {
      AppMethodBeat.o(269273);
      return;
    }
    Object localObject2 = paramad.getRuntime();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof t)) {
      localObject1 = null;
    }
    localObject1 = (t)localObject1;
    if (localObject1 != null)
    {
      localObject1 = ((t)localObject1).bDy();
      if (localObject1 != null)
      {
        localObject2 = ((AppBrandInitConfigWC)localObject1).Qw();
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label80;
        }
      }
    }
    localObject1 = "";
    label80:
    AppBrandRuntime localAppBrandRuntime = paramad.getRuntime();
    localObject2 = localAppBrandRuntime;
    if (!(localAppBrandRuntime instanceof t)) {
      localObject2 = null;
    }
    localObject2 = (t)localObject2;
    if (localObject2 != null) {}
    for (int i = ((t)localObject2).bDC();; i = 0)
    {
      localObject2 = a.IAB;
      a.a((String)localObject1, i, paramad.getAppId(), true, paramad.cec(), paramInt, paramString1, paramBoolean1, paramBoolean2, paramString2);
      AppMethodBeat.o(269273);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.e
 * JD-Core Version:    0.7.0.1
 */