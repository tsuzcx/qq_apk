package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r
  extends b
{
  public static final int CTRL_INDEX = 136;
  public static final String NAME = "includeMapPoints";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143670);
    super.a(parame, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiIncludeMapPoints", "data is null");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(143670);
      return;
    }
    Log.i("MicroMsg.JsApiIncludeMapPoints", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.l.a.b localb = g(parame, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiIncludeMapPoints", "mapView is null, return");
      parame.j(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(143670);
      return;
    }
    try
    {
      if (paramJSONObject.has("points"))
      {
        ArrayList localArrayList = new ArrayList();
        Object localObject = paramJSONObject.optString("points");
        if (!Util.isNullOrNil((String)localObject))
        {
          localObject = new JSONArray((String)localObject);
          i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(i);
            localArrayList.add(new b.i(Util.getDouble(localJSONObject.optString("latitude"), 0.0D), Util.getDouble(localJSONObject.optString("longitude"), 0.0D)) {});
            i += 1;
          }
        }
        int i = 0;
        paramJSONObject = paramJSONObject.optString("padding");
        if (!Util.isNullOrNil(paramJSONObject)) {
          i = g.c(new JSONArray(paramJSONObject), 0);
        }
        if (localArrayList.size() > 0) {
          localb.h(localArrayList, i);
        }
      }
      a(parame, paramInt, h("ok", null), true, localb.bSF());
      AppMethodBeat.o(143670);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.JsApiIncludeMapPoints", "parse points error, exception : %s", new Object[] { paramJSONObject });
      parame.j(paramInt, h("fail:internal error", null));
      AppMethodBeat.o(143670);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.r
 * JD-Core Version:    0.7.0.1
 */