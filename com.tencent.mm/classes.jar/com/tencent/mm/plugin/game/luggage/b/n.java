package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.wepkg.model.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONException;
import org.json.JSONObject;

public class n
  extends br<com.tencent.mm.plugin.game.luggage.g.i>
{
  public final void a(Context paramContext, String paramString, final br.a parama)
  {
    AppMethodBeat.i(83072);
    Log.i("MicroMsg.JsApiGetLocalWePkgInfo", "invokeInMM");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83071);
        com.tencent.mm.plugin.wepkg.model.i.a(new i.a()
        {
          public final void aR(JSONObject paramAnonymous2JSONObject)
          {
            AppMethodBeat.i(83070);
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("wepkg_info", paramAnonymous2JSONObject);
              label21:
              n.1.this.xwB.i(null, localJSONObject);
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
  
  public final int dTs()
  {
    return 1;
  }
  
  public final String name()
  {
    return "getLocalWePkgInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.n
 * JD-Core Version:    0.7.0.1
 */