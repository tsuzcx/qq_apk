package com.tencent.mm.plugin.game.luggage;

import android.os.Build.VERSION;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.e;
import com.tencent.mm.plugin.webview.ui.tools.game.d;

public final class a
  implements com.tencent.luggage.webview.a.c
{
  private e njh;
  
  public a(e parame)
  {
    this.njh = parame;
  }
  
  public final WebResourceResponse bG(String paramString)
  {
    AppMethodBeat.i(135806);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(135806);
      return null;
    }
    boolean bool = false;
    if (this.njh.getWePkgPlugin() != null) {
      bool = this.njh.getWePkgPlugin().vEy;
    }
    paramString = d.oA(bool);
    AppMethodBeat.o(135806);
    return paramString;
  }
  
  public final String xd()
  {
    return "weixin://game.js";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.a
 * JD-Core Version:    0.7.0.1
 */