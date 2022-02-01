package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage.5;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bw;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bd;
import org.json.JSONObject;

public class au
  extends bw<GameWebPage>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<GameWebPage>.a paramb)
  {
    AppMethodBeat.i(83093);
    JSONObject localJSONObject = paramb.eiZ.eif;
    localJSONObject.optString("url");
    String str = localJSONObject.optString("viewId");
    int i = localJSONObject.optInt("left");
    i = bd.fromDPToPix(MMApplicationContext.getContext(), i);
    int j = localJSONObject.optInt("top");
    j = bd.fromDPToPix(MMApplicationContext.getContext(), j);
    int k = localJSONObject.optInt("width");
    k = bd.fromDPToPix(MMApplicationContext.getContext(), k);
    int m = localJSONObject.optInt("height");
    m = bd.fromDPToPix(MMApplicationContext.getContext(), m);
    paramb = (GameWebPage)paramb.eiY;
    paramb.aR(new GameWebPage.5(paramb, str, k, m, i, j));
    AppMethodBeat.o(83093);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "updateInsertedWebView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.au
 * JD-Core Version:    0.7.0.1
 */