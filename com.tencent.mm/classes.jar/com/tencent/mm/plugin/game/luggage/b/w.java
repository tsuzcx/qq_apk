package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;

public class w
  extends br<i>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(final b<i>.a paramb)
  {
    AppMethodBeat.i(83081);
    Log.i("MicroMsg.JsApiOpenGameRegion", "invoke");
    final MMActivity localMMActivity = (MMActivity)((i)paramb.cta).mContext;
    localMMActivity.mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(83080);
        if (paramAnonymousInt1 == (w.this.hashCode() & 0xFFFF))
        {
          if (paramAnonymousInt2 != -1) {
            break label96;
          }
          if (paramAnonymousIntent == null) {
            break label83;
          }
          paramAnonymousIntent = Util.nullAs(paramAnonymousIntent.getStringExtra("gameRegionName"), "");
          HashMap localHashMap = new HashMap();
          localHashMap.put("gameRegionName", paramAnonymousIntent);
          paramb.e("", localHashMap);
        }
        for (;;)
        {
          localMMActivity.mmSetOnActivityResultCallback(null);
          AppMethodBeat.o(83080);
          return;
          label83:
          paramb.c("fail", null);
          continue;
          label96:
          if (paramAnonymousInt2 == 1) {
            paramb.c("fail", null);
          } else {
            paramb.c("cancel", null);
          }
        }
      }
    });
    c.a(localMMActivity, "game", ".ui.GameRegionSelectUI", null, hashCode() & 0xFFFF, false);
    AppMethodBeat.o(83081);
  }
  
  public final int dTs()
  {
    return 0;
  }
  
  public final String name()
  {
    return "openGameRegion";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.w
 * JD-Core Version:    0.7.0.1
 */