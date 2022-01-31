package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.i;
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
    paramJSONObject = new JsApiRefreshSession.RefreshSessionTask();
    Object localObject = (i)paramc.D(i.class);
    if (localObject != null) {
      JsApiRefreshSession.RefreshSessionTask.a(paramJSONObject, ((i)localObject).fPS.fEM);
    }
    localObject = paramc.getAppId();
    paramJSONObject.gfh = this;
    paramJSONObject.ggu = paramc;
    paramJSONObject.gfg = paramInt;
    paramJSONObject.appId = ((String)localObject);
    paramc = com.tencent.mm.plugin.appbrand.a.qp((String)localObject);
    if (paramc != null) {
      paramJSONObject.ghm = paramc.scene;
    }
    paramJSONObject.ahC();
    AppBrandMainProcessService.a(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiRefreshSession
 * JD-Core Version:    0.7.0.1
 */