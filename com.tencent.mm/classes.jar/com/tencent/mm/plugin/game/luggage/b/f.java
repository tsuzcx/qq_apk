package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.luggage.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.b.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONArray;
import org.json.JSONObject;

public class f
  extends bi<com.tencent.mm.plugin.game.luggage.d.f>
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(135869);
    ab.i("MicroMsg.JsApiClearGameData", "invokeInMM");
    paramContext = i.ci(paramString);
    if (paramContext == null)
    {
      ab.e("MicroMsg.JsApiClearGameData", "data is null");
      parama.c("null_data", null);
      AppMethodBeat.o(135869);
      return;
    }
    paramString = paramContext.optString("preVerifyAppId");
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.JsApiClearGameData", "appId is null");
      parama.c("appid_null", null);
      AppMethodBeat.o(135869);
      return;
    }
    JSONArray localJSONArray = paramContext.optJSONArray("keys");
    boolean bool = paramContext.optBoolean("clearAllData", false);
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      b.dav().b(paramString, localJSONArray);
      parama.c(null, null);
      AppMethodBeat.o(135869);
      return;
    }
    if (bool)
    {
      b.dav().agI(paramString);
      parama.c(null, null);
      AppMethodBeat.o(135869);
      return;
    }
    ab.i("MicroMsg.JsApiClearGameData", "keys is null");
    parama.c("fail", null);
    AppMethodBeat.o(135869);
  }
  
  public final void b(a<com.tencent.mm.plugin.game.luggage.d.f>.a parama) {}
  
  public final int bjL()
  {
    return 1;
  }
  
  public final String name()
  {
    return "clearGameData";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.f
 * JD-Core Version:    0.7.0.1
 */