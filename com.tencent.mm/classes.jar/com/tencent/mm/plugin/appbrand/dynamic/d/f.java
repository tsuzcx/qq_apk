package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.z.b.b.a;
import com.tencent.recovery.util.Util;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public f(int paramInt)
  {
    super("log", paramInt);
  }
  
  public final void a(com.tencent.mm.z.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(10832);
    for (;;)
    {
      int i;
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("dataArray");
        ArrayList localArrayList = new ArrayList(paramJSONObject.length());
        i = 0;
        if (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
          if (localJSONObject != null)
          {
            LogInfo localLogInfo = new LogInfo();
            localLogInfo.ts = localJSONObject.optLong("ts");
            localLogInfo.level = (localJSONObject.optInt("level") + 1);
            localLogInfo.message = localJSONObject.optString("msg");
            localArrayList.add(localLogInfo);
            ab.d("MicroMsg.JsApiFunc_Log", "ts : %s, level : %d, msg : %s", new Object[] { Util.oW(localLogInfo.ts), Integer.valueOf(localLogInfo.level), localLogInfo.message });
          }
        }
        else
        {
          com.tencent.mm.plugin.appbrand.dynamic.debugger.a.c(parama.Qx().getString("__page_view_id", null), localArrayList);
          parama1.aj(a(true, "", null));
          AppMethodBeat.o(10832);
          return;
        }
      }
      catch (JSONException parama)
      {
        parama1.aj(a(false, "dataArray is null", null));
        AppMethodBeat.o(10832);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.f
 * JD-Core Version:    0.7.0.1
 */