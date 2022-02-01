package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.i;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.t;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiNavigateToMiniProgram;", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/JsApiNavigateToMiniProgramWC;", "()V", "createNavigatorCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/IMiniProgramNavigator$NavigatorCallback;", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class h
  extends i
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "sdk_navigateToMiniProgram";
  public static final a qbM;
  
  static
  {
    AppMethodBeat.i(274022);
    qbM = new a((byte)0);
    AppMethodBeat.o(274022);
  }
  
  public final c.c b(final g paramg, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(274021);
    p.k(paramg, "service");
    p.k(paramJSONObject, "data");
    AppBrandRuntime localAppBrandRuntime = paramg.getRuntime();
    if (localAppBrandRuntime == null)
    {
      paramg = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalRuntime");
      AppMethodBeat.o(274021);
      throw paramg;
    }
    ((com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l)localAppBrandRuntime).a((l.a)new b(this, paramg, paramInt));
    paramg = (c.c)new c(this, paramJSONObject, paramg, paramInt);
    AppMethodBeat.o(274021);
    return paramg;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiNavigateToMiniProgram$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "thatConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "kotlin.jvm.PlatformType", "data", "", "onRuntimeReceiveReturnData"})
  static final class b
    implements l.a
  {
    b(h paramh, g paramg, int paramInt) {}
    
    public final void c(AppBrandInitConfig paramAppBrandInitConfig, Object paramObject)
    {
      Object localObject = null;
      AppMethodBeat.i(277584);
      if (!(paramObject instanceof MiniProgramNavigationBackResult)) {
        paramObject = null;
      }
      for (;;)
      {
        paramObject = (MiniProgramNavigationBackResult)paramObject;
        Log.i("MicroMsg.AppBrand.FunctionalJsApiNavigateToMiniProgram", "onReceiveReturnData navigateToAppId:" + paramAppBrandInitConfig.appId + " result:" + paramObject);
        HashMap localHashMap = new HashMap();
        if (paramObject != null) {}
        for (paramAppBrandInitConfig = paramObject.nyM;; paramAppBrandInitConfig = null)
        {
          if (paramAppBrandInitConfig != null) {
            localHashMap.put("extraData", paramObject.nyM);
          }
          paramAppBrandInitConfig = localObject;
          if (paramObject != null) {
            paramAppBrandInitConfig = paramObject.nyN;
          }
          if (paramAppBrandInitConfig != null) {
            localHashMap.put("privateExtraData", paramObject.nyN);
          }
          paramg.j(paramInt, this.qbN.m("ok", (Map)localHashMap));
          AppMethodBeat.o(277584);
          return;
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ok", "", "reason", "", "kotlin.jvm.PlatformType", "onNavigateResult"})
  static final class c
    implements c.c
  {
    c(h paramh, JSONObject paramJSONObject, g paramg, int paramInt) {}
    
    public final void s(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(267713);
      String str = paramJSONObject.optString("appId");
      Log.i("MicroMsg.AppBrand.FunctionalJsApiNavigateToMiniProgram", "onNavigateResult, navigateToAppId:" + str + " ok:" + paramBoolean + ", reason:" + paramString);
      if (!paramBoolean)
      {
        g localg = paramg;
        int i = paramInt;
        h localh = this.qbN;
        StringBuilder localStringBuilder = new StringBuilder("fail: navigate error ");
        str = paramString;
        if (paramString == null) {
          str = "";
        }
        localg.j(i, localh.agS(str));
      }
      AppMethodBeat.o(267713);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.h
 * JD-Core Version:    0.7.0.1
 */