package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends a
{
  public static final int CTRL_INDEX = 39;
  public static final String NAME = "getNetworkType";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = new HashMap();
    if (!aq.isConnected(paramc.getContext())) {
      paramJSONObject.put("networkType", "none");
    }
    for (;;)
    {
      paramc.C(paramInt, h("ok", paramJSONObject));
      return;
      if (aq.is2G(paramc.getContext())) {
        paramJSONObject.put("networkType", "2g");
      } else if (aq.is3G(paramc.getContext())) {
        paramJSONObject.put("networkType", "3g");
      } else if (aq.is4G(paramc.getContext())) {
        paramJSONObject.put("networkType", "4g");
      } else if (aq.isWifi(paramc.getContext())) {
        paramJSONObject.put("networkType", "wifi");
      } else {
        paramJSONObject.put("networkType", "unknown");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.c
 * JD-Core Version:    0.7.0.1
 */