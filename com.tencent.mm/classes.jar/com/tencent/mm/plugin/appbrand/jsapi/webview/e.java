package com.tencent.mm.plugin.appbrand.jsapi.webview;

import android.os.Bundle;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.scanner.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandWebViewQRCodeReportHelper;", "", "()V", "appendParamsForPreviewImg", "", "result", "Landroid/os/Bundle;", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "reportQrCode", "isShowEntry", "", "codeType", "", "codeStr", "", "isWebView", "isClick", "url", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e sLq;
  
  static
  {
    AppMethodBeat.i(327486);
    sLq = new e();
    AppMethodBeat.o(327486);
  }
  
  public static void a(Bundle paramBundle, ad paramad)
  {
    AppMethodBeat.i(327480);
    s.u(paramBundle, "result");
    if (paramad == null)
    {
      AppMethodBeat.o(327480);
      return;
    }
    paramBundle.putString("wxappPathWithQuery", paramad.cEE());
    Object localObject;
    if (paramad == null)
    {
      localObject = null;
      if (!(localObject instanceof w)) {
        break label108;
      }
      localObject = (w)localObject;
      label49:
      if (localObject != null) {
        break label113;
      }
      localObject = "";
      label56:
      if (paramad != null) {
        break label146;
      }
      paramad = null;
      label62:
      if (!(paramad instanceof w)) {
        break label154;
      }
      paramad = (w)paramad;
      label74:
      if (paramad != null) {
        break label159;
      }
    }
    label146:
    label154:
    label159:
    for (int i = 0;; i = paramad.asA().epn.scene)
    {
      paramBundle.putString("wxappSessionId", (String)localObject);
      paramBundle.putInt("wxappScene", i);
      AppMethodBeat.o(327480);
      return;
      localObject = paramad.getRuntime();
      break;
      label108:
      localObject = null;
      break label49;
      label113:
      localObject = ((w)localObject).getInitConfig();
      if (localObject == null)
      {
        localObject = "";
        break label56;
      }
      localObject = ((AppBrandInitConfigLU)localObject).eoP;
      if (localObject == null)
      {
        localObject = "";
        break label56;
      }
      break label56;
      paramad = paramad.getRuntime();
      break label62;
      paramad = null;
      break label74;
    }
  }
  
  public static void a(ad paramad, boolean paramBoolean1, int paramInt, String paramString1, boolean paramBoolean2, String paramString2)
  {
    AppMethodBeat.i(327474);
    if (paramad == null)
    {
      AppMethodBeat.o(327474);
      return;
    }
    Object localObject1;
    label37:
    label46:
    Object localObject2;
    if (paramad == null)
    {
      localObject1 = null;
      if (!(localObject1 instanceof w)) {
        break label119;
      }
      localObject1 = (w)localObject1;
      if (localObject1 != null) {
        break label125;
      }
      localObject1 = "";
      if (paramad != null) {
        break label167;
      }
      localObject2 = null;
      label53:
      if (!(localObject2 instanceof w)) {
        break label176;
      }
      localObject2 = (w)localObject2;
      label68:
      if (localObject2 != null) {
        break label182;
      }
    }
    label167:
    label176:
    label182:
    for (int i = 0;; i = ((d)localObject2).asA().epn.scene)
    {
      localObject2 = a.OGI;
      a.a((String)localObject1, i, paramad.getAppId(), true, paramad.cEE(), paramInt, paramString1, paramBoolean1, paramBoolean2, paramString2);
      AppMethodBeat.o(327474);
      return;
      localObject1 = paramad.getRuntime();
      break;
      label119:
      localObject1 = null;
      break label37;
      label125:
      localObject1 = ((w)localObject1).getInitConfig();
      if (localObject1 == null)
      {
        localObject1 = "";
        break label46;
      }
      localObject2 = ((AppBrandInitConfigLU)localObject1).eoP;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label46;
      }
      localObject1 = "";
      break label46;
      localObject2 = paramad.getRuntime();
      break label53;
      localObject2 = null;
      break label68;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.e
 * JD-Core Version:    0.7.0.1
 */