package com.tencent.mm.plugin.lite.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.plugin.webview.jsapi.c;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.jsapi.p.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271560);
    Log.i("LiteAppBridgeWebViewJsApi", "invoke " + this.efV);
    if (paramJSONObject == null)
    {
      this.JZj.aJV("data is null");
      AppMethodBeat.o(271560);
      return;
    }
    Object localObject = d.fUb();
    paramJSONObject = paramJSONObject.toString();
    int i = (int)this.JZi.efY;
    ((d)localObject).JZV.put(Integer.valueOf(i), this.JZi);
    paramString = ((d)localObject).Kaj;
    localObject = new d.1((d)localObject);
    try
    {
      paramJSONObject = p.a.bq(this.efV, paramJSONObject, String.valueOf(this.JZi.efY));
      paramString.JZY = this.JZi.efW;
      paramString.JZX.a(paramJSONObject, (c)localObject);
      AppMethodBeat.o(271560);
      return;
    }
    catch (JSONException paramString)
    {
      this.JZi.i("params error", false);
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("LiteAppJsApiBridgeWebViewHandler", paramString, "", new Object[0]);
      AppMethodBeat.o(271560);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.b.b.a
 * JD-Core Version:    0.7.0.1
 */