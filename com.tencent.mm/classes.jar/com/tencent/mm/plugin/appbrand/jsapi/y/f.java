package com.tencent.mm.plugin.appbrand.jsapi.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.file.i.a;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

public final class f
  extends d
{
  public static final int CTRL_INDEX = 488;
  public static final String NAME = "enableGyroscope";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137638);
    final l locall = new l("enableGyroscope");
    paramJSONObject = locall.a(paramf, paramJSONObject, new f.b(paramf)
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(137636);
        h.b(paramf.getAppId(), this);
        locall.a(this);
        AppMethodBeat.o(137636);
      }
    }, "JsApi#SensorGyroscope" + paramf.hashCode(), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(4) })));
    paramf.i(paramInt, n(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(137638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.f
 * JD-Core Version:    0.7.0.1
 */