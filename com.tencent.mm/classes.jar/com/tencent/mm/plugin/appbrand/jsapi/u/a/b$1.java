package com.tencent.mm.plugin.appbrand.jsapi.u.a;

import com.tencent.mm.plugin.appbrand.jsapi.u.a.b.c;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

final class b$1
  implements am.a
{
  b$1(b paramb) {}
  
  public final boolean tC()
  {
    if (this.gHz.gHr != null)
    {
      b localb = this.gHz;
      int i = this.gHz.gHr.getCurrentPosition();
      int j = this.gHz.gHr.getDuration();
      try
      {
        if (Math.abs(i - localb.gHx) < 250) {
          return true;
        }
        localb.gHx = i;
        double d1 = j * 1.0D / 1000.0D;
        double d2 = new BigDecimal(i * 1.0D / 1000.0D).setScale(3, 4).doubleValue();
        JSONObject localJSONObject = localb.akU();
        localJSONObject.put("position", d2);
        localJSONObject.put("duration", d1);
        localb.a(new b.g((byte)0), localJSONObject);
        return true;
      }
      catch (JSONException localJSONException)
      {
        y.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoTimeUpdate fail", new Object[] { localJSONException });
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.b.1
 * JD-Core Version:    0.7.0.1
 */