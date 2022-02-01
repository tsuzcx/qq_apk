package com.tencent.mm.plugin.appbrand.jsapi.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.i.a;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

public final class f
  extends a
{
  public static final int CTRL_INDEX = 488;
  public static final String NAME = "enableGyroscope";
  
  public final void a(final c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137638);
    final l locall = new l("enableGyroscope");
    paramJSONObject = locall.a(paramc, paramJSONObject, new f.b(paramc)
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(137636);
        g.b(paramc.getAppId(), this);
        locall.a(this);
        AppMethodBeat.o(137636);
      }
    }, "JsApi#SensorGyroscope" + paramc.hashCode(), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(4) })));
    paramc.h(paramInt, m(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(137638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.f
 * JD-Core Version:    0.7.0.1
 */