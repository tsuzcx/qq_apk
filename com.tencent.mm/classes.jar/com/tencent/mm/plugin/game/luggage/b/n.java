package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.game.luggage.d.f.9;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bo;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.ao;
import org.json.JSONObject;

public class n
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(83074);
    Object localObject = parama.bWS.bVY;
    String str1 = ((JSONObject)localObject).optString("url");
    String str2 = ((JSONObject)localObject).optString("viewId");
    int i = ((JSONObject)localObject).optInt("left");
    i = ao.fromDPToPix(ai.getContext(), i);
    int j = ((JSONObject)localObject).optInt("top");
    j = ao.fromDPToPix(ai.getContext(), j);
    int k = ((JSONObject)localObject).optInt("width");
    k = ao.fromDPToPix(ai.getContext(), k);
    int m = ((JSONObject)localObject).optInt("height");
    m = ao.fromDPToPix(ai.getContext(), m);
    localObject = (f)parama.bWR;
    ((f)localObject).av(new f.9((f)localObject, str1, str2, k, m, i, j));
    parama.a("", null);
    AppMethodBeat.o(83074);
  }
  
  public final int bYk()
  {
    return 0;
  }
  
  public final String name()
  {
    return "insertWebView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.n
 * JD-Core Version:    0.7.0.1
 */