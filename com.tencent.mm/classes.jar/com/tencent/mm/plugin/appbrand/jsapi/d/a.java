package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.sns.waid.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/device/JsApiGetDeviceInfo;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends d<f>
{
  public static final int CTRL_INDEX = 867;
  public static final String NAME = "getDeviceInfo";
  public static final a lTK;
  
  static
  {
    AppMethodBeat.i(228394);
    lTK = new a((byte)0);
    AppMethodBeat.o(228394);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(228393);
    String str2 = com.tencent.mm.plugin.sns.ad.b.a.aoK();
    String str3 = com.tencent.mm.plugin.sns.ad.b.a.eWE();
    String str1 = "";
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("waidPkg");
      str1 = b.aRy(paramJSONObject);
      p.g(str1, "WaidHelper.getAppWaid(waidPkg)");
      Log.i("MicroMsg.AppBrand.JsApiGetDeviceInfo", "waidPkg=".concat(String.valueOf(paramJSONObject)));
    }
    String str4 = com.tencent.mm.plugin.sns.ad.b.a.eWC();
    if (paramf != null)
    {
      paramJSONObject = (com.tencent.mm.plugin.appbrand.s.a)paramf.av(com.tencent.mm.plugin.appbrand.s.a.class);
      if (paramJSONObject == null) {}
    }
    for (paramJSONObject = paramJSONObject.nhM;; paramJSONObject = null)
    {
      Log.i("MicroMsg.AppBrand.JsApiGetDeviceInfo", "getDeviceInfo, oaid:" + str2 + ", imei:" + str3 + ", waid:" + str1, new Object[] { "ua:".concat(String.valueOf(paramJSONObject)) });
      if ((str2 != null) || (str3 != null) || (str1 != null) || (str4 != null) || (paramJSONObject != null)) {
        break label203;
      }
      if (paramf == null) {
        break;
      }
      paramf.i(paramInt, Zf("fail"));
      AppMethodBeat.o(228393);
      return;
    }
    AppMethodBeat.o(228393);
    return;
    label203:
    paramJSONObject = ae.e(new o[] { s.U("oaid", str2), s.U("imei", str3), s.U("waid", str1), s.U("devIdInfo", str4), s.U("ua", paramJSONObject) });
    if (paramf != null)
    {
      paramf.i(paramInt, n("ok", paramJSONObject));
      AppMethodBeat.o(228393);
      return;
    }
    AppMethodBeat.o(228393);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/device/JsApiGetDeviceInfo$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.a
 * JD-Core Version:    0.7.0.1
 */