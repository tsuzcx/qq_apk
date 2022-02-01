package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.q;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
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
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, final JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(234548);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiInitMapMarkerCluster", "data is null");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(234548);
      return;
    }
    Log.i("MicroMsg.JsApiInitMapMarkerCluster", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.k.a.b localb = h(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiInitMapMarkerCluster", "mapView is null, return");
      paramf.i(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(234548);
      return;
    }
    boolean bool1 = paramJSONObject.optBoolean("enableDefaultStyle", true);
    boolean bool2 = paramJSONObject.optBoolean("zoomOnClick", true);
    int i = paramJSONObject.optInt("minimumClusterSize", 2);
    int j = paramJSONObject.optInt("gridSize", 60);
    Log.i("MicroMsg.JsApiInitMapMarkerCluster", "enableDefaultStyle:%b, zoomOnClick:%b, minimumClusterSize:%d, gridSize:%d", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(i), Integer.valueOf(j) });
    localb.a(bool1, bool2, i, j, new b.q()
    {
      JSONObject jsonObject;
      
      public final void aa(JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(234547);
        s.a locala = new s.a();
        HashMap localHashMap = new HashMap();
        localHashMap.put("cluster", paramAnonymousJSONObject);
        localHashMap.put("mapId", Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.k.a.f.ab(paramJSONObject)));
        locala.L(localHashMap);
        Log.i("MicroMsg.JsApiInitMapMarkerCluster", "click clusterInfo:%s", new Object[] { paramAnonymousJSONObject });
        paramAnonymousJSONObject = ((g)paramf.M(g.class)).c(paramf, paramJSONObject);
        if (paramAnonymousJSONObject != null)
        {
          paramAnonymousJSONObject.a(locala, null);
          AppMethodBeat.o(234547);
          return;
        }
        paramf.a(locala);
        AppMethodBeat.o(234547);
      }
      
      public final void p(JSONArray paramAnonymousJSONArray)
      {
        AppMethodBeat.i(234546);
        s.b localb = new s.b();
        HashMap localHashMap = new HashMap();
        localHashMap.put("clusters", paramAnonymousJSONArray);
        localHashMap.put("mapId", Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.k.a.f.ab(paramJSONObject)));
        try
        {
          this.jsonObject.remove("clusters");
          this.jsonObject.put("clusters", paramAnonymousJSONArray);
          this.jsonObject.remove("mapId");
          this.jsonObject.put("mapId", com.tencent.mm.plugin.appbrand.jsapi.k.a.f.ab(paramJSONObject));
          label98:
          localb.L(localHashMap);
          Log.i("MicroMsg.JsApiInitMapMarkerCluster", "create clusterInfo:%s", new Object[] { paramAnonymousJSONArray });
          paramAnonymousJSONArray = ((g)paramf.M(g.class)).c(paramf, paramJSONObject);
          if (paramAnonymousJSONArray != null)
          {
            paramAnonymousJSONArray.a(localb, null);
            AppMethodBeat.o(234546);
            return;
          }
          paramf.a(localb);
          AppMethodBeat.o(234546);
          return;
        }
        catch (JSONException localJSONException)
        {
          break label98;
        }
      }
    });
    paramf.i(paramInt, h("ok", null));
    AppMethodBeat.o(234548);
  }
  
  public static final class a
    extends bc
  {
    private static final int CTRL_INDEX = 859;
    private static final String NAME = "onMapMarkerClusterClick";
  }
  
  public static final class b
    extends bc
  {
    private static final int CTRL_INDEX = 858;
    private static final String NAME = "onMapMarkerClusterCreate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.s
 * JD-Core Version:    0.7.0.1
 */