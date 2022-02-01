package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.kn;
import com.tencent.mm.autogen.a.kn.b;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class af
  extends bw<GameWebPage>
{
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    AppMethodBeat.i(83084);
    Log.i("MicroMsg.JsApiOperateGameCenterMsg", "invokeInMM");
    try
    {
      paramContext = new JSONObject(paramString);
      if (paramContext == null)
      {
        Log.i("MicroMsg.JsApiOperateGameCenterMsg", "data is null");
        parama.j("invalid_data", null);
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
      paramContext = new kn();
      paramContext.hMg.bUl = i;
      paramContext.hMg.param = paramString.toString();
      paramContext.publish();
      paramString = new JSONObject();
    }
    try
    {
      paramString.put("result", Util.nullAsNil(paramContext.hMh.hMi));
      label124:
      parama.j(null, paramString);
      AppMethodBeat.o(83084);
      return;
    }
    catch (JSONException paramContext)
    {
      break label124;
    }
  }
  
  public final void b(b.a parama) {}
  
  public final int dgI()
  {
    return 1;
  }
  
  public final String name()
  {
    return "operateGameCenterMsg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.af
 * JD-Core Version:    0.7.0.1
 */