package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.utils.b.a.a;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class b
  extends at
  implements a.b
{
  private static final int CTRL_INDEX = 341;
  private static final String NAME = "onLocationChange";
  private final c kOq;
  
  b(c paramc)
  {
    this.kOq = paramc;
  }
  
  public final void a(int paramInt, String paramString, a.a parama)
  {
    AppMethodBeat.i(143626);
    if (paramInt == -1)
    {
      ad.e("MicroMsg.AppBrand.EventOnLocationChange", "errCode:%d, errStr:%s", new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(143626);
      return;
    }
    paramString = new HashMap(7);
    paramString.put("longitude", Double.valueOf(parama.longitude));
    paramString.put("latitude", Double.valueOf(parama.latitude));
    paramString.put("speed", Double.valueOf(parama.dfE));
    paramString.put("accuracy", Double.valueOf(parama.mPP));
    paramString.put("altitude", Double.valueOf(parama.altitude));
    paramString.put("verticalAccuracy", Float.valueOf(0.0F));
    paramString.put("horizontalAccuracy", Double.valueOf(parama.mPP));
    if (!bt.isNullOrNil(parama.buildingId))
    {
      paramString.put("buildingId", parama.buildingId);
      paramString.put("floorName", parama.floorName);
    }
    paramString.put("provider", parama.provider);
    paramString.put("indoorLocationType", Integer.valueOf(parama.mPQ));
    paramString.put("direction", Float.valueOf(parama.mPR));
    paramString.put("steps", Double.valueOf(parama.mPS));
    paramString = new JSONObject(paramString).toString();
    ad.v("MicroMsg.AppBrand.EventOnLocationChange", "onLocationChanged %s, %s, %s", new Object[] { this.kOq.getAppId(), parama.provider, paramString });
    try
    {
      h(this.kOq).Pi(paramString).bir();
      return;
    }
    finally
    {
      AppMethodBeat.o(143626);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.b
 * JD-Core Version:    0.7.0.1
 */