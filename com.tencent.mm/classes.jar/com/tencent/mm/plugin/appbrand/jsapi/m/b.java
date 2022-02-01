package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.b.a.a;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class b
  extends bc
  implements a.b
{
  private static final int CTRL_INDEX = 341;
  private static final String NAME = "onLocationChange";
  private final f rZU;
  
  b(f paramf)
  {
    this.rZU = paramf;
  }
  
  public final void a(int paramInt, String paramString, a.a parama)
  {
    AppMethodBeat.i(143626);
    if (paramInt != 0)
    {
      Log.e("MicroMsg.AppBrand.EventOnLocationChange", "errCode:%d, errStr:%s", new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(143626);
      return;
    }
    paramString = new HashMap(7);
    paramString.put("longitude", Double.valueOf(parama.longitude));
    paramString.put("latitude", Double.valueOf(parama.latitude));
    paramString.put("speed", Double.valueOf(parama.huN));
    paramString.put("accuracy", Double.valueOf(parama.usi));
    paramString.put("altitude", Double.valueOf(parama.altitude));
    paramString.put("verticalAccuracy", Float.valueOf(0.0F));
    paramString.put("horizontalAccuracy", Double.valueOf(parama.usi));
    if (!Util.isNullOrNil(parama.buildingId))
    {
      paramString.put("buildingId", parama.buildingId);
      paramString.put("floorName", parama.floorName);
    }
    paramString.put("provider", parama.provider);
    paramString.put("indoorLocationType", Integer.valueOf(parama.usj));
    paramString.put("direction", Float.valueOf(parama.usk));
    paramString.put("steps", Double.valueOf(parama.usl));
    paramString.put("type", parama.type);
    paramString = new JSONObject(paramString).toString();
    Log.v("MicroMsg.AppBrand.EventOnLocationChange", "onLocationChanged %s, %s, %s", new Object[] { this.rZU.getAppId(), parama.provider, paramString });
    try
    {
      i(this.rZU).ZR(paramString).cpV();
      return;
    }
    finally
    {
      AppMethodBeat.o(143626);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.b
 * JD-Core Version:    0.7.0.1
 */