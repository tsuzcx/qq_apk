package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import org.json.JSONObject;

public final class JsApiRefreshSession
  extends a
{
  private static final int CTRL_INDEX = 118;
  private static final String NAME = "refreshSession";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(130553);
    paramJSONObject = new JsApiRefreshSession.RefreshSessionTask();
    Object localObject = (h)paramc.U(h.class);
    if (localObject != null) {
      JsApiRefreshSession.RefreshSessionTask.a(paramJSONObject, ((h)localObject).hiX.gXe);
    }
    localObject = paramc.getAppId();
    paramJSONObject.hrz = this;
    paramJSONObject.hyO = paramc;
    paramJSONObject.hry = paramInt;
    paramJSONObject.appId = ((String)localObject);
    paramc = com.tencent.mm.plugin.appbrand.a.xN((String)localObject);
    if (paramc != null) {
      paramJSONObject.hzB = paramc.scene;
    }
    paramJSONObject.aBj();
    AppBrandMainProcessService.a(paramJSONObject);
    AppMethodBeat.o(130553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiRefreshSession
 * JD-Core Version:    0.7.0.1
 */