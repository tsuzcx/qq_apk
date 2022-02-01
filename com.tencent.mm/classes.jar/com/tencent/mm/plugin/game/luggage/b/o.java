package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.api.a.c;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public class o
  extends bn<f>
{
  public final void a(Context paramContext, String paramString, final bn.a parama)
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
        ((c)g.ab(c.class)).a(paramContext, localIntent, new a.c()
        {
          public final void beX()
          {
            AppMethodBeat.i(83075);
            parama.f(null, null);
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
        ac.printErrStackTrace("MicroMsg.JsApiJumpDownloaderWidget", paramString, "", new Object[0]);
        paramString = null;
        continue;
        paramString = "";
      }
    }
  }
  
  public final void b(a<f>.a parama) {}
  
  public final int bYk()
  {
    return 2;
  }
  
  public final String name()
  {
    return "jumpDownloaderWidget";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.o
 * JD-Core Version:    0.7.0.1
 */