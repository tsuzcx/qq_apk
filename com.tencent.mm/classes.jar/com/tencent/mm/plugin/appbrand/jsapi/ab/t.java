package com.tencent.mm.plugin.appbrand.jsapi.ab;

import android.content.Context;
import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class t
  extends c
{
  public static final int CTRL_INDEX = 231;
  public static final String NAME = "vibrateLong";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137689);
    Log.d("MicroMsg.JsApiVibrateLong", "JsApiVibrateLong!");
    if (parame.getAppState() != b.nKP)
    {
      parame.j(paramInt, h("fail:not allowed in background", null));
      AppMethodBeat.o(137689);
      return;
    }
    paramJSONObject = (Vibrator)parame.getContext().getSystemService("vibrator");
    if (paramJSONObject != null) {
      paramJSONObject.vibrate(400L);
    }
    parame.j(paramInt, h("ok", null));
    AppMethodBeat.o(137689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.t
 * JD-Core Version:    0.7.0.1
 */