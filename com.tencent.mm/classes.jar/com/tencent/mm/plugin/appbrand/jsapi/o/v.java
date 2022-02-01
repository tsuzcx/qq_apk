package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.l;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.m;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.o;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.p;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.s;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.t;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.u;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.w;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.x;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.z;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class v
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b
{
  public static final int CTRL_INDEX = 2;
  public static final String NAME = "insertMap";
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143684);
    try
    {
      int i = paramJSONObject.optInt("mapId");
      AppMethodBeat.o(143684);
      return i;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.JsApiInsertMap", "get mapId error, exception : %s", new Object[] { paramJSONObject });
      AppMethodBeat.o(143684);
    }
    return -1;
  }
  
  public final View a(final h paramh, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143683);
    float f1 = Util.getFloat(paramJSONObject.optString("centerLatitude"), 0.0F);
    float f2 = Util.getFloat(paramJSONObject.optString("centerLongitude"), 0.0F);
    float f3 = Util.getFloat(paramJSONObject.optString("scale"), 16.0F);
    int i = paramJSONObject.optInt("rotate", 0);
    int j = paramJSONObject.optInt("skew", 0);
    int k = (int)Util.getFloat(paramJSONObject.optString("maxScale"), 20.0F);
    int m = (int)Util.getFloat(paramJSONObject.optString("minScale"), 3.0F);
    if ((Math.abs(f1) > 90.0F) || (Math.abs(f2) > 180.0F))
    {
      Log.d("MicroMsg.JsApiInsertMap", "centerLatitude or centerLongitude value is error!");
      AppMethodBeat.o(143683);
      return null;
    }
    com.tencent.mm.plugin.appbrand.jsapi.o.a.e.AQ(0);
    final String str = paramh.getAppId();
    Log.i("MicroMsg.JsApiInsertMap", "insertMap appId:%s viewId:%d data:%s", new Object[] { str, Integer.valueOf(V(paramJSONObject)), paramJSONObject });
    final com.tencent.mm.plugin.appbrand.jsapi.o.a.b localb = ((c)com.tencent.luggage.a.e.T(c.class)).b(paramh, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiInsertMap", "mapView is null, return");
      AppMethodBeat.o(143683);
      return null;
    }
    if (!g.a(str, f.h(paramh, paramJSONObject), localb))
    {
      Log.e("MicroMsg.JsApiInsertMap", "initMapView is false, return");
      com.tencent.mm.plugin.appbrand.jsapi.o.a.e.AQ(1);
      AppMethodBeat.o(143683);
      return null;
    }
    com.tencent.mm.plugin.appbrand.jsapi.o.a.e.AQ(2);
    localb.jq(paramJSONObject.optBoolean("enableZoom", true));
    localb.jr(paramJSONObject.optBoolean("enableScroll", true));
    localb.js(paramJSONObject.optBoolean("enableRotate", false));
    localb.jt(paramJSONObject.optBoolean("showCompass", false));
    localb.setBuilding3dEffectEnable(paramJSONObject.optBoolean("enable3D", false));
    localb.ju(paramJSONObject.optBoolean("enableOverlooking", false));
    localb.jv(paramJSONObject.optBoolean("enableSatellite", false));
    localb.jx(paramJSONObject.optBoolean("enableIndoor", true));
    localb.jy(paramJSONObject.optBoolean("enableIndoorLevelPick", false));
    localb.jz(paramJSONObject.optBoolean("showScale", true));
    if (paramJSONObject.has("enablePoi")) {
      localb.setPoisEnabled(paramJSONObject.optBoolean("enablePoi", true));
    }
    if (paramJSONObject.has("enableBuilding")) {
      localb.jA(paramJSONObject.optBoolean("enableBuilding", true));
    }
    localb.setMaxZoomLevel(k);
    localb.setMinZoomLevel(m);
    localb.a(f1, f2, f3, i, j);
    paramh.a(new i.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(143671);
        Log.i("MicroMsg.JsApiInsertMap", "onBackground");
        if (localb != null) {
          localb.onPause();
        }
        AppMethodBeat.o(143671);
      }
    });
    paramh.a(new i.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(143673);
        Log.i("MicroMsg.JsApiInsertMap", "onForeground");
        if (localb != null) {
          localb.onResume();
        }
        AppMethodBeat.o(143673);
      }
    });
    paramh.a(new i.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(143674);
        Log.i("MicroMsg.JsApiInsertMap", "onDestroy");
        paramh.b(this);
        g.ee(str, f.h(paramh, paramJSONObject));
        AppMethodBeat.o(143674);
      }
    });
    localb.getView().setVisibility(0);
    paramh = new CoverViewContainer(paramh.getContext(), localb.getView());
    AppMethodBeat.o(143683);
    return paramh;
  }
  
  public final void a(final h paramh, final int paramInt, final View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143685);
    paramView = g.ed(paramh.getAppId(), f.h(paramh, paramJSONObject));
    if (paramView == null)
    {
      Log.e("MicroMsg.JsApiInsertMap", "mapView is null, error, return");
      AppMethodBeat.o(143685);
      return;
    }
    paramView.a(new b.l()
    {
      public final void a(b.u paramAnonymousu)
      {
        AppMethodBeat.i(143675);
        v.b localb = new v.b();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("mapId", paramInt);
          localJSONObject.put("data", paramAnonymousu.data);
          localb.ZR(localJSONObject.toString());
          paramh.a(localb, null);
          AppMethodBeat.o(143675);
          return;
        }
        catch (JSONException paramAnonymousu)
        {
          for (;;)
          {
            Log.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { paramAnonymousu });
          }
        }
      }
    });
    paramView.a(new b.p()
    {
      public final boolean b(b.u paramAnonymousu)
      {
        AppMethodBeat.i(143676);
        v.f localf = new v.f();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("mapId", paramInt);
          localJSONObject.put("data", paramAnonymousu.data);
          localf.ZR(localJSONObject.toString());
          paramh.a(localf, null);
          AppMethodBeat.o(143676);
          return true;
        }
        catch (JSONException paramAnonymousu)
        {
          for (;;)
          {
            Log.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { paramAnonymousu });
          }
        }
      }
    });
    paramView.a(new b.m()
    {
      public final void h(double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(143677);
        v.c localc = new v.c();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("mapId", paramInt);
          localJSONObject.put("longitude", paramAnonymousDouble1);
          localJSONObject.put("latitude", paramAnonymousDouble2);
          localc.ZR(localJSONObject.toString());
          paramh.a(localc, null);
          AppMethodBeat.o(143677);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            Log.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { localJSONException });
          }
        }
      }
    });
    paramView.a(new b.o()
    {
      public final boolean c(b.u paramAnonymousu)
      {
        AppMethodBeat.i(143678);
        v.e locale = new v.e();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("mapId", paramInt);
          localJSONObject.put("data", paramAnonymousu.data);
          locale.ZR(localJSONObject.toString());
          paramh.a(locale, null);
          AppMethodBeat.o(143678);
          return true;
        }
        catch (JSONException paramAnonymousu)
        {
          for (;;)
          {
            Log.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { paramAnonymousu });
          }
        }
      }
    });
    paramView.a(new b.z()
    {
      public final void a(b.t paramAnonymoust)
      {
        AppMethodBeat.i(143679);
        v.g localg = new v.g();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("mapId", paramInt);
          localJSONObject.put("latitude", paramAnonymoust.latitude);
          localJSONObject.put("longitude", paramAnonymoust.longitude);
          localJSONObject.put("name", paramAnonymoust.name);
          if (!Util.isNullOrNil(paramAnonymoust.buildingId))
          {
            localJSONObject.put("buildingId", paramAnonymoust.buildingId);
            localJSONObject.put("floorName", paramAnonymoust.floorName);
          }
          localg.ZR(localJSONObject.toString());
          paramh.a(localg, null);
          Log.v("MicroMsg.JsApiInsertMap", "OnMapPoiClick %s", new Object[] { localJSONObject.toString() });
          AppMethodBeat.o(143679);
          return;
        }
        catch (JSONException paramAnonymoust)
        {
          for (;;)
          {
            Log.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { paramAnonymoust });
          }
        }
      }
    });
    paramView.jB(paramJSONObject.optBoolean("showLocation"));
    paramView.a(new b.w()
    {
      JSONObject rNs;
      AtomicBoolean sbF;
      float sbG;
      v.h sbH;
      
      public final void a(b.a paramAnonymousa, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(143681);
        if (this.sbF.compareAndSet(false, true)) {}
        for (;;)
        {
          try
          {
            this.rNs.remove("mapId");
            this.rNs.put("mapId", paramInt);
            this.rNs.remove("type");
            this.rNs.put("type", "begin");
            if (!paramAnonymousBoolean) {
              continue;
            }
            this.rNs.put("causedBy", "gesture");
            this.rNs.remove("rotate");
            this.rNs.remove("skew");
          }
          catch (JSONException localJSONException)
          {
            Log.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { localJSONException });
            continue;
          }
          this.sbH.ZR(this.rNs.toString());
          paramh.a(this.sbH, null);
          this.sbG = paramAnonymousa.zoom;
          Log.v("MicroMsg.JsApiInsertMap", "onCameraChange begin");
          AppMethodBeat.o(143681);
          return;
          this.rNs.put("causedBy", "update");
        }
      }
      
      public final void b(b.a paramAnonymousa, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(143682);
        if (this.sbF.compareAndSet(true, false)) {}
        for (;;)
        {
          try
          {
            this.rNs.remove("mapId");
            this.rNs.put("mapId", paramInt);
            this.rNs.remove("type");
            this.rNs.put("type", "end");
            this.rNs.remove("causedBy");
            if (paramAnonymousa.zoom == this.sbG) {
              continue;
            }
            i = 1;
            if (!paramAnonymousBoolean) {
              continue;
            }
            if (i == 0) {
              continue;
            }
            this.rNs.put("causedBy", "scale");
          }
          catch (JSONException paramAnonymousa)
          {
            int i;
            Log.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { paramAnonymousa });
            continue;
            this.rNs.put("causedBy", "update");
            continue;
          }
          this.rNs.remove("rotate");
          this.rNs.put("rotate", paramAnonymousa.aBi);
          this.rNs.remove("skew");
          this.rNs.put("skew", paramAnonymousa.skew);
          this.rNs.remove("scale");
          this.rNs.put("scale", paramView.getZoom());
          a.a(paramView, this.rNs);
          a.b(paramView, this.rNs);
          this.sbH.ZR(this.rNs.toString());
          paramh.a(this.sbH, null);
          Log.v("MicroMsg.JsApiInsertMap", "onCameraChange finish, result:%s", new Object[] { this.rNs.toString() });
          AppMethodBeat.o(143682);
          return;
          i = 0;
          continue;
          this.rNs.put("causedBy", "drag");
        }
      }
    });
    paramView.a(new b.x()
    {
      public final void a(b.f paramAnonymousf)
      {
        AppMethodBeat.i(143672);
        v.d locald = new v.d();
        JSONObject localJSONObject1 = new JSONObject();
        JSONArray localJSONArray;
        try
        {
          localJSONObject1.put("mapId", paramInt);
          if (paramAnonymousf != null)
          {
            localJSONObject1.put("buildingId", paramAnonymousf.buildingId);
            localJSONObject1.put("buildingName", paramAnonymousf.buildingName);
            if ((paramAnonymousf.sdQ != null) && (paramAnonymousf.sdQ.size() > 0))
            {
              localJSONArray = new JSONArray();
              Iterator localIterator = paramAnonymousf.sdQ.iterator();
              while (localIterator.hasNext())
              {
                b.g localg = (b.g)localIterator.next();
                JSONObject localJSONObject2 = new JSONObject();
                localJSONObject2.put("name", localg.floorName);
                localJSONArray.put(localJSONObject2);
              }
            }
          }
          else
          {
            locald.ZR(localJSONObject1.toString());
          }
        }
        catch (JSONException paramAnonymousf)
        {
          Log.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { paramAnonymousf });
        }
        for (;;)
        {
          paramh.a(locald, null);
          Log.v("MicroMsg.JsApiInsertMap", "OnMapIndoorStateChange:%s", new Object[] { localJSONObject1.toString() });
          AppMethodBeat.o(143672);
          return;
          localJSONObject1.put("floorList", localJSONArray);
          localJSONObject1.put("floorIndex", paramAnonymousf.sdR);
        }
      }
    });
    paramView.a(new b.s()
    {
      public final void g(double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(329405);
        v.a locala = new v.a();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("mapId", paramInt);
          localJSONObject.put("longitude", paramAnonymousDouble2);
          localJSONObject.put("latitude", paramAnonymousDouble1);
          locala.ZR(localJSONObject.toString());
          paramh.a(locala, null);
          Log.v("MicroMsg.JsApiInsertMap", "MapOnMapAnchorPointClick:%s", new Object[] { localJSONObject.toString() });
          AppMethodBeat.o(329405);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            Log.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { localJSONException });
          }
        }
      }
    });
    AppMethodBeat.o(143685);
  }
  
  public static final class a
    extends bc
  {
    private static final int CTRL_INDEX = 832;
    private static final String NAME = "onMapAnchorPointClick";
  }
  
  public static final class b
    extends bc
  {
    private static final int CTRL_INDEX = 199;
    private static final String NAME = "onMapCalloutClick";
  }
  
  public static final class c
    extends bc
  {
    private static final int CTRL_INDEX = 151;
    private static final String NAME = "onMapClick";
  }
  
  public static final class d
    extends bc
  {
    private static final int CTRL_INDEX = 524;
    private static final String NAME = "onMapIndoorChange";
  }
  
  public static final class e
    extends bc
  {
    private static final int CTRL_INDEX = 679;
    private static final String NAME = "onMapLabelClick";
  }
  
  public static final class f
    extends bc
  {
    private static final int CTRL_INDEX = 142;
    private static final String NAME = "onMapMarkerClick";
  }
  
  public static final class g
    extends bc
  {
    private static final int CTRL_INDEX = 511;
    private static final String NAME = "onMapPoiClick";
  }
  
  public static final class h
    extends bc
  {
    private static final int CTRL_INDEX = 147;
    private static final String NAME = "onMapRegionChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.v
 * JD-Core Version:    0.7.0.1
 */