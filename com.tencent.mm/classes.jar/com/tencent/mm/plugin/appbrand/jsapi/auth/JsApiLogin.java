package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiLogin
  extends f
{
  public static final int CTRL_INDEX = 52;
  public static final String NAME = "login";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(130872);
    try
    {
      if (!paramJSONObject.has("requestInQueue")) {
        paramJSONObject.put("requestInQueue", false);
      }
      super.a(paramh, paramJSONObject, paramInt);
      AppMethodBeat.o(130872);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiLogin", "invoke put KEY_IN_QUEUE e=%s", new Object[] { localJSONException.getMessage() });
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, JSONObject paramJSONObject, int paramInt, d paramd)
  {
    AppMethodBeat.i(130873);
    JsApiLogin.LoginTask localLoginTask = new JsApiLogin.LoginTask();
    localLoginTask.appId = paramh.getAppId();
    localLoginTask.hDy = "login";
    Object localObject = paramh.getRuntime().wY();
    if (localObject != null) {
      localLoginTask.hcr = ((com.tencent.mm.plugin.appbrand.config.h)localObject).hiX.gXe;
    }
    localObject = a.xN(paramh.getAppId());
    if (localObject != null) {
      localLoginTask.hzB = ((AppBrandStatObject)localObject).scene;
    }
    paramJSONObject = paramJSONObject.toString();
    localLoginTask.hDu = this;
    localLoginTask.hDv = paramh;
    localLoginTask.data = paramJSONObject;
    localLoginTask.hry = paramInt;
    localLoginTask.hDw = paramd;
    localLoginTask.hDI = new Bundle();
    if ((paramh instanceof r)) {
      localLoginTask.hDJ = 1;
    }
    for (;;)
    {
      localLoginTask.aBj();
      AppBrandMainProcessService.a(localLoginTask);
      AppMethodBeat.o(130873);
      return;
      if ((paramh instanceof v)) {
        localLoginTask.hDJ = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin
 * JD-Core Version:    0.7.0.1
 */