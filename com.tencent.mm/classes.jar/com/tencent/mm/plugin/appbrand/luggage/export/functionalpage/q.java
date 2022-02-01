package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.t;
import org.json.JSONException;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalAPIInvokeProcess;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "callbackContextMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "callbackIdGenerator", "", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "navigateBack", "", "transitiveData", "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "onPayAheadCallback", "callbackStr", "performInvoke", "invokeData", "CallbackContext", "Companion", "plugin-appbrand-integration_release"})
final class q
  implements o
{
  @Deprecated
  public static final b naJ;
  private int naH;
  private final SparseArray<a> naI;
  private final l nas;
  
  static
  {
    AppMethodBeat.i(228847);
    naJ = new b((byte)0);
    AppMethodBeat.o(228847);
  }
  
  public q(l paraml)
  {
    AppMethodBeat.i(228846);
    this.nas = paraml;
    this.naI = new SparseArray();
    AppMethodBeat.o(228846);
  }
  
  private final void ep(String paramString1, String paramString2)
  {
    AppMethodBeat.i(228845);
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.LegacySDKInvokeProcess", "navigateBack, instance(" + hashCode() + "), invokeResult(" + paramString2 + ')');
    this.naH += 1;
    int i = this.naH;
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("data", paramString2);
    localJSONObject2.put("transitiveData", paramString1);
    localJSONObject1.put("extraData", localJSONObject2);
    paramString1 = localJSONObject1.toString();
    kotlin.g.b.p.g(paramString1, "JSONObject().apply {\n   …   )\n        }.toString()");
    this.naI.put(i, q.a.b.naK);
    this.nas.bsE().y("navigateBackApplication", paramString1, i);
    AppMethodBeat.o(228845);
  }
  
  public final void a(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(228843);
    kotlin.g.b.p.h(paramp, "component");
    kotlin.g.b.p.h(paramString, "data");
    paramp = (a)this.naI.get(paramInt, null);
    if ((paramp instanceof q.a.a))
    {
      this.naI.remove(paramInt);
      ep(((q.a.a)paramp).les, paramString);
      AppMethodBeat.o(228843);
      return;
    }
    if ((paramp instanceof q.a.b))
    {
      this.naI.remove(paramInt);
      paramp = this.nas.getContext();
      if (paramp != null) {
        paramp.moveTaskToBack(true);
      }
      this.nas.finish();
    }
    AppMethodBeat.o(228843);
  }
  
  public final void acv(String paramString)
  {
    AppMethodBeat.i(228842);
    kotlin.g.b.p.h(paramString, "invokeData");
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.LegacySDKInvokeProcess", "performInvoke with instance(" + hashCode() + ") appId(" + this.nas.getAppId() + ") data(" + paramString + ')');
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
        AppMethodBeat.o(228842);
        return;
        switch (paramString.hashCode())
        {
        }
      } while (!paramString.equals("webview"));
      paramString = this.nas.bsD();
      kotlin.g.b.p.g(paramString, "runtime.pageContainer");
      paramString = paramString.getPageView();
      if (paramString != null) {
        break label417;
      }
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
      AppMethodBeat.o(228842);
      throw paramString;
    }
    catch (RuntimeException paramString)
    {
      label149:
      label163:
      AppMethodBeat.o(228842);
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
      ep(str3, "fail invalid args");
      AppMethodBeat.o(228842);
      return;
      paramString = paramString.optString("jsapiType");
      if (paramString != null) {}
    }
    for (;;)
    {
      ep(str3, d.en("fail invalid jsapiType", str1));
      paramString = (Throwable)new RuntimeException();
      AppMethodBeat.o(228842);
      throw paramString;
      if (paramString.equals("appservice"))
      {
        paramString = this.nas.bsE();
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
          AppMethodBeat.o(228842);
          throw paramString;
        }
        label417:
        for (paramString = (p)paramString;; paramString = (p)paramString)
        {
          this.naH += 1;
          i = this.naH;
          this.naI.put(i, new q.a.a(str3));
          if (paramString != null) {
            break;
          }
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.AppBrandComponentImpl");
          AppMethodBeat.o(228842);
          throw paramString;
        }
        ((g)paramString).y(str1, str2, i);
        AppMethodBeat.o(228842);
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
    AppMethodBeat.i(228844);
    kotlin.g.b.p.h(paramp, "component");
    kotlin.g.b.p.h(paramString, "callbackStr");
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.LegacySDKInvokeProcess", "onPayAheadCallback, instance(" + hashCode() + ", callbackId(" + paramInt + "), callbackStr(" + paramString + ')');
    a(paramp, paramInt, paramString);
    AppMethodBeat.o(228844);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "", "()V", "InvokeCallbackContext", "NavigateBackCallbackContext", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$InvokeCallbackContext;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$NavigateBackCallbackContext;", "plugin-appbrand-integration_release"})
  public static abstract class a
  {
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$InvokeCallbackContext;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "transitiveData", "", "(Ljava/lang/String;)V", "getTransitiveData", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
    public static final class a
      extends q.a
    {
      final String les;
      
      public a(String paramString)
      {
        super();
        this.les = paramString;
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(228840);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if (!kotlin.g.b.p.j(this.les, paramObject.les)) {}
          }
        }
        else
        {
          AppMethodBeat.o(228840);
          return true;
        }
        AppMethodBeat.o(228840);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(228839);
        String str = this.les;
        if (str != null)
        {
          int i = str.hashCode();
          AppMethodBeat.o(228839);
          return i;
        }
        AppMethodBeat.o(228839);
        return 0;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(228838);
        String str = "InvokeCallbackContext(transitiveData=" + this.les + ")";
        AppMethodBeat.o(228838);
        return str;
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$NavigateBackCallbackContext;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "()V", "plugin-appbrand-integration_release"})
    public static final class b
      extends q.a
    {
      public static final b naK;
      
      static
      {
        AppMethodBeat.i(228841);
        naK = new b();
        AppMethodBeat.o(228841);
      }
      
      private b()
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.q
 * JD-Core Version:    0.7.0.1
 */