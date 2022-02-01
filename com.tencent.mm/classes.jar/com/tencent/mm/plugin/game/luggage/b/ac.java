package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ac
  extends bs<i>
{
  public final void a(Context paramContext, String paramString, br.a parama)
  {
    AppMethodBeat.i(83086);
    paramContext = com.tencent.mm.plugin.webview.luggage.c.b.Zc(paramString);
    if (paramContext == null) {
      paramContext = ((d)g.af(d.class)).b(null, true);
    }
    for (;;)
    {
      paramString = new JSONObject();
      try
      {
        paramString.put("data", paramContext);
        label46:
        parama.i(null, paramString);
        AppMethodBeat.o(83086);
        return;
        paramContext = paramContext.optJSONArray("postIdList");
        if ((paramContext == null) || (paramContext.length() == 0))
        {
          paramContext = ((d)g.af(d.class)).b(null, true);
          continue;
        }
        paramContext = ((d)g.af(d.class)).b(paramContext, false);
      }
      catch (JSONException paramContext)
      {
        break label46;
      }
    }
  }
  
  public final void b(com.tencent.luggage.d.b<i>.a paramb) {}
  
  public final int dTs()
  {
    return 1;
  }
  
  public final String name()
  {
    return "queryHaowanPublish";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ac
 * JD-Core Version:    0.7.0.1
 */