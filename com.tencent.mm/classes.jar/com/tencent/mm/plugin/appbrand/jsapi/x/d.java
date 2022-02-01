package com.tencent.mm.plugin.appbrand.jsapi.x;

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
    paramc = a.mPB.bBz();
    paramJSONObject = new HashMap();
    paramJSONObject.put("level", Integer.valueOf(paramc.mPM));
    paramJSONObject.put("isCharging", Boolean.valueOf(paramc.mPL));
    paramc = m("ok", paramJSONObject);
    AppMethodBeat.o(137659);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.d
 * JD-Core Version:    0.7.0.1
 */