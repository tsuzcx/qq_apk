package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;

public class ab
  extends bv<GameWebPage>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(final b<GameWebPage>.a paramb)
  {
    AppMethodBeat.i(83081);
    Log.i("MicroMsg.JsApiOpenGameRegion", "invoke");
    final MMActivity localMMActivity = (MMActivity)((GameWebPage)paramb.eiY).mContext;
    localMMActivity.mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(83080);
        if (paramAnonymousInt1 == (ab.this.hashCode() & 0xFFFF))
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
          paramb.d("", localHashMap);
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
    c.a(localMMActivity, "game", ".ui.GameRegionSelectUI", null, hashCode() & 0xFFFF, false);
    AppMethodBeat.o(83081);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "openGameRegion";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ab
 * JD-Core Version:    0.7.0.1
 */