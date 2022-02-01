package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import org.json.JSONArray;
import org.json.JSONObject;

public class e
  extends bs<i>
{
  public final void a(Context paramContext, String paramString, br.a parama)
  {
    AppMethodBeat.i(83054);
    paramContext = c.agO(paramString);
    if (paramContext == null)
    {
      parama.i("empty_postId", null);
      AppMethodBeat.o(83054);
      return;
    }
    if (paramContext.optBoolean("cancelAll")) {
      ((d)h.ae(d.class)).c(null, true);
    }
    for (;;)
    {
      parama.i(null, null);
      AppMethodBeat.o(83054);
      return;
      paramContext = paramContext.optJSONArray("postIdList");
      if ((paramContext == null) || (paramContext.length() == 0))
      {
        parama.i("empty_postId", null);
        AppMethodBeat.o(83054);
        return;
      }
      ((d)h.ae(d.class)).c(paramContext, false);
    }
  }
  
  public final void b(b<i>.a paramb) {}
  
  public final int cDj()
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