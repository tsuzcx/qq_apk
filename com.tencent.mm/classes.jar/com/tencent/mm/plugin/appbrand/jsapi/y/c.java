package com.tencent.mm.plugin.appbrand.jsapi.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.i.a;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

public final class c
  extends d
{
  public static final int CTRL_INDEX = 94;
  public static final String NAME = "enableCompass";
  
  public final void a(final f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137628);
    final l locall = new l("enableCompass");
    paramJSONObject = locall.a(paramf, paramJSONObject, new c.b(paramf)
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(137626);
        h.b(paramf.getAppId(), this);
        locall.a(this);
        AppMethodBeat.o(137626);
      }
    }, "JsApi#SensorMagneticField" + paramf.hashCode(), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1) })));
    paramf.i(paramInt, n(paramJSONObject.errMsg, paramJSONObject.values));
    AppMethodBeat.o(137628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.c
 * JD-Core Version:    0.7.0.1
 */