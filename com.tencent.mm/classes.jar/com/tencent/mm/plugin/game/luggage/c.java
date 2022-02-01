package com.tencent.mm.plugin.game.luggage;

import android.os.Build.VERSION;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.page.h;
import com.tencent.mm.plugin.wepkg.f;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  implements com.tencent.luggage.webview.a.c
{
  private h ItJ;
  
  public c(h paramh)
  {
    this.ItJ = paramh;
  }
  
  public final String atp()
  {
    return "weixin://game.js";
  }
  
  public final WebResourceResponse eI(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(82986);
    Log.i("MicroMsg.LuggageGameJsResourceProvider", "onResourceRequest, url = %s", new Object[] { paramString });
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(82986);
      return null;
    }
    if (this.ItJ.getWePkgPlugin() != null) {
      bool = this.ItJ.getWePkgPlugin().XEu;
    }
    paramString = a.wj(bool);
    AppMethodBeat.o(82986);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c
 * JD-Core Version:    0.7.0.1
 */