package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.aa;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.z;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class l
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
      ac.e("MicroMsg.JsApiGetMapRegion", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143666);
      return;
    }
    ac.i("MicroMsg.JsApiGetMapRegion", "data:%s", new Object[] { paramJSONObject });
    paramJSONObject = h(paramc, paramJSONObject);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.JsApiGetMapRegion", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(143666);
      return;
    }
    Object localObject1 = paramJSONObject.bhj().kwg;
    if (localObject1 == null)
    {
      ac.e("MicroMsg.JsApiGetMapRegion", "visibleRegion is  null");
      paramc.h(paramInt, e("fail:visibleRegion is null", null));
      AppMethodBeat.o(143666);
      return;
    }
    localObject1 = ((b.aa)localObject1).kwh;
    if (localObject1 == null)
    {
      ac.e("MicroMsg.JsApiGetMapRegion", "latLngBounds is  null");
      paramc.h(paramInt, e("fail:latLngBounds is null", null));
      AppMethodBeat.o(143666);
      return;
    }
    Object localObject2 = ((b.i)localObject1).kvI;
    Object localObject3 = ((b.i)localObject1).kvJ;
    localObject1 = new HashMap();
    if (localObject2 != null)
    {
      ((Map)localObject1).put("latitude", Double.valueOf(((b.h)localObject2).latitude));
      ((Map)localObject1).put("longitude", Double.valueOf(((b.h)localObject2).longitude));
    }
    localObject2 = new HashMap();
    if (localObject3 != null)
    {
      ((Map)localObject2).put("latitude", Double.valueOf(((b.h)localObject3).latitude));
      ((Map)localObject2).put("longitude", Double.valueOf(((b.h)localObject3).longitude));
    }
    localObject3 = new HashMap();
    ((Map)localObject3).put("southwest", localObject1);
    ((Map)localObject3).put("northeast", localObject2);
    ac.i("MicroMsg.JsApiGetMapRegion", "getMapRegion ok, values:%s", new Object[] { localObject3.toString() });
    a(paramc, paramInt, k("ok", (Map)localObject3), true, paramJSONObject.bhm());
    AppMethodBeat.o(143666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.l
 * JD-Core Version:    0.7.0.1
 */