package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class h
  extends aa<ad>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "initReady";
  
  public String a(ad paramad, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(134879);
    boolean bool = paramJSONObject.optBoolean("ignoreWebviewPreload", false);
    Log.i("MicroMsg.JsApiInitReady", "invoke, appId:%s, webviewId:%s, ignoreWebviewPreload:%b, url:%s", new Object[] { paramad.getAppId(), Integer.valueOf(paramad.getComponentId()), Boolean.valueOf(bool), paramad.oxe });
    if (!bool) {
      paramad.getRuntime().bBX().i(paramad);
    }
    paramad.alH("initReady");
    paramad = h("ok", null);
    AppMethodBeat.o(134879);
    return paramad;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.h
 * JD-Core Version:    0.7.0.1
 */