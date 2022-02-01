package com.tencent.mm.plugin.bbom;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ab;

final class PluginBigBallOfMudAsync$6
  implements c
{
  PluginBigBallOfMudAsync$6(PluginBigBallOfMudAsync paramPluginBigBallOfMudAsync) {}
  
  public final ab a(MMWebView paramMMWebView, d paramd, Bundle paramBundle)
  {
    AppMethodBeat.i(22425);
    paramMMWebView = new l(paramMMWebView, false, paramd, paramBundle);
    AppMethodBeat.o(22425);
    return paramMMWebView;
  }
  
  public final ab a(MMWebView paramMMWebView, boolean paramBoolean, d paramd)
  {
    AppMethodBeat.i(22424);
    paramMMWebView = new l(paramMMWebView, paramBoolean, paramd);
    AppMethodBeat.o(22424);
    return paramMMWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync.6
 * JD-Core Version:    0.7.0.1
 */