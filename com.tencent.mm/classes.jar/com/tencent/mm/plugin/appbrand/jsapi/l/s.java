package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.b.q;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.o;
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
  
  public final void a(final e parame, final JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(193293);
    super.a(parame, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiInitMapMarkerCluster", "data is null");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(193293);
      return;
    }
    Log.i("MicroMsg.JsApiInitMapMarkerCluster", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.l.a.b localb = g(parame, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiInitMapMarkerCluster", "mapView is null, return");
      parame.j(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(193293);
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
      
      public final void ae(JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(192265);
        s.a locala = new s.a();
        HashMap localHashMap = new HashMap();
        localHashMap.put("cluster", paramAnonymousJSONObject);
        localHashMap.put("mapId", Integer.valueOf(f.af(paramJSONObject)));
        locala.E(localHashMap);
        Log.i("MicroMsg.JsApiInitMapMarkerCluster", "click clusterInfo:%s", new Object[] { paramAnonymousJSONObject });
        paramAnonymousJSONObject = ((com.tencent.mm.plugin.appbrand.jsapi.base.g)parame.K(com.tencent.mm.plugin.appbrand.jsapi.base.g.class)).c(parame, paramJSONObject);
        if (paramAnonymousJSONObject != null)
        {
          paramAnonymousJSONObject.a(locala, null);
          AppMethodBeat.o(192265);
          return;
        }
        parame.a(locala);
        AppMethodBeat.o(192265);
      }
      
      public final void p(JSONArray paramAnonymousJSONArray)
      {
        AppMethodBeat.i(192257);
        s.b localb = new s.b();
        HashMap localHashMap = new HashMap();
        localHashMap.put("clusters", paramAnonymousJSONArray);
        localHashMap.put("mapId", Integer.valueOf(f.af(paramJSONObject)));
        try
        {
          this.jsonObject.remove("clusters");
          this.jsonObject.put("clusters", paramAnonymousJSONArray);
          this.jsonObject.remove("mapId");
          this.jsonObject.put("mapId", f.af(paramJSONObject));
          label98:
          localb.E(localHashMap);
          Log.i("MicroMsg.JsApiInitMapMarkerCluster", "create clusterInfo:%s", new Object[] { paramAnonymousJSONArray });
          paramAnonymousJSONArray = ((com.tencent.mm.plugin.appbrand.jsapi.base.g)parame.K(com.tencent.mm.plugin.appbrand.jsapi.base.g.class)).c(parame, paramJSONObject);
          if (paramAnonymousJSONArray != null)
          {
            paramAnonymousJSONArray.a(localb, null);
            AppMethodBeat.o(192257);
            return;
          }
          parame.a(localb);
          AppMethodBeat.o(192257);
          return;
        }
        catch (JSONException localJSONException)
        {
          break label98;
        }
      }
    });
    parame.j(paramInt, h("ok", null));
    AppMethodBeat.o(193293);
  }
  
  public static final class a
    extends az
  {
    private static final int CTRL_INDEX = 859;
    private static final String NAME = "onMapMarkerClusterClick";
  }
  
  public static final class b
    extends az
  {
    private static final int CTRL_INDEX = 858;
    private static final String NAME = "onMapMarkerClusterCreate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.s
 * JD-Core Version:    0.7.0.1
 */