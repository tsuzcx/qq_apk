package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalAPIInvokeProcess;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "callbackContextMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "callbackIdGenerator", "", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "navigateBack", "", "transitiveData", "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "onPayAheadCallback", "callbackStr", "performInvoke", "invokeData", "CallbackContext", "Companion", "plugin-appbrand-integration_release"})
final class q
  implements o
{
  @Deprecated
  public static final q.b lOF;
  private int lOD;
  private final SparseArray<q.a> lOE;
  private final l lOq;
  
  static
  {
    AppMethodBeat.i(189368);
    lOF = new q.b((byte)0);
    AppMethodBeat.o(189368);
  }
  
  public q(l paraml)
  {
    AppMethodBeat.i(189367);
    this.lOq = paraml;
    this.lOE = new SparseArray();
    AppMethodBeat.o(189367);
  }
  
  private final void dW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189366);
    ad.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.LegacySDKInvokeProcess", "navigateBack, instance(" + hashCode() + "), invokeResult(" + paramString2 + ')');
    this.lOD += 1;
    int i = this.lOD;
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("data", paramString2);
    localJSONObject2.put("transitiveData", paramString1);
    localJSONObject1.put("extraData", localJSONObject2);
    paramString1 = localJSONObject1.toString();
    d.g.b.p.g(paramString1, "JSONObject().apply {\n   …   )\n        }.toString()");
    this.lOE.put(i, q.a.b.lOG);
    this.lOq.aXe().y("navigateBackApplication", paramString1, i);
    AppMethodBeat.o(189366);
  }
  
  public final void Se(String paramString)
  {
    AppMethodBeat.i(189363);
    d.g.b.p.h(paramString, "invokeData");
    ad.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.LegacySDKInvokeProcess", "performInvoke with instance(" + hashCode() + ") appId(" + this.lOq.getAppId() + ") data(" + paramString + ')');
    String str1;
    String str2;
    String str3;
    int i;
    try
    {
      paramString = new JSONObject(paramString);
      str1 = paramString.optString("name");
      str2 = paramString.optString("args");
      str3 = paramString.optString("transitiveData");
      localCharSequence = (CharSequence)str1;
      if (localCharSequence == null) {
        break label443;
      }
      if (localCharSequence.length() != 0) {
        break label457;
      }
    }
    catch (JSONException paramString)
    {
      do
      {
        CharSequence localCharSequence;
        ad.e("MicroMsg.AppBrand.FunctionalAPIInvokeManager", "performInvoke, json parse e = ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(189363);
        return;
        switch (paramString.hashCode())
        {
        }
      } while (!paramString.equals("webview"));
      paramString = this.lOq.aXd();
      d.g.b.p.g(paramString, "runtime.pageContainer");
      paramString = paramString.getPageView();
      if (paramString != null) {
        break label414;
      }
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
      AppMethodBeat.o(189363);
      throw paramString;
    }
    catch (RuntimeException paramString)
    {
      label149:
      label163:
      AppMethodBeat.o(189363);
      return;
    }
    if (i == 0)
    {
      localCharSequence = (CharSequence)str2;
      if (localCharSequence != null) {
        if (localCharSequence.length() != 0) {
          break label462;
        }
      }
    }
    else
    {
      dW(str3, "fail invalid args");
      AppMethodBeat.o(189363);
      return;
      paramString = paramString.optString("jsapiType");
      if (paramString != null) {}
    }
    for (;;)
    {
      dW(str3, d.dU("fail invalid jsapiType", str1));
      paramString = (Throwable)new RuntimeException();
      AppMethodBeat.o(189363);
      throw paramString;
      if (paramString.equals("appservice"))
      {
        paramString = this.lOq.aXe();
        if (paramString == null)
        {
          paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
          AppMethodBeat.o(189363);
          throw paramString;
        }
        label414:
        for (paramString = (p)paramString;; paramString = (p)paramString)
        {
          this.lOD += 1;
          i = this.lOD;
          this.lOE.put(i, new q.a.a(str3));
          if (paramString != null) {
            break;
          }
          paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.AppBrandComponentImpl");
          AppMethodBeat.o(189363);
          throw paramString;
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.d)paramString).y(str1, str2, i);
        AppMethodBeat.o(189363);
        return;
        label443:
        i = 1;
        break;
        label457:
        label462:
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label465;
          }
          break label149;
          i = 0;
          break;
        }
        label465:
        break label163;
      }
    }
  }
  
  public final void a(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(189364);
    d.g.b.p.h(paramp, "component");
    d.g.b.p.h(paramString, "data");
    paramp = (q.a)this.lOE.get(paramInt, null);
    if ((paramp instanceof q.a.a))
    {
      this.lOE.remove(paramInt);
      dW(((q.a.a)paramp).jXV, paramString);
      AppMethodBeat.o(189364);
      return;
    }
    if ((paramp instanceof q.a.b))
    {
      this.lOE.remove(paramInt);
      paramp = this.lOq.getContext();
      if (paramp != null) {
        paramp.moveTaskToBack(true);
      }
      this.lOq.finish();
    }
    AppMethodBeat.o(189364);
  }
  
  public final void b(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(189365);
    d.g.b.p.h(paramp, "component");
    d.g.b.p.h(paramString, "callbackStr");
    ad.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.LegacySDKInvokeProcess", "onPayAheadCallback, instance(" + hashCode() + ", callbackId(" + paramInt + "), callbackStr(" + paramString + ')');
    a(paramp, paramInt, paramString);
    AppMethodBeat.o(189365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.q
 * JD-Core Version:    0.7.0.1
 */