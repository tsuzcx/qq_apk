package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.game.luggage.page.f;
import com.tencent.mm.plugin.game.luggage.page.f.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class at
  extends bw<GameWebPage>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<GameWebPage>.a paramb)
  {
    AppMethodBeat.i(277167);
    Log.i("MicroMsg.JsApiSwitchToGameTab", "invokeInOwn");
    Object localObject = paramb.eiZ.eif;
    if (localObject == null)
    {
      Log.e("MicroMsg.JsApiSwitchToGameTab", "data is null");
      paramb.a("null_data", null);
      AppMethodBeat.o(277167);
      return;
    }
    f localf = ((GameWebPage)paramb.eiY).Ixc;
    if (localf == null)
    {
      Log.e("MicroMsg.JsApiSwitchToGameTab", "is not tab page");
      paramb.a("not_tab", null);
      AppMethodBeat.o(277167);
      return;
    }
    localObject = ((JSONObject)localObject).optString("tabKey");
    if ((!Util.isNullOrNil((String)localObject)) && (localf.IvR != null)) {
      localf.IvR.aGh((String)localObject);
    }
    paramb.a("", null);
    AppMethodBeat.o(277167);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "switchToGameTab";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.at
 * JD-Core Version:    0.7.0.1
 */