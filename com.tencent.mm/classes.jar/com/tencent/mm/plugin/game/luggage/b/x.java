package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bi;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.al;
import org.json.JSONObject;

public class x
  extends bi<f>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(154154);
    JSONObject localJSONObject = parama.byF.bxK;
    localJSONObject.optString("url");
    String str = localJSONObject.optString("viewId");
    int i = localJSONObject.optInt("left");
    i = al.fromDPToPix(ah.getContext(), i);
    int j = localJSONObject.optInt("top");
    j = al.fromDPToPix(ah.getContext(), j);
    int k = localJSONObject.optInt("width");
    k = al.fromDPToPix(ah.getContext(), k);
    int m = localJSONObject.optInt("height");
    m = al.fromDPToPix(ah.getContext(), m);
    ((f)parama.byE).c(str, i, j, k, m);
    AppMethodBeat.o(154154);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "updateInsertedWebView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.x
 * JD-Core Version:    0.7.0.1
 */