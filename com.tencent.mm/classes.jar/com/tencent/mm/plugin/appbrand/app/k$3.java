package com.tencent.mm.plugin.appbrand.app;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.e.f;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class k$3
  implements com.tencent.mm.vending.c.a<Void, Void>
{
  k$3(k paramk, String paramString1, String paramString2) {}
  
  private Void bFz()
  {
    AppMethodBeat.i(283648);
    b.akn(this.nCI).bhW();
    try
    {
      Object localObject3 = new i(this.nCJ);
      Object localObject2 = new i(((i)localObject3).optString("invokeData"));
      localObject1 = ((i)localObject2).optString("miniprogramAppID");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        Log.e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage, invalid miniprogramAppId");
        b.akm(this.nCI).bhW();
        localObject1 = YAb;
        AppMethodBeat.o(283648);
        return localObject1;
      }
      String str1 = ((i)localObject2).optString("path", "__wx__/open-api-redirecting-page");
      Object localObject4 = ((i)localObject2).optString("name");
      String str2 = ((i)localObject3).optString("runtimeAppid");
      localObject3 = new AppBrandStatObject();
      ((AppBrandStatObject)localObject3).scene = 1111;
      ((AppBrandStatObject)localObject3).fvd = (str2 + ":" + (String)localObject4);
      localObject4 = new AppBrandLaunchReferrer();
      ((AppBrandLaunchReferrer)localObject4).nYB = 7;
      ((AppBrandLaunchReferrer)localObject4).appId = null;
      ((AppBrandLaunchReferrer)localObject4).nYE = ((i)localObject2).toString();
      localObject2 = new LaunchParcel();
      ((LaunchParcel)localObject2).appId = ((String)localObject1);
      ((LaunchParcel)localObject2).nBq = str1;
      ((LaunchParcel)localObject2).pdk = ((AppBrandStatObject)localObject3);
      ((LaunchParcel)localObject2).cwV = ((AppBrandLaunchReferrer)localObject4);
      ((LaunchParcel)localObject2).pZl = new com.tencent.luggage.sdk.launching.a() {};
      f.pZN.a(MMApplicationContext.getContext(), (LaunchParcel)localObject2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        Log.e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage, parse failed e = %s, uuid = %s, json = %s", new Object[] { localException, this.nCI, this.nCJ });
        b.akm(this.nCI).bhW();
      }
    }
    localObject1 = YAb;
    AppMethodBeat.o(283648);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.k.3
 * JD-Core Version:    0.7.0.1
 */