package com.tencent.mm.plugin.appbrand.jsapi.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.i.a;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

public final class b
  extends a
{
  public static final int CTRL_INDEX = 92;
  public static final String NAME = "enableAccelerometer";
  
  public final void a(final c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137625);
    final l locall = new l("enableAccelerometer");
    paramJSONObject = locall.a(paramc, paramJSONObject, new b.b(paramc)
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(137623);
        g.b(paramc.getAppId(), this);
        locall.a(this);
        AppMethodBeat.o(137623);
      }
    }, "JsApi#SensorAccelerometer" + paramc.hashCode(), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1) })));
    paramc.h(paramInt, m(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(137625);
  }
  
  public static final class a
    extends at
  {
    private static final int CTRL_INDEX = 93;
    private static final String NAME = "onAccelerometerChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.b
 * JD-Core Version:    0.7.0.1
 */