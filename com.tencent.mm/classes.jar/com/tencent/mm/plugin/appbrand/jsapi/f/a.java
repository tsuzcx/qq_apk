package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.sns.waid.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/device/JsApiGetDeviceInfo;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c<f>
{
  public static final int CTRL_INDEX = 867;
  public static final String NAME = "getDeviceInfo";
  public static final a rUj;
  
  static
  {
    AppMethodBeat.i(325803);
    rUj = new a((byte)0);
    AppMethodBeat.o(325803);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(325804);
    String str2 = com.tencent.mm.plugin.sns.ad.a.a.aPk();
    String str3 = com.tencent.mm.plugin.sns.ad.a.a.gZB();
    String str1 = "";
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("waidPkg");
      str1 = b.bbr(paramJSONObject);
      s.s(str1, "getAppWaid(waidPkg)");
      Log.i("MicroMsg.AppBrand.JsApiGetDeviceInfo", s.X("waidPkg=", paramJSONObject));
    }
    String str4 = com.tencent.mm.plugin.sns.ad.a.a.gZz();
    if (paramf == null) {
      paramJSONObject = null;
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrand.JsApiGetDeviceInfo", "getDeviceInfo, oaid:" + str2 + ", imei:" + str3 + ", waid:" + str1, new Object[] { s.X("ua:", paramJSONObject) });
      paramJSONObject = ak.e(new r[] { v.Y("oaid", str2), v.Y("imei", str3), v.Y("waid", str1), v.Y("devIdInfo", str4), v.Y("ua", paramJSONObject) });
      if (paramf != null) {
        paramf.callback(paramInt, m("ok", paramJSONObject));
      }
      AppMethodBeat.o(325804);
      return;
      paramJSONObject = (com.tencent.mm.plugin.appbrand.t.a)paramf.aN(com.tencent.mm.plugin.appbrand.t.a.class);
      if (paramJSONObject == null) {
        paramJSONObject = null;
      } else {
        paramJSONObject = paramJSONObject.tnh;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/device/JsApiGetDeviceInfo$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.a
 * JD-Core Version:    0.7.0.1
 */