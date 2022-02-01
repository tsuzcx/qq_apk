package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.game.luggage.g.i.4;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import org.json.JSONObject;

public class ak
  extends bs<i>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<i>.a paramb)
  {
    AppMethodBeat.i(83093);
    JSONObject localJSONObject = paramb.ctb.csi;
    localJSONObject.optString("url");
    String str = localJSONObject.optString("viewId");
    int i = localJSONObject.optInt("left");
    i = at.fromDPToPix(MMApplicationContext.getContext(), i);
    int j = localJSONObject.optInt("top");
    j = at.fromDPToPix(MMApplicationContext.getContext(), j);
    int k = localJSONObject.optInt("width");
    k = at.fromDPToPix(MMApplicationContext.getContext(), k);
    int m = localJSONObject.optInt("height");
    m = at.fromDPToPix(MMApplicationContext.getContext(), m);
    paramb = (i)paramb.cta;
    paramb.aC(new i.4(paramb, str, k, m, i, j));
    AppMethodBeat.o(83093);
  }
  
  public final int dTs()
  {
    return 0;
  }
  
  public final String name()
  {
    return "updateInsertedWebView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ak
 * JD-Core Version:    0.7.0.1
 */