package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.g.f;
import com.tencent.mm.plugin.game.luggage.g.f.a;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class al
  extends bs<i>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<i>.a paramb)
  {
    AppMethodBeat.i(232287);
    Log.i("MicroMsg.JsApiSetGameTab", "invokeInOwn");
    JSONObject localJSONObject = paramb.crh.cqn;
    if (localJSONObject == null)
    {
      Log.e("MicroMsg.JsApiSetGameTab", "data is null");
      paramb.a("null_data", null);
      AppMethodBeat.o(232287);
      return;
    }
    f localf = ((i)paramb.crg).CDb;
    if (localf == null)
    {
      Log.e("MicroMsg.JsApiSetGameTab", "is not tab page");
      paramb.a("not_tab", null);
      AppMethodBeat.o(232287);
      return;
    }
    int i;
    if (localJSONObject.has("isShowTab"))
    {
      i = localJSONObject.optInt("isShowTab", -1);
      Log.i("MicroMsg.JsApiSetGameTab", "isShowTab:%d", new Object[] { Integer.valueOf(i) });
      if (localf.CCc != null) {
        localf.CCc.Tt(i);
      }
    }
    if (localJSONObject.has("isSwitchEnable"))
    {
      i = localJSONObject.optInt("isSwitchEnable", -1);
      Log.i("MicroMsg.JsApiSetGameTab", "isSwitchEnable:%d", new Object[] { Integer.valueOf(i) });
      if (localf.CCc != null) {
        localf.CCc.Tu(i);
      }
    }
    paramb.a("", null);
    AppMethodBeat.o(232287);
  }
  
  public final int cDj()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setGameTab";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.al
 * JD-Core Version:    0.7.0.1
 */