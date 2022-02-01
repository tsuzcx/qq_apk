package com.tencent.mm.plugin.appbrand.jsapi.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.file.i.a;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

public final class c
  extends a
{
  public static final int CTRL_INDEX = 94;
  public static final String NAME = "enableCompass";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137628);
    final l locall = new l("enableCompass");
    paramJSONObject = locall.a(paramc, paramJSONObject, new c.b(paramc)
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(137626);
        g.b(paramc.getAppId(), this);
        locall.a(this);
        AppMethodBeat.o(137626);
      }
    }, "JsApi#SensorMagneticField" + paramc.hashCode(), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1) })));
    paramc.h(paramInt, m(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(137628);
  }
  
  public static final class a
    extends at
  {
    private static final int CTRL_INDEX = 95;
    private static final String NAME = "onCompassChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.c
 * JD-Core Version:    0.7.0.1
 */