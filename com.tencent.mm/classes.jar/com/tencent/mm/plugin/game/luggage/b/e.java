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
import org.json.JSONObject;

public class e
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama)
  {
    AppMethodBeat.i(83054);
    paramContext = b.LK(paramString);
    if (paramContext == null)
    {
      parama.f("empty_postId", null);
      AppMethodBeat.o(83054);
      return;
    }
    if (paramContext.optBoolean("cancelAll")) {
      ((c)g.ab(c.class)).c(null, true);
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
      ((c)g.ab(c.class)).c(paramContext, false);
    }
  }
  
  public final void b(a<f>.a parama) {}
  
  public final int bYk()
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