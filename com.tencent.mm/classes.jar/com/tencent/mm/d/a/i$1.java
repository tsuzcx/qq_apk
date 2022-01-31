package com.tencent.mm.d.a;

import android.util.Log;
import com.tencent.mm.plugin.appbrand.i.e;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

final class i$1
  implements e
{
  i$1(i parami, b paramb) {}
  
  public final void x(String paramString1, String paramString2)
  {
    y.e("MicroMsg.V8EngineWorkerManager", "handleException(%s), stackTrace : %s", new Object[] { paramString1, paramString2 });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("message", paramString1);
      localJSONObject.put("stack", paramString2);
      this.bzK.a(String.format("WeixinWorker.errorHandler(%s)", new Object[] { localJSONObject }), null);
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        y.e("MicroMsg.V8EngineWorkerManager", Log.getStackTraceString(paramString1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.d.a.i.1
 * JD-Core Version:    0.7.0.1
 */