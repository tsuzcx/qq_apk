package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.q;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class s
  extends b
{
  public static final int CTRL_INDEX = 857;
  public static final String NAME = "initMapMarkerCluster";
  
  public final void a(final c paramc, final JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(206460);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiInitMapMarkerCluster", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(206460);
      return;
    }
    ae.i("MicroMsg.JsApiInitMapMarkerCluster", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ae.e("MicroMsg.JsApiInitMapMarkerCluster", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(206460);
      return;
    }
    boolean bool1 = paramJSONObject.optBoolean("enableDefaultStyle", true);
    boolean bool2 = paramJSONObject.optBoolean("zoomOnClick", true);
    int i = paramJSONObject.optInt("minimumClusterSize", 2);
    int j = paramJSONObject.optInt("gridSize", 60);
    ae.i("MicroMsg.JsApiInitMapMarkerCluster", "enableDefaultStyle:%b, zoomOnClick:%b, minimumClusterSize:%d, gridSize:%d", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(i), Integer.valueOf(j) });
    localb.a(bool1, bool2, i, j, new b.q()
    {
      JSONObject jsonObject;
      
      public final void R(JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(206459);
        s.a locala = new s.a();
        HashMap localHashMap = new HashMap();
        localHashMap.put("cluster", paramAnonymousJSONObject);
        localHashMap.put("mapId", Integer.valueOf(f.S(paramJSONObject)));
        locala.I(localHashMap);
        ae.i("MicroMsg.JsApiInitMapMarkerCluster", "click clusterInfo:%s", new Object[] { paramAnonymousJSONObject });
        paramAnonymousJSONObject = ((g)paramc.K(g.class)).c(paramc, paramJSONObject);
        if (paramAnonymousJSONObject != null)
        {
          paramAnonymousJSONObject.b(locala);
          AppMethodBeat.o(206459);
          return;
        }
        paramc.a(locala);
        AppMethodBeat.o(206459);
      }
      
      public final void p(JSONArray paramAnonymousJSONArray)
      {
        AppMethodBeat.i(206458);
        s.b localb = new s.b();
        HashMap localHashMap = new HashMap();
        localHashMap.put("clusters", paramAnonymousJSONArray);
        localHashMap.put("mapId", Integer.valueOf(f.S(paramJSONObject)));
        try
        {
          this.jsonObject.remove("clusters");
          this.jsonObject.put("clusters", paramAnonymousJSONArray);
          this.jsonObject.remove("mapId");
          this.jsonObject.put("mapId", f.S(paramJSONObject));
          label98:
          localb.I(localHashMap);
          ae.i("MicroMsg.JsApiInitMapMarkerCluster", "create clusterInfo:%s", new Object[] { paramAnonymousJSONArray });
          paramAnonymousJSONArray = ((g)paramc.K(g.class)).c(paramc, paramJSONObject);
          if (paramAnonymousJSONArray != null)
          {
            paramAnonymousJSONArray.b(localb);
            AppMethodBeat.o(206458);
            return;
          }
          paramc.a(localb);
          AppMethodBeat.o(206458);
          return;
        }
        catch (JSONException localJSONException)
        {
          break label98;
        }
      }
    });
    paramc.h(paramInt, e("ok", null));
    AppMethodBeat.o(206460);
  }
  
  public static final class a
    extends at
  {
    private static final int CTRL_INDEX = 859;
    private static final String NAME = "onMapMarkerClusterClick";
  }
  
  public static final class b
    extends at
  {
    private static final int CTRL_INDEX = 858;
    private static final String NAME = "onMapMarkerClusterCreate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.s
 * JD-Core Version:    0.7.0.1
 */