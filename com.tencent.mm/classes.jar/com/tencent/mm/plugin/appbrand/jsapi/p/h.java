package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class h
  extends ab<ac>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "initReady";
  
  public String a(ac paramac, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(134879);
    boolean bool = paramJSONObject.optBoolean("ignoreWebviewPreload", false);
    Log.i("MicroMsg.JsApiInitReady", "invoke, appId:%s, webviewId:%s, ignoreWebviewPreload:%b, url:%s", new Object[] { paramac.getAppId(), Integer.valueOf(paramac.getComponentId()), Boolean.valueOf(bool), paramac.lBI });
    if (!bool) {
      paramac.getRuntime().brh().i(paramac);
    }
    paramac.adM("initReady");
    paramac = h("ok", null);
    AppMethodBeat.o(134879);
    return paramac;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.h
 * JD-Core Version:    0.7.0.1
 */