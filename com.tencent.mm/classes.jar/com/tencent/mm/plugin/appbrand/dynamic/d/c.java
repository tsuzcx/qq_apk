package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.sdk.platformtools.ax;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public c(int paramInt)
  {
    super("getNetworkType", paramInt);
  }
  
  public final void a(com.tencent.mm.aa.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(121309);
    parama = parama.getContext();
    paramJSONObject = new HashMap();
    if (!ax.isConnected(parama)) {
      paramJSONObject.put("networkType", "none");
    }
    for (;;)
    {
      parama1.bi(a(true, "", paramJSONObject));
      AppMethodBeat.o(121309);
      return;
      if (ax.is2G(parama)) {
        paramJSONObject.put("networkType", "2g");
      } else if (ax.is3G(parama)) {
        paramJSONObject.put("networkType", "3g");
      } else if (ax.is4G(parama)) {
        paramJSONObject.put("networkType", "4g");
      } else if (ax.isWifi(parama)) {
        paramJSONObject.put("networkType", "wifi");
      } else {
        paramJSONObject.put("networkType", "unknown");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.c
 * JD-Core Version:    0.7.0.1
 */