package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bw;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class ap
  extends bw<GameWebPage>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<GameWebPage>.a paramb)
  {
    AppMethodBeat.i(277178);
    Log.i("MicroMsg.JsApiSetDownloadWidgetEntrance", "invokeInOwn");
    JSONObject localJSONObject = paramb.eiZ.eif;
    if (localJSONObject == null)
    {
      Log.e("MicroMsg.JsApiSetDownloadWidgetEntrance", "data is null");
      paramb.a("null_data", null);
      AppMethodBeat.o(277178);
      return;
    }
    boolean bool = localJSONObject.optBoolean("show", false);
    Log.i("MicroMsg.JsApiSetDownloadWidgetEntrance", "download widget show:%b", new Object[] { Boolean.valueOf(bool) });
    ((GameWebPage)paramb.eiY).wn(bool);
    paramb.a("", null);
    AppMethodBeat.o(277178);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setDownloadWidgetEntrance";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ap
 * JD-Core Version:    0.7.0.1
 */