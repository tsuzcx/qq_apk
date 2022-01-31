package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.content.Context;
import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class n
  extends a
{
  public static final int CTRL_INDEX = 230;
  public static final String NAME = "vibrateShort";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(126435);
    ab.d("MicroMsg.JsApiVibrateShort", "JsApiVibrateShort services!");
    paramJSONObject = paramc.getContext();
    for (;;)
    {
      try
      {
        paramJSONObject = (Vibrator)paramJSONObject.getSystemService("vibrator");
        if (paramJSONObject != null) {
          continue;
        }
      }
      catch (Exception paramJSONObject)
      {
        ab.w("MicroMsg.JsApiVibrateShort", "vibrateShort exception %s", new Object[] { paramJSONObject.getMessage() });
        continue;
      }
      paramc.h(paramInt, j("ok", null));
      AppMethodBeat.o(126435);
      return;
      paramJSONObject.vibrate(15L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.n
 * JD-Core Version:    0.7.0.1
 */