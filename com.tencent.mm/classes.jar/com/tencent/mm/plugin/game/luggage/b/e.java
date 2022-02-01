package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import org.json.JSONArray;
import org.json.JSONObject;

public class e
  extends br<com.tencent.mm.plugin.game.luggage.f.g>
{
  public final void a(Context paramContext, String paramString, bq.a parama)
  {
    AppMethodBeat.i(83054);
    paramContext = com.tencent.mm.plugin.webview.luggage.c.b.PM(paramString);
    if (paramContext == null)
    {
      parama.f("empty_postId", null);
      AppMethodBeat.o(83054);
      return;
    }
    if (paramContext.optBoolean("cancelAll")) {
      ((d)com.tencent.mm.kernel.g.ab(d.class)).c(null, true);
    }
    for (;;)
    {
      parama.f(null, null);
      AppMethodBeat.o(83054);
      return;
      paramContext = paramContext.optJSONArray("postIdList");
      if ((paramContext == null) || (paramContext.length() == 0))
      {
        parama.f("empty_postId", null);
        AppMethodBeat.o(83054);
        return;
      }
      ((d)com.tencent.mm.kernel.g.ab(d.class)).c(paramContext, false);
    }
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.game.luggage.f.g>.a paramb) {}
  
  public final int ced()
  {
    return 1;
  }
  
  public final String name()
  {
    return "cancelHaowanPublish";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.e
 * JD-Core Version:    0.7.0.1
 */