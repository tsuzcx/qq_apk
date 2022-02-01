package com.tencent.mm.plugin.appbrand.jsapi.x;

import android.content.Context;
import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class p
  extends a
{
  public static final int CTRL_INDEX = 231;
  public static final String NAME = "vibrateLong";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137689);
    ae.d("MicroMsg.JsApiVibrateLong", "JsApiVibrateLong!");
    paramJSONObject = (Vibrator)paramc.getContext().getSystemService("vibrator");
    if (paramJSONObject != null) {
      paramJSONObject.vibrate(400L);
    }
    paramc.h(paramInt, e("ok", null));
    AppMethodBeat.o(137689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.p
 * JD-Core Version:    0.7.0.1
 */