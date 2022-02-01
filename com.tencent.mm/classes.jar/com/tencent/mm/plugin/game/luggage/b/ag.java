package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.lite.api.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import org.json.JSONObject;

public class ag
  extends bv
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(277164);
    String str2 = parama.eiZ.eif.optString("appId");
    if (parama.eiZ.eif.has("path")) {}
    for (String str1 = parama.eiZ.eif.optString("path");; str1 = "")
    {
      ((c)h.ax(c.class)).aB(str2, str1, "preloadLiteApp");
      parama.a("", null);
      AppMethodBeat.o(277164);
      return;
    }
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "preloadLiteApp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ag
 * JD-Core Version:    0.7.0.1
 */