package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.ui.tools.game.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class k
  extends br<i>
{
  public final void a(Context paramContext, String paramString, br.a parama)
  {
    AppMethodBeat.i(83066);
    AppMethodBeat.o(83066);
  }
  
  public final void b(final com.tencent.luggage.d.b<i>.a paramb)
  {
    AppMethodBeat.i(180134);
    Log.i("MicroMsg.JsApiGetGameCommInfo", "invoke");
    Object localObject = paramb.ctb.csi;
    if (localObject == null)
    {
      Log.e("MicroMsg.JsApiGetGameCommInfo", "data is null");
      paramb.c("null_data", null);
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
        localJSONObject.put("page_start_time", ((i)paramb.cta).xyM.JqU);
        paramb.c("", localJSONObject);
        AppMethodBeat.o(180134);
        return;
      }
      catch (JSONException localJSONException)
      {
        paramb.c("", null);
        AppMethodBeat.o(180134);
        return;
      }
    }
    if (i == 10009)
    {
      ((i)paramb.cta).xyN = Util.getLong(localJSONException, System.currentTimeMillis());
      paramb.c("", null);
      AppMethodBeat.o(180134);
      return;
    }
    h.a(MainProcessIPCService.dkO, localBundle, a.class, new d() {});
    AppMethodBeat.o(180134);
  }
  
  public final int dTs()
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
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.k
 * JD-Core Version:    0.7.0.1
 */