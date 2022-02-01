package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b$f
{
  public final String qWb;
  public final String[] qWc;
  
  public b$f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(323428);
    if (paramJSONObject != null)
    {
      this.qWb = paramJSONObject.optString("default", "webview");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("allUsed");
      int i;
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        this.qWc = new String[localJSONArray.length()];
        i = 0;
      }
      while (i < localJSONArray.length())
      {
        this.qWc[i] = localJSONArray.optString(i, this.qWb);
        i += 1;
        continue;
        this.qWc = new String[0];
      }
      Log.i("MicroMsg.AppBrandAppConfig", "renderBackend is %s, default is %s", new Object[] { paramJSONObject, this.qWb });
      AppMethodBeat.o(323428);
      return;
    }
    Log.i("MicroMsg.AppBrandAppConfig", "renderBackend is null");
    this.qWb = "webview";
    this.qWc = new String[0];
    AppMethodBeat.o(323428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.b.f
 * JD-Core Version:    0.7.0.1
 */