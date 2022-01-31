package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.file.h.a;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

public final class c
  extends a
{
  public static final int CTRL_INDEX = 94;
  public static final String NAME = "enableCompass";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(126374);
    l locall = new l();
    paramJSONObject = locall.a(paramc, paramJSONObject, new c.1(this, paramc, paramc, locall), "JsApi#SensorMagneticField" + paramc.hashCode(), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1) })));
    paramc.h(paramInt, j(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(126374);
  }
  
  public static final class a
    extends ai
  {
    private static final int CTRL_INDEX = 95;
    private static final String NAME = "onCompassChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.c
 * JD-Core Version:    0.7.0.1
 */