package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.g.a.gy.b;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bi;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public class r
  extends bi<f>
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(135884);
    ab.i("MicroMsg.JsApiOperateGameCenterMsg", "invokeInMM");
    paramContext = i.ci(paramString);
    if (paramContext == null)
    {
      ab.i("MicroMsg.JsApiOperateGameCenterMsg", "data is null");
      parama.c("invalid_data", null);
      AppMethodBeat.o(135884);
      return;
    }
    int i = paramContext.optInt("cmd");
    paramString = paramContext.optJSONObject("param");
    paramContext = new gy();
    paramContext.cvT.vA = i;
    paramContext.cvT.cvO = paramString.toString();
    a.ymk.l(paramContext);
    paramString = new JSONObject();
    try
    {
      paramString.put("result", bo.nullAsNil(paramContext.cvU.cvV));
      label117:
      parama.c(null, paramString);
      AppMethodBeat.o(135884);
      return;
    }
    catch (JSONException paramContext)
    {
      break label117;
    }
  }
  
  public final void b(a.a parama) {}
  
  public final int bjL()
  {
    return 1;
  }
  
  public final String name()
  {
    return "operateGameCenterMsg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.r
 * JD-Core Version:    0.7.0.1
 */