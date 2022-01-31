package com.tencent.mm.plugin.bbom;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.w;

final class PluginBigBallOfMudAsync$6
  implements c
{
  PluginBigBallOfMudAsync$6(PluginBigBallOfMudAsync paramPluginBigBallOfMudAsync) {}
  
  public final w a(MMWebView paramMMWebView, d paramd, Bundle paramBundle)
  {
    AppMethodBeat.i(18313);
    paramMMWebView = new l(paramMMWebView, false, paramd, paramBundle);
    AppMethodBeat.o(18313);
    return paramMMWebView;
  }
  
  public final w a(MMWebView paramMMWebView, boolean paramBoolean, d paramd)
  {
    AppMethodBeat.i(18312);
    paramMMWebView = new l(paramMMWebView, paramBoolean, paramd);
    AppMethodBeat.o(18312);
    return paramMMWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync.6
 * JD-Core Version:    0.7.0.1
 */