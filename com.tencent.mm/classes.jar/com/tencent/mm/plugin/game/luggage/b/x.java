package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.g.a.ih.b;
import com.tencent.mm.plugin.game.luggage.f.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONException;
import org.json.JSONObject;

public class x
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama)
  {
    AppMethodBeat.i(83084);
    ae.i("MicroMsg.JsApiOperateGameCenterMsg", "invokeInMM");
    try
    {
      paramContext = new JSONObject(paramString);
      if (paramContext == null)
      {
        ae.i("MicroMsg.JsApiOperateGameCenterMsg", "data is null");
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
      paramContext = new ih();
      paramContext.dvR.EN = i;
      paramContext.dvR.param = paramString.toString();
      a.IvT.l(paramContext);
      paramString = new JSONObject();
    }
    try
    {
      paramString.put("result", bu.nullAsNil(paramContext.dvS.dvT));
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
  
  public final void b(b.a parama) {}
  
  public final int ced()
  {
    return 1;
  }
  
  public final String name()
  {
    return "operateGameCenterMsg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.x
 * JD-Core Version:    0.7.0.1
 */