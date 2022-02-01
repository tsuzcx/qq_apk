package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.ac;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.ad;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.j;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n
  extends b
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getMapRegion";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143666);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiGetMapRegion", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143666);
      return;
    }
    ae.i("MicroMsg.JsApiGetMapRegion", "data:%s", new Object[] { paramJSONObject });
    paramJSONObject = h(paramc, paramJSONObject);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiGetMapRegion", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(143666);
      return;
    }
    Object localObject1 = paramJSONObject.bly().kVV;
    if (localObject1 == null)
    {
      ae.e("MicroMsg.JsApiGetMapRegion", "visibleRegion is  null");
      paramc.h(paramInt, e("fail:visibleRegion is null", null));
      AppMethodBeat.o(143666);
      return;
    }
    localObject1 = ((b.ad)localObject1).kVW;
    if (localObject1 == null)
    {
      ae.e("MicroMsg.JsApiGetMapRegion", "latLngBounds is  null");
      paramc.h(paramInt, e("fail:latLngBounds is null", null));
      AppMethodBeat.o(143666);
      return;
    }
    Object localObject2 = ((b.j)localObject1).kVv;
    Object localObject3 = ((b.j)localObject1).kVw;
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
    ae.i("MicroMsg.JsApiGetMapRegion", "getMapRegion ok, values:%s", new Object[] { localObject3.toString() });
    a(paramc, paramInt, n("ok", (Map)localObject3), true, paramJSONObject.blB());
    AppMethodBeat.o(143666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.n
 * JD-Core Version:    0.7.0.1
 */