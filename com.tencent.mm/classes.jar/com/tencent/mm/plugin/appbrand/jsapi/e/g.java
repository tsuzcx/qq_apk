package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.os.Bundle;
import com.tencent.luggage.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class g<CONTEXT extends c>
  extends a<CONTEXT>
{
  public static final int CTRL_INDEX = 37;
  public static final String NAME = "getLocation";
  
  public final void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    String str = paramJSONObject.optString("type", "wgs84");
    if (bk.bl(str)) {
      str = "wgs84";
    }
    for (;;)
    {
      boolean bool = paramJSONObject.optBoolean("altitude", false);
      y.v("MicroMsg.JsApiGetLocation", "doGeoLocation, geoType = %s, needAltitude = %b", new Object[] { str, Boolean.valueOf(bool) });
      if ((!"wgs84".equals(str)) && (!"gcj02".equals(str)))
      {
        y.e("MicroMsg.JsApiGetLocation", "doGeoLocation fail, unsupported type = %s", new Object[] { str });
        paramJSONObject = new HashMap(1);
        paramJSONObject.put("errCode", Integer.valueOf(-1));
        paramCONTEXT.C(paramInt, h("fail:invalid data", paramJSONObject));
        return;
      }
      if (!i(paramCONTEXT))
      {
        paramJSONObject = new HashMap(1);
        paramJSONObject.put("errCode", Integer.valueOf(-2));
        paramCONTEXT.C(paramInt, h("fail:system permission denied", paramJSONObject));
        return;
      }
      j(paramCONTEXT);
      paramJSONObject = d(paramCONTEXT, paramJSONObject);
      ((com.tencent.mm.plugin.appbrand.v.b.a)e.i(com.tencent.mm.plugin.appbrand.v.b.a.class)).c(str, new g.1(this, paramCONTEXT, bool, paramInt), paramJSONObject);
      return;
    }
  }
  
  protected Bundle d(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    return null;
  }
  
  protected void j(CONTEXT paramCONTEXT) {}
  
  protected void k(CONTEXT paramCONTEXT) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.g
 * JD-Core Version:    0.7.0.1
 */