package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.os.Parcelable;
import com.tencent.luggage.sdk.launching.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.sdk.platformtools.ae;
import d.v;
import org.json.JSONException;
import org.json.JSONObject;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WebInvokeProcess;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalAPIInvokeProcess;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "CALLBACK_ID", "", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "transitiveData", "", "navigateBack", "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "onPayAheadCallback", "callbackStr", "performInvoke", "invokeData", "Companion", "plugin-appbrand-integration_release"})
final class r
  implements o
{
  @Deprecated
  public static final a lTx;
  private String kbk;
  private final l lSR;
  private final int lTj;
  
  static
  {
    AppMethodBeat.i(223663);
    lTx = new a((byte)0);
    AppMethodBeat.o(223663);
  }
  
  public r(l paraml)
  {
    AppMethodBeat.i(223662);
    this.lSR = paraml;
    this.lTj = (hashCode() & 0xFFFF);
    AppMethodBeat.o(223662);
  }
  
  private final void dY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223661);
    ae.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.WebInvokeProcess", "navigateBack, instance(" + hashCode() + "), invokeResult(" + paramString2 + ')');
    a locala = this.lSR.aXx().cmC;
    if (locala != null)
    {
      if (locala == null)
      {
        paramString1 = new v("null cannot be cast to non-null type com.tencent.luggage.sdk.launching.OnWXAppResultListener<com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult>");
        AppMethodBeat.o(223661);
        throw paramString1;
      }
      locala.b((Parcelable)new ByRuntimeQrcodeResult(paramString2, paramString1));
      this.lSR.finish();
      AppMethodBeat.o(223661);
      return;
    }
    AppMethodBeat.o(223661);
  }
  
  public final void SN(String paramString)
  {
    AppMethodBeat.i(223658);
    d.g.b.p.h(paramString, "invokeData");
    ae.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.WebInvokeProcess", "performInvoke with instance(" + hashCode() + "), appId(" + this.lSR.getAppId() + ") data(" + paramString + ')');
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
        ae.e("MicroMsg.AppBrand.FunctionalAPIInvokeManager", "performInvoke, json parse e = ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(223658);
        return;
        switch (((String)localObject).hashCode())
        {
        }
      } while (!((String)localObject).equals("webview"));
      paramString = this.lSR.aXy();
      d.g.b.p.g(paramString, "runtime.pageContainer");
      paramString = paramString.getPageView();
      if (paramString != null) {
        break label385;
      }
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
      AppMethodBeat.o(223658);
      throw paramString;
    }
    catch (RuntimeException paramString)
    {
      label152:
      label165:
      AppMethodBeat.o(223658);
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
      dY(paramString, "fail invalid args");
      AppMethodBeat.o(223658);
      return;
      localObject = ((JSONObject)localObject).optString("jsapiType");
      if (localObject != null) {}
    }
    for (;;)
    {
      dY(paramString, d.dW("fail invalid jsapiType", str1));
      paramString = (Throwable)new RuntimeException();
      AppMethodBeat.o(223658);
      throw paramString;
      if (((String)localObject).equals("appservice"))
      {
        paramString = this.lSR.aXz();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
          AppMethodBeat.o(223658);
          throw paramString;
        }
        label385:
        for (paramString = (p)paramString; paramString == null; paramString = (p)paramString)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.AppBrandComponentImpl");
          AppMethodBeat.o(223658);
          throw paramString;
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.d)paramString).y(str1, str2, this.lTj);
        AppMethodBeat.o(223658);
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
    AppMethodBeat.i(223659);
    d.g.b.p.h(paramp, "component");
    d.g.b.p.h(paramString, "data");
    if (this.lTj == paramInt) {
      dY(this.kbk, paramString);
    }
    AppMethodBeat.o(223659);
  }
  
  public final void b(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(223660);
    d.g.b.p.h(paramp, "component");
    d.g.b.p.h(paramString, "callbackStr");
    ae.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.WebInvokeProcess", "onPayAheadCallback, instance(" + hashCode() + ", callbackId(" + paramInt + "), callbackStr(" + paramString + ')');
    dY(this.kbk, paramString);
    AppMethodBeat.o(223660);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WebInvokeProcess$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.r
 * JD-Core Version:    0.7.0.1
 */