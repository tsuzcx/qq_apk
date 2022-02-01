package com.tencent.mm.plugin.game.luggage;

import android.os.Build.VERSION;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.e;
import com.tencent.mm.plugin.webview.ui.tools.game.d;

public final class b
  implements com.tencent.luggage.webview.a.c
{
  private e sWF;
  
  public b(e parame)
  {
    this.sWF = parame;
  }
  
  public final String DX()
  {
    return "weixin://game.js";
  }
  
  public final WebResourceResponse bM(String paramString)
  {
    AppMethodBeat.i(82986);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(82986);
      return null;
    }
    boolean bool = false;
    if (this.sWF.getWePkgPlugin() != null) {
      bool = this.sWF.getWePkgPlugin().CZo;
    }
    paramString = d.uy(bool);
    AppMethodBeat.o(82986);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b
 * JD-Core Version:    0.7.0.1
 */