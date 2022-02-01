package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class an
  extends b
{
  public static final int CTRL_INDEX = 891;
  public static final String NAME = "updateMapGroundOverlay";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(329486);
    super.a(paramf, paramJSONObject, paramInt);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiUpdateMapGroundOverlay", "data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(329486);
      return;
    }
    Log.i("MicroMsg.JsApiUpdateMapGroundOverlay", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.o.a.b localb = g(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiUpdateMapGroundOverlay", "mapView is null, return");
      paramf.callback(paramInt, ZP("fail:mapview is null"));
      AppMethodBeat.o(329486);
      return;
    }
    for (;;)
    {
      b.e locale;
      String str;
      try
      {
        locale = new b.e();
        int i = paramJSONObject.getInt("id");
        str = paramJSONObject.getString("src");
        if (paramJSONObject.has("bounds"))
        {
          JSONObject localJSONObject1 = paramJSONObject.getJSONObject("bounds");
          if (localJSONObject1.has("southwest"))
          {
            JSONObject localJSONObject2 = localJSONObject1.getJSONObject("southwest");
            locale.sdO = new b.i(localJSONObject2.optDouble("latitude", 0.0D), localJSONObject2.optDouble("longitude", 0.0D));
          }
          if (localJSONObject1.has("northeast"))
          {
            localJSONObject1 = localJSONObject1.getJSONObject("northeast");
            locale.sdP = new b.i(localJSONObject1.optDouble("latitude", 0.0D), localJSONObject1.optDouble("longitude", 0.0D));
          }
        }
        boolean bool = paramJSONObject.optBoolean("visible", true);
        int j = paramJSONObject.optInt("zIndex", 1);
        double d = paramJSONObject.optDouble("opacity", 1.0D);
        if ((!Util.isNullOrNil(str)) && (paramf.T(com.tencent.mm.plugin.appbrand.f.b.class) != null))
        {
          locale.sdM = ((com.tencent.mm.plugin.appbrand.f.b)paramf.T(com.tencent.mm.plugin.appbrand.f.b.class)).b(paramf, str);
          locale.visible = bool;
          locale.zIndex = j;
          locale.alpha = ((float)d);
          if (!localb.b(i, locale, (a)paramf.T(a.class))) {
            break;
          }
          Log.i("MicroMsg.JsApiUpdateMapGroundOverlay", "updateGroundOverlay ok");
          paramf.callback(paramInt, ZP("ok"));
          AppMethodBeat.o(329486);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        Log.i("MicroMsg.JsApiUpdateMapGroundOverlay", "");
        Log.e("MicroMsg.JsApiUpdateMapGroundOverlay", "parse update groundOverlay error, exception : %s", new Object[] { paramJSONObject });
        a(paramf, paramInt, ZP("fail:internal error"), false, localb.csM());
        AppMethodBeat.o(329486);
        return;
      }
      locale.sdM = str;
    }
    Log.i("MicroMsg.JsApiUpdateMapGroundOverlay", "updateGroundOverlay fail");
    paramf.callback(paramInt, ZP("fail"));
    AppMethodBeat.o(329486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.an
 * JD-Core Version:    0.7.0.1
 */