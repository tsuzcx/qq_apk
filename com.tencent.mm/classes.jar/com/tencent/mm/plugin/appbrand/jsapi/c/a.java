package com.tencent.mm.plugin.appbrand.jsapi.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.sns.waid.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.ae;
import d.g.b.p;
import d.l;
import d.o;
import d.u;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/device/JsApiGetDeviceInfo;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = 867;
  public static final String NAME = "getDeviceInfo";
  public static final a kLx;
  
  static
  {
    AppMethodBeat.i(189120);
    kLx = new a((byte)0);
    AppMethodBeat.o(189120);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(189119);
    String str2 = com.tencent.mm.plugin.sns.ad.a.a.aaC();
    String str3 = com.tencent.mm.plugin.sns.ad.a.a.ftk();
    String str1 = "";
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("waidPkg");
      str1 = b.aBl(paramJSONObject);
      p.g(str1, "WaidHelper.getAppWaid(waidPkg)");
      ad.i("MicroMsg.AppBrand.JsApiGetDeviceInfo", "waidPkg=".concat(String.valueOf(paramJSONObject)));
    }
    String str4 = com.tencent.mm.plugin.sns.ad.a.a.dRf();
    if (paramc != null)
    {
      paramJSONObject = (com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class);
      if (paramJSONObject == null) {}
    }
    for (paramJSONObject = paramJSONObject.lVu;; paramJSONObject = null)
    {
      ad.i("MicroMsg.AppBrand.JsApiGetDeviceInfo", "getDeviceInfo, oaid:" + str2 + ", imei:" + str3 + ", waid:" + str1, new Object[] { "ua:".concat(String.valueOf(paramJSONObject)) });
      if ((str2 != null) || (str3 != null) || (str1 != null) || (str4 != null) || (paramJSONObject != null)) {
        break label203;
      }
      if (paramc == null) {
        break;
      }
      paramc.h(paramInt, Pg("fail"));
      AppMethodBeat.o(189119);
      return;
    }
    AppMethodBeat.o(189119);
    return;
    label203:
    paramJSONObject = ae.a(new o[] { u.S("oaid", str2), u.S("imei", str3), u.S("waid", str1), u.S("devIdInfo", str4), u.S("ua", paramJSONObject) });
    if (paramc != null)
    {
      paramc.h(paramInt, m("ok", paramJSONObject));
      AppMethodBeat.o(189119);
      return;
    }
    AppMethodBeat.o(189119);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/device/JsApiGetDeviceInfo$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.a
 * JD-Core Version:    0.7.0.1
 */