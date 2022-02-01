package com.tencent.mm.plugin.lite.jsapi.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends b
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(233532);
    Log.d("LiteAppJsApiOpenFinderView", "Invoke");
    if (paramJSONObject == null)
    {
      this.Ega.aNa("data is null");
      AppMethodBeat.o(233532);
      return;
    }
    paramString = new JSONObject();
    try
    {
      paramString.put("extInfo", new JSONObject(paramJSONObject.optString("extInfo")));
      ((ak)h.ag(ak.class)).enterFinderUI(MMApplicationContext.getContext(), paramString.toString());
      this.Ega.eLC();
      AppMethodBeat.o(233532);
      return;
    }
    catch (JSONException paramString)
    {
      this.Ega.aNa("fail");
      AppMethodBeat.o(233532);
    }
  }
  
  public final int ewF()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.a.c
 * JD-Core Version:    0.7.0.1
 */