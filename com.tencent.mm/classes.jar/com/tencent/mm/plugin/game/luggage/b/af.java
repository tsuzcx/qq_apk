package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.f.d;
import com.tencent.mm.plugin.game.luggage.f.d.a;
import com.tencent.mm.plugin.game.luggage.f.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public class af
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(211619);
    ad.i("MicroMsg.JsApiSetGameTab", "invokeInOwn");
    JSONObject localJSONObject = paramb.chh.cgn;
    if (localJSONObject == null)
    {
      ad.e("MicroMsg.JsApiSetGameTab", "data is null");
      paramb.a("null_data", null);
      AppMethodBeat.o(211619);
      return;
    }
    d locald = ((g)paramb.chg).tVG;
    if (locald == null)
    {
      ad.e("MicroMsg.JsApiSetGameTab", "is not tab page");
      paramb.a("not_tab", null);
      AppMethodBeat.o(211619);
      return;
    }
    int i;
    if (localJSONObject.has("isShowTab"))
    {
      i = localJSONObject.optInt("isShowTab", -1);
      ad.i("MicroMsg.JsApiSetGameTab", "isShowTab:%d", new Object[] { Integer.valueOf(i) });
      if (locald.tUN != null) {
        locald.tUN.HA(i);
      }
    }
    if (localJSONObject.has("isSwitchEnable"))
    {
      i = localJSONObject.optInt("isSwitchEnable", -1);
      ad.i("MicroMsg.JsApiSetGameTab", "isSwitchEnable:%d", new Object[] { Integer.valueOf(i) });
      if (locald.tUN != null) {
        locald.tUN.HB(i);
      }
    }
    paramb.a("", null);
    AppMethodBeat.o(211619);
  }
  
  public final int ccO()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setGameTab";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.af
 * JD-Core Version:    0.7.0.1
 */