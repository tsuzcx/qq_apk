package com.tencent.mm.plugin.appbrand.jsapi.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.d<f>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "kvReport";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(163955);
    Log.i("MicroMsg.Finder.JsApiKvReport", "kvReport");
    if (paramJSONObject == null)
    {
      paramf.i(paramInt, "fail:data is null");
      AppMethodBeat.o(163955);
      return;
    }
    paramInt = paramJSONObject.optInt("logId");
    paramf = paramJSONObject.optString("logStr");
    if ((paramInt > 0) && (!Util.isNullOrNil(paramf)))
    {
      Log.i("MicroMsg.Finder.JsApiKvReport", "%s %s", new Object[] { Integer.valueOf(paramInt), paramf });
      e.Cxv.kvStat(paramInt, paramf);
    }
    AppMethodBeat.o(163955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.d
 * JD-Core Version:    0.7.0.1
 */