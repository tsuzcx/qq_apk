package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;
import org.json.JSONObject;

public class f
  extends a
{
  private static final int CTRL_INDEX = 64;
  private static final String NAME = "reportIDKey";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(73182);
    paramJSONObject = paramJSONObject.optJSONArray("dataArray");
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, j("fail", null));
      AppMethodBeat.o(73182);
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
          h.qsU.idkeyStat(j, k, m, false);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.e("MicroMsg.JsApiReportIDKey", "parse json failed : %s", new Object[] { localException.getMessage() });
          }
        }
      }
    }
    paramc.h(paramInt, j("ok", null));
    AppMethodBeat.o(73182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.f
 * JD-Core Version:    0.7.0.1
 */