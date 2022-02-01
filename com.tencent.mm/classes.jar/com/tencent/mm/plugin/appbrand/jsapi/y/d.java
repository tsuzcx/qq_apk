package com.tencent.mm.plugin.appbrand.jsapi.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.i.a;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  public static final int CTRL_INDEX = 491;
  public static final String NAME = "enableDeviceMotionChangeListening";
  
  private static String z(f paramf)
  {
    AppMethodBeat.i(193695);
    paramf = "JsApi#SensorDeviceMotion" + paramf.hashCode();
    AppMethodBeat.o(193695);
    return paramf;
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137631);
    final l locall = new l("enableDeviceMotionChangeListening");
    d.b local1 = new d.b(paramf)
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(137629);
        h.b(paramf.getAppId(), this);
        locall.a(this);
        AppMethodBeat.o(137629);
      }
    };
    if (i.mqN.bIG())
    {
      paramJSONObject = locall.a(paramf, paramJSONObject, local1, z(paramf), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(11) })));
      paramf.i(paramInt, n(paramJSONObject.errMsg, paramJSONObject.values));
      AppMethodBeat.o(137631);
      return;
    }
    paramJSONObject = locall.a(paramf, paramJSONObject, local1, z(paramf), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(3) })));
    paramf.i(paramInt, n(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(137631);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.d
 * JD-Core Version:    0.7.0.1
 */