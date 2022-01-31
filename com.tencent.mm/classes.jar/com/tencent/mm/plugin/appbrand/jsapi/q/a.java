package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.mm.plugin.appbrand.jsapi.s;
import java.util.HashMap;
import org.json.JSONObject;

public final class a
  extends s
{
  public static final int CTRL_INDEX = 425;
  public static final String NAME = "getBatteryInfo";
  
  public final String a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject)
  {
    paramc = com.tencent.mm.plugin.appbrand.v.a.a.hlJ.aqx();
    paramJSONObject = new HashMap();
    paramJSONObject.put("level", Integer.valueOf(paramc.hlT));
    paramJSONObject.put("isCharging", Boolean.valueOf(paramc.hlS));
    return h("ok", paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.a
 * JD-Core Version:    0.7.0.1
 */