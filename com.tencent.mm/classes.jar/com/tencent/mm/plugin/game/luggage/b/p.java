package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.f.g;
import com.tencent.mm.plugin.game.luggage.f.g.9;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.aq;
import org.json.JSONObject;

public class p
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(83074);
    Object localObject = paramb.chh.cgn;
    String str1 = ((JSONObject)localObject).optString("url");
    String str2 = ((JSONObject)localObject).optString("viewId");
    int i = ((JSONObject)localObject).optInt("left");
    i = aq.fromDPToPix(aj.getContext(), i);
    int j = ((JSONObject)localObject).optInt("top");
    j = aq.fromDPToPix(aj.getContext(), j);
    int k = ((JSONObject)localObject).optInt("width");
    k = aq.fromDPToPix(aj.getContext(), k);
    int m = ((JSONObject)localObject).optInt("height");
    m = aq.fromDPToPix(aj.getContext(), m);
    localObject = (g)paramb.chg;
    ((g)localObject).au(new g.9((g)localObject, str1, str2, k, m, i, j));
    paramb.a("", null);
    AppMethodBeat.o(83074);
  }
  
  public final int ccO()
  {
    return 0;
  }
  
  public final String name()
  {
    return "insertWebView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.p
 * JD-Core Version:    0.7.0.1
 */