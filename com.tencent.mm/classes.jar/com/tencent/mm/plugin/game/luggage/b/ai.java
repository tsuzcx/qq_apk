package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bw;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ai
  extends bw<GameWebPage>
{
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    AppMethodBeat.i(83086);
    paramContext = c.ZL(paramString);
    if (paramContext == null) {
      paramContext = ((d)h.ax(d.class)).b(null, true);
    }
    for (;;)
    {
      paramString = new JSONObject();
      try
      {
        paramString.put("data", paramContext);
        label46:
        parama.j(null, paramString);
        AppMethodBeat.o(83086);
        return;
        paramContext = paramContext.optJSONArray("postIdList");
        if ((paramContext == null) || (paramContext.length() == 0))
        {
          paramContext = ((d)h.ax(d.class)).b(null, true);
          continue;
        }
        paramContext = ((d)h.ax(d.class)).b(paramContext, false);
      }
      catch (JSONException paramContext)
      {
        break label46;
      }
    }
  }
  
  public final void b(b<GameWebPage>.a paramb) {}
  
  public final int dgI()
  {
    return 1;
  }
  
  public final String name()
  {
    return "queryHaowanPublish";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ai
 * JD-Core Version:    0.7.0.1
 */