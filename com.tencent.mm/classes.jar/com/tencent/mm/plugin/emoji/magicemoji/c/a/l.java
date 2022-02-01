package com.tencent.mm.plugin.emoji.magicemoji.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ae.z;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class l
  extends z<f>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "impact";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(270249);
    Log.i("MicroMsg.JsApiVibrateForMagicEmoji", "hy: request vibrate");
    super.a(paramf, paramJSONObject, paramInt);
    AppMethodBeat.o(270249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.c.a.l
 * JD-Core Version:    0.7.0.1
 */