package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.h.a;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

public final class f
  extends a
{
  public static final int CTRL_INDEX = 488;
  public static final String NAME = "enableGyroscope";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(126384);
    l locall = new l();
    paramJSONObject = locall.a(paramc, paramJSONObject, new f.1(this, paramc, paramc, locall), "JsApi#SensorGyroscope" + paramc.hashCode(), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(4) })));
    paramc.h(paramInt, j(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(126384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.f
 * JD-Core Version:    0.7.0.1
 */