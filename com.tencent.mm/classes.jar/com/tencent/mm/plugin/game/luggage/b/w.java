package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.c;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class w
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama)
  {
    AppMethodBeat.i(83086);
    paramContext = b.LK(paramString);
    if (paramContext == null) {
      paramContext = ((c)g.ab(c.class)).b(null, true);
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
          paramContext = ((c)g.ab(c.class)).b(null, true);
          continue;
        }
        paramContext = ((c)g.ab(c.class)).b(paramContext, false);
      }
      catch (JSONException paramContext)
      {
        break label46;
      }
    }
  }
  
  public final void b(a<f>.a parama) {}
  
  public final int bYk()
  {
    return 1;
  }
  
  public final String name()
  {
    return "queryHaowanPublish";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.w
 * JD-Core Version:    0.7.0.1
 */