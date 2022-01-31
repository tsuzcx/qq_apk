package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n
  extends a
{
  public static final int CTRL_INDEX = 136;
  public static final String NAME = "includeMapPoints";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(93851);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiIncludeMapPoints", "data is null");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(93851);
      return;
    }
    ab.i("MicroMsg.JsApiIncludeMapPoints", "data:%s", new Object[] { paramJSONObject });
    b localb = f(paramc, paramJSONObject);
    if (localb == null)
    {
      ab.e("MicroMsg.JsApiIncludeMapPoints", "mapView is null, return");
      paramc.h(paramInt, j("fail:mapview is null", null));
      AppMethodBeat.o(93851);
      return;
    }
    try
    {
      if (paramJSONObject.has("points"))
      {
        ArrayList localArrayList = new ArrayList();
        Object localObject = paramJSONObject.optString("points");
        if (!bo.isNullOrNil((String)localObject))
        {
          localObject = new JSONArray((String)localObject);
          i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(i);
            float f1 = bo.getFloat(localJSONObject.optString("latitude"), 0.0F);
            float f2 = bo.getFloat(localJSONObject.optString("longitude"), 0.0F);
            localArrayList.add(new n.1(this, f1, f2));
            i += 1;
          }
        }
        int i = 0;
        paramJSONObject = paramJSONObject.optString("padding");
        if (!bo.isNullOrNil(paramJSONObject)) {
          i = g.a(new JSONArray(paramJSONObject), 0);
        }
        if (localArrayList.size() > 0) {
          localb.h(localArrayList, i);
        }
      }
      a(paramc, paramInt, j("ok", null), true, localb.aDx());
      AppMethodBeat.o(93851);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ab.e("MicroMsg.JsApiIncludeMapPoints", "parse points error, exception : %s", new Object[] { paramJSONObject });
      paramc.h(paramInt, j("fail:internal error", null));
      AppMethodBeat.o(93851);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.n
 * JD-Core Version:    0.7.0.1
 */