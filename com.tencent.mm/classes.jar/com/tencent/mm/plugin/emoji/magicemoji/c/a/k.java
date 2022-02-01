package com.tencent.mm.plugin.emoji.magicemoji.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class k
  extends c<f>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "systemLog";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(270239);
    String str = paramJSONObject.optString("level");
    paramJSONObject = paramJSONObject.optString("content");
    if ((!Util.isNullOrNil(str)) && (!Util.isNullOrNil(paramJSONObject)))
    {
      if (!"info".equalsIgnoreCase(str)) {
        break label70;
      }
      Log.i("MicroMsg.JsApiSystemLogME", paramJSONObject);
    }
    for (;;)
    {
      paramf.callback(paramInt, ZP("ok"));
      AppMethodBeat.o(270239);
      return;
      label70:
      if ("warn".equalsIgnoreCase(str)) {
        Log.w("MicroMsg.JsApiSystemLogME", paramJSONObject);
      } else {
        Log.e("MicroMsg.JsApiSystemLogME", paramJSONObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.c.a.k
 * JD-Core Version:    0.7.0.1
 */