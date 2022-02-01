package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.iw;
import com.tencent.mm.g.a.iw.b;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class aa
  extends bs<i>
{
  public final void a(Context paramContext, String paramString, br.a parama)
  {
    AppMethodBeat.i(83084);
    Log.i("MicroMsg.JsApiOperateGameCenterMsg", "invokeInMM");
    try
    {
      paramContext = new JSONObject(paramString);
      if (paramContext == null)
      {
        Log.i("MicroMsg.JsApiOperateGameCenterMsg", "data is null");
        parama.i("invalid_data", null);
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
      paramContext = new iw();
      paramContext.dNy.EX = i;
      paramContext.dNy.param = paramString.toString();
      EventCenter.instance.publish(paramContext);
      paramString = new JSONObject();
    }
    try
    {
      paramString.put("result", Util.nullAsNil(paramContext.dNz.dNA));
      label127:
      parama.i(null, paramString);
      AppMethodBeat.o(83084);
      return;
    }
    catch (JSONException paramContext)
    {
      break label127;
    }
  }
  
  public final void b(b.a parama) {}
  
  public final int dTs()
  {
    return 1;
  }
  
  public final String name()
  {
    return "operateGameCenterMsg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.aa
 * JD-Core Version:    0.7.0.1
 */