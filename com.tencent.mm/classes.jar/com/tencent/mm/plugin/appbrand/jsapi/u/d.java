package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.appbrand.utils.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class d
  extends y
{
  public static final int CTRL_INDEX = 425;
  public static final String NAME = "getBatteryInfo";
  
  public final String a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137659);
    paramc = a.moW.bxu();
    paramJSONObject = new HashMap();
    paramJSONObject.put("level", Integer.valueOf(paramc.mph));
    paramJSONObject.put("isCharging", Boolean.valueOf(paramc.mpg));
    paramc = k("ok", paramJSONObject);
    AppMethodBeat.o(137659);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.d
 * JD-Core Version:    0.7.0.1
 */