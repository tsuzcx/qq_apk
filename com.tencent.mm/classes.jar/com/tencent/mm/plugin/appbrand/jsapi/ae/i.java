package com.tencent.mm.plugin.appbrand.jsapi.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.a.a;
import com.tencent.mm.plugin.appbrand.utils.a.c;
import java.util.HashMap;
import org.json.JSONObject;

public final class i
  extends ab
{
  public static final int CTRL_INDEX = 425;
  public static final String NAME = "getBatteryInfo";
  
  public final String a(f paramf, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137659);
    paramf = a.urT.cNI();
    paramJSONObject = new HashMap();
    paramJSONObject.put("level", Integer.valueOf(paramf.usf));
    paramJSONObject.put("isCharging", Boolean.valueOf(paramf.use));
    paramf = m("ok", paramJSONObject);
    AppMethodBeat.o(137659);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.i
 * JD-Core Version:    0.7.0.1
 */