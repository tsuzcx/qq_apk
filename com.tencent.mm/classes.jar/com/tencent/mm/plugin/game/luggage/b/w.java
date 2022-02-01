package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.a.a;
import com.tencent.mm.plugin.lite.a.a.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public class w
  extends br<com.tencent.mm.plugin.game.luggage.f.g>
{
  public final void a(Context paramContext, String paramString, final bq.a parama)
  {
    AppMethodBeat.i(211613);
    JSONObject localJSONObject = com.tencent.mm.plugin.webview.luggage.c.b.Pe(paramString);
    if (localJSONObject == null)
    {
      parama.f("invalid_data", null);
      AppMethodBeat.o(211613);
      return;
    }
    paramString = new Bundle();
    try
    {
      paramString.putString("appId", localJSONObject.getString("appId"));
      paramString.putString("data", localJSONObject.toString());
      label61:
      ((a)com.tencent.mm.kernel.g.ab(a.class)).a(paramContext, paramString, new a.a()
      {
        public final void cXe()
        {
          AppMethodBeat.i(211611);
          ad.i("JsApiOpenLiteApp", "JsApiOpenLiteApp success");
          parama.f(null, null);
          AppMethodBeat.o(211611);
        }
        
        public final void cXf()
        {
          AppMethodBeat.i(211612);
          ad.i("JsApiOpenLiteApp", "JsApiOpenLiteApp fail");
          parama.f("fail", null);
          AppMethodBeat.o(211612);
        }
      });
      AppMethodBeat.o(211613);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label61;
    }
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.game.luggage.f.g>.a paramb) {}
  
  public final int ccO()
  {
    return 1;
  }
  
  public final String name()
  {
    return "openLiteApp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.w
 * JD-Core Version:    0.7.0.1
 */