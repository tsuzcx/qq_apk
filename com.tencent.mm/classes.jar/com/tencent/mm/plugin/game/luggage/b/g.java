package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.j.c;
import com.tencent.mm.plugin.game.luggage.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;
import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONObject;

public class g
  extends aw<d>
{
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    try
    {
      paramString = new JSONObject(paramString);
      paramString = paramString.optString("appId");
      if (bk.bl(paramString))
      {
        parama.e("invalid_params", null);
        return;
      }
    }
    catch (Exception paramContext)
    {
      c.printErrStackTrace("MicroMsg.JsApiJumpDownloaderApp", paramContext, "", new Object[0]);
      parama.e("fail", null);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("appId", paramString);
    ((com.tencent.mm.plugin.downloader_app.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.downloader_app.a.a.class)).a(paramContext, localIntent, new g.1(this, parama));
  }
  
  public final int aGj()
  {
    return 2;
  }
  
  public final void b(com.tencent.luggage.e.a<d>.a parama) {}
  
  public final String name()
  {
    return "jumpDownloaderApp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.g
 * JD-Core Version:    0.7.0.1
 */