package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.z.b.b.a;
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
  
  public final void a(com.tencent.mm.z.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(10829);
    parama = parama.getContext();
    paramJSONObject = new HashMap();
    if (!at.isConnected(parama)) {
      paramJSONObject.put("networkType", "none");
    }
    for (;;)
    {
      parama1.aj(a(true, "", paramJSONObject));
      AppMethodBeat.o(10829);
      return;
      if (at.is2G(parama)) {
        paramJSONObject.put("networkType", "2g");
      } else if (at.is3G(parama)) {
        paramJSONObject.put("networkType", "3g");
      } else if (at.is4G(parama)) {
        paramJSONObject.put("networkType", "4g");
      } else if (at.isWifi(parama)) {
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