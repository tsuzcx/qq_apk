package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.luggage.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.b.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class w
  extends bi<f>
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(135888);
    ab.i("MicroMsg.JsApiSetGameData", "invokeInMM");
    paramContext = i.ci(paramString);
    if (paramContext == null)
    {
      ab.e("MicroMsg.JsApiSetGameData", "data is null");
      parama.c("null_data", null);
      AppMethodBeat.o(135888);
      return;
    }
    paramString = paramContext.optString("preVerifyAppId");
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.JsApiSetGameData", "appId is null");
      parama.c("appid_null", null);
      AppMethodBeat.o(135888);
      return;
    }
    String str1 = paramContext.optString("key");
    String str2 = paramContext.optString("value");
    String str3 = paramContext.optString("weight", "1");
    String str4 = paramContext.optString("expireTime");
    boolean bool = paramContext.optBoolean("autoClean", true);
    if ((bo.isNullOrNil(str1)) || (bo.isNullOrNil(str2)))
    {
      ab.i("MicroMsg.JsApiSetGameData", "key or value is null");
      parama.c("null_key", null);
      AppMethodBeat.o(135888);
      return;
    }
    if (b.dav().a(paramString, str1, str2, str3, str4, bool))
    {
      parama.c(null, null);
      AppMethodBeat.o(135888);
      return;
    }
    parama.c("exceed_size", null);
    AppMethodBeat.o(135888);
  }
  
  public final void b(a<f>.a parama) {}
  
  public final int bjL()
  {
    return 1;
  }
  
  public final String name()
  {
    return "setGameData";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.w
 * JD-Core Version:    0.7.0.1
 */