package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c.a;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.webview.ui.tools.game.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class n
  extends bv<GameWebPage>
{
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    AppMethodBeat.i(83066);
    AppMethodBeat.o(83066);
  }
  
  public final void b(final b<GameWebPage>.a paramb)
  {
    AppMethodBeat.i(180134);
    Log.i("MicroMsg.JsApiGetGameCommInfo", "invoke");
    Object localObject = paramb.eiZ.eif;
    if (localObject == null)
    {
      Log.e("MicroMsg.JsApiGetGameCommInfo", "data is null");
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
        localJSONObject.put("page_start_time", ((GameWebPage)paramb.eiY).IwV.XgF);
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
      ((GameWebPage)paramb.eiY).IwW = Util.getLong(localJSONException, System.currentTimeMillis());
      paramb.a("", null);
      AppMethodBeat.o(180134);
      return;
    }
    j.a(MainProcessIPCService.PROCESS_NAME, localBundle, a.class, new f() {});
    AppMethodBeat.o(180134);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getGameCommInfo";
  }
  
  @a
  static class a
    implements d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.n
 * JD-Core Version:    0.7.0.1
 */