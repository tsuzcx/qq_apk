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

public class ai
  extends bs<i>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<i>.a paramb)
  {
    AppMethodBeat.i(186887);
    Log.i("MicroMsg.JsApiSetGameTab", "invokeInOwn");
    JSONObject localJSONObject = paramb.ctb.csi;
    if (localJSONObject == null)
    {
      Log.e("MicroMsg.JsApiSetGameTab", "data is null");
      paramb.c("null_data", null);
      AppMethodBeat.o(186887);
      return;
    }
    f localf = ((i)paramb.cta).xyT;
    if (localf == null)
    {
      Log.e("MicroMsg.JsApiSetGameTab", "is not tab page");
      paramb.c("not_tab", null);
      AppMethodBeat.o(186887);
      return;
    }
    int i;
    if (localJSONObject.has("isShowTab"))
    {
      i = localJSONObject.optInt("isShowTab", -1);
      Log.i("MicroMsg.JsApiSetGameTab", "isShowTab:%d", new Object[] { Integer.valueOf(i) });
      if (localf.xxS != null) {
        localf.xxS.Oa(i);
      }
    }
    if (localJSONObject.has("isSwitchEnable"))
    {
      i = localJSONObject.optInt("isSwitchEnable", -1);
      Log.i("MicroMsg.JsApiSetGameTab", "isSwitchEnable:%d", new Object[] { Integer.valueOf(i) });
      if (localf.xxS != null) {
        localf.xxS.Ob(i);
      }
    }
    paramb.c("", null);
    AppMethodBeat.o(186887);
  }
  
  public final int dTs()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setGameTab";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ai
 * JD-Core Version:    0.7.0.1
 */