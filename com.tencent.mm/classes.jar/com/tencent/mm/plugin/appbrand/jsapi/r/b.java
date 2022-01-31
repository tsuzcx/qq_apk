package com.tencent.mm.plugin.appbrand.jsapi.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.t.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class b
  extends u
{
  public static final int CTRL_INDEX = 425;
  public static final String NAME = "getBatteryInfo";
  
  public final String a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126405);
    paramc = a.iYk.aOb();
    paramJSONObject = new HashMap();
    paramJSONObject.put("level", Integer.valueOf(paramc.iYu));
    paramJSONObject.put("isCharging", Boolean.valueOf(paramc.iYt));
    paramc = j("ok", paramJSONObject);
    AppMethodBeat.o(126405);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.b
 * JD-Core Version:    0.7.0.1
 */