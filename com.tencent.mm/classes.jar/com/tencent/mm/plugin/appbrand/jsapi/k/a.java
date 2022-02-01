package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.ac;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.ad;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.j;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static void a(b paramb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(234539);
    paramb = paramb.bGU().mbe;
    if (paramb == null) {
      Log.e("MicroMsg.AppBrandMapUtils", "visibleRegion is  null");
    }
    Object localObject = paramb.mbf;
    if (localObject == null) {
      Log.e("MicroMsg.AppBrandMapUtils", "latLngBounds is  null");
    }
    paramb = ((b.j)localObject).maE;
    localObject = ((b.j)localObject).maF;
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
      AppMethodBeat.o(234539);
      return;
    }
    catch (JSONException paramb)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandMapUtils", paramb, "", new Object[0]);
      AppMethodBeat.o(234539);
    }
  }
  
  public static void b(b paramb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(234540);
    paramb = paramb.bGY();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("latitude", paramb.latitude);
      localJSONObject.put("longitude", paramb.longitude);
      paramJSONObject.remove("centerLocation");
      paramJSONObject.put("centerLocation", localJSONObject);
      AppMethodBeat.o(234540);
      return;
    }
    catch (JSONException paramb)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandMapUtils", paramb, "", new Object[0]);
      AppMethodBeat.o(234540);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.a
 * JD-Core Version:    0.7.0.1
 */