package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONException;
import org.json.JSONObject;

public class i
  extends bn<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama)
  {
    AppMethodBeat.i(83066);
    AppMethodBeat.o(83066);
  }
  
  public final void b(final a<f>.a parama)
  {
    AppMethodBeat.i(180134);
    ac.i("MicroMsg.JsApiGetGameCommInfo", "invoke");
    Object localObject = parama.bWS.bVY;
    if (localObject == null)
    {
      ac.e("MicroMsg.JsApiGetGameCommInfo", "data is null");
      parama.a("null_data", null);
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
        localJSONObject.put("page_start_time", ((f)parama.bWR).sYo.CFE);
        parama.a("", localJSONObject);
        AppMethodBeat.o(180134);
        return;
      }
      catch (JSONException localJSONException)
      {
        parama.a("", null);
        AppMethodBeat.o(180134);
        return;
      }
    }
    if (i == 10009)
    {
      ((f)parama.bWR).sYp = bs.getLong(localJSONException, System.currentTimeMillis());
      parama.a("", null);
      AppMethodBeat.o(180134);
      return;
    }
    com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", localBundle, a.class, new d() {});
    AppMethodBeat.o(180134);
  }
  
  public final int bYk()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getGameCommInfo";
  }
  
  static class a
    implements b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.i
 * JD-Core Version:    0.7.0.1
 */