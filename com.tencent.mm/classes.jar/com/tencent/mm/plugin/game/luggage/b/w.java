package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader_app.api.a.c;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class w
  extends bv<GameWebPage>
{
  public final void a(Context paramContext, String paramString, final bv.a parama)
  {
    AppMethodBeat.i(83076);
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString != null)
      {
        paramString = paramString.optString("appId");
        Intent localIntent = new Intent();
        localIntent.putExtra("appId", paramString);
        localIntent.putExtra("view_task", true);
        localIntent.addFlags(268435456);
        ((c)h.ax(c.class)).a(paramContext, localIntent, new a.c()
        {
          public final void cqd()
          {
            AppMethodBeat.i(83075);
            parama.j(null, null);
            AppMethodBeat.o(83075);
          }
        });
        AppMethodBeat.o(83076);
        return;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.JsApiJumpDownloaderWidget", paramString, "", new Object[0]);
        paramString = null;
        continue;
        paramString = "";
      }
    }
  }
  
  public final void b(b<GameWebPage>.a paramb) {}
  
  public final int dgI()
  {
    return 2;
  }
  
  public final String name()
  {
    return "jumpDownloaderWidget";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.w
 * JD-Core Version:    0.7.0.1
 */