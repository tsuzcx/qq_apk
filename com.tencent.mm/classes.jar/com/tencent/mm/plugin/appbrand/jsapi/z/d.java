package com.tencent.mm.plugin.appbrand.jsapi.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.a.a;
import com.tencent.mm.plugin.appbrand.utils.a.c;
import java.util.HashMap;
import org.json.JSONObject;

public final class d
  extends ab
{
  public static final int CTRL_INDEX = 425;
  public static final String NAME = "getBatteryInfo";
  
  public final String a(f paramf, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137659);
    paramf = a.ohL.bZx();
    paramJSONObject = new HashMap();
    paramJSONObject.put("level", Integer.valueOf(paramf.ohW));
    paramJSONObject.put("isCharging", Boolean.valueOf(paramf.ohV));
    paramf = n("ok", paramJSONObject);
    AppMethodBeat.o(137659);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.d
 * JD-Core Version:    0.7.0.1
 */