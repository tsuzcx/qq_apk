package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage.4;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bw;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bd;
import org.json.JSONObject;

public class v
  extends bw<GameWebPage>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<GameWebPage>.a paramb)
  {
    AppMethodBeat.i(83074);
    Object localObject = paramb.eiZ.eif;
    String str1 = ((JSONObject)localObject).optString("url");
    String str2 = ((JSONObject)localObject).optString("viewId");
    int i = ((JSONObject)localObject).optInt("left");
    i = bd.fromDPToPix(MMApplicationContext.getContext(), i);
    int j = ((JSONObject)localObject).optInt("top");
    j = bd.fromDPToPix(MMApplicationContext.getContext(), j);
    int k = ((JSONObject)localObject).optInt("width");
    k = bd.fromDPToPix(MMApplicationContext.getContext(), k);
    int m = ((JSONObject)localObject).optInt("height");
    m = bd.fromDPToPix(MMApplicationContext.getContext(), m);
    localObject = (GameWebPage)paramb.eiY;
    ((GameWebPage)localObject).aR(new GameWebPage.4((GameWebPage)localObject, str1, str2, k, m, i, j));
    paramb.a("", null);
    AppMethodBeat.o(83074);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "insertWebView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.v
 * JD-Core Version:    0.7.0.1
 */