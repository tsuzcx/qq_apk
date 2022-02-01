package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.f.g;
import com.tencent.mm.plugin.game.luggage.f.g.11;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.aq;
import org.json.JSONObject;

public class ah
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(83093);
    JSONObject localJSONObject = paramb.chh.cgn;
    localJSONObject.optString("url");
    String str = localJSONObject.optString("viewId");
    int i = localJSONObject.optInt("left");
    i = aq.fromDPToPix(ak.getContext(), i);
    int j = localJSONObject.optInt("top");
    j = aq.fromDPToPix(ak.getContext(), j);
    int k = localJSONObject.optInt("width");
    k = aq.fromDPToPix(ak.getContext(), k);
    int m = localJSONObject.optInt("height");
    m = aq.fromDPToPix(ak.getContext(), m);
    paramb = (g)paramb.chg;
    paramb.as(new g.11(paramb, str, k, m, i, j));
    AppMethodBeat.o(83093);
  }
  
  public final int ced()
  {
    return 0;
  }
  
  public final String name()
  {
    return "updateInsertedWebView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ah
 * JD-Core Version:    0.7.0.1
 */