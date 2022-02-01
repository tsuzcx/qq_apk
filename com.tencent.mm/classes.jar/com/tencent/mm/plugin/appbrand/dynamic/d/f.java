package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b.b.a;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.sdk.platformtools.ad;
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
  
  public final void a(com.tencent.mm.ab.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(121312);
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
            localLogInfo.hKv = localJSONObject.optLong("ts");
            localLogInfo.level = (localJSONObject.optInt("level") + 1);
            localLogInfo.message = localJSONObject.optString("msg");
            localArrayList.add(localLogInfo);
            ad.d("MicroMsg.JsApiFunc_Log", "ts : %s, level : %d, msg : %s", new Object[] { Util.getTimeFormat(localLogInfo.hKv), Integer.valueOf(localLogInfo.level), localLogInfo.message });
          }
        }
        else
        {
          com.tencent.mm.plugin.appbrand.dynamic.debugger.a.c(parama.ail().getString("__page_view_id", null), localArrayList);
          parama1.bk(a(true, "", null));
          AppMethodBeat.o(121312);
          return;
        }
      }
      catch (JSONException parama)
      {
        parama1.bk(a(false, "dataArray is null", null));
        AppMethodBeat.o(121312);
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