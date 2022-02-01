package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.ac;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.ad;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.j;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static void a(b paramb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(329478);
    paramb = paramb.csJ();
    if (paramb == null) {
      Log.e("MicroMsg.AppBrandMapUtils", "projection is  null");
    }
    paramb = paramb.sew;
    if (paramb == null) {
      Log.e("MicroMsg.AppBrandMapUtils", "visibleRegion is  null");
    }
    Object localObject = paramb.sey;
    if (localObject == null) {
      Log.e("MicroMsg.AppBrandMapUtils", "latLngBounds is  null");
    }
    paramb = ((b.j)localObject).sdU;
    localObject = ((b.j)localObject).sdV;
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
      AppMethodBeat.o(329478);
      return;
    }
    catch (JSONException paramb)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandMapUtils", paramb, "", new Object[0]);
      AppMethodBeat.o(329478);
    }
  }
  
  public static void b(b paramb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(329480);
    paramb = paramb.csN();
    if (paramb != null)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("latitude", paramb.latitude);
        localJSONObject.put("longitude", paramb.longitude);
        paramJSONObject.remove("centerLocation");
        paramJSONObject.put("centerLocation", localJSONObject);
        AppMethodBeat.o(329480);
        return;
      }
      catch (JSONException paramb)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandMapUtils", paramb, "", new Object[0]);
      }
    }
    AppMethodBeat.o(329480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.a
 * JD-Core Version:    0.7.0.1
 */