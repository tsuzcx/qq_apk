package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.plugin.wepkg.model.h;
import com.tencent.mm.plugin.wepkg.model.h.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import org.json.JSONException;
import org.json.JSONObject;

public class k
  extends bn<f>
{
  public final void a(Context paramContext, String paramString, final bn.a parama)
  {
    AppMethodBeat.i(83072);
    ad.i("MicroMsg.JsApiGetLocalWePkgInfo", "invokeInMM");
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83071);
        h.a(new h.a()
        {
          public final void ar(JSONObject paramAnonymous2JSONObject)
          {
            AppMethodBeat.i(83070);
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("wepkg_info", paramAnonymous2JSONObject);
              label21:
              k.1.this.ohm.f(null, localJSONObject);
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
  
  public final void b(a.a parama) {}
  
  public final int bQV()
  {
    return 1;
  }
  
  public final String name()
  {
    return "getLocalWePkgInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.k
 * JD-Core Version:    0.7.0.1
 */