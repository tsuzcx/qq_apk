package com.tencent.mm.plugin.appbrand.jsapi.profile;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/JsApiOpenBizProfile;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  private static final int CTRL_INDEX = 560;
  private static final String NAME = "openBizProfile";
  public static final a.a hXf;
  
  static
  {
    AppMethodBeat.i(134689);
    hXf = new a.a((byte)0);
    NAME = "openBizProfile";
    CTRL_INDEX = 560;
    AppMethodBeat.o(134689);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(134688);
    j.q(paramc, "env");
    j.q(paramJSONObject, "data");
    Object localObject = paramJSONObject.optString("username");
    int i = paramJSONObject.optInt("scene", 122);
    String str = paramJSONObject.optString("profileReportInfo");
    if (bo.isNullOrNil((String)localObject))
    {
      paramc.h(paramInt, BL("fail:invalid data"));
      AppMethodBeat.o(134688);
      return;
    }
    paramJSONObject = new ProfileRequest();
    paramJSONObject.username = ((String)localObject);
    paramJSONObject.scene = i;
    localObject = (AppBrandProxyUIProcessTask.b)new a.b(this, paramc, paramInt, str, i, (String)localObject);
    com.tencent.mm.plugin.appbrand.ipc.a.a(paramc.getContext(), (AppBrandProxyUIProcessTask.ProcessRequest)paramJSONObject, (AppBrandProxyUIProcessTask.b)localObject);
    AppMethodBeat.o(134688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.a
 * JD-Core Version:    0.7.0.1
 */