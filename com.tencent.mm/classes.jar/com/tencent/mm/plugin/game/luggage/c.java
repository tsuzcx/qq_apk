package com.tencent.mm.plugin.game.luggage;

import android.os.Build.VERSION;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.f.f;
import com.tencent.mm.plugin.wepkg.d;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  implements com.tencent.luggage.webview.a.c
{
  private f ued;
  
  public c(f paramf)
  {
    this.ued = paramf;
  }
  
  public final String FC()
  {
    return "weixin://game.js";
  }
  
  public final WebResourceResponse cG(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(82986);
    ae.i("MicroMsg.LuggageGameJsResourceProvider", "onResourceRequest, url = %s", new Object[] { paramString });
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(82986);
      return null;
    }
    if (this.ued.getWePkgPlugin() != null) {
      bool = this.ued.getWePkgPlugin().EVI;
    }
    paramString = a.nb(bool);
    AppMethodBeat.o(82986);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c
 * JD-Core Version:    0.7.0.1
 */