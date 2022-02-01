package com.tencent.mm.plugin.appbrand.jsapi.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.sns.waid.b;
import d.g.b.p;
import d.l;
import d.o;
import d.u;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/device/JsApiGetDeviceInfo;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = 867;
  public static final String NAME = "getDeviceInfo";
  public static final a kOM;
  
  static
  {
    AppMethodBeat.i(223379);
    kOM = new a((byte)0);
    AppMethodBeat.o(223379);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(223378);
    String str2 = com.tencent.mm.plugin.sns.ad.a.a.aaL();
    String str3 = com.tencent.mm.plugin.sns.ad.a.a.dUD();
    String str1 = "";
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("waidPkg");
      str1 = b.aCC(paramJSONObject);
      p.g(str1, "WaidHelper.getAppWaid(waidPkg)");
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrand.JsApiGetDeviceInfo", "waidPkg=".concat(String.valueOf(paramJSONObject)));
    }
    String str4 = com.tencent.mm.plugin.sns.ad.a.a.dUB();
    if (paramc != null)
    {
      paramJSONObject = (com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class);
      if (paramJSONObject == null) {}
    }
    for (paramJSONObject = paramJSONObject.lZX;; paramJSONObject = null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrand.JsApiGetDeviceInfo", "getDeviceInfo, oaid:" + str2 + ", imei:" + str3 + ", waid:" + str1, new Object[] { "ua:".concat(String.valueOf(paramJSONObject)) });
      if ((str2 != null) || (str3 != null) || (str1 != null) || (str4 != null) || (paramJSONObject != null)) {
        break label203;
      }
      if (paramc == null) {
        break;
      }
      paramc.h(paramInt, PO("fail"));
      AppMethodBeat.o(223378);
      return;
    }
    AppMethodBeat.o(223378);
    return;
    label203:
    paramJSONObject = d.a.ae.a(new o[] { u.R("oaid", str2), u.R("imei", str3), u.R("waid", str1), u.R("devIdInfo", str4), u.R("ua", paramJSONObject) });
    if (paramc != null)
    {
      paramc.h(paramInt, n("ok", paramJSONObject));
      AppMethodBeat.o(223378);
      return;
    }
    AppMethodBeat.o(223378);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/device/JsApiGetDeviceInfo$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.a
 * JD-Core Version:    0.7.0.1
 */