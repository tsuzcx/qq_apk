package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.widget.MailMMWebView;
import com.tencent.mm.plugin.webview.ui.tools.widget.g;
import com.tencent.mm.ui.widget.MMWebView;

final class PluginBigBallOfMudAsync$5
  implements g
{
  PluginBigBallOfMudAsync$5(PluginBigBallOfMudAsync paramPluginBigBallOfMudAsync) {}
  
  public final MMWebView dz(Context paramContext)
  {
    AppMethodBeat.i(18311);
    MailMMWebView.fB(paramContext);
    paramContext = new MailMMWebView(paramContext);
    MailMMWebView.a(paramContext);
    AppMethodBeat.o(18311);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync.5
 * JD-Core Version:    0.7.0.1
 */