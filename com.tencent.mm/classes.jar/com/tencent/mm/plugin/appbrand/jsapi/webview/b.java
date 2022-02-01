package com.tencent.mm.plugin.appbrand.jsapi.webview;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.ui.widget.MMWebView;

public final class b
{
  public static String[] c(ah paramah)
  {
    AppMethodBeat.i(327449);
    Object localObject2 = paramah.getRuntime();
    Object localObject4 = ((d)localObject2).asA().epn;
    Object localObject3 = ((w)localObject2).getInitConfig();
    Object localObject1 = paramah.cFg();
    String str1 = ((AppBrandStatObject)localObject4).scene;
    String str2 = ((AppBrandStatObject)localObject4).hzx;
    String str3 = ((AppBrandRuntime)localObject2).mAppId;
    String str4 = ((w)localObject2).ccM().qYY.pkgVersion;
    localObject3 = ((AppBrandInitConfigLU)localObject3).eoP;
    String str5 = ((w)localObject2).ccM().qYY.qHO + 1;
    String str6 = ((AppBrandStatObject)localObject4).tOj;
    String str7 = paramah.cgR();
    if (localObject1 == null) {}
    for (localObject1 = "";; localObject1 = ((g.c)localObject1).getWebView().getUrl())
    {
      paramah = j.getNetworkType(paramah.getContext());
      String str8 = ((AppBrandStatObject)localObject4).icZ;
      localObject4 = ((AppBrandStatObject)localObject4).ida;
      localObject2 = ((w)localObject2).getInitConfig().appServiceType + 1000;
      AppMethodBeat.o(327449);
      return new String[] { str1, str2, str3, str4, localObject3, str5, str6, str7, localObject1, paramah, "", "", "", "", "", "", str8, localObject4, localObject2 };
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.b
 * JD-Core Version:    0.7.0.1
 */