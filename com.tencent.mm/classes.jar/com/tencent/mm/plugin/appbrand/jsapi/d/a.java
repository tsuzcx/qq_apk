package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.sns.waid.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/device/JsApiGetDeviceInfo;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends c<e>
{
  public static final int CTRL_INDEX = 867;
  public static final String NAME = "getDeviceInfo";
  public static final a oQs;
  
  static
  {
    AppMethodBeat.i(274322);
    oQs = new a((byte)0);
    AppMethodBeat.o(274322);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(274321);
    String str2 = com.tencent.mm.plugin.sns.ad.a.a.auQ();
    String str3 = com.tencent.mm.plugin.sns.ad.a.a.fJH();
    String str1 = "";
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("waidPkg");
      str1 = b.bcD(paramJSONObject);
      p.j(str1, "WaidHelper.getAppWaid(waidPkg)");
      Log.i("MicroMsg.AppBrand.JsApiGetDeviceInfo", "waidPkg=".concat(String.valueOf(paramJSONObject)));
    }
    String str4 = com.tencent.mm.plugin.sns.ad.a.a.fJF();
    if (parame != null)
    {
      paramJSONObject = (com.tencent.mm.plugin.appbrand.s.a)parame.au(com.tencent.mm.plugin.appbrand.s.a.class);
      if (paramJSONObject == null) {}
    }
    for (paramJSONObject = paramJSONObject.qiv;; paramJSONObject = null)
    {
      Log.i("MicroMsg.AppBrand.JsApiGetDeviceInfo", "getDeviceInfo, oaid:" + str2 + ", imei:" + str3 + ", waid:" + str1, new Object[] { "ua:".concat(String.valueOf(paramJSONObject)) });
      if ((str2 != null) || (str3 != null) || (str1 != null) || (str4 != null) || (paramJSONObject != null)) {
        break label203;
      }
      if (parame == null) {
        break;
      }
      parame.j(paramInt, agS("fail"));
      AppMethodBeat.o(274321);
      return;
    }
    AppMethodBeat.o(274321);
    return;
    label203:
    paramJSONObject = ae.e(new o[] { s.M("oaid", str2), s.M("imei", str3), s.M("waid", str1), s.M("devIdInfo", str4), s.M("ua", paramJSONObject) });
    if (parame != null)
    {
      parame.j(paramInt, m("ok", paramJSONObject));
      AppMethodBeat.o(274321);
      return;
    }
    AppMethodBeat.o(274321);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/device/JsApiGetDeviceInfo$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.a
 * JD-Core Version:    0.7.0.1
 */