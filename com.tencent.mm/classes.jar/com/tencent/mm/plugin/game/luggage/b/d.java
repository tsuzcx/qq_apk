package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.c;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bi;
import org.json.JSONArray;
import org.json.JSONObject;

public class d
  extends bi<f>
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(154139);
    paramContext = b.BJ(paramString);
    if (paramContext == null)
    {
      parama.c("empty_postId", null);
      AppMethodBeat.o(154139);
      return;
    }
    if (paramContext.optBoolean("cancelAll")) {
      ((c)g.E(c.class)).c(null, true);
    }
    for (;;)
    {
      parama.c(null, null);
      AppMethodBeat.o(154139);
      return;
      paramContext = paramContext.optJSONArray("postIdList");
      if ((paramContext == null) || (paramContext.length() == 0))
      {
        parama.c("empty_postId", null);
        AppMethodBeat.o(154139);
        return;
      }
      ((c)g.E(c.class)).c(paramContext, false);
    }
  }
  
  public final void b(a<f>.a parama) {}
  
  public final int bjL()
  {
    return 1;
  }
  
  public final String name()
  {
    return "cancelHaowanPublish";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.d
 * JD-Core Version:    0.7.0.1
 */