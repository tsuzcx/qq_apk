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
import org.json.JSONObject;

public class ar
  extends bw<GameWebPage>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<GameWebPage>.a paramb)
  {
    AppMethodBeat.i(277166);
    Log.i("MicroMsg.JsApiSetGameTab", "invokeInOwn");
    JSONObject localJSONObject = paramb.eiZ.eif;
    if (localJSONObject == null)
    {
      Log.e("MicroMsg.JsApiSetGameTab", "data is null");
      paramb.a("null_data", null);
      AppMethodBeat.o(277166);
      return;
    }
    f localf = ((GameWebPage)paramb.eiY).Ixc;
    if (localf == null)
    {
      Log.e("MicroMsg.JsApiSetGameTab", "is not tab page");
      paramb.a("not_tab", null);
      AppMethodBeat.o(277166);
      return;
    }
    int i;
    if (localJSONObject.has("isShowTab"))
    {
      i = localJSONObject.optInt("isShowTab", -1);
      Log.i("MicroMsg.JsApiSetGameTab", "isShowTab:%d", new Object[] { Integer.valueOf(i) });
      if (localf.IvR != null) {
        localf.IvR.Xn(i);
      }
    }
    if (localJSONObject.has("isSwitchEnable"))
    {
      i = localJSONObject.optInt("isSwitchEnable", -1);
      Log.i("MicroMsg.JsApiSetGameTab", "isSwitchEnable:%d", new Object[] { Integer.valueOf(i) });
      if (localf.IvR != null) {
        localf.IvR.Xo(i);
      }
    }
    paramb.a("", null);
    AppMethodBeat.o(277166);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setGameTab";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ar
 * JD-Core Version:    0.7.0.1
 */