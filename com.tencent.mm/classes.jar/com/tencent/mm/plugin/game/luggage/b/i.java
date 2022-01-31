package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.b.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public class i
  extends bi<f>
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(135872);
    ab.i("MicroMsg.JsApiGetGameData", "invokeInMM");
    paramString = com.tencent.luggage.g.i.ci(paramString);
    if (paramString == null)
    {
      ab.e("MicroMsg.JsApiGetGameData", "data is null");
      parama.c("null_data", null);
      AppMethodBeat.o(135872);
      return;
    }
    paramContext = paramString.optString("preVerifyAppId");
    if (bo.isNullOrNil(paramContext))
    {
      ab.i("MicroMsg.JsApiGetGameData", "appId is null");
      parama.c("appid_null", null);
      AppMethodBeat.o(135872);
      return;
    }
    paramString = paramString.optString("key");
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.JsApiGetGameData", "key is null");
      parama.c("null_key", null);
      AppMethodBeat.o(135872);
      return;
    }
    paramString = b.dav().hk(paramContext, paramString);
    if (!bo.isNullOrNil(paramString.field_value)) {
      paramContext = new JSONObject();
    }
    try
    {
      paramContext.put("value", paramString.field_value);
      paramContext.put("weight", paramString.field_weight);
      paramContext.put("expireTime", paramString.field_expireTime - System.currentTimeMillis() / 1000L);
      label177:
      parama.c(null, paramContext);
      AppMethodBeat.o(135872);
      return;
      parama.c(null, null);
      AppMethodBeat.o(135872);
      return;
    }
    catch (JSONException paramString)
    {
      break label177;
    }
  }
  
  public final void b(com.tencent.luggage.d.a<f>.a parama) {}
  
  public final int bjL()
  {
    return 1;
  }
  
  public final String name()
  {
    return "getGameData";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.i
 * JD-Core Version:    0.7.0.1
 */