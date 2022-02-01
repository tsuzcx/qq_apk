package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.t;
import org.json.JSONException;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalAPIInvokeProcess;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "callbackContextMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "callbackIdGenerator", "", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "navigateBack", "", "transitiveData", "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "onPayAheadCallback", "callbackStr", "performInvoke", "invokeData", "CallbackContext", "Companion", "plugin-appbrand-integration_release"})
final class q
  implements o
{
  @Deprecated
  public static final b qaY;
  private final l qaH;
  private int qaW;
  private final SparseArray<a> qaX;
  
  static
  {
    AppMethodBeat.i(280283);
    qaY = new b((byte)0);
    AppMethodBeat.o(280283);
  }
  
  public q(l paraml)
  {
    AppMethodBeat.i(280281);
    this.qaH = paraml;
    this.qaX = new SparseArray();
    AppMethodBeat.o(280281);
  }
  
  private final void eD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(280279);
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.LegacySDKInvokeProcess", "navigateBack, instance(" + hashCode() + "), invokeResult(" + paramString2 + ')');
    this.qaW += 1;
    int i = this.qaW;
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("data", paramString2);
    localJSONObject2.put("transitiveData", paramString1);
    localJSONObject1.put("extraData", localJSONObject2);
    paramString1 = localJSONObject1.toString();
    kotlin.g.b.p.j(paramString1, "JSONObject().apply {\n   …   )\n        }.toString()");
    this.qaX.put(i, q.a.b.qaZ);
    this.qaH.bDA().B("navigateBackApplication", paramString1, i);
    AppMethodBeat.o(280279);
  }
  
  public final void a(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(280275);
    kotlin.g.b.p.k(paramp, "component");
    kotlin.g.b.p.k(paramString, "data");
    paramp = (a)this.qaX.get(paramInt, null);
    if ((paramp instanceof q.a.a))
    {
      this.qaX.remove(paramInt);
      eD(((q.a.a)paramp).nYF, paramString);
      AppMethodBeat.o(280275);
      return;
    }
    if ((paramp instanceof q.a.b))
    {
      this.qaX.remove(paramInt);
      paramp = this.qaH.getContext();
      if (paramp != null) {
        paramp.moveTaskToBack(true);
      }
      this.qaH.finish();
    }
    AppMethodBeat.o(280275);
  }
  
  public final void akp(String paramString)
  {
    AppMethodBeat.i(280273);
    kotlin.g.b.p.k(paramString, "invokeData");
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.LegacySDKInvokeProcess", "performInvoke with instance(" + hashCode() + ") appId(" + this.qaH.getAppId() + ") data(" + paramString + ')');
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
        break label446;
      }
      if (localCharSequence.length() != 0) {
        break label460;
      }
    }
    catch (JSONException paramString)
    {
      do
      {
        CharSequence localCharSequence;
        Log.e("MicroMsg.AppBrand.FunctionalAPIInvokeManager.LegacySDKInvokeProcess", "performInvoke, json parse e = ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(280273);
        return;
        switch (paramString.hashCode())
        {
        }
      } while (!paramString.equals("webview"));
      paramString = this.qaH.bDz();
      kotlin.g.b.p.j(paramString, "runtime.pageContainer");
      paramString = paramString.getPageView();
      if (paramString != null) {
        break label417;
      }
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
      AppMethodBeat.o(280273);
      throw paramString;
    }
    catch (RuntimeException paramString)
    {
      label149:
      label163:
      AppMethodBeat.o(280273);
      return;
    }
    if (i == 0)
    {
      localCharSequence = (CharSequence)str2;
      if (localCharSequence != null) {
        if (localCharSequence.length() != 0) {
          break label465;
        }
      }
    }
    else
    {
      eD(str3, "fail invalid args");
      AppMethodBeat.o(280273);
      return;
      paramString = paramString.optString("jsapiType");
      if (paramString != null) {}
    }
    for (;;)
    {
      eD(str3, d.eB("fail invalid jsapiType", str1));
      paramString = (Throwable)new RuntimeException();
      AppMethodBeat.o(280273);
      throw paramString;
      if (paramString.equals("appservice"))
      {
        paramString = this.qaH.bDA();
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
          AppMethodBeat.o(280273);
          throw paramString;
        }
        label417:
        for (paramString = (p)paramString;; paramString = (p)paramString)
        {
          this.qaW += 1;
          i = this.qaW;
          this.qaX.put(i, new q.a.a(str3));
          if (paramString != null) {
            break;
          }
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.AppBrandComponentImpl");
          AppMethodBeat.o(280273);
          throw paramString;
        }
        ((f)paramString).B(str1, str2, i);
        AppMethodBeat.o(280273);
        return;
        label446:
        i = 1;
        break;
        label460:
        label465:
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label468;
          }
          break label149;
          i = 0;
          break;
        }
        label468:
        break label163;
      }
    }
  }
  
  public final void b(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(280277);
    kotlin.g.b.p.k(paramp, "component");
    kotlin.g.b.p.k(paramString, "callbackStr");
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.LegacySDKInvokeProcess", "onPayAheadCallback, instance(" + hashCode() + ", callbackId(" + paramInt + "), callbackStr(" + paramString + ')');
    a(paramp, paramInt, paramString);
    AppMethodBeat.o(280277);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "", "()V", "InvokeCallbackContext", "NavigateBackCallbackContext", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$InvokeCallbackContext;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$NavigateBackCallbackContext;", "plugin-appbrand-integration_release"})
  public static abstract class a
  {
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$InvokeCallbackContext;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "transitiveData", "", "(Ljava/lang/String;)V", "getTransitiveData", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
    public static final class a
      extends q.a
    {
      final String nYF;
      
      public a(String paramString)
      {
        super();
        this.nYF = paramString;
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(272456);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if (!kotlin.g.b.p.h(this.nYF, paramObject.nYF)) {}
          }
        }
        else
        {
          AppMethodBeat.o(272456);
          return true;
        }
        AppMethodBeat.o(272456);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(272454);
        String str = this.nYF;
        if (str != null)
        {
          int i = str.hashCode();
          AppMethodBeat.o(272454);
          return i;
        }
        AppMethodBeat.o(272454);
        return 0;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(272453);
        String str = "InvokeCallbackContext(transitiveData=" + this.nYF + ")";
        AppMethodBeat.o(272453);
        return str;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$NavigateBackCallbackContext;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "()V", "plugin-appbrand-integration_release"})
    public static final class b
      extends q.a
    {
      public static final b qaZ;
      
      static
      {
        AppMethodBeat.i(281457);
        qaZ = new b();
        AppMethodBeat.o(281457);
      }
      
      private b()
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.q
 * JD-Core Version:    0.7.0.1
 */