package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.i;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiNavigateToMiniProgram;", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/JsApiNavigateToMiniProgramWC;", "()V", "createNavigatorCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/IMiniProgramNavigator$NavigatorCallback;", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends i
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "sdk_navigateToMiniProgram";
  public static final h.a tgI;
  
  static
  {
    AppMethodBeat.i(320117);
    tgI = new h.a((byte)0);
    AppMethodBeat.o(320117);
  }
  
  private static final void a(g paramg, int paramInt, h paramh, AppBrandInitConfig paramAppBrandInitConfig, Object paramObject)
  {
    Object localObject = null;
    AppMethodBeat.i(320103);
    s.u(paramg, "$service");
    s.u(paramh, "this$0");
    HashMap localHashMap;
    if ((paramObject instanceof MiniProgramNavigationBackResult))
    {
      paramObject = (MiniProgramNavigationBackResult)paramObject;
      Log.i("MicroMsg.AppBrand.FunctionalJsApiNavigateToMiniProgram", "onReceiveReturnData navigateToAppId:" + paramAppBrandInitConfig.appId + " result:" + paramObject);
      localHashMap = new HashMap();
      if (paramObject != null) {
        break label155;
      }
      paramAppBrandInitConfig = null;
      label85:
      if (paramAppBrandInitConfig != null) {
        localHashMap.put("extraData", paramObject.qxT);
      }
      if (paramObject != null) {
        break label164;
      }
    }
    label155:
    label164:
    for (paramAppBrandInitConfig = localObject;; paramAppBrandInitConfig = paramObject.qxU)
    {
      if (paramAppBrandInitConfig != null) {
        localHashMap.put("privateExtraData", paramObject.qxU);
      }
      paramg.callback(paramInt, paramh.m("ok", (Map)localHashMap));
      AppMethodBeat.o(320103);
      return;
      paramObject = null;
      break;
      paramAppBrandInitConfig = paramObject.qxT;
      break label85;
    }
  }
  
  private static final void a(JSONObject paramJSONObject, g paramg, int paramInt, h paramh, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(320111);
    s.u(paramJSONObject, "$data");
    s.u(paramg, "$service");
    s.u(paramh, "this$0");
    paramJSONObject = paramJSONObject.optString("appId");
    Log.i("MicroMsg.AppBrand.FunctionalJsApiNavigateToMiniProgram", "onNavigateResult, navigateToAppId:" + paramJSONObject + " ok:" + paramBoolean + ", reason:" + paramString);
    if (!paramBoolean)
    {
      paramJSONObject = paramString;
      if (paramString == null) {
        paramJSONObject = "";
      }
      paramg.callback(paramInt, paramh.ZP(s.X("fail: navigate error ", paramJSONObject)));
    }
    AppMethodBeat.o(320111);
  }
  
  public final c.c a(g paramg, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(320138);
    s.u(paramg, "service");
    s.u(paramJSONObject, "data");
    AppBrandRuntime localAppBrandRuntime = paramg.getRuntime();
    if (localAppBrandRuntime == null)
    {
      paramg = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalRuntime");
      AppMethodBeat.o(320138);
      throw paramg;
    }
    ((l)localAppBrandRuntime).tfY = new h..ExternalSyntheticLambda1(paramg, paramInt, this);
    paramg = new h..ExternalSyntheticLambda0(paramJSONObject, paramg, paramInt, this);
    AppMethodBeat.o(320138);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.h
 * JD-Core Version:    0.7.0.1
 */