package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.os.Parcelable;
import com.tencent.luggage.sdk.launching.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.t;
import org.json.JSONException;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WebInvokeProcess;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalAPIInvokeProcess;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "CALLBACK_ID", "", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "transitiveData", "", "navigateBack", "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "onPayAheadCallback", "callbackStr", "performInvoke", "invokeData", "Companion", "plugin-appbrand-integration_release"})
final class r
  implements o
{
  @Deprecated
  public static final a qbp;
  private String nYF;
  private final l qaH;
  private final int qbb;
  
  static
  {
    AppMethodBeat.i(282824);
    qbp = new a((byte)0);
    AppMethodBeat.o(282824);
  }
  
  public r(l paraml)
  {
    AppMethodBeat.i(282822);
    this.qaH = paraml;
    this.qbb = (hashCode() & 0xFFFF);
    AppMethodBeat.o(282822);
  }
  
  private final void eD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(282821);
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.WebInvokeProcess", "navigateBack, instance(" + hashCode() + "), invokeResult(" + paramString2 + ')');
    a locala = this.qaH.bDy().cxc;
    if (locala != null)
    {
      if (locala == null)
      {
        paramString1 = new t("null cannot be cast to non-null type com.tencent.luggage.sdk.launching.OnWXAppResultListener<com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult>");
        AppMethodBeat.o(282821);
        throw paramString1;
      }
      locala.b((Parcelable)new ByRuntimeQrcodeResult(paramString2, paramString1));
      this.qaH.caW();
      AppMethodBeat.o(282821);
      return;
    }
    AppMethodBeat.o(282821);
  }
  
  public final void a(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(282817);
    kotlin.g.b.p.k(paramp, "component");
    kotlin.g.b.p.k(paramString, "data");
    if (this.qbb == paramInt) {
      eD(this.nYF, paramString);
    }
    AppMethodBeat.o(282817);
  }
  
  public final void akp(String paramString)
  {
    AppMethodBeat.i(282815);
    kotlin.g.b.p.k(paramString, "invokeData");
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.WebInvokeProcess", "performInvoke with instance(" + hashCode() + "), appId(" + this.qaH.getAppId() + ") data(" + paramString + ')');
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
        AppMethodBeat.o(282815);
        return;
        switch (((String)localObject).hashCode())
        {
        }
      } while (!((String)localObject).equals("webview"));
      paramString = this.qaH.bDz();
      kotlin.g.b.p.j(paramString, "runtime.pageContainer");
      paramString = paramString.getPageView();
      if (paramString != null) {
        break label386;
      }
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
      AppMethodBeat.o(282815);
      throw paramString;
    }
    catch (RuntimeException paramString)
    {
      label152:
      label165:
      AppMethodBeat.o(282815);
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
      eD(paramString, "fail invalid args");
      AppMethodBeat.o(282815);
      return;
      localObject = ((JSONObject)localObject).optString("jsapiType");
      if (localObject != null) {}
    }
    for (;;)
    {
      eD(paramString, d.eB("fail invalid jsapiType", str1));
      paramString = (Throwable)new RuntimeException();
      AppMethodBeat.o(282815);
      throw paramString;
      if (((String)localObject).equals("appservice"))
      {
        paramString = this.qaH.bDA();
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
          AppMethodBeat.o(282815);
          throw paramString;
        }
        label386:
        for (paramString = (p)paramString; paramString == null; paramString = (p)paramString)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.AppBrandComponentImpl");
          AppMethodBeat.o(282815);
          throw paramString;
        }
        ((f)paramString).B(str1, str2, this.qbb);
        AppMethodBeat.o(282815);
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
    AppMethodBeat.i(282819);
    kotlin.g.b.p.k(paramp, "component");
    kotlin.g.b.p.k(paramString, "callbackStr");
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.WebInvokeProcess", "onPayAheadCallback, instance(" + hashCode() + ", callbackId(" + paramInt + "), callbackStr(" + paramString + ')');
    eD(this.nYF, paramString);
    AppMethodBeat.o(282819);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WebInvokeProcess$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.r
 * JD-Core Version:    0.7.0.1
 */