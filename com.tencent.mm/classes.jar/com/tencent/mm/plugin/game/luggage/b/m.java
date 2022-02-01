package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.f.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.wepkg.model.h;
import com.tencent.mm.plugin.wepkg.model.h.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import org.json.JSONException;
import org.json.JSONObject;

public class m
  extends bq<g>
{
  public final void a(Context paramContext, String paramString, final bq.a parama)
  {
    AppMethodBeat.i(83072);
    ae.i("MicroMsg.JsApiGetLocalWePkgInfo", "invokeInMM");
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83071);
        h.a(new h.a()
        {
          public final void av(JSONObject paramAnonymous2JSONObject)
          {
            AppMethodBeat.i(83070);
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("wepkg_info", paramAnonymous2JSONObject);
              label21:
              m.1.this.pva.f(null, localJSONObject);
              AppMethodBeat.o(83070);
              return;
            }
            catch (JSONException paramAnonymous2JSONObject)
            {
              break label21;
            }
          }
        });
        AppMethodBeat.o(83071);
      }
    });
    AppMethodBeat.o(83072);
  }
  
  public final void b(b.a parama) {}
  
  public final int ced()
  {
    return 1;
  }
  
  public final String name()
  {
    return "getLocalWePkgInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.m
 * JD-Core Version:    0.7.0.1
 */