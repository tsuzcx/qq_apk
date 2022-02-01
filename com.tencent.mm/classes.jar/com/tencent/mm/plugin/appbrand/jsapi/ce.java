package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiSystemLog;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "PREFIX", "", "PREFIX$annotations", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "getPREFIX", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)Ljava/lang/String;", "invoke", "", "service", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app_release"})
public final class ce
  extends a<c>
{
  public static final int CTRL_INDEX = 65;
  public static final String NAME = "systemLog";
  public static final a kuI;
  
  static
  {
    AppMethodBeat.i(197497);
    kuI = new a((byte)0);
    AppMethodBeat.o(197497);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(139845);
    p.h(paramc, "service");
    p.h(paramJSONObject, "data");
    String str2 = paramJSONObject.optString("message");
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = "appId[" + paramc.getAppId() + ']';
    if ((paramc instanceof q)) {
      paramJSONObject = "Service ".concat(String.valueOf(str1));
    }
    for (;;)
    {
      ad.i("AppBrandLog", new StringBuilder().append(paramJSONObject).append(" print:").toString() + str2);
      paramc.h(paramInt, Pg("ok"));
      AppMethodBeat.o(139845);
      return;
      paramJSONObject = str1;
      if ((paramc instanceof aa)) {
        paramJSONObject = "Page " + str1 + " url[" + ((aa)paramc).getURL() + ']';
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiSystemLog$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-wxa-app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ce
 * JD-Core Version:    0.7.0.1
 */