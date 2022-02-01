package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
  extends b
{
  public static final int CTRL_INDEX = 140;
  public static final String NAME = "addMapControls";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143659);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiAddMapControls", "data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(143659);
      return;
    }
    Log.d("MicroMsg.JsApiAddMapControls", "data:%s", new Object[] { paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.o.a.b localb = g(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiAddMapControls", "mapView is null, return");
      paramf.callback(paramInt, ZP("fail:mapview is null"));
      AppMethodBeat.o(143659);
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        if (paramJSONObject.has("controls"))
        {
          localb.csP();
          JSONArray localJSONArray = new JSONArray(paramJSONObject.optString("controls"));
          i = 0;
          if (i < localJSONArray.length())
          {
            JSONObject localJSONObject1 = (JSONObject)localJSONArray.get(i);
            b.c localc = new b.c();
            localc.sdM = ((com.tencent.mm.plugin.appbrand.f.b)paramf.T(com.tencent.mm.plugin.appbrand.f.b.class)).b(paramf, localJSONObject1.optString("iconPath"));
            localc.sdN = localJSONObject1.optBoolean("clickable");
            localc.data = localJSONObject1.optString("data");
            JSONObject localJSONObject2 = localJSONObject1.getJSONObject("position");
            int j = i.a(localJSONObject2, "left", 0);
            int k = i.a(localJSONObject2, "top", 0);
            localc.left = j;
            localc.top = k;
            if (localJSONObject2.has("width")) {
              localc.width = i.a(localJSONObject2, "width", 0);
            }
            if (localJSONObject2.has("height")) {
              localc.height = i.a(localJSONObject2, "height", 0);
            }
            if (localJSONObject1.optBoolean("clickable")) {
              localb.a(localc, new e.1(this, com.tencent.mm.plugin.appbrand.jsapi.o.a.f.ap(paramJSONObject), paramf), (a)paramf.T(a.class));
            } else {
              localb.a(localc, null, (a)paramf.T(a.class));
            }
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.e("MicroMsg.JsApiAddMapControls", "parse controls error, exception : %s", new Object[] { paramJSONObject });
        a(paramf, paramInt, ZP("fail:internal error"), false, localb.csM());
        AppMethodBeat.o(143659);
        return;
      }
      a(paramf, paramInt, ZP("ok"), true, localb.csM());
      AppMethodBeat.o(143659);
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.e
 * JD-Core Version:    0.7.0.1
 */