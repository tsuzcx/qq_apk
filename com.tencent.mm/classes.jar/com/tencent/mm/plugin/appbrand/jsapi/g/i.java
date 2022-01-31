package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i
  extends c
{
  public static final int CTRL_INDEX = 136;
  public static final String NAME = "includeMapPoints";
  
  protected final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiIncludeMapPoints", "data is null");
      return false;
    }
    parame = f.o(parame.getAppId(), parame.ahJ(), p(paramJSONObject));
    if (parame == null)
    {
      y.e("MicroMsg.JsApiIncludeMapPoints", "mapView is null, return");
      return false;
    }
    y.i("MicroMsg.JsApiIncludeMapPoints", "includeMapPoints, onUpdateView()");
    try
    {
      if (paramJSONObject.has("points"))
      {
        paramView = new ArrayList();
        Object localObject = paramJSONObject.optString("points");
        if (!bk.bl((String)localObject))
        {
          localObject = new JSONArray((String)localObject);
          paramInt = 0;
          while (paramInt < ((JSONArray)localObject).length())
          {
            JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(paramInt);
            float f1 = bk.getFloat(localJSONObject.optString("latitude"), 0.0F);
            float f2 = bk.getFloat(localJSONObject.optString("longitude"), 0.0F);
            paramView.add(new i.1(this, f1, f2));
            paramInt += 1;
          }
        }
        paramInt = 0;
        paramJSONObject = paramJSONObject.optString("padding");
        if (!bk.bl(paramJSONObject)) {
          paramInt = h.a(new JSONArray(paramJSONObject), 0);
        }
        if (paramView.size() > 0) {
          parame.e(paramView, paramInt);
        }
      }
      return true;
    }
    catch (Exception parame)
    {
      y.e("MicroMsg.JsApiIncludeMapPoints", "parse points error, exception : %s", new Object[] { parame });
    }
    return false;
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
      y.e("MicroMsg.JsApiIncludeMapPoints", "get mapId error, exception : %s", new Object[] { paramJSONObject });
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.i
 * JD-Core Version:    0.7.0.1
 */