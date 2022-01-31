package com.tencent.mm.plugin.appbrand.jsapi.v.c;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.v.c.a.b.1;
import com.tencent.mm.plugin.appbrand.jsapi.v.c.a.b.2;
import com.tencent.mm.plugin.appbrand.jsapi.v.c.a.b.3;
import com.tencent.mm.plugin.appbrand.jsapi.v.c.a.b.4;
import com.tencent.mm.plugin.appbrand.jsapi.v.c.a.b.5;
import com.tencent.mm.plugin.appbrand.jsapi.v.c.a.b.6;
import com.tencent.mm.plugin.appbrand.jsapi.v.c.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class a$2
  implements Runnable
{
  a$2(a parama, m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(155137);
    a locala;
    Object localObject3;
    Object localObject4;
    m localm;
    int i;
    int j;
    if ((this.hwN instanceof com.tencent.mm.plugin.appbrand.jsapi.v.c.a.b))
    {
      ab.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "Tummy insert");
      com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oe(9);
      locala = this.iiH;
      localObject3 = this.hza;
      localObject4 = this.bBa;
      localm = this.hwN;
      i = this.bAX;
      locala.bDN = ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject3);
      com.tencent.mm.plugin.appbrand.jsapi.v.c.a.b localb = (com.tencent.mm.plugin.appbrand.jsapi.v.c.a.b)localm;
      ??? = locala.mSurfaceTexture;
      ab.i("MicroMsg.JsApiInsertXWebMap", "insertXwebMap:%s", new Object[] { localObject4 });
      float f1 = bo.getFloat(((JSONObject)localObject4).optString("centerLatitude"), 0.0F);
      float f2 = bo.getFloat(((JSONObject)localObject4).optString("centerLongitude"), 0.0F);
      j = ((JSONObject)localObject4).optInt("scale", 16);
      int k = ((JSONObject)localObject4).optInt("rotate", 0);
      int m = ((JSONObject)localObject4).optInt("skew", 0);
      if ((Math.abs(f1) > 90.0F) || (Math.abs(f2) > 180.0F))
      {
        ab.d("MicroMsg.JsApiInsertXWebMap", "centerLatitude or centerLongitude value is error!");
        ??? = null;
      }
      for (;;)
      {
        locala.iiF = ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)???);
        ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject3).h(i, localm.j("ok", null));
        com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oe(10);
        if ((localObject3 instanceof com.tencent.mm.plugin.appbrand.jsapi.e))
        {
          ??? = (com.tencent.mm.plugin.appbrand.jsapi.e)localObject3;
          ((com.tencent.mm.plugin.appbrand.jsapi.e)???).a(new a.3(locala));
          ((com.tencent.mm.plugin.appbrand.jsapi.e)???).a(new a.4(locala));
          ((com.tencent.mm.plugin.appbrand.jsapi.e)???).a(new a.5(locala, (com.tencent.mm.plugin.appbrand.jsapi.e)???, (com.tencent.mm.plugin.appbrand.jsapi.c)localObject3, (JSONObject)localObject4));
        }
        AppMethodBeat.o(155137);
        return;
        String str1 = ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject3).getAppId();
        String str2 = ((JSONObject)localObject4).optString("theme", "");
        String str3 = ((JSONObject)localObject4).optString("subKey", "");
        String str4 = ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject3).getAppId();
        int n = ((JSONObject)localObject4).optInt("styleId", 0);
        Object localObject5 = ((JSONObject)localObject4).optJSONObject("position");
        if (localObject5 == null)
        {
          ab.e("MicroMsg.JsApiInsertXWebMap", "positionObj is null, err, return");
          ??? = null;
        }
        else
        {
          int i1 = com.tencent.mm.plugin.appbrand.s.g.a((JSONObject)localObject5, "width", 0);
          int i2 = com.tencent.mm.plugin.appbrand.s.g.a((JSONObject)localObject5, "height", 0);
          localObject5 = f.g((com.tencent.mm.plugin.appbrand.jsapi.c)localObject3, (JSONObject)localObject4);
          HashMap localHashMap = new HashMap(5);
          localHashMap.put("theme", str2);
          localHashMap.put("subKey", str3);
          localHashMap.put("subId", str4);
          localHashMap.put("styleId", Integer.valueOf(n));
          localHashMap.put("surface", ???);
          localHashMap.put("width", Integer.valueOf(i1));
          localHashMap.put("height", Integer.valueOf(i2));
          localHashMap.put("mapType", Integer.valueOf(2));
          ??? = ((com.tencent.mm.plugin.appbrand.jsapi.g.a.c)com.tencent.luggage.a.e.q(com.tencent.mm.plugin.appbrand.jsapi.g.a.c.class)).a(((com.tencent.mm.plugin.appbrand.jsapi.c)localObject3).getContext(), (String)localObject5, localHashMap);
          if (??? == null)
          {
            ab.e("MicroMsg.JsApiInsertXWebMap", "mapView is null, return");
            ??? = null;
          }
          else if (!com.tencent.mm.plugin.appbrand.jsapi.g.a.g.a(str1, f.g((com.tencent.mm.plugin.appbrand.jsapi.c)localObject3, (JSONObject)localObject4), (com.tencent.mm.plugin.appbrand.jsapi.g.a.b)???))
          {
            ab.e("MicroMsg.JsApiInsertXWebMap", "initMapView is false, return");
            ??? = null;
          }
          else
          {
            ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)???).ej(((JSONObject)localObject4).optBoolean("enableZoom", true));
            ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)???).ek(((JSONObject)localObject4).optBoolean("enableScroll", true));
            ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)???).el(((JSONObject)localObject4).optBoolean("enableRotate", false));
            ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)???).em(((JSONObject)localObject4).optBoolean("showCompass", false));
            ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)???).en(((JSONObject)localObject4).optBoolean("enable3D", false));
            ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)???).eo(((JSONObject)localObject4).optBoolean("enableOverlooking", false));
            ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)???).ep(((JSONObject)localObject4).optBoolean("enableSatellite", false));
            ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)???).er(((JSONObject)localObject4).optBoolean("enableIndoor", true));
            ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)???).es(((JSONObject)localObject4).optBoolean("enableIndoorLevelPick", false));
            ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)???).et(((JSONObject)localObject4).optBoolean("showScale", true));
            ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)???).a(f1, f2, j, k, m);
            ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)???).getView().setVisibility(0);
            if (??? == null)
            {
              ab.e("MicroMsg.JsApiInsertXWebMap", "mapView is null, error, return");
              ??? = null;
            }
            else
            {
              j = f.G((JSONObject)localObject4);
              ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)???).a(new b.1(localb, j, (com.tencent.mm.plugin.appbrand.jsapi.c)localObject3));
              ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)???).a(new b.2(localb, j, (com.tencent.mm.plugin.appbrand.jsapi.c)localObject3));
              ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)???).a(new b.3(localb, j, (com.tencent.mm.plugin.appbrand.jsapi.c)localObject3));
              ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)???).a(new b.4(localb, j, (com.tencent.mm.plugin.appbrand.jsapi.c)localObject3));
              ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)???).eu(((JSONObject)localObject4).optBoolean("showLocation"));
              ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)???).a(new b.5(localb, j, (com.tencent.mm.plugin.appbrand.jsapi.c)localObject3));
              ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)???).a(new b.6(localb, j, (com.tencent.mm.plugin.appbrand.jsapi.c)localObject3));
            }
          }
        }
      }
    }
    if ((this.hwN instanceof d))
    {
      ab.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "Tummy update");
      com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oe(12);
      locala = this.iiH;
      localObject3 = this.hza;
      localObject4 = this.bBa;
      localm = this.hwN;
      i = this.bAX;
      synchronized (locala.iiG)
      {
        if ((locala.iiF != null) && (d.h((com.tencent.mm.plugin.appbrand.jsapi.c)localObject3, (JSONObject)localObject4)))
        {
          ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject3).h(i, localm.j("ok", null));
          com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oe(13);
          AppMethodBeat.o(155137);
          return;
        }
        ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "update fail");
        com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oe(14);
        ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject3).h(i, localm.j("fail:internal error", null));
      }
    }
    if ((this.hwN instanceof com.tencent.mm.plugin.appbrand.jsapi.v.c.a.c))
    {
      com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oe(15);
      ??? = this.iiH;
      com.tencent.mm.plugin.appbrand.jsapi.c localc = this.hza;
      localObject3 = this.bBa;
      localObject4 = this.hwN;
      j = this.bAX;
      if (localObject3 == null) {
        ab.e("MicroMsg.JsApiRemoveXWebMap", "data is null");
      }
      for (i = 0; i != 0; i = 1)
      {
        localc.h(j, ((m)localObject4).j("ok", null));
        ((a)???).iiF = null;
        com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oe(16);
        AppMethodBeat.o(155137);
        return;
        ab.i("MicroMsg.JsApiRemoveXWebMap", "removeXWebMap:%s", new Object[] { localObject3 });
        com.tencent.mm.plugin.appbrand.jsapi.g.a.g.cm(localc.getAppId(), f.g(localc, (JSONObject)localObject3));
      }
      ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "remove fail");
      com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oe(17);
      localc.h(j, ((m)localObject4).j("fail:internal error", null));
    }
    AppMethodBeat.o(155137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.c.a.2
 * JD-Core Version:    0.7.0.1
 */