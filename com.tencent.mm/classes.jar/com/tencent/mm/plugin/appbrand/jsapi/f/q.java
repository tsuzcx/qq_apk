package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.k;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.l;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.n;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.o;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.q;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.r;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.s;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.u;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.v;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.x;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class q
  extends com.tencent.mm.plugin.appbrand.jsapi.base.a
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
      ac.e("MicroMsg.JsApiInsertMap", "get mapId error, exception : %s", new Object[] { paramJSONObject });
      AppMethodBeat.o(143684);
    }
    return -1;
  }
  
  public final View a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143683);
    float f1 = bs.getFloat(paramJSONObject.optString("centerLatitude"), 0.0F);
    float f2 = bs.getFloat(paramJSONObject.optString("centerLongitude"), 0.0F);
    float f3 = bs.getFloat(paramJSONObject.optString("scale"), 16.0F);
    int i = paramJSONObject.optInt("rotate", 0);
    int j = paramJSONObject.optInt("skew", 0);
    int k = bs.getInt(paramJSONObject.optString("maxScale"), 20);
    int m = bs.getInt(paramJSONObject.optString("minScale"), 3);
    if ((Math.abs(f1) > 90.0F) || (Math.abs(f2) > 180.0F))
    {
      ac.d("MicroMsg.JsApiInsertMap", "centerLatitude or centerLongitude value is error!");
      AppMethodBeat.o(143683);
      return null;
    }
    com.tencent.mm.plugin.appbrand.jsapi.f.a.e.sE(0);
    final String str = parame.getAppId();
    ac.i("MicroMsg.JsApiInsertMap", "insertMap appId:%s viewId:%d data:%s", new Object[] { str, Integer.valueOf(A(paramJSONObject)), paramJSONObject });
    final b localb = ((c)com.tencent.luggage.a.e.K(c.class)).b(parame, paramJSONObject);
    if (localb == null)
    {
      ac.e("MicroMsg.JsApiInsertMap", "mapView is null, return");
      AppMethodBeat.o(143683);
      return null;
    }
    if (!g.a(str, f.i(parame, paramJSONObject), localb))
    {
      ac.e("MicroMsg.JsApiInsertMap", "initMapView is false, return");
      com.tencent.mm.plugin.appbrand.jsapi.f.a.e.sE(1);
      AppMethodBeat.o(143683);
      return null;
    }
    com.tencent.mm.plugin.appbrand.jsapi.f.a.e.sE(2);
    localb.gu(paramJSONObject.optBoolean("enableZoom", true));
    localb.gv(paramJSONObject.optBoolean("enableScroll", true));
    localb.gw(paramJSONObject.optBoolean("enableRotate", false));
    localb.gx(paramJSONObject.optBoolean("showCompass", false));
    localb.gy(paramJSONObject.optBoolean("enable3D", false));
    localb.gz(paramJSONObject.optBoolean("enableOverlooking", false));
    localb.gA(paramJSONObject.optBoolean("enableSatellite", false));
    localb.gC(paramJSONObject.optBoolean("enableIndoor", true));
    localb.gD(paramJSONObject.optBoolean("enableIndoorLevelPick", false));
    localb.gE(paramJSONObject.optBoolean("showScale", true));
    localb.setMaxZoomLevel(k);
    localb.setMinZoomLevel(m);
    localb.a(f1, f2, f3, i, j);
    parame.a(new f.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(143671);
        ac.i("MicroMsg.JsApiInsertMap", "onBackground");
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
        ac.i("MicroMsg.JsApiInsertMap", "onForeground");
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
        ac.i("MicroMsg.JsApiInsertMap", "onDestroy");
        parame.b(this);
        g.dh(str, f.i(parame, paramJSONObject));
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
    paramView = g.dg(parame.getAppId(), f.i(parame, paramJSONObject));
    if (paramView == null)
    {
      ac.e("MicroMsg.JsApiInsertMap", "mapView is null, error, return");
      AppMethodBeat.o(143685);
      return;
    }
    paramView.a(new b.k()
    {
      public final void a(b.s paramAnonymouss)
      {
        AppMethodBeat.i(143675);
        q.b localb = new q.b();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("mapId", paramInt);
          localJSONObject.put("data", paramAnonymouss.data);
          localb.LO(localJSONObject.toString());
          parame.b(localb);
          AppMethodBeat.o(143675);
          return;
        }
        catch (JSONException paramAnonymouss)
        {
          for (;;)
          {
            ac.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { paramAnonymouss });
          }
        }
      }
    });
    paramView.a(new b.o()
    {
      public final boolean b(b.s paramAnonymouss)
      {
        AppMethodBeat.i(143676);
        q.f localf = new q.f();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("mapId", paramInt);
          localJSONObject.put("data", paramAnonymouss.data);
          localf.LO(localJSONObject.toString());
          parame.b(localf);
          AppMethodBeat.o(143676);
          return true;
        }
        catch (JSONException paramAnonymouss)
        {
          for (;;)
          {
            ac.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { paramAnonymouss });
          }
        }
      }
    });
    paramView.a(new b.l()
    {
      public final void e(double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(143677);
        q.c localc = new q.c();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("mapId", paramInt);
          localJSONObject.put("longitude", paramAnonymousDouble1);
          localJSONObject.put("latitude", paramAnonymousDouble2);
          localc.LO(localJSONObject.toString());
          parame.b(localc);
          AppMethodBeat.o(143677);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ac.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { localJSONException });
          }
        }
      }
    });
    paramView.a(new b.n()
    {
      public final boolean c(b.s paramAnonymouss)
      {
        AppMethodBeat.i(143678);
        q.e locale = new q.e();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("mapId", paramInt);
          localJSONObject.put("data", paramAnonymouss.data);
          locale.LO(localJSONObject.toString());
          parame.b(locale);
          AppMethodBeat.o(143678);
          return true;
        }
        catch (JSONException paramAnonymouss)
        {
          for (;;)
          {
            ac.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { paramAnonymouss });
          }
        }
      }
    });
    paramView.a(new b.x()
    {
      public final void a(b.r paramAnonymousr)
      {
        AppMethodBeat.i(143679);
        q.g localg = new q.g();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("mapId", paramInt);
          localJSONObject.put("latitude", paramAnonymousr.latitude);
          localJSONObject.put("longitude", paramAnonymousr.longitude);
          localJSONObject.put("name", paramAnonymousr.name);
          if (!bs.isNullOrNil(paramAnonymousr.buildingId))
          {
            localJSONObject.put("buildingId", paramAnonymousr.buildingId);
            localJSONObject.put("floorName", paramAnonymousr.floorName);
          }
          localg.LO(localJSONObject.toString());
          parame.b(localg);
          ac.v("MicroMsg.JsApiInsertMap", "OnMapPoiClick %s", new Object[] { localJSONObject.toString() });
          AppMethodBeat.o(143679);
          return;
        }
        catch (JSONException paramAnonymousr)
        {
          for (;;)
          {
            ac.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { paramAnonymousr });
          }
        }
      }
    });
    paramView.gF(paramJSONObject.optBoolean("showLocation"));
    paramView.a(new b.u()
    {
      JSONObject jsonObject;
      AtomicBoolean kud;
      float kue;
      q.h kuf;
      
      public final void a(b.a paramAnonymousa, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(143681);
        if (this.kud.compareAndSet(false, true)) {}
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
            ac.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { localJSONException });
            continue;
          }
          this.kuf.LO(this.jsonObject.toString());
          parame.b(this.kuf);
          this.kue = paramAnonymousa.zoom;
          ac.v("MicroMsg.JsApiInsertMap", "onCameraChange begin");
          AppMethodBeat.o(143681);
          return;
          this.jsonObject.put("causedBy", "update");
        }
      }
      
      public final void b(b.a paramAnonymousa, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(143682);
        if (this.kud.compareAndSet(true, false)) {}
        for (;;)
        {
          try
          {
            this.jsonObject.remove("mapId");
            this.jsonObject.put("mapId", paramInt);
            this.jsonObject.remove("type");
            this.jsonObject.put("type", "end");
            this.jsonObject.remove("causedBy");
            if (paramAnonymousa.zoom == this.kue) {
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
            ac.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { paramAnonymousa });
            continue;
            this.jsonObject.put("causedBy", "update");
            continue;
          }
          this.jsonObject.remove("rotate");
          this.jsonObject.put("rotate", paramAnonymousa.kvB);
          this.jsonObject.remove("skew");
          this.jsonObject.put("skew", paramAnonymousa.skew);
          this.jsonObject.remove("scale");
          this.jsonObject.put("scale", paramView.getZoom());
          a.a(paramView, this.jsonObject);
          a.b(paramView, this.jsonObject);
          this.kuf.LO(this.jsonObject.toString());
          parame.b(this.kuf);
          ac.v("MicroMsg.JsApiInsertMap", "onCameraChange finish, result:%s", new Object[] { this.jsonObject.toString() });
          AppMethodBeat.o(143682);
          return;
          i = 0;
          continue;
          this.jsonObject.put("causedBy", "drag");
        }
      }
    });
    paramView.a(new b.v()
    {
      public final void a(b.e paramAnonymouse)
      {
        AppMethodBeat.i(143672);
        q.d locald = new q.d();
        JSONObject localJSONObject1 = new JSONObject();
        JSONArray localJSONArray;
        try
        {
          localJSONObject1.put("mapId", paramInt);
          if (paramAnonymouse != null)
          {
            localJSONObject1.put("buildingId", paramAnonymouse.buildingId);
            localJSONObject1.put("buildingName", paramAnonymouse.buildingName);
            if ((paramAnonymouse.kvE != null) && (paramAnonymouse.kvE.size() > 0))
            {
              localJSONArray = new JSONArray();
              Iterator localIterator = paramAnonymouse.kvE.iterator();
              while (localIterator.hasNext())
              {
                b.f localf = (b.f)localIterator.next();
                JSONObject localJSONObject2 = new JSONObject();
                localJSONObject2.put("name", localf.floorName);
                localJSONArray.put(localJSONObject2);
              }
            }
          }
          else
          {
            locald.LO(localJSONObject1.toString());
          }
        }
        catch (JSONException paramAnonymouse)
        {
          ac.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { paramAnonymouse });
        }
        for (;;)
        {
          parame.b(locald);
          ac.v("MicroMsg.JsApiInsertMap", "OnMapIndoorStateChange:%s", new Object[] { localJSONObject1.toString() });
          AppMethodBeat.o(143672);
          return;
          localJSONObject1.put("floorList", localJSONArray);
          localJSONObject1.put("floorIndex", paramAnonymouse.kvF);
        }
      }
    });
    paramView.a(new b.q()
    {
      public final void d(double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(205022);
        q.a locala = new q.a();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("mapId", paramInt);
          localJSONObject.put("longitude", paramAnonymousDouble2);
          localJSONObject.put("latitude", paramAnonymousDouble1);
          locala.LO(localJSONObject.toString());
          parame.b(locala);
          ac.v("MicroMsg.JsApiInsertMap", "MapOnMapAnchorPointClick:%s", new Object[] { localJSONObject.toString() });
          AppMethodBeat.o(205022);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ac.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { localJSONException });
          }
        }
      }
    });
    AppMethodBeat.o(143685);
  }
  
  public static final class a
    extends ar
  {
    private static final int CTRL_INDEX = 832;
    private static final String NAME = "onMapAnchorPointClick";
  }
  
  public static final class b
    extends ar
  {
    private static final int CTRL_INDEX = 199;
    private static final String NAME = "onMapCalloutClick";
  }
  
  public static final class c
    extends ar
  {
    private static final int CTRL_INDEX = 151;
    private static final String NAME = "onMapClick";
  }
  
  public static final class d
    extends ar
  {
    private static final int CTRL_INDEX = 524;
    private static final String NAME = "onMapIndoorChange";
  }
  
  public static final class e
    extends ar
  {
    private static final int CTRL_INDEX = 679;
    private static final String NAME = "onMapLabelClick";
  }
  
  public static final class f
    extends ar
  {
    private static final int CTRL_INDEX = 142;
    private static final String NAME = "onMapMarkerClick";
  }
  
  public static final class g
    extends ar
  {
    private static final int CTRL_INDEX = 511;
    private static final String NAME = "onMapPoiClick";
  }
  
  public static final class h
    extends ar
  {
    private static final int CTRL_INDEX = 147;
    private static final String NAME = "onMapRegionChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.q
 * JD-Core Version:    0.7.0.1
 */