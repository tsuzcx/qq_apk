package com.tencent.mm.plugin.appbrand.jsapi.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class d
  extends c<e>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "kvReport";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(163955);
    Log.i("MicroMsg.Finder.JsApiKvReport", "kvReport");
    if (paramJSONObject == null)
    {
      parame.j(paramInt, "fail:data is null");
      AppMethodBeat.o(163955);
      return;
    }
    paramInt = paramJSONObject.optInt("logId");
    parame = paramJSONObject.optString("logStr");
    if ((paramInt > 0) && (!Util.isNullOrNil(parame)))
    {
      Log.i("MicroMsg.Finder.JsApiKvReport", "%s %s", new Object[] { Integer.valueOf(paramInt), parame });
      f.Iyx.kvStat(paramInt, parame);
    }
    AppMethodBeat.o(163955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.d
 * JD-Core Version:    0.7.0.1
 */