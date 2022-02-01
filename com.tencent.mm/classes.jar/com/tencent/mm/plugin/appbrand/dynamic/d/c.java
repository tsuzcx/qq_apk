package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.b.b.a;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
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
  
  public final void a(com.tencent.mm.ac.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(121309);
    parama = parama.getContext();
    paramJSONObject = new HashMap();
    if (!NetStatusUtil.isConnected(parama)) {
      paramJSONObject.put("networkType", "none");
    }
    for (;;)
    {
      parama1.bt(a(true, "", paramJSONObject));
      AppMethodBeat.o(121309);
      return;
      if (NetStatusUtil.is2G(parama)) {
        paramJSONObject.put("networkType", "2g");
      } else if (NetStatusUtil.is3G(parama)) {
        paramJSONObject.put("networkType", "3g");
      } else if (NetStatusUtil.is4G(parama)) {
        paramJSONObject.put("networkType", "4g");
      } else if (NetStatusUtil.isWifi(parama)) {
        paramJSONObject.put("networkType", "wifi");
      } else {
        paramJSONObject.put("networkType", "unknown");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.c
 * JD-Core Version:    0.7.0.1
 */