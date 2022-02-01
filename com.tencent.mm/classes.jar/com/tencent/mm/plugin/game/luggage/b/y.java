package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.game.luggage.d.f.10;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bo;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.ao;
import org.json.JSONObject;

public class y
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(83093);
    JSONObject localJSONObject = parama.bZV.bZb;
    localJSONObject.optString("url");
    String str = localJSONObject.optString("viewId");
    int i = localJSONObject.optInt("left");
    i = ao.fromDPToPix(aj.getContext(), i);
    int j = localJSONObject.optInt("top");
    j = ao.fromDPToPix(aj.getContext(), j);
    int k = localJSONObject.optInt("width");
    k = ao.fromDPToPix(aj.getContext(), k);
    int m = localJSONObject.optInt("height");
    m = ao.fromDPToPix(aj.getContext(), m);
    parama = (f)parama.bZU;
    parama.at(new f.10(parama, str, k, m, i, j));
    AppMethodBeat.o(83093);
  }
  
  public final int bQV()
  {
    return 0;
  }
  
  public final String name()
  {
    return "updateInsertedWebView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.y
 * JD-Core Version:    0.7.0.1
 */