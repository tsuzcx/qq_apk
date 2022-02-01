package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class z
  extends br<com.tencent.mm.plugin.game.luggage.f.g>
{
  public final void a(Context paramContext, String paramString, bq.a parama)
  {
    AppMethodBeat.i(83086);
    paramContext = com.tencent.mm.plugin.webview.luggage.c.b.Pe(paramString);
    if (paramContext == null) {
      paramContext = ((d)com.tencent.mm.kernel.g.ab(d.class)).b(null, true);
    }
    for (;;)
    {
      paramString = new JSONObject();
      try
      {
        paramString.put("data", paramContext);
        label46:
        parama.f(null, paramString);
        AppMethodBeat.o(83086);
        return;
        paramContext = paramContext.optJSONArray("postIdList");
        if ((paramContext == null) || (paramContext.length() == 0))
        {
          paramContext = ((d)com.tencent.mm.kernel.g.ab(d.class)).b(null, true);
          continue;
        }
        paramContext = ((d)com.tencent.mm.kernel.g.ab(d.class)).b(paramContext, false);
      }
      catch (JSONException paramContext)
      {
        break label46;
      }
    }
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.game.luggage.f.g>.a paramb) {}
  
  public final int ccO()
  {
    return 1;
  }
  
  public final String name()
  {
    return "queryHaowanPublish";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.z
 * JD-Core Version:    0.7.0.1
 */