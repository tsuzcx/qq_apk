package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.g.a.hz.b;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONException;
import org.json.JSONObject;

public class u
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama)
  {
    AppMethodBeat.i(83084);
    ac.i("MicroMsg.JsApiOperateGameCenterMsg", "invokeInMM");
    try
    {
      paramContext = new JSONObject(paramString);
      if (paramContext == null)
      {
        ac.i("MicroMsg.JsApiOperateGameCenterMsg", "data is null");
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
      paramContext = new hz();
      paramContext.dja.CW = i;
      paramContext.dja.param = paramString.toString();
      a.GpY.l(paramContext);
      paramString = new JSONObject();
    }
    try
    {
      paramString.put("result", bs.nullAsNil(paramContext.djb.djc));
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
  
  public final int bYk()
  {
    return 1;
  }
  
  public final String name()
  {
    return "operateGameCenterMsg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.u
 * JD-Core Version:    0.7.0.1
 */