package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;

public class r
  extends bn<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(final a<f>.a parama)
  {
    AppMethodBeat.i(83081);
    ac.i("MicroMsg.JsApiOpenGameRegion", "invoke");
    final MMActivity localMMActivity = (MMActivity)((f)parama.bWR).mContext;
    localMMActivity.mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(83080);
        if (paramAnonymousInt1 == (r.this.hashCode() & 0xFFFF))
        {
          if (paramAnonymousInt2 != -1) {
            break label96;
          }
          if (paramAnonymousIntent == null) {
            break label83;
          }
          paramAnonymousIntent = bs.bG(paramAnonymousIntent.getStringExtra("gameRegionName"), "");
          HashMap localHashMap = new HashMap();
          localHashMap.put("gameRegionName", paramAnonymousIntent);
          parama.c("", localHashMap);
        }
        for (;;)
        {
          localMMActivity.mmSetOnActivityResultCallback(null);
          AppMethodBeat.o(83080);
          return;
          label83:
          parama.a("fail", null);
          continue;
          label96:
          if (paramAnonymousInt2 == 1) {
            parama.a("fail", null);
          } else {
            parama.a("cancel", null);
          }
        }
      }
    });
    d.a(localMMActivity, "game", ".ui.GameRegionSelectUI", null, hashCode() & 0xFFFF, false);
    AppMethodBeat.o(83081);
  }
  
  public final int bYk()
  {
    return 0;
  }
  
  public final String name()
  {
    return "openGameRegion";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.r
 * JD-Core Version:    0.7.0.1
 */