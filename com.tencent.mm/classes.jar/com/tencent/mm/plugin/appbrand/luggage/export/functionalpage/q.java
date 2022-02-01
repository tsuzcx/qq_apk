package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ae;
import d.v;
import org.json.JSONException;
import org.json.JSONObject;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalAPIInvokeProcess;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "callbackContextMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "callbackIdGenerator", "", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "navigateBack", "", "transitiveData", "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "onPayAheadCallback", "callbackStr", "performInvoke", "invokeData", "CallbackContext", "Companion", "plugin-appbrand-integration_release"})
final class q
  implements o
{
  @Deprecated
  public static final b lTg;
  private final l lSR;
  private int lTe;
  private final SparseArray<a> lTf;
  
  static
  {
    AppMethodBeat.i(223628);
    lTg = new b((byte)0);
    AppMethodBeat.o(223628);
  }
  
  public q(l paraml)
  {
    AppMethodBeat.i(223627);
    this.lSR = paraml;
    this.lTf = new SparseArray();
    AppMethodBeat.o(223627);
  }
  
  private final void dY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223626);
    ae.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.LegacySDKInvokeProcess", "navigateBack, instance(" + hashCode() + "), invokeResult(" + paramString2 + ')');
    this.lTe += 1;
    int i = this.lTe;
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("data", paramString2);
    localJSONObject2.put("transitiveData", paramString1);
    localJSONObject1.put("extraData", localJSONObject2);
    paramString1 = localJSONObject1.toString();
    d.g.b.p.g(paramString1, "JSONObject().apply {\n   …   )\n        }.toString()");
    this.lTf.put(i, q.a.b.lTh);
    this.lSR.aXz().y("navigateBackApplication", paramString1, i);
    AppMethodBeat.o(223626);
  }
  
  public final void SN(String paramString)
  {
    AppMethodBeat.i(223623);
    d.g.b.p.h(paramString, "invokeData");
    ae.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.LegacySDKInvokeProcess", "performInvoke with instance(" + hashCode() + ") appId(" + this.lSR.getAppId() + ") data(" + paramString + ')');
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
        break label444;
      }
      if (localCharSequence.length() != 0) {
        break label458;
      }
    }
    catch (JSONException paramString)
    {
      do
      {
        CharSequence localCharSequence;
        ae.e("MicroMsg.AppBrand.FunctionalAPIInvokeManager", "performInvoke, json parse e = ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(223623);
        return;
        switch (paramString.hashCode())
        {
        }
      } while (!paramString.equals("webview"));
      paramString = this.lSR.aXy();
      d.g.b.p.g(paramString, "runtime.pageContainer");
      paramString = paramString.getPageView();
      if (paramString != null) {
        break label415;
      }
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
      AppMethodBeat.o(223623);
      throw paramString;
    }
    catch (RuntimeException paramString)
    {
      label149:
      label163:
      AppMethodBeat.o(223623);
      return;
    }
    if (i == 0)
    {
      localCharSequence = (CharSequence)str2;
      if (localCharSequence != null) {
        if (localCharSequence.length() != 0) {
          break label463;
        }
      }
    }
    else
    {
      dY(str3, "fail invalid args");
      AppMethodBeat.o(223623);
      return;
      paramString = paramString.optString("jsapiType");
      if (paramString != null) {}
    }
    for (;;)
    {
      dY(str3, d.dW("fail invalid jsapiType", str1));
      paramString = (Throwable)new RuntimeException();
      AppMethodBeat.o(223623);
      throw paramString;
      if (paramString.equals("appservice"))
      {
        paramString = this.lSR.aXz();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
          AppMethodBeat.o(223623);
          throw paramString;
        }
        label415:
        for (paramString = (p)paramString;; paramString = (p)paramString)
        {
          this.lTe += 1;
          i = this.lTe;
          this.lTf.put(i, new q.a.a(str3));
          if (paramString != null) {
            break;
          }
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.AppBrandComponentImpl");
          AppMethodBeat.o(223623);
          throw paramString;
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.d)paramString).y(str1, str2, i);
        AppMethodBeat.o(223623);
        return;
        label444:
        i = 1;
        break;
        label458:
        label463:
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label466;
          }
          break label149;
          i = 0;
          break;
        }
        label466:
        break label163;
      }
    }
  }
  
  public final void a(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(223624);
    d.g.b.p.h(paramp, "component");
    d.g.b.p.h(paramString, "data");
    paramp = (a)this.lTf.get(paramInt, null);
    if ((paramp instanceof q.a.a))
    {
      this.lTf.remove(paramInt);
      dY(((q.a.a)paramp).kbk, paramString);
      AppMethodBeat.o(223624);
      return;
    }
    if ((paramp instanceof q.a.b))
    {
      this.lTf.remove(paramInt);
      paramp = this.lSR.getContext();
      if (paramp != null) {
        paramp.moveTaskToBack(true);
      }
      this.lSR.finish();
    }
    AppMethodBeat.o(223624);
  }
  
  public final void b(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(223625);
    d.g.b.p.h(paramp, "component");
    d.g.b.p.h(paramString, "callbackStr");
    ae.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.LegacySDKInvokeProcess", "onPayAheadCallback, instance(" + hashCode() + ", callbackId(" + paramInt + "), callbackStr(" + paramString + ')');
    a(paramp, paramInt, paramString);
    AppMethodBeat.o(223625);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "", "()V", "InvokeCallbackContext", "NavigateBackCallbackContext", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$InvokeCallbackContext;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$NavigateBackCallbackContext;", "plugin-appbrand-integration_release"})
  public static abstract class a
  {
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$InvokeCallbackContext;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "transitiveData", "", "(Ljava/lang/String;)V", "getTransitiveData", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
    public static final class a
      extends q.a
    {
      final String kbk;
      
      public a(String paramString)
      {
        super();
        this.kbk = paramString;
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(223621);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if (!d.g.b.p.i(this.kbk, paramObject.kbk)) {}
          }
        }
        else
        {
          AppMethodBeat.o(223621);
          return true;
        }
        AppMethodBeat.o(223621);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(223620);
        String str = this.kbk;
        if (str != null)
        {
          int i = str.hashCode();
          AppMethodBeat.o(223620);
          return i;
        }
        AppMethodBeat.o(223620);
        return 0;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(223619);
        String str = "InvokeCallbackContext(transitiveData=" + this.kbk + ")";
        AppMethodBeat.o(223619);
        return str;
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$NavigateBackCallbackContext;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "()V", "plugin-appbrand-integration_release"})
    public static final class b
      extends q.a
    {
      public static final b lTh;
      
      static
      {
        AppMethodBeat.i(223622);
        lTh = new b();
        AppMethodBeat.o(223622);
      }
      
      private b()
      {
        super();
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.q
 * JD-Core Version:    0.7.0.1
 */