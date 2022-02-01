package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.aa;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.z;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static void a(b paramb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(205020);
    paramb = paramb.bhj().kwg;
    if (paramb == null) {
      ac.e("MicroMsg.AppBrandMapUtils", "visibleRegion is  null");
    }
    Object localObject = paramb.kwh;
    if (localObject == null) {
      ac.e("MicroMsg.AppBrandMapUtils", "latLngBounds is  null");
    }
    paramb = ((b.i)localObject).kvI;
    localObject = ((b.i)localObject).kvJ;
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
      AppMethodBeat.o(205020);
      return;
    }
    catch (JSONException paramb)
    {
      ac.printErrStackTrace("MicroMsg.AppBrandMapUtils", paramb, "", new Object[0]);
      AppMethodBeat.o(205020);
    }
  }
  
  public static void b(b paramb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(205021);
    paramb = paramb.bhn();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("latitude", paramb.latitude);
      localJSONObject.put("longitude", paramb.longitude);
      paramJSONObject.remove("centerLocation");
      paramJSONObject.put("centerLocation", localJSONObject);
      AppMethodBeat.o(205021);
      return;
    }
    catch (JSONException paramb)
    {
      ac.printErrStackTrace("MicroMsg.AppBrandMapUtils", paramb, "", new Object[0]);
      AppMethodBeat.o(205021);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.a
 * JD-Core Version:    0.7.0.1
 */