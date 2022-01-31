package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.v.b.a.a;
import com.tencent.mm.plugin.appbrand.v.b.a.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class b
  extends ac
  implements a.b
{
  private static final int CTRL_INDEX = 341;
  private static final String NAME = "onLocationChange";
  private final c grA;
  
  b(c paramc)
  {
    this.grA = paramc;
  }
  
  public final void a(int paramInt, String paramString, a.a parama)
  {
    if (paramInt == -1)
    {
      y.e("MicroMsg.AppBrand.EventOnLocationChange", "errCode:%d, errStr:%s", new Object[] { Integer.valueOf(paramInt), paramString });
      return;
    }
    paramString = new HashMap(7);
    paramString.put("longitude", Double.valueOf(parama.longitude));
    paramString.put("latitude", Double.valueOf(parama.latitude));
    paramString.put("speed", Double.valueOf(parama.hlU));
    paramString.put("accuracy", Double.valueOf(parama.hlV));
    paramString.put("altitude", Double.valueOf(parama.altitude));
    paramString.put("verticalAccuracy", Float.valueOf(0.0F));
    paramString.put("horizontalAccuracy", Double.valueOf(parama.hlV));
    paramString = new JSONObject(paramString).toString();
    y.v("MicroMsg.AppBrand.EventOnLocationChange", "onLocationChanged %s, %s, %s", new Object[] { this.grA.getAppId(), parama.bbx, paramString });
    try
    {
      e(this.grA).tM(paramString).dispatch();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.b
 * JD-Core Version:    0.7.0.1
 */