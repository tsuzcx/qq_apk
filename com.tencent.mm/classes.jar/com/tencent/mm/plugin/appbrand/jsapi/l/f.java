package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends b
{
  public static final int CTRL_INDEX = 889;
  public static final String NAME = "addMapGroundOverlay";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(193358);
    super.a(parame, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiAddMapGroundOverlay", "data is null");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(193358);
      return;
    }
    Log.i("MicroMsg.JsApiAddMapGroundOverlay", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.l.a.b localb = g(parame, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiAddMapGroundOverlay", "mapView is null, return");
      parame.j(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(193358);
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
            locale.oYo = new b.i(localJSONObject2.optDouble("latitude", 0.0D), localJSONObject2.optDouble("longitude", 0.0D));
          }
          if (localJSONObject1.has("northeast"))
          {
            localJSONObject1 = localJSONObject1.getJSONObject("northeast");
            locale.oYp = new b.i(localJSONObject1.optDouble("latitude", 0.0D), localJSONObject1.optDouble("longitude", 0.0D));
          }
        }
        boolean bool = paramJSONObject.optBoolean("visible", true);
        int j = paramJSONObject.optInt("zIndex", 1);
        double d = paramJSONObject.optDouble("opacity", 1.0D);
        if ((!Util.isNullOrNil(str)) && (parame.K(com.tencent.mm.plugin.appbrand.f.b.class) != null))
        {
          locale.oYm = ((com.tencent.mm.plugin.appbrand.f.b)parame.K(com.tencent.mm.plugin.appbrand.f.b.class)).b(parame, str);
          locale.visible = bool;
          locale.zIndex = j;
          locale.alpha = ((float)d);
          if (!localb.a(i, locale, (a)parame.K(a.class))) {
            break;
          }
          Log.i("MicroMsg.JsApiAddMapGroundOverlay", "addGroundOverlay ok");
          parame.j(paramInt, h("ok", null));
          AppMethodBeat.o(193358);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        Log.i("MicroMsg.JsApiAddMapGroundOverlay", "");
        Log.e("MicroMsg.JsApiAddMapGroundOverlay", "parse add groundOverlay error, exception : %s", new Object[] { paramJSONObject });
        a(parame, paramInt, h("fail:internal error", null), false, localb.bSF());
        AppMethodBeat.o(193358);
        return;
      }
      locale.oYm = str;
    }
    Log.i("MicroMsg.JsApiAddMapGroundOverlay", "addGroundOverlay fail");
    parame.j(paramInt, h("fail", null));
    AppMethodBeat.o(193358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.f
 * JD-Core Version:    0.7.0.1
 */