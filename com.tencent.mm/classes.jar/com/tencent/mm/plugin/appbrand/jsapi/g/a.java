package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.aa;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.z;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static void a(b paramb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(195146);
    paramb = paramb.baq().jVu;
    if (paramb == null) {
      ad.e("MicroMsg.AppBrandMapUtils", "visibleRegion is  null");
    }
    Object localObject = paramb.jVv;
    if (localObject == null) {
      ad.e("MicroMsg.AppBrandMapUtils", "latLngBounds is  null");
    }
    paramb = ((b.i)localObject).jUX;
    localObject = ((b.i)localObject).jUY;
    JSONObject localJSONObject1 = new JSONObject();
    if (paramb != null) {}
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("latitude", paramb.latitude);
      localJSONObject2.put("longitude", paramb.longitude);
      localJSONObject1.put("southwest", localJSONObject2);
      if (localObject != null)
      {
        paramb = new JSONObject();
        paramb.put("latitude", ((b.h)localObject).latitude);
        paramb.put("longitude", ((b.h)localObject).longitude);
        localJSONObject1.put("northeast", paramb);
      }
      paramJSONObject.remove("region");
      paramJSONObject.put("region", localJSONObject1);
      AppMethodBeat.o(195146);
      return;
    }
    catch (JSONException paramb)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandMapUtils", paramb, "", new Object[0]);
      AppMethodBeat.o(195146);
    }
  }
  
  public static void b(b paramb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(195147);
    paramb = paramb.bau();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("latitude", paramb.latitude);
      localJSONObject.put("longitude", paramb.longitude);
      paramJSONObject.remove("centerLocation");
      paramJSONObject.put("centerLocation", localJSONObject);
      AppMethodBeat.o(195147);
      return;
    }
    catch (JSONException paramb)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandMapUtils", paramb, "", new Object[0]);
      AppMethodBeat.o(195147);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a
 * JD-Core Version:    0.7.0.1
 */