package com.tencent.mm.d.a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.h;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

final class t$1
  implements h
{
  t$1(t paramt, l paraml) {}
  
  public final void s(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113891);
    ab.e("MicroMsg.V8EngineWorkerManager", "handleException(%s), stackTrace : %s", new Object[] { paramString1, paramString2 });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("message", paramString1);
      localJSONObject.put("stack", paramString2);
      this.ccy.a(String.format("WeixinWorker.errorHandler(%s)", new Object[] { localJSONObject }), null);
      AppMethodBeat.o(113891);
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        ab.e("MicroMsg.V8EngineWorkerManager", Log.getStackTraceString(paramString1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.d.a.t.1
 * JD-Core Version:    0.7.0.1
 */