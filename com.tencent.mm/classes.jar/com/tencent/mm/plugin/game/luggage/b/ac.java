package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppTaskPreloadReceiver;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class ac
  extends br
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(231471);
    String str = parama.crh.cqn.optString("appId");
    Intent localIntent = new Intent();
    localIntent.setClass(MMApplicationContext.getContext(), LiteAppTaskPreloadReceiver.class);
    localIntent.addFlags(268435456);
    localIntent.putExtra("task", "preloadLiteApp");
    localIntent.putExtra("appId", str);
    if (parama.crh.cqn.has("path")) {
      localIntent.putExtra("path", parama.crh.cqn.optString("path"));
    }
    MMApplicationContext.getContext().sendBroadcast(localIntent);
    parama.a("", null);
    AppMethodBeat.o(231471);
  }
  
  public final int cDj()
  {
    return 0;
  }
  
  public final String name()
  {
    return "preloadLiteApp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ac
 * JD-Core Version:    0.7.0.1
 */