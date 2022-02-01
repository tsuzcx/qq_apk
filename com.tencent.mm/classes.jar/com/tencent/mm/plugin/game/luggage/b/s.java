package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.game.luggage.g.i.3;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import org.json.JSONObject;

public class s
  extends bs<i>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<i>.a paramb)
  {
    AppMethodBeat.i(83074);
    Object localObject = paramb.ctb.csi;
    String str1 = ((JSONObject)localObject).optString("url");
    String str2 = ((JSONObject)localObject).optString("viewId");
    int i = ((JSONObject)localObject).optInt("left");
    i = at.fromDPToPix(MMApplicationContext.getContext(), i);
    int j = ((JSONObject)localObject).optInt("top");
    j = at.fromDPToPix(MMApplicationContext.getContext(), j);
    int k = ((JSONObject)localObject).optInt("width");
    k = at.fromDPToPix(MMApplicationContext.getContext(), k);
    int m = ((JSONObject)localObject).optInt("height");
    m = at.fromDPToPix(MMApplicationContext.getContext(), m);
    localObject = (i)paramb.cta;
    ((i)localObject).aC(new i.3((i)localObject, str1, str2, k, m, i, j));
    paramb.c("", null);
    AppMethodBeat.o(83074);
  }
  
  public final int dTs()
  {
    return 0;
  }
  
  public final String name()
  {
    return "insertWebView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.s
 * JD-Core Version:    0.7.0.1
 */