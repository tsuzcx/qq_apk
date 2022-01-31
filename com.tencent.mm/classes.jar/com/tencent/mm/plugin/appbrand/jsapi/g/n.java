package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.widget.d.a;
import com.tencent.mm.plugin.appbrand.widget.d.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class n
  extends a
{
  public static final int CTRL_INDEX = 200;
  public static final String NAME = "translateMapMarker";
  private a.a gtu;
  
  protected final boolean a(e parame, JSONObject paramJSONObject, a.a parama, g paramg)
  {
    this.gtu = parama;
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiTranslateMapMarker", "data is null");
      return false;
    }
    y.d("MicroMsg.JsApiTranslateMapMarker", "onUpdateView, data:%s", new Object[] { paramJSONObject.toString() });
    parame = f.o(parame.getAppId(), parame.ahJ(), p(paramJSONObject));
    if (parame == null)
    {
      y.e("MicroMsg.JsApiTranslateMapMarker", "mapView is null, return");
      return false;
    }
    parama = paramJSONObject.optString("markerId");
    for (;;)
    {
      LinkedList localLinkedList;
      int i;
      try
      {
        paramJSONObject = new JSONArray(paramJSONObject.optString("keyFrames"));
        localLinkedList = new LinkedList();
        y.d("MicroMsg.JsApiTranslateMapMarker", "keyFramesArray size :%d", new Object[] { Integer.valueOf(paramJSONObject.length()) });
        i = 0;
        if (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = (JSONObject)paramJSONObject.get(i);
          b.e locale = new b.e();
          locale.duration = localJSONObject.optInt("duration", 0);
          if (locale.duration == 0)
          {
            y.e("MicroMsg.JsApiTranslateMapMarker", "keyFrame.duration is zero, err continue");
          }
          else
          {
            locale.rotate = ((float)localJSONObject.optDouble("rotate", 0.0D));
            locale.latitude = bk.getFloat(localJSONObject.optString("latitude"), 0.0F);
            locale.longitude = bk.getFloat(localJSONObject.optString("longitude"), 0.0F);
            localLinkedList.add(locale);
          }
        }
      }
      catch (JSONException parame)
      {
        y.e("MicroMsg.JsApiTranslateMapMarker", "parse keyFrames error, exception : %s", new Object[] { parame });
        paramg.tT(h("fail", null));
        return false;
      }
      parame.a(parama, localLinkedList, new n.1(this, paramg));
      return true;
      i += 1;
    }
  }
  
  protected final boolean aik()
  {
    return true;
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
      y.e("MicroMsg.JsApiTranslateMapMarker", "get mapId error, exception : %s", new Object[] { paramJSONObject });
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.n
 * JD-Core Version:    0.7.0.1
 */