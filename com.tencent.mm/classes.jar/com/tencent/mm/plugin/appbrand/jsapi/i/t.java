package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.l;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.m;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.o;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.p;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.s;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.t;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.u;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.w;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.x;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.z;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b
{
  public static final int CTRL_INDEX = 2;
  public static final String NAME = "insertMap";
  
  public final int A(JSONObject paramJSONObject)
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
      ad.e("MicroMsg.JsApiInsertMap", "get mapId error, exception : %s", new Object[] { paramJSONObject });
      AppMethodBeat.o(143684);
    }
    return -1;
  }
  
  public final View a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143683);
    float f1 = bt.getFloat(paramJSONObject.optString("centerLatitude"), 0.0F);
    float f2 = bt.getFloat(paramJSONObject.optString("centerLongitude"), 0.0F);
    float f3 = bt.getFloat(paramJSONObject.optString("scale"), 16.0F);
    int i = paramJSONObject.optInt("rotate", 0);
    int j = paramJSONObject.optInt("skew", 0);
    int k = bt.getInt(paramJSONObject.optString("maxScale"), 20);
    int m = bt.getInt(paramJSONObject.optString("minScale"), 3);
    if ((Math.abs(f1) > 90.0F) || (Math.abs(f2) > 180.0F))
    {
      ad.d("MicroMsg.JsApiInsertMap", "centerLatitude or centerLongitude value is error!");
      AppMethodBeat.o(143683);
      return null;
    }
    com.tencent.mm.plugin.appbrand.jsapi.i.a.e.th(0);
    final String str = parame.getAppId();
    ad.i("MicroMsg.JsApiInsertMap", "insertMap appId:%s viewId:%d data:%s", new Object[] { str, Integer.valueOf(A(paramJSONObject)), paramJSONObject });
    final com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = ((c)com.tencent.luggage.a.e.K(c.class)).b(parame, paramJSONObject);
    if (localb == null)
    {
      ad.e("MicroMsg.JsApiInsertMap", "mapView is null, return");
      AppMethodBeat.o(143683);
      return null;
    }
    if (!g.a(str, f.i(parame, paramJSONObject), localb))
    {
      ad.e("MicroMsg.JsApiInsertMap", "initMapView is false, return");
      com.tencent.mm.plugin.appbrand.jsapi.i.a.e.th(1);
      AppMethodBeat.o(143683);
      return null;
    }
    com.tencent.mm.plugin.appbrand.jsapi.i.a.e.th(2);
    localb.gA(paramJSONObject.optBoolean("enableZoom", true));
    localb.gB(paramJSONObject.optBoolean("enableScroll", true));
    localb.gC(paramJSONObject.optBoolean("enableRotate", false));
    localb.gD(paramJSONObject.optBoolean("showCompass", false));
    localb.gE(paramJSONObject.optBoolean("enable3D", false));
    localb.gF(paramJSONObject.optBoolean("enableOverlooking", false));
    localb.gG(paramJSONObject.optBoolean("enableSatellite", false));
    localb.gI(paramJSONObject.optBoolean("enableIndoor", true));
    localb.gJ(paramJSONObject.optBoolean("enableIndoorLevelPick", false));
    localb.gK(paramJSONObject.optBoolean("showScale", true));
    if (paramJSONObject.has("enablePoi")) {
      localb.setPoisEnabled(paramJSONObject.optBoolean("enablePoi", true));
    }
    localb.setMaxZoomLevel(k);
    localb.setMinZoomLevel(m);
    localb.a(f1, f2, f3, i, j);
    parame.a(new f.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(143671);
        ad.i("MicroMsg.JsApiInsertMap", "onBackground");
        if (localb != null) {
          localb.onPause();
        }
        AppMethodBeat.o(143671);
      }
    });
    parame.a(new f.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(143673);
        ad.i("MicroMsg.JsApiInsertMap", "onForeground");
        if (localb != null) {
          localb.onResume();
        }
        AppMethodBeat.o(143673);
      }
    });
    parame.a(new f.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(143674);
        ad.i("MicroMsg.JsApiInsertMap", "onDestroy");
        parame.b(this);
        g.dj(str, f.i(parame, paramJSONObject));
        AppMethodBeat.o(143674);
      }
    });
    localb.getView().setVisibility(0);
    parame = new CoverViewContainer(parame.getContext(), localb.getView());
    AppMethodBeat.o(143683);
    return parame;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, final int paramInt, final View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143685);
    paramView = g.di(parame.getAppId(), f.i(parame, paramJSONObject));
    if (paramView == null)
    {
      ad.e("MicroMsg.JsApiInsertMap", "mapView is null, error, return");
      AppMethodBeat.o(143685);
      return;
    }
    paramView.a(new b.l()
    {
      public final void a(b.u paramAnonymousu)
      {
        AppMethodBeat.i(143675);
        t.b localb = new t.b();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("mapId", paramInt);
          localJSONObject.put("data", paramAnonymousu.data);
          localb.Pi(localJSONObject.toString());
          parame.b(localb);
          AppMethodBeat.o(143675);
          return;
        }
        catch (JSONException paramAnonymousu)
        {
          for (;;)
          {
            ad.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { paramAnonymousu });
          }
        }
      }
    });
    paramView.a(new b.p()
    {
      public final boolean b(b.u paramAnonymousu)
      {
        AppMethodBeat.i(143676);
        t.f localf = new t.f();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("mapId", paramInt);
          localJSONObject.put("data", paramAnonymousu.data);
          localf.Pi(localJSONObject.toString());
          parame.b(localf);
          AppMethodBeat.o(143676);
          return true;
        }
        catch (JSONException paramAnonymousu)
        {
          for (;;)
          {
            ad.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { paramAnonymousu });
          }
        }
      }
    });
    paramView.a(new b.m()
    {
      public final void e(double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(143677);
        t.c localc = new t.c();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("mapId", paramInt);
          localJSONObject.put("longitude", paramAnonymousDouble1);
          localJSONObject.put("latitude", paramAnonymousDouble2);
          localc.Pi(localJSONObject.toString());
          parame.b(localc);
          AppMethodBeat.o(143677);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ad.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { localJSONException });
          }
        }
      }
    });
    paramView.a(new b.o()
    {
      public final boolean c(b.u paramAnonymousu)
      {
        AppMethodBeat.i(143678);
        t.e locale = new t.e();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("mapId", paramInt);
          localJSONObject.put("data", paramAnonymousu.data);
          locale.Pi(localJSONObject.toString());
          parame.b(locale);
          AppMethodBeat.o(143678);
          return true;
        }
        catch (JSONException paramAnonymousu)
        {
          for (;;)
          {
            ad.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { paramAnonymousu });
          }
        }
      }
    });
    paramView.a(new b.z()
    {
      public final void a(b.t paramAnonymoust)
      {
        AppMethodBeat.i(143679);
        t.g localg = new t.g();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("mapId", paramInt);
          localJSONObject.put("latitude", paramAnonymoust.latitude);
          localJSONObject.put("longitude", paramAnonymoust.longitude);
          localJSONObject.put("name", paramAnonymoust.name);
          if (!bt.isNullOrNil(paramAnonymoust.buildingId))
          {
            localJSONObject.put("buildingId", paramAnonymoust.buildingId);
            localJSONObject.put("floorName", paramAnonymoust.floorName);
          }
          localg.Pi(localJSONObject.toString());
          parame.b(localg);
          ad.v("MicroMsg.JsApiInsertMap", "OnMapPoiClick %s", new Object[] { localJSONObject.toString() });
          AppMethodBeat.o(143679);
          return;
        }
        catch (JSONException paramAnonymoust)
        {
          for (;;)
          {
            ad.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { paramAnonymoust });
          }
        }
      }
    });
    paramView.gL(paramJSONObject.optBoolean("showLocation"));
    paramView.a(new b.w()
    {
      JSONObject jsonObject;
      AtomicBoolean kPB;
      float kPC;
      t.h kPD;
      
      public final void a(b.a paramAnonymousa, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(143681);
        if (this.kPB.compareAndSet(false, true)) {}
        for (;;)
        {
          try
          {
            this.jsonObject.remove("mapId");
            this.jsonObject.put("mapId", paramInt);
            this.jsonObject.remove("type");
            this.jsonObject.put("type", "begin");
            if (!paramAnonymousBoolean) {
              continue;
            }
            this.jsonObject.put("causedBy", "gesture");
            this.jsonObject.remove("rotate");
            this.jsonObject.remove("skew");
          }
          catch (JSONException localJSONException)
          {
            ad.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { localJSONException });
            continue;
          }
          this.kPD.Pi(this.jsonObject.toString());
          parame.b(this.kPD);
          this.kPC = paramAnonymousa.zoom;
          ad.v("MicroMsg.JsApiInsertMap", "onCameraChange begin");
          AppMethodBeat.o(143681);
          return;
          this.jsonObject.put("causedBy", "update");
        }
      }
      
      public final void b(b.a paramAnonymousa, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(143682);
        if (this.kPB.compareAndSet(true, false)) {}
        for (;;)
        {
          try
          {
            this.jsonObject.remove("mapId");
            this.jsonObject.put("mapId", paramInt);
            this.jsonObject.remove("type");
            this.jsonObject.put("type", "end");
            this.jsonObject.remove("causedBy");
            if (paramAnonymousa.zoom == this.kPC) {
              continue;
            }
            i = 1;
            if (!paramAnonymousBoolean) {
              continue;
            }
            if (i == 0) {
              continue;
            }
            this.jsonObject.put("causedBy", "scale");
          }
          catch (JSONException paramAnonymousa)
          {
            int i;
            ad.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { paramAnonymousa });
            continue;
            this.jsonObject.put("causedBy", "update");
            continue;
          }
          this.jsonObject.remove("rotate");
          this.jsonObject.put("rotate", paramAnonymousa.kRD);
          this.jsonObject.remove("skew");
          this.jsonObject.put("skew", paramAnonymousa.skew);
          this.jsonObject.remove("scale");
          this.jsonObject.put("scale", paramView.getZoom());
          a.a(paramView, this.jsonObject);
          a.b(paramView, this.jsonObject);
          this.kPD.Pi(this.jsonObject.toString());
          parame.b(this.kPD);
          ad.v("MicroMsg.JsApiInsertMap", "onCameraChange finish, result:%s", new Object[] { this.jsonObject.toString() });
          AppMethodBeat.o(143682);
          return;
          i = 0;
          continue;
          this.jsonObject.put("causedBy", "drag");
        }
      }
    });
    paramView.a(new b.x()
    {
      public final void a(b.f paramAnonymousf)
      {
        AppMethodBeat.i(143672);
        t.d locald = new t.d();
        JSONObject localJSONObject1 = new JSONObject();
        JSONArray localJSONArray;
        try
        {
          localJSONObject1.put("mapId", paramInt);
          if (paramAnonymousf != null)
          {
            localJSONObject1.put("buildingId", paramAnonymousf.buildingId);
            localJSONObject1.put("buildingName", paramAnonymousf.buildingName);
            if ((paramAnonymousf.kRI != null) && (paramAnonymousf.kRI.size() > 0))
            {
              localJSONArray = new JSONArray();
              Iterator localIterator = paramAnonymousf.kRI.iterator();
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
            locald.Pi(localJSONObject1.toString());
          }
        }
        catch (JSONException paramAnonymousf)
        {
          ad.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { paramAnonymousf });
        }
        for (;;)
        {
          parame.b(locald);
          ad.v("MicroMsg.JsApiInsertMap", "OnMapIndoorStateChange:%s", new Object[] { localJSONObject1.toString() });
          AppMethodBeat.o(143672);
          return;
          localJSONObject1.put("floorList", localJSONArray);
          localJSONObject1.put("floorIndex", paramAnonymousf.kRJ);
        }
      }
    });
    paramView.a(new b.s()
    {
      public final void d(double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(186146);
        t.a locala = new t.a();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("mapId", paramInt);
          localJSONObject.put("longitude", paramAnonymousDouble2);
          localJSONObject.put("latitude", paramAnonymousDouble1);
          locala.Pi(localJSONObject.toString());
          parame.b(locala);
          ad.v("MicroMsg.JsApiInsertMap", "MapOnMapAnchorPointClick:%s", new Object[] { localJSONObject.toString() });
          AppMethodBeat.o(186146);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ad.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { localJSONException });
          }
        }
      }
    });
    AppMethodBeat.o(143685);
  }
  
  public static final class a
    extends at
  {
    private static final int CTRL_INDEX = 832;
    private static final String NAME = "onMapAnchorPointClick";
  }
  
  public static final class b
    extends at
  {
    private static final int CTRL_INDEX = 199;
    private static final String NAME = "onMapCalloutClick";
  }
  
  public static final class c
    extends at
  {
    private static final int CTRL_INDEX = 151;
    private static final String NAME = "onMapClick";
  }
  
  public static final class d
    extends at
  {
    private static final int CTRL_INDEX = 524;
    private static final String NAME = "onMapIndoorChange";
  }
  
  public static final class e
    extends at
  {
    private static final int CTRL_INDEX = 679;
    private static final String NAME = "onMapLabelClick";
  }
  
  public static final class f
    extends at
  {
    private static final int CTRL_INDEX = 142;
    private static final String NAME = "onMapMarkerClick";
  }
  
  public static final class g
    extends at
  {
    private static final int CTRL_INDEX = 511;
    private static final String NAME = "onMapPoiClick";
  }
  
  public static final class h
    extends at
  {
    private static final int CTRL_INDEX = 147;
    private static final String NAME = "onMapRegionChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.t
 * JD-Core Version:    0.7.0.1
 */