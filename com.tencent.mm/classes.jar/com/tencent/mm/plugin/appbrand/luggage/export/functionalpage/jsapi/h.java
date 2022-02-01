package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.i;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.t;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiNavigateToMiniProgram;", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/JsApiNavigateToMiniProgramWC;", "()V", "createNavigatorCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/IMiniProgramNavigator$NavigatorCallback;", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class h
  extends i
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "sdk_navigateToMiniProgram";
  public static final a nbx;
  
  static
  {
    AppMethodBeat.i(228911);
    nbx = new a((byte)0);
    AppMethodBeat.o(228911);
  }
  
  public final c.c b(final d paramd, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(228910);
    p.h(paramd, "service");
    p.h(paramJSONObject, "data");
    AppBrandRuntime localAppBrandRuntime = paramd.getRuntime();
    if (localAppBrandRuntime == null)
    {
      paramd = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalRuntime");
      AppMethodBeat.o(228910);
      throw paramd;
    }
    ((com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l)localAppBrandRuntime).a((l.a)new b(this, paramd, paramInt));
    paramd = (c.c)new c(this, paramJSONObject, paramd, paramInt);
    AppMethodBeat.o(228910);
    return paramd;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiNavigateToMiniProgram$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "thatConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "kotlin.jvm.PlatformType", "data", "", "onRuntimeReceiveReturnData"})
  static final class b
    implements l.a
  {
    b(h paramh, d paramd, int paramInt) {}
    
    public final void c(AppBrandInitConfig paramAppBrandInitConfig, Object paramObject)
    {
      Object localObject = null;
      AppMethodBeat.i(228908);
      if (!(paramObject instanceof MiniProgramNavigationBackResult)) {
        paramObject = null;
      }
      for (;;)
      {
        paramObject = (MiniProgramNavigationBackResult)paramObject;
        Log.i("MicroMsg.AppBrand.FunctionalJsApiNavigateToMiniProgram", "onReceiveReturnData navigateToAppId:" + paramAppBrandInitConfig.appId + " result:" + paramObject);
        HashMap localHashMap = new HashMap();
        if (paramObject != null) {}
        for (paramAppBrandInitConfig = paramObject.kFg;; paramAppBrandInitConfig = null)
        {
          if (paramAppBrandInitConfig != null) {
            localHashMap.put("extraData", paramObject.kFg);
          }
          paramAppBrandInitConfig = localObject;
          if (paramObject != null) {
            paramAppBrandInitConfig = paramObject.kFh;
          }
          if (paramAppBrandInitConfig != null) {
            localHashMap.put("privateExtraData", paramObject.kFh);
          }
          paramd.i(paramInt, this.nby.n("ok", (Map)localHashMap));
          AppMethodBeat.o(228908);
          return;
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ok", "", "reason", "", "kotlin.jvm.PlatformType", "onNavigateResult"})
  static final class c
    implements c.c
  {
    c(h paramh, JSONObject paramJSONObject, d paramd, int paramInt) {}
    
    public final void o(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(228909);
      String str = paramJSONObject.optString("appId");
      Log.i("MicroMsg.AppBrand.FunctionalJsApiNavigateToMiniProgram", "onNavigateResult, navigateToAppId:" + str + " ok:" + paramBoolean + ", reason:" + paramString);
      if (!paramBoolean)
      {
        d locald = paramd;
        int i = paramInt;
        h localh = this.nby;
        StringBuilder localStringBuilder = new StringBuilder("fail: navigate error ");
        str = paramString;
        if (paramString == null) {
          str = "";
        }
        locald.i(i, localh.Zf(str));
      }
      AppMethodBeat.o(228909);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.h
 * JD-Core Version:    0.7.0.1
 */