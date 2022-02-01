package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hs;
import com.tencent.mm.g.a.hs.b;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public class s
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama)
  {
    AppMethodBeat.i(83084);
    ad.i("MicroMsg.JsApiOperateGameCenterMsg", "invokeInMM");
    try
    {
      paramContext = new JSONObject(paramString);
      if (paramContext == null)
      {
        ad.i("MicroMsg.JsApiOperateGameCenterMsg", "data is null");
        parama.f("invalid_data", null);
        AppMethodBeat.o(83084);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
      int i = paramContext.optInt("cmd");
      paramString = paramContext.optJSONObject("param");
      paramContext = new hs();
      paramContext.dls.BX = i;
      paramContext.dls.dln = paramString.toString();
      a.ESL.l(paramContext);
      paramString = new JSONObject();
    }
    try
    {
      paramString.put("result", bt.nullAsNil(paramContext.dlt.dlu));
      label127:
      parama.f(null, paramString);
      AppMethodBeat.o(83084);
      return;
    }
    catch (JSONException paramContext)
    {
      break label127;
    }
  }
  
  public final void b(a.a parama) {}
  
  public final int bQV()
  {
    return 1;
  }
  
  public final String name()
  {
    return "operateGameCenterMsg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.s
 * JD-Core Version:    0.7.0.1
 */