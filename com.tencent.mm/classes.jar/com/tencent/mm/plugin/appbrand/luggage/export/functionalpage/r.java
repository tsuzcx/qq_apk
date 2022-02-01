package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.os.Parcelable;
import com.tencent.luggage.sdk.launching.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.t;
import org.json.JSONException;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WebInvokeProcess;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalAPIInvokeProcess;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "CALLBACK_ID", "", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "transitiveData", "", "navigateBack", "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "onPayAheadCallback", "callbackStr", "performInvoke", "invokeData", "Companion", "plugin-appbrand-integration_release"})
final class r
  implements o
{
  @Deprecated
  public static final a nba;
  private String les;
  private final int naM;
  private final l nas;
  
  static
  {
    AppMethodBeat.i(228882);
    nba = new a((byte)0);
    AppMethodBeat.o(228882);
  }
  
  public r(l paraml)
  {
    AppMethodBeat.i(228881);
    this.nas = paraml;
    this.naM = (hashCode() & 0xFFFF);
    AppMethodBeat.o(228881);
  }
  
  private final void ep(String paramString1, String paramString2)
  {
    AppMethodBeat.i(228880);
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.WebInvokeProcess", "navigateBack, instance(" + hashCode() + "), invokeResult(" + paramString2 + ')');
    a locala = this.nas.bsC().cyx;
    if (locala != null)
    {
      if (locala == null)
      {
        paramString1 = new t("null cannot be cast to non-null type com.tencent.luggage.sdk.launching.OnWXAppResultListener<com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult>");
        AppMethodBeat.o(228880);
        throw paramString1;
      }
      locala.b((Parcelable)new ByRuntimeQrcodeResult(paramString2, paramString1));
      this.nas.bOG();
      AppMethodBeat.o(228880);
      return;
    }
    AppMethodBeat.o(228880);
  }
  
  public final void a(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(228878);
    kotlin.g.b.p.h(paramp, "component");
    kotlin.g.b.p.h(paramString, "data");
    if (this.naM == paramInt) {
      ep(this.les, paramString);
    }
    AppMethodBeat.o(228878);
  }
  
  public final void acv(String paramString)
  {
    AppMethodBeat.i(228877);
    kotlin.g.b.p.h(paramString, "invokeData");
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.WebInvokeProcess", "performInvoke with instance(" + hashCode() + "), appId(" + this.nas.getAppId() + ") data(" + paramString + ')');
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
        break label418;
      }
      if (localCharSequence.length() != 0) {
        break label432;
      }
    }
    catch (JSONException paramString)
    {
      do
      {
        CharSequence localCharSequence;
        Log.e("MicroMsg.AppBrand.FunctionalAPIInvokeManager.WebInvokeProcess", "performInvoke, json parse e = ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(228877);
        return;
        switch (((String)localObject).hashCode())
        {
        }
      } while (!((String)localObject).equals("webview"));
      paramString = this.nas.bsD();
      kotlin.g.b.p.g(paramString, "runtime.pageContainer");
      paramString = paramString.getPageView();
      if (paramString != null) {
        break label386;
      }
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
      AppMethodBeat.o(228877);
      throw paramString;
    }
    catch (RuntimeException paramString)
    {
      label152:
      label165:
      AppMethodBeat.o(228877);
      return;
    }
    if (i == 0)
    {
      localCharSequence = (CharSequence)str2;
      if (localCharSequence != null) {
        if (localCharSequence.length() != 0) {
          break label437;
        }
      }
    }
    else
    {
      ep(paramString, "fail invalid args");
      AppMethodBeat.o(228877);
      return;
      localObject = ((JSONObject)localObject).optString("jsapiType");
      if (localObject != null) {}
    }
    for (;;)
    {
      ep(paramString, d.en("fail invalid jsapiType", str1));
      paramString = (Throwable)new RuntimeException();
      AppMethodBeat.o(228877);
      throw paramString;
      if (((String)localObject).equals("appservice"))
      {
        paramString = this.nas.bsE();
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
          AppMethodBeat.o(228877);
          throw paramString;
        }
        label386:
        for (paramString = (p)paramString; paramString == null; paramString = (p)paramString)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.AppBrandComponentImpl");
          AppMethodBeat.o(228877);
          throw paramString;
        }
        ((g)paramString).y(str1, str2, this.naM);
        AppMethodBeat.o(228877);
        return;
        label418:
        i = 1;
        break;
        label432:
        label437:
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label440;
          }
          break label152;
          i = 0;
          break;
        }
        label440:
        break label165;
      }
    }
  }
  
  public final void b(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(228879);
    kotlin.g.b.p.h(paramp, "component");
    kotlin.g.b.p.h(paramString, "callbackStr");
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.WebInvokeProcess", "onPayAheadCallback, instance(" + hashCode() + ", callbackId(" + paramInt + "), callbackStr(" + paramString + ')');
    ep(this.les, paramString);
    AppMethodBeat.o(228879);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WebInvokeProcess$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.r
 * JD-Core Version:    0.7.0.1
 */