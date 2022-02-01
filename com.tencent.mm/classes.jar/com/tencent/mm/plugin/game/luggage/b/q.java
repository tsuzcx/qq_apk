package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.wepkg.model.i;
import com.tencent.mm.plugin.wepkg.model.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONException;
import org.json.JSONObject;

public class q
  extends bv<GameWebPage>
{
  public final void a(Context paramContext, String paramString, final bv.a parama)
  {
    AppMethodBeat.i(83072);
    Log.i("MicroMsg.JsApiGetLocalWePkgInfo", "invokeInMM");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83071);
        i.a(new i.a()
        {
          public final void bl(JSONObject paramAnonymous2JSONObject)
          {
            AppMethodBeat.i(83070);
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("wepkg_info", paramAnonymous2JSONObject);
              label21:
              q.1.this.Iuv.j(null, localJSONObject);
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
  
  public final int dgI()
  {
    return 1;
  }
  
  public final String name()
  {
    return "getLocalWePkgInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.q
 * JD-Core Version:    0.7.0.1
 */