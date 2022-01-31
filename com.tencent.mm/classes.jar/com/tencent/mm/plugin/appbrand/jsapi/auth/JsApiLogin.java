package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import org.json.JSONObject;

public final class JsApiLogin
  extends c
{
  public static final int CTRL_INDEX = 52;
  public static final String NAME = "login";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt, b paramb)
  {
    JsApiLogin.LoginTask localLoginTask = new JsApiLogin.LoginTask();
    localLoginTask.appId = paramf.getAppId();
    localLoginTask.gjL = "login";
    Object localObject = paramf.getRuntime().ZB();
    if (localObject != null) {
      localLoginTask.fJy = ((com.tencent.mm.plugin.appbrand.config.i)localObject).fPS.fEM;
    }
    localObject = a.qp(paramf.getAppId());
    if (localObject != null) {
      localLoginTask.ghm = ((AppBrandStatObject)localObject).scene;
    }
    paramJSONObject = paramJSONObject.toString();
    localLoginTask.gjH = this;
    localLoginTask.gjI = paramf;
    localLoginTask.data = paramJSONObject;
    localLoginTask.gfg = paramInt;
    localLoginTask.gjJ = paramb;
    localLoginTask.gjP = new Bundle();
    if ((paramf instanceof o)) {
      localLoginTask.gjQ = 1;
    }
    for (;;)
    {
      localLoginTask.ahC();
      AppBrandMainProcessService.a(localLoginTask);
      return;
      if ((paramf instanceof q)) {
        localLoginTask.gjQ = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin
 * JD-Core Version:    0.7.0.1
 */