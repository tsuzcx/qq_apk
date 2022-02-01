package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p
  extends b
{
  public static final int CTRL_INDEX = 136;
  public static final String NAME = "includeMapPoints";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143670);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiIncludeMapPoints", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143670);
      return;
    }
    ad.i("MicroMsg.JsApiIncludeMapPoints", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.g.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ad.e("MicroMsg.JsApiIncludeMapPoints", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(143670);
      return;
    }
    try
    {
      if (paramJSONObject.has("points"))
      {
        ArrayList localArrayList = new ArrayList();
        Object localObject = paramJSONObject.optString("points");
        if (!bt.isNullOrNil((String)localObject))
        {
          localObject = new JSONArray((String)localObject);
          i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(i);
            localArrayList.add(new b.h(bt.getDouble(localJSONObject.optString("latitude"), 0.0D), bt.getDouble(localJSONObject.optString("longitude"), 0.0D)) {});
            i += 1;
          }
        }
        int i = 0;
        paramJSONObject = paramJSONObject.optString("padding");
        if (!bt.isNullOrNil(paramJSONObject)) {
          i = g.c(new JSONArray(paramJSONObject), 0);
        }
        if (localArrayList.size() > 0) {
          localb.h(localArrayList, i);
        }
      }
      a(paramc, paramInt, e("ok", null), true, localb.bat());
      AppMethodBeat.o(143670);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ad.e("MicroMsg.JsApiIncludeMapPoints", "parse points error, exception : %s", new Object[] { paramJSONObject });
      paramc.h(paramInt, e("fail:internal error", null));
      AppMethodBeat.o(143670);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.p
 * JD-Core Version:    0.7.0.1
 */