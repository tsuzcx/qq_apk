package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.ac;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.ad;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.j;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n
  extends b
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getMapRegion";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143666);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiGetMapRegion", "data is null");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(143666);
      return;
    }
    Log.i("MicroMsg.JsApiGetMapRegion", "data:%s", new Object[] { paramJSONObject });
    paramJSONObject = h(paramf, paramJSONObject);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiGetMapRegion", "mapView is null, return");
      paramf.i(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(143666);
      return;
    }
    Object localObject1 = paramJSONObject.bGU().mbe;
    if (localObject1 == null)
    {
      Log.e("MicroMsg.JsApiGetMapRegion", "visibleRegion is  null");
      paramf.i(paramInt, h("fail:visibleRegion is null", null));
      AppMethodBeat.o(143666);
      return;
    }
    localObject1 = ((b.ad)localObject1).mbf;
    if (localObject1 == null)
    {
      Log.e("MicroMsg.JsApiGetMapRegion", "latLngBounds is  null");
      paramf.i(paramInt, h("fail:latLngBounds is null", null));
      AppMethodBeat.o(143666);
      return;
    }
    Object localObject2 = ((b.j)localObject1).maE;
    Object localObject3 = ((b.j)localObject1).maF;
    localObject1 = new HashMap();
    if (localObject2 != null)
    {
      ((Map)localObject1).put("latitude", Double.valueOf(((b.i)localObject2).latitude));
      ((Map)localObject1).put("longitude", Double.valueOf(((b.i)localObject2).longitude));
    }
    localObject2 = new HashMap();
    if (localObject3 != null)
    {
      ((Map)localObject2).put("latitude", Double.valueOf(((b.i)localObject3).latitude));
      ((Map)localObject2).put("longitude", Double.valueOf(((b.i)localObject3).longitude));
    }
    localObject3 = new HashMap();
    ((Map)localObject3).put("southwest", localObject1);
    ((Map)localObject3).put("northeast", localObject2);
    Log.i("MicroMsg.JsApiGetMapRegion", "getMapRegion ok, values:%s", new Object[] { localObject3.toString() });
    a(paramf, paramInt, n("ok", (Map)localObject3), true, paramJSONObject.bGX());
    AppMethodBeat.o(143666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.n
 * JD-Core Version:    0.7.0.1
 */