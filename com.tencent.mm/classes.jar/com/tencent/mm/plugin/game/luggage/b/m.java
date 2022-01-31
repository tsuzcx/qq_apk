package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.a.d;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public class m
  extends bh<f>
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(135878);
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString != null)
      {
        paramString = paramString.optString("appId");
        Intent localIntent = new Intent();
        localIntent.putExtra("appId", paramString);
        localIntent.putExtra("view_task", true);
        localIntent.addFlags(67108864);
        ((d)g.E(d.class)).a(paramContext, localIntent, new m.1(this, parama));
        AppMethodBeat.o(135878);
        return;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.JsApiJumpDownloaderWidget", paramString, "", new Object[0]);
        paramString = null;
        continue;
        paramString = "";
      }
    }
  }
  
  public final void b(a<f>.a parama) {}
  
  public final int bjL()
  {
    return 2;
  }
  
  public final String name()
  {
    return "jumpDownloaderWidget";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.m
 * JD-Core Version:    0.7.0.1
 */