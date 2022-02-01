package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.game.luggage.f.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;

public class t
  extends bq<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(final b<g>.a paramb)
  {
    AppMethodBeat.i(83081);
    ae.i("MicroMsg.JsApiOpenGameRegion", "invoke");
    final MMActivity localMMActivity = (MMActivity)((g)paramb.chg).mContext;
    localMMActivity.mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(83080);
        if (paramAnonymousInt1 == (t.this.hashCode() & 0xFFFF))
        {
          if (paramAnonymousInt2 != -1) {
            break label96;
          }
          if (paramAnonymousIntent == null) {
            break label83;
          }
          paramAnonymousIntent = bu.bI(paramAnonymousIntent.getStringExtra("gameRegionName"), "");
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
          paramb.a("fail", null);
          continue;
          label96:
          if (paramAnonymousInt2 == 1) {
            paramb.a("fail", null);
          } else {
            paramb.a("cancel", null);
          }
        }
      }
    });
    d.a(localMMActivity, "game", ".ui.GameRegionSelectUI", null, hashCode() & 0xFFFF, false);
    AppMethodBeat.o(83081);
  }
  
  public final int ced()
  {
    return 0;
  }
  
  public final String name()
  {
    return "openGameRegion";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.t
 * JD-Core Version:    0.7.0.1
 */