package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.h.a;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

public final class d
  extends a
{
  public static final int CTRL_INDEX = 491;
  public static final String NAME = "enableDeviceMotionChangeListening";
  
  public final void a(final c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(126377);
    final l locall = new l();
    paramJSONObject = locall.a(paramc, paramJSONObject, new d.b(paramc)
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(126375);
        e.b(paramc.getAppId(), this);
        locall.a(this);
        AppMethodBeat.o(126375);
      }
    }, "JsApi#SensorDeviceMotion" + paramc.hashCode(), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(3) })));
    paramc.h(paramInt, j(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(126377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.d
 * JD-Core Version:    0.7.0.1
 */