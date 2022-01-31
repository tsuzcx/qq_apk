package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class j
  extends a
{
  public static final int CTRL_INDEX = 2;
  public static final String NAME = "insertMap";
  
  protected final View a(e parame, JSONObject paramJSONObject)
  {
    float f1 = bk.getFloat(paramJSONObject.optString("centerLatitude"), 0.0F);
    float f2 = bk.getFloat(paramJSONObject.optString("centerLongitude"), 0.0F);
    int i = paramJSONObject.optInt("scale", 16);
    if ((Math.abs(f1) > 90.0F) || (Math.abs(f2) > 180.0F))
    {
      y.d("MicroMsg.JsApiInsertMap", "centerLatitude or centerLongitude value is error!");
      return null;
    }
    String str = parame.getAppId();
    int j = p(paramJSONObject);
    y.i("MicroMsg.JsApiInsertMap", "insertMap appId:%s viewId:%d data:%s", new Object[] { str, Integer.valueOf(j), paramJSONObject });
    final b localb = f.a(parame.getContext(), str, parame.ahJ(), j, paramJSONObject);
    if (localb == null)
    {
      y.e("MicroMsg.JsApiInsertMap", "mapView is null, return");
      return null;
    }
    localb.dg(paramJSONObject.optBoolean("enableZoom", true));
    localb.dh(paramJSONObject.optBoolean("enableScroll", true));
    localb.di(paramJSONObject.optBoolean("enableRotate", false));
    localb.dj(paramJSONObject.optBoolean("showCompass", false));
    localb.dk(paramJSONObject.optBoolean("enable3D", false));
    localb.dl(paramJSONObject.optBoolean("enableOverlooking", false));
    localb.dm(paramJSONObject.optBoolean("enableSatellite", false));
    localb.dn(paramJSONObject.optBoolean("enableTraffic", false));
    localb.c(f1, f2, i);
    parame.a(new e.b()
    {
      public final void qa()
      {
        y.i("MicroMsg.JsApiInsertMap", "onBackground");
        if (localb != null)
        {
          localb.onPause();
          localb.jdMethod_do(false);
        }
      }
    });
    parame.a(new j.2(this, localb, paramJSONObject));
    parame.a(new j.3(this, parame, str, j));
    localb.getView().setVisibility(0);
    return new CoverViewContainer(parame.getContext(), localb.getView());
  }
  
  protected final void a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    paramView = f.o(parame.getAppId(), parame.ahJ(), p(paramJSONObject));
    if (paramView == null)
    {
      y.e("MicroMsg.JsApiInsertMap", "mapView is null, error, return");
      return;
    }
    paramView.a(new j.4(this, paramInt, parame));
    paramView.a(new j.5(this, paramInt, parame));
    paramView.a(new j.6(this, paramInt, parame));
    paramView.a(new j.7(this, paramInt, parame));
    paramView.jdMethod_do(paramJSONObject.optBoolean("showLocation"));
    paramView.a(new j.8(this, paramInt, parame));
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("mapId");
      return i;
    }
    catch (Exception paramJSONObject)
    {
      y.e("MicroMsg.JsApiInsertMap", "get mapId error, exception : %s", new Object[] { paramJSONObject });
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.j
 * JD-Core Version:    0.7.0.1
 */