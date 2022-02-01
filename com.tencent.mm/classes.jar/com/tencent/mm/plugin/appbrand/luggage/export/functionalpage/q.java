package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalAPIInvokeProcess;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "callbackContextMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "callbackIdGenerator", "", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "navigateBack", "", "transitiveData", "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "onPayAheadCallback", "callbackStr", "performInvoke", "invokeData", "CallbackContext", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class q
  implements o
{
  private static final b tgc;
  private final l tfN;
  private int tgd;
  private final SparseArray<a> tge;
  
  static
  {
    AppMethodBeat.i(320006);
    tgc = new b((byte)0);
    AppMethodBeat.o(320006);
  }
  
  public q(l paraml)
  {
    AppMethodBeat.i(319989);
    this.tfN = paraml;
    this.tge = new SparseArray();
    AppMethodBeat.o(319989);
  }
  
  private final void eU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(320000);
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.LegacySDKInvokeProcess", "navigateBack, instance(" + hashCode() + "), invokeResult(" + paramString2 + ')');
    this.tgd += 1;
    int i = this.tgd;
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("data", paramString2);
    localJSONObject2.put("transitiveData", paramString1);
    paramString1 = ah.aiuX;
    localJSONObject1.put("extraData", localJSONObject2);
    paramString1 = localJSONObject1.toString();
    s.s(paramString1, "JSONObject().apply {\n   …   )\n        }.toString()");
    this.tge.put(i, q.a.b.tgf);
    this.tfN.ccO().d("navigateBackApplication", paramString1, "", i);
    AppMethodBeat.o(320000);
  }
  
  public final void a(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(320026);
    s.u(paramp, "component");
    s.u(paramString, "data");
    paramp = (a)this.tge.get(paramInt, null);
    if ((paramp instanceof q.a.a))
    {
      this.tge.remove(paramInt);
      eU(((q.a.a)paramp).qYI, paramString);
      AppMethodBeat.o(320026);
      return;
    }
    if ((paramp instanceof q.a.b))
    {
      this.tge.remove(paramInt);
      paramp = AndroidContextUtil.castActivityOrNull(this.tfN.mContext);
      if (paramp != null) {
        paramp.moveTaskToBack(true);
      }
      this.tfN.finish();
    }
    AppMethodBeat.o(320026);
  }
  
  public final void adv(String paramString)
  {
    AppMethodBeat.i(320018);
    s.u(paramString, "invokeData");
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.LegacySDKInvokeProcess", "performInvoke with instance(" + hashCode() + ") appId(" + this.tfN.mAppId + ") data(" + paramString + ')');
    String str1;
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
        break label384;
      }
      if (localCharSequence.length() != 0) {
        break label398;
      }
    }
    catch (JSONException paramString)
    {
      String str2;
      CharSequence localCharSequence;
      Log.e("MicroMsg.AppBrand.FunctionalAPIInvokeManager.LegacySDKInvokeProcess", s.X("performInvoke, json parse e = ", paramString));
      AppMethodBeat.o(320018);
      return;
      paramString = (p)paramString;
      this.tgd += 1;
      i = this.tgd;
      this.tge.put(i, new q.a.a(str3));
      ((g)paramString).d(str1, str2, "", i);
      AppMethodBeat.o(320018);
      return;
      if (!s.p(paramString, "webview")) {
        break label350;
      }
      paramString = this.tfN.ccN().getPageView();
      if (paramString != null) {
        break label339;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
      AppMethodBeat.o(320018);
      throw paramString;
    }
    catch (RuntimeException paramString)
    {
      label149:
      AppMethodBeat.o(320018);
      return;
    }
    if (i == 0)
    {
      localCharSequence = (CharSequence)str2;
      if (localCharSequence != null) {
        if (localCharSequence.length() != 0) {
          break label403;
        }
      }
    }
    else
    {
      eU(str3, "fail invalid args");
      AppMethodBeat.o(320018);
      return;
    }
    label384:
    label398:
    label403:
    label406:
    for (;;)
    {
      paramString = paramString.optString("jsapiType");
      if (s.p(paramString, "appservice"))
      {
        paramString = this.tfN.ccO();
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
          AppMethodBeat.o(320018);
          throw paramString;
        }
      }
      for (;;)
      {
        label339:
        paramString = (p)paramString;
      }
      label350:
      s.s(str1, "name");
      eU(str3, d.eS("fail invalid jsapiType", str1));
      paramString = new RuntimeException();
      AppMethodBeat.o(320018);
      throw paramString;
      i = 1;
      break;
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label406;
        }
        break label149;
        i = 0;
        break;
      }
    }
  }
  
  public final void b(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(320033);
    s.u(paramp, "component");
    s.u(paramString, "callbackStr");
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.LegacySDKInvokeProcess", "onPayAheadCallback, instance(" + hashCode() + ", callbackId(" + paramInt + "), callbackStr(" + paramString + ')');
    a(paramp, paramInt, paramString);
    AppMethodBeat.o(320033);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "", "()V", "InvokeCallbackContext", "NavigateBackCallbackContext", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$InvokeCallbackContext;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$NavigateBackCallbackContext;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class a
  {
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$InvokeCallbackContext;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "transitiveData", "", "(Ljava/lang/String;)V", "getTransitiveData", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends q.a
    {
      final String qYI;
      
      public a(String paramString)
      {
        super();
        this.qYI = paramString;
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(319925);
        if (this == paramObject)
        {
          AppMethodBeat.o(319925);
          return true;
        }
        if (!(paramObject instanceof a))
        {
          AppMethodBeat.o(319925);
          return false;
        }
        paramObject = (a)paramObject;
        if (!s.p(this.qYI, paramObject.qYI))
        {
          AppMethodBeat.o(319925);
          return false;
        }
        AppMethodBeat.o(319925);
        return true;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(319922);
        if (this.qYI == null)
        {
          AppMethodBeat.o(319922);
          return 0;
        }
        int i = this.qYI.hashCode();
        AppMethodBeat.o(319922);
        return i;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(319919);
        String str = "InvokeCallbackContext(transitiveData=" + this.qYI + ')';
        AppMethodBeat.o(319919);
        return str;
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$NavigateBackCallbackContext;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "()V", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      extends q.a
    {
      public static final b tgf;
      
      static
      {
        AppMethodBeat.i(319926);
        tgf = new b();
        AppMethodBeat.o(319926);
      }
      
      private b()
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.q
 * JD-Core Version:    0.7.0.1
 */