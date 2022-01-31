package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class o
  extends a
{
  public static final int CTRL_INDEX = 2;
  public static final String NAME = "insertMap";
  
  public final View a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(93863);
    float f1 = bo.getFloat(paramJSONObject.optString("centerLatitude"), 0.0F);
    float f2 = bo.getFloat(paramJSONObject.optString("centerLongitude"), 0.0F);
    int i = paramJSONObject.optInt("scale", 16);
    int j = paramJSONObject.optInt("rotate", 0);
    int k = paramJSONObject.optInt("skew", 0);
    if ((Math.abs(f1) > 90.0F) || (Math.abs(f2) > 180.0F))
    {
      ab.d("MicroMsg.JsApiInsertMap", "centerLatitude or centerLongitude value is error!");
      AppMethodBeat.o(93863);
      return null;
    }
    com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oe(0);
    String str = parame.getAppId();
    ab.i("MicroMsg.JsApiInsertMap", "insertMap appId:%s viewId:%d data:%s", new Object[] { str, Integer.valueOf(w(paramJSONObject)), paramJSONObject });
    b localb = ((c)com.tencent.luggage.a.e.q(c.class)).b(parame, paramJSONObject);
    if (localb == null)
    {
      ab.e("MicroMsg.JsApiInsertMap", "mapView is null, return");
      AppMethodBeat.o(93863);
      return null;
    }
    if (!g.a(str, f.g(parame, paramJSONObject), localb))
    {
      ab.e("MicroMsg.JsApiInsertMap", "initMapView is false, return");
      com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oe(1);
      AppMethodBeat.o(93863);
      return null;
    }
    com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oe(2);
    localb.ej(paramJSONObject.optBoolean("enableZoom", true));
    localb.ek(paramJSONObject.optBoolean("enableScroll", true));
    localb.el(paramJSONObject.optBoolean("enableRotate", false));
    localb.em(paramJSONObject.optBoolean("showCompass", false));
    localb.en(paramJSONObject.optBoolean("enable3D", false));
    localb.eo(paramJSONObject.optBoolean("enableOverlooking", false));
    localb.ep(paramJSONObject.optBoolean("enableSatellite", false));
    localb.er(paramJSONObject.optBoolean("enableIndoor", true));
    localb.es(paramJSONObject.optBoolean("enableIndoorLevelPick", false));
    localb.et(paramJSONObject.optBoolean("showScale", true));
    localb.a(f1, f2, i, j, k);
    parame.a(new o.1(this, localb));
    parame.a(new o.2(this, localb));
    parame.a(new o.3(this, parame, str, paramJSONObject));
    localb.getView().setVisibility(0);
    parame = new CoverViewContainer(parame.getContext(), localb.getView());
    AppMethodBeat.o(93863);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(93865);
    paramView = g.cl(parame.getAppId(), f.g(parame, paramJSONObject));
    if (paramView == null)
    {
      ab.e("MicroMsg.JsApiInsertMap", "mapView is null, error, return");
      AppMethodBeat.o(93865);
      return;
    }
    paramView.a(new o.4(this, paramInt, parame));
    paramView.a(new o.5(this, paramInt, parame));
    paramView.a(new o.6(this, paramInt, parame));
    paramView.a(new o.7(this, paramInt, parame));
    paramView.eu(paramJSONObject.optBoolean("showLocation"));
    paramView.a(new o.8(this, paramInt, parame));
    paramView.a(new o.9(this, paramInt, parame));
    AppMethodBeat.o(93865);
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(93864);
    try
    {
      int i = paramJSONObject.optInt("mapId");
      AppMethodBeat.o(93864);
      return i;
    }
    catch (Exception paramJSONObject)
    {
      ab.e("MicroMsg.JsApiInsertMap", "get mapId error, exception : %s", new Object[] { paramJSONObject });
      AppMethodBeat.o(93864);
    }
    return -1;
  }
  
  public static final class e
    extends ai
  {
    private static final int CTRL_INDEX = 511;
    private static final String NAME = "onMapPoiClick";
  }
  
  public static final class f
    extends ai
  {
    private static final int CTRL_INDEX = 147;
    private static final String NAME = "onMapRegionChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.o
 * JD-Core Version:    0.7.0.1
 */