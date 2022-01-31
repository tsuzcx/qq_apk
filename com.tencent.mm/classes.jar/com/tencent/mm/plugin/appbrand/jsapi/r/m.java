package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.content.Context;
import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class m
  extends a
{
  public static final int CTRL_INDEX = 231;
  public static final String NAME = "vibrateLong";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(126434);
    ab.d("MicroMsg.JsApiVibrateLong", "JsApiVibrateLong!");
    paramJSONObject = (Vibrator)paramc.getContext().getSystemService("vibrator");
    if (paramJSONObject != null) {
      paramJSONObject.vibrate(400L);
    }
    paramc.h(paramInt, j("ok", null));
    AppMethodBeat.o(126434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.m
 * JD-Core Version:    0.7.0.1
 */