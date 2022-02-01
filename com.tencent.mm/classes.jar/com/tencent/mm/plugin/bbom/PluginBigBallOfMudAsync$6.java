package com.tencent.mm.plugin.bbom;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.widget.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.g;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ag;

final class PluginBigBallOfMudAsync$6
  implements f
{
  PluginBigBallOfMudAsync$6(PluginBigBallOfMudAsync paramPluginBigBallOfMudAsync) {}
  
  public final ag a(MMWebView paramMMWebView, g paramg, Bundle paramBundle)
  {
    AppMethodBeat.i(22425);
    paramMMWebView = new o(paramMMWebView, false, paramg, paramBundle);
    AppMethodBeat.o(22425);
    return paramMMWebView;
  }
  
  public final ag a(MMWebView paramMMWebView, boolean paramBoolean, g paramg)
  {
    AppMethodBeat.i(22424);
    paramMMWebView = new o(paramMMWebView, paramBoolean, paramg);
    AppMethodBeat.o(22424);
    return paramMMWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync.6
 * JD-Core Version:    0.7.0.1
 */