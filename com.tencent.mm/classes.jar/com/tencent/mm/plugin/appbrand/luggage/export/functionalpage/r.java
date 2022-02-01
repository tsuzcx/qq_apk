package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.os.Parcelable;
import com.tencent.luggage.sdk.launching.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WebInvokeProcess;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalAPIInvokeProcess;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "CALLBACK_ID", "", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "transitiveData", "", "navigateBack", "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "onPayAheadCallback", "callbackStr", "performInvoke", "invokeData", "Companion", "plugin-appbrand-integration_release"})
final class r
  implements o
{
  @Deprecated
  public static final r.a lOW;
  private String jXV;
  private final int lOI;
  private final l lOq;
  
  static
  {
    AppMethodBeat.i(189403);
    lOW = new r.a((byte)0);
    AppMethodBeat.o(189403);
  }
  
  public r(l paraml)
  {
    AppMethodBeat.i(189402);
    this.lOq = paraml;
    this.lOI = (hashCode() & 0xFFFF);
    AppMethodBeat.o(189402);
  }
  
  private final void dW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189401);
    ad.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.WebInvokeProcess", "navigateBack, instance(" + hashCode() + "), invokeResult(" + paramString2 + ')');
    a locala = this.lOq.aXc().cmA;
    if (locala != null)
    {
      if (locala == null)
      {
        paramString1 = new d.v("null cannot be cast to non-null type com.tencent.luggage.sdk.launching.OnWXAppResultListener<com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult>");
        AppMethodBeat.o(189401);
        throw paramString1;
      }
      locala.b((Parcelable)new ByRuntimeQrcodeResult(paramString2, paramString1));
      this.lOq.finish();
      AppMethodBeat.o(189401);
      return;
    }
    AppMethodBeat.o(189401);
  }
  
  public final void Se(String paramString)
  {
    AppMethodBeat.i(189398);
    d.g.b.p.h(paramString, "invokeData");
    ad.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.WebInvokeProcess", "performInvoke with instance(" + hashCode() + "), appId(" + this.lOq.getAppId() + ") data(" + paramString + ')');
    Object localObject;
    String str1;
    String str2;
    int i;
    try
    {
      localObject = new JSONObject(paramString);
      str1 = ((JSONObject)localObject).optString("name");
      str2 = ((JSONObject)localObject).optString("args");
      paramString = ((JSONObject)localObject).optString("transitiveData");
      localCharSequence = (CharSequence)str1;
      if (localCharSequence == null) {
        break label417;
      }
      if (localCharSequence.length() != 0) {
        break label431;
      }
    }
    catch (JSONException paramString)
    {
      do
      {
        CharSequence localCharSequence;
        ad.e("MicroMsg.AppBrand.FunctionalAPIInvokeManager", "performInvoke, json parse e = ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(189398);
        return;
        switch (((String)localObject).hashCode())
        {
        }
      } while (!((String)localObject).equals("webview"));
      paramString = this.lOq.aXd();
      d.g.b.p.g(paramString, "runtime.pageContainer");
      paramString = paramString.getPageView();
      if (paramString != null) {
        break label385;
      }
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
      AppMethodBeat.o(189398);
      throw paramString;
    }
    catch (RuntimeException paramString)
    {
      label152:
      label165:
      AppMethodBeat.o(189398);
      return;
    }
    if (i == 0)
    {
      localCharSequence = (CharSequence)str2;
      if (localCharSequence != null) {
        if (localCharSequence.length() != 0) {
          break label436;
        }
      }
    }
    else
    {
      dW(paramString, "fail invalid args");
      AppMethodBeat.o(189398);
      return;
      localObject = ((JSONObject)localObject).optString("jsapiType");
      if (localObject != null) {}
    }
    for (;;)
    {
      dW(paramString, d.dU("fail invalid jsapiType", str1));
      paramString = (Throwable)new RuntimeException();
      AppMethodBeat.o(189398);
      throw paramString;
      if (((String)localObject).equals("appservice"))
      {
        paramString = this.lOq.aXe();
        if (paramString == null)
        {
          paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
          AppMethodBeat.o(189398);
          throw paramString;
        }
        label385:
        for (paramString = (p)paramString; paramString == null; paramString = (p)paramString)
        {
          paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.AppBrandComponentImpl");
          AppMethodBeat.o(189398);
          throw paramString;
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.d)paramString).y(str1, str2, this.lOI);
        AppMethodBeat.o(189398);
        return;
        label417:
        i = 1;
        break;
        label431:
        label436:
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label439;
          }
          break label152;
          i = 0;
          break;
        }
        label439:
        break label165;
      }
    }
  }
  
  public final void a(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(189399);
    d.g.b.p.h(paramp, "component");
    d.g.b.p.h(paramString, "data");
    if (this.lOI == paramInt) {
      dW(this.jXV, paramString);
    }
    AppMethodBeat.o(189399);
  }
  
  public final void b(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(189400);
    d.g.b.p.h(paramp, "component");
    d.g.b.p.h(paramString, "callbackStr");
    ad.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.WebInvokeProcess", "onPayAheadCallback, instance(" + hashCode() + ", callbackId(" + paramInt + "), callbackStr(" + paramString + ')');
    dW(this.jXV, paramString);
    AppMethodBeat.o(189400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.r
 * JD-Core Version:    0.7.0.1
 */