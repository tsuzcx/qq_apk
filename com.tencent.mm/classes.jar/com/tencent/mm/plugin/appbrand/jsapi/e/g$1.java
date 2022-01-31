package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.t.b.a.a;
import com.tencent.mm.plugin.appbrand.t.b.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

final class g$1
  implements a.b
{
  g$1(g paramg, c paramc, boolean paramBoolean, int paramInt) {}
  
  public final void a(int paramInt, String paramString, a.a parama)
  {
    AppMethodBeat.i(93824);
    ab.i("MicroMsg.JsApiGetLocation", "errCode:%d, errStr:%s, location:%s", new Object[] { Integer.valueOf(paramInt), paramString, parama });
    this.hNe.aDf();
    if (paramInt == 0)
    {
      paramString = new HashMap(4);
      paramString.put("latitude", Double.valueOf(parama.latitude));
      paramString.put("longitude", Double.valueOf(parama.longitude));
      paramString.put("speed", Double.valueOf(parama.iYv));
      paramString.put("accuracy", Double.valueOf(parama.iYw));
      if (this.hNd) {
        paramString.put("altitude", Double.valueOf(parama.altitude));
      }
      paramString.put("provider", parama.bsd);
      paramString.put("verticalAccuracy", Integer.valueOf(0));
      paramString.put("horizontalAccuracy", Double.valueOf(parama.iYw));
      if (!bo.isNullOrNil(parama.buildingId))
      {
        paramString.put("buildingId", parama.buildingId);
        paramString.put("floorName", parama.floorName);
      }
      paramString.put("indoorLocationType", Integer.valueOf(parama.iYx));
      paramString.put("direction", Float.valueOf(parama.direction));
      this.hKB.h(this.bAX, this.hNe.j("ok", paramString));
      AppMethodBeat.o(93824);
      return;
    }
    parama = new HashMap(1);
    parama.put("errCode", Integer.valueOf(paramInt));
    this.hKB.h(this.bAX, this.hNe.j("fail:".concat(String.valueOf(paramString)), parama));
    AppMethodBeat.o(93824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.g.1
 * JD-Core Version:    0.7.0.1
 */