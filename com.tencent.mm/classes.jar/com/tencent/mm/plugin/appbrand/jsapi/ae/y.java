package com.tencent.mm.plugin.appbrand.jsapi.ae;

import android.content.Context;
import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class y
  extends c
{
  public static final int CTRL_INDEX = 231;
  public static final String NAME = "vibrateLong";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137689);
    Log.d("MicroMsg.JsApiVibrateLong", "JsApiVibrateLong!");
    if (paramf.getAppState() != b.qKw)
    {
      paramf.callback(paramInt, ZP("fail:not allowed in background"));
      AppMethodBeat.o(137689);
      return;
    }
    paramJSONObject = (Vibrator)paramf.getContext().getSystemService("vibrator");
    if (paramJSONObject != null) {
      paramJSONObject.vibrate(400L);
    }
    paramf.callback(paramInt, ZP("ok"));
    AppMethodBeat.o(137689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.y
 * JD-Core Version:    0.7.0.1
 */