package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.ac;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.ad;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.j;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static void a(b paramb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186136);
    paramb = paramb.bkO().kSm;
    if (paramb == null) {
      ad.e("MicroMsg.AppBrandMapUtils", "visibleRegion is  null");
    }
    Object localObject = paramb.kSn;
    if (localObject == null) {
      ad.e("MicroMsg.AppBrandMapUtils", "latLngBounds is  null");
    }
    paramb = ((b.j)localObject).kRM;
    localObject = ((b.j)localObject).kRN;
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
        paramb.put("latitude", ((b.i)localObject).latitude);
        paramb.put("longitude", ((b.i)localObject).longitude);
        localJSONObject1.put("northeast", paramb);
      }
      paramJSONObject.remove("region");
      paramJSONObject.put("region", localJSONObject1);
      AppMethodBeat.o(186136);
      return;
    }
    catch (JSONException paramb)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandMapUtils", paramb, "", new Object[0]);
      AppMethodBeat.o(186136);
    }
  }
  
  public static void b(b paramb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186137);
    paramb = paramb.bkS();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("latitude", paramb.latitude);
      localJSONObject.put("longitude", paramb.longitude);
      paramJSONObject.remove("centerLocation");
      paramJSONObject.put("centerLocation", localJSONObject);
      AppMethodBeat.o(186137);
      return;
    }
    catch (JSONException paramb)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandMapUtils", paramb, "", new Object[0]);
      AppMethodBeat.o(186137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.a
 * JD-Core Version:    0.7.0.1
 */