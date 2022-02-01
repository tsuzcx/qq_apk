package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public class j
  extends bq<com.tencent.mm.plugin.game.luggage.f.g>
{
  public final void a(Context paramContext, String paramString, bq.a parama)
  {
    AppMethodBeat.i(83066);
    AppMethodBeat.o(83066);
  }
  
  public final void b(final com.tencent.luggage.d.b<com.tencent.mm.plugin.game.luggage.f.g>.a paramb)
  {
    AppMethodBeat.i(180134);
    ad.i("MicroMsg.JsApiGetGameCommInfo", "invoke");
    Object localObject = paramb.chh.cgn;
    if (localObject == null)
    {
      ad.e("MicroMsg.JsApiGetGameCommInfo", "data is null");
      paramb.a("null_data", null);
      AppMethodBeat.o(180134);
      return;
    }
    int i = ((JSONObject)localObject).optInt("cmd", 0);
    localObject = ((JSONObject)localObject).optString("param");
    Bundle localBundle = new Bundle();
    localBundle.putInt("cmd", i);
    localBundle.putString("param", (String)localObject);
    JSONObject localJSONObject = new JSONObject();
    if (i == 10008) {
      try
      {
        localJSONObject.put("page_start_time", ((com.tencent.mm.plugin.game.luggage.f.g)paramb.chg).tVA.Ejp);
        paramb.a("", localJSONObject);
        AppMethodBeat.o(180134);
        return;
      }
      catch (JSONException localJSONException)
      {
        paramb.a("", null);
        AppMethodBeat.o(180134);
        return;
      }
    }
    if (i == 10009)
    {
      ((com.tencent.mm.plugin.game.luggage.f.g)paramb.chg).tVB = bt.getLong(localJSONException, System.currentTimeMillis());
      paramb.a("", null);
      AppMethodBeat.o(180134);
      return;
    }
    h.a("com.tencent.mm", localBundle, a.class, new d() {});
    AppMethodBeat.o(180134);
  }
  
  public final int ccO()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getGameCommInfo";
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.j
 * JD-Core Version:    0.7.0.1
 */