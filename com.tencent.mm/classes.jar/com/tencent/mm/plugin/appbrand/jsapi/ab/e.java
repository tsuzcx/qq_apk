package com.tencent.mm.plugin.appbrand.jsapi.ab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.utils.a.a;
import com.tencent.mm.plugin.appbrand.utils.a.c;
import java.util.HashMap;
import org.json.JSONObject;

public final class e
  extends aa
{
  public static final int CTRL_INDEX = 425;
  public static final String NAME = "getBatteryInfo";
  
  public final String a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137659);
    parame = a.rjz.cmn();
    paramJSONObject = new HashMap();
    paramJSONObject.put("level", Integer.valueOf(parame.rjL));
    paramJSONObject.put("isCharging", Boolean.valueOf(parame.rjK));
    parame = m("ok", paramJSONObject);
    AppMethodBeat.o(137659);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.e
 * JD-Core Version:    0.7.0.1
 */