package com.tencent.mm.plugin.account.bind.ui;

import android.webkit.ConsoleMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.xweb.p;

final class BindGoogleContactUI$3
  extends p
{
  BindGoogleContactUI$3(BindGoogleContactUI paramBindGoogleContactUI) {}
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(13350);
    if (paramConsoleMessage != null) {}
    for (String str = paramConsoleMessage.message();; str = null)
    {
      str = u.amW(str);
      if (!str.toLowerCase().startsWith("weixin://private/googlegetcode")) {
        break;
      }
      BindGoogleContactUI.a(this.gsF, str);
      AppMethodBeat.o(13350);
      return true;
    }
    boolean bool = super.onConsoleMessage(paramConsoleMessage);
    AppMethodBeat.o(13350);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI.3
 * JD-Core Version:    0.7.0.1
 */