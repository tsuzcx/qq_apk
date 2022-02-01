package com.tencent.mm.plugin.game.luggage;

import android.os.Build.VERSION;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.g.h;
import com.tencent.mm.plugin.wepkg.f;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  implements com.tencent.luggage.webview.a.c
{
  private h CzY;
  
  public c(h paramh)
  {
    this.CzY = paramh;
  }
  
  public final String SK()
  {
    return "weixin://game.js";
  }
  
  public final WebResourceResponse dx(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(82986);
    Log.i("MicroMsg.LuggageGameJsResourceProvider", "onResourceRequest, url = %s", new Object[] { paramString });
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(82986);
      return null;
    }
    if (this.CzY.getWePkgPlugin() != null) {
      bool = this.CzY.getWePkgPlugin().QKV;
    }
    paramString = a.se(bool);
    AppMethodBeat.o(82986);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c
 * JD-Core Version:    0.7.0.1
 */