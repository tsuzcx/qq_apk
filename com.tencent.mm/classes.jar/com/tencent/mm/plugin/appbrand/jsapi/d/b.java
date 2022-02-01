package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.utils.b.a.a;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class b
  extends ar
  implements a.b
{
  private static final int CTRL_INDEX = 341;
  private static final String NAME = "onLocationChange";
  private final c ksU;
  
  b(c paramc)
  {
    this.ksU = paramc;
  }
  
  public final void a(int paramInt, String paramString, a.a parama)
  {
    AppMethodBeat.i(143626);
    if (paramInt == -1)
    {
      ac.e("MicroMsg.AppBrand.EventOnLocationChange", "errCode:%d, errStr:%s", new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(143626);
      return;
    }
    paramString = new HashMap(7);
    paramString.put("longitude", Double.valueOf(parama.longitude));
    paramString.put("latitude", Double.valueOf(parama.latitude));
    paramString.put("speed", Double.valueOf(parama.cUo));
    paramString.put("accuracy", Double.valueOf(parama.mpk));
    paramString.put("altitude", Double.valueOf(parama.altitude));
    paramString.put("verticalAccuracy", Float.valueOf(0.0F));
    paramString.put("horizontalAccuracy", Double.valueOf(parama.mpk));
    if (!bs.isNullOrNil(parama.buildingId))
    {
      paramString.put("buildingId", parama.buildingId);
      paramString.put("floorName", parama.floorName);
    }
    paramString.put("provider", parama.provider);
    paramString.put("indoorLocationType", Integer.valueOf(parama.mpl));
    paramString.put("direction", Float.valueOf(parama.mpm));
    paramString.put("steps", Double.valueOf(parama.mpn));
    paramString = new JSONObject(paramString).toString();
    ac.v("MicroMsg.AppBrand.EventOnLocationChange", "onLocationChanged %s, %s, %s", new Object[] { this.ksU.getAppId(), parama.provider, paramString });
    try
    {
      h(this.ksU).LO(paramString).beN();
      return;
    }
    finally
    {
      AppMethodBeat.o(143626);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.b
 * JD-Core Version:    0.7.0.1
 */