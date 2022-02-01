package com.tencent.mm.plugin.emoji.magicemoji.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.jsapi.f>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "kvReport";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(270280);
    Log.i("MicroMsg.Finder.JsApiKvReport", "kvReport");
    if (paramJSONObject == null)
    {
      paramf.callback(paramInt, "fail:data is null");
      AppMethodBeat.o(270280);
      return;
    }
    paramInt = paramJSONObject.optInt("logId");
    paramf = paramJSONObject.optString("logStr");
    if ((paramInt > 0) && (!Util.isNullOrNil(paramf)))
    {
      Log.i("MicroMsg.Finder.JsApiKvReport", "%s %s", new Object[] { Integer.valueOf(paramInt), paramf });
      com.tencent.mm.plugin.report.f.Ozc.kvStat(paramInt, paramf);
    }
    AppMethodBeat.o(270280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.c.a.c
 * JD-Core Version:    0.7.0.1
 */