package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.utils.b.a.a;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class b
  extends at
  implements a.b
{
  private static final int CTRL_INDEX = 341;
  private static final String NAME = "onLocationChange";
  private final c kRS;
  
  b(c paramc)
  {
    this.kRS = paramc;
  }
  
  public final void a(int paramInt, String paramString, a.a parama)
  {
    AppMethodBeat.i(143626);
    if (paramInt == -1)
    {
      ae.e("MicroMsg.AppBrand.EventOnLocationChange", "errCode:%d, errStr:%s", new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(143626);
      return;
    }
    paramString = new HashMap(7);
    paramString.put("longitude", Double.valueOf(parama.longitude));
    paramString.put("latitude", Double.valueOf(parama.latitude));
    paramString.put("speed", Double.valueOf(parama.dgG));
    paramString.put("accuracy", Double.valueOf(parama.mUZ));
    paramString.put("altitude", Double.valueOf(parama.altitude));
    paramString.put("verticalAccuracy", Float.valueOf(0.0F));
    paramString.put("horizontalAccuracy", Double.valueOf(parama.mUZ));
    if (!bu.isNullOrNil(parama.buildingId))
    {
      paramString.put("buildingId", parama.buildingId);
      paramString.put("floorName", parama.floorName);
    }
    paramString.put("provider", parama.provider);
    paramString.put("indoorLocationType", Integer.valueOf(parama.mVa));
    paramString.put("direction", Float.valueOf(parama.mVb));
    paramString.put("steps", Double.valueOf(parama.mVc));
    paramString = new JSONObject(paramString).toString();
    ae.v("MicroMsg.AppBrand.EventOnLocationChange", "onLocationChanged %s, %s, %s", new Object[] { this.kRS.getAppId(), parama.provider, paramString });
    try
    {
      h(this.kRS).PQ(paramString).bja();
      return;
    }
    finally
    {
      AppMethodBeat.o(143626);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.b
 * JD-Core Version:    0.7.0.1
 */