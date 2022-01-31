package com.tencent.mm.plugin.appbrand.app;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.precondition.f;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class e$2
  implements com.tencent.mm.vending.c.a<Void, Void>
{
  e$2(e parame, String paramString1, String paramString2) {}
  
  private Void atf()
  {
    AppMethodBeat.i(129241);
    b.Du(this.gSO).adl();
    try
    {
      Object localObject3 = new i(this.gSP);
      Object localObject2 = new i(((i)localObject3).optString("invokeData"));
      localObject1 = ((i)localObject2).optString("miniprogramAppID");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        ab.e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage, invalid miniprogramAppId");
        b.Dt(this.gSO).adl();
        localObject1 = AOo;
        AppMethodBeat.o(129241);
        return localObject1;
      }
      Object localObject4 = ((i)localObject2).optString("name");
      String str = ((i)localObject3).optString("runtimeAppid");
      localObject3 = new AppBrandStatObject();
      ((AppBrandStatObject)localObject3).scene = 1111;
      ((AppBrandStatObject)localObject3).cmF = (str + ":" + (String)localObject4);
      localObject4 = new AppBrandLaunchReferrer();
      ((AppBrandLaunchReferrer)localObject4).hiK = 7;
      ((AppBrandLaunchReferrer)localObject4).appId = null;
      ((AppBrandLaunchReferrer)localObject4).hiN = ((i)localObject2).toString();
      localObject2 = new LaunchParcel();
      ((LaunchParcel)localObject2).appId = ((String)localObject1);
      ((LaunchParcel)localObject2).hiw = "__wx__/open-api-redirecting-page";
      ((LaunchParcel)localObject2).inG = ((AppBrandStatObject)localObject3);
      ((LaunchParcel)localObject2).hiz = ((AppBrandLaunchReferrer)localObject4);
      ((LaunchParcel)localObject2).inJ = new e.2.1(this);
      f.ioc.a(ah.getContext(), (LaunchParcel)localObject2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        ab.e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage, parse failed e = %s, uuid = %s, json = %s", new Object[] { localException, this.gSO, this.gSP });
        b.Dt(this.gSO).adl();
      }
    }
    localObject1 = AOo;
    AppMethodBeat.o(129241);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.e.2
 * JD-Core Version:    0.7.0.1
 */