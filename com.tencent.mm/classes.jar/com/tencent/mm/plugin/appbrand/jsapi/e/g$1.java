package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.v.b.a.a;
import com.tencent.mm.plugin.appbrand.v.b.a.b;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class g$1
  implements a.b
{
  g$1(g paramg, c paramc, boolean paramBoolean, int paramInt) {}
  
  public final void a(int paramInt, String paramString, a.a parama)
  {
    y.i("MicroMsg.JsApiGetLocation", "errCode:%d, errStr:%s, location:%s", new Object[] { Integer.valueOf(paramInt), paramString, parama });
    this.grH.k(this.gpS);
    if (paramInt == 0)
    {
      paramString = new HashMap(4);
      paramString.put("latitude", Double.valueOf(parama.latitude));
      paramString.put("longitude", Double.valueOf(parama.longitude));
      paramString.put("speed", Double.valueOf(parama.hlU));
      paramString.put("accuracy", Double.valueOf(parama.hlV));
      if (this.grG) {
        paramString.put("altitude", Double.valueOf(parama.altitude));
      }
      if (b.cqk()) {
        paramString.put("provider", parama.bbx);
      }
      paramString.put("verticalAccuracy", Integer.valueOf(0));
      paramString.put("horizontalAccuracy", Double.valueOf(parama.hlV));
      this.gpS.C(this.dIS, this.grH.h("ok", paramString));
      return;
    }
    parama = new HashMap(1);
    parama.put("errCode", Integer.valueOf(paramInt));
    this.gpS.C(this.dIS, this.grH.h("fail:" + paramString, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.g.1
 * JD-Core Version:    0.7.0.1
 */