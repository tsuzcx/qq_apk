package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.os.Parcelable;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WebInvokeProcess;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalAPIInvokeProcess;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "CALLBACK_ID", "", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "transitiveData", "", "navigateBack", "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "onPayAheadCallback", "callbackStr", "performInvoke", "invokeData", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class r
  implements o
{
  private static final a tgq;
  private String qYI;
  private final l tfN;
  private final int tgi;
  
  static
  {
    AppMethodBeat.i(320003);
    tgq = new a((byte)0);
    AppMethodBeat.o(320003);
  }
  
  public r(l paraml)
  {
    AppMethodBeat.i(319988);
    this.tfN = paraml;
    this.tgi = (hashCode() & 0xFFFF);
    AppMethodBeat.o(319988);
  }
  
  private final void eU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(319996);
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.WebInvokeProcess", "navigateBack, instance(" + hashCode() + "), invokeResult(" + paramString2 + ')');
    b localb = this.tfN.getInitConfig().epg;
    if (localb != null)
    {
      localb.onWXAppResult((Parcelable)new ByRuntimeQrcodeResult(paramString2, paramString1));
      this.tfN.cBq();
      AppMethodBeat.o(319996);
      return;
    }
    AppMethodBeat.o(319996);
  }
  
  public final void a(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(320020);
    s.u(paramp, "component");
    s.u(paramString, "data");
    if (this.tgi == paramInt) {
      eU(this.qYI, paramString);
    }
    AppMethodBeat.o(320020);
  }
  
  public final void adv(String paramString)
  {
    AppMethodBeat.i(320015);
    s.u(paramString, "invokeData");
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.WebInvokeProcess", "performInvoke with instance(" + hashCode() + "), appId(" + this.tfN.mAppId + ") data(" + paramString + ')');
    String str1;
    int i;
    try
    {
      localObject = new JSONObject(paramString);
      str1 = ((JSONObject)localObject).optString("name");
      str2 = ((JSONObject)localObject).optString("args");
      paramString = ((JSONObject)localObject).optString("transitiveData");
      localCharSequence = (CharSequence)str1;
      if (localCharSequence == null) {
        break label354;
      }
      if (localCharSequence.length() != 0) {
        break label368;
      }
    }
    catch (JSONException paramString)
    {
      Object localObject;
      String str2;
      CharSequence localCharSequence;
      Log.e("MicroMsg.AppBrand.FunctionalAPIInvokeManager.WebInvokeProcess", s.X("performInvoke, json parse e = ", paramString));
      AppMethodBeat.o(320015);
      return;
      paramString = (p)paramString;
      ((g)paramString).d(str1, str2, "", this.tgi);
      AppMethodBeat.o(320015);
      return;
      if (!s.p(localObject, "webview")) {
        break label322;
      }
      paramString = this.tfN.ccN().getPageView();
      if (paramString != null) {
        break label311;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
      AppMethodBeat.o(320015);
      throw paramString;
    }
    catch (RuntimeException paramString)
    {
      label152:
      AppMethodBeat.o(320015);
      return;
    }
    if (i == 0)
    {
      localCharSequence = (CharSequence)str2;
      if (localCharSequence != null) {
        if (localCharSequence.length() != 0) {
          break label373;
        }
      }
    }
    else
    {
      eU(paramString, "fail invalid args");
      AppMethodBeat.o(320015);
      return;
    }
    label311:
    label322:
    label354:
    label368:
    label373:
    label376:
    for (;;)
    {
      localObject = ((JSONObject)localObject).optString("jsapiType");
      if (s.p(localObject, "appservice"))
      {
        paramString = this.tfN.ccO();
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
          AppMethodBeat.o(320015);
          throw paramString;
        }
      }
      for (;;)
      {
        paramString = (p)paramString;
      }
      s.s(str1, "name");
      eU(paramString, d.eS("fail invalid jsapiType", str1));
      paramString = new RuntimeException();
      AppMethodBeat.o(320015);
      throw paramString;
      i = 1;
      break;
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label376;
        }
        break label152;
        i = 0;
        break;
      }
    }
  }
  
  public final void b(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(320028);
    s.u(paramp, "component");
    s.u(paramString, "callbackStr");
    Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.WebInvokeProcess", "onPayAheadCallback, instance(" + hashCode() + ", callbackId(" + paramInt + "), callbackStr(" + paramString + ')');
    eU(this.qYI, paramString);
    AppMethodBeat.o(320028);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WebInvokeProcess$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.r
 * JD-Core Version:    0.7.0.1
 */