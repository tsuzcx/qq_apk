package com.tencent.mm.plugin.lite.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.k;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class c
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271547);
    Log.d("LiteAppJsApiPreloadMiniProgramEnv", "Invoke preloadMiniProgramEnv");
    if (paramJSONObject == null)
    {
      this.JZj.aJV("data is null");
      AppMethodBeat.o(271547);
      return;
    }
    paramString = paramJSONObject.optString("appId");
    if (Util.isNullOrNil(paramString))
    {
      this.JZj.aJV("fail: params error");
      AppMethodBeat.o(271547);
      return;
    }
    ((k)h.ax(k.class)).UV(paramString);
    this.JZj.fTW();
    AppMethodBeat.o(271547);
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.a.c
 * JD-Core Version:    0.7.0.1
 */