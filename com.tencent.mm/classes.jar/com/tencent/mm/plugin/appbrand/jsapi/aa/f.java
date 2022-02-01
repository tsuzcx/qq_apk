package com.tencent.mm.plugin.appbrand.jsapi.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONObject;

public class f
  extends c<com.tencent.mm.plugin.appbrand.jsapi.f>
{
  private static final int CTRL_INDEX = 64;
  private static final String NAME = "reportIDKey";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(107802);
    paramJSONObject = paramJSONObject.optJSONArray("dataArray");
    if (paramJSONObject == null)
    {
      paramf.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(107802);
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i < paramJSONObject.length()) {
        try
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
          int j = localJSONObject.optInt("id");
          int k = localJSONObject.optInt("key");
          int m = localJSONObject.optInt("value");
          h.OAn.idkeyStat(j, k, m, false);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.JsApiReportIDKey", "parse json failed : %s", new Object[] { localException.getMessage() });
          }
        }
      }
    }
    paramf.callback(paramInt, ZP("ok"));
    AppMethodBeat.o(107802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.f
 * JD-Core Version:    0.7.0.1
 */