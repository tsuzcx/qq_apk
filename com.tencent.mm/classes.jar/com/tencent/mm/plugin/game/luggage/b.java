package com.tencent.mm.plugin.game.luggage;

import android.os.Build.VERSION;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.e;
import com.tencent.mm.plugin.webview.ui.tools.game.d;

public final class b
  implements com.tencent.luggage.webview.a.c
{
  private e rOP;
  
  public b(e parame)
  {
    this.rOP = parame;
  }
  
  public final String Eu()
  {
    return "weixin://game.js";
  }
  
  public final WebResourceResponse bW(String paramString)
  {
    AppMethodBeat.i(82986);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(82986);
      return null;
    }
    boolean bool = false;
    if (this.rOP.getWePkgPlugin() != null) {
      bool = this.rOP.getWePkgPlugin().BHg;
    }
    paramString = d.tw(bool);
    AppMethodBeat.o(82986);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b
 * JD-Core Version:    0.7.0.1
 */