package com.tencent.mm.plugin.account.bind.ui;

import android.webkit.ConsoleMessage;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.xweb.j;

final class BindGoogleContactUI$3
  extends j
{
  BindGoogleContactUI$3(BindGoogleContactUI paramBindGoogleContactUI) {}
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if (paramConsoleMessage != null) {}
    for (String str = paramConsoleMessage.message();; str = null)
    {
      str = s.Xd(str);
      if (!str.toLowerCase().startsWith("weixin://private/googlegetcode")) {
        break;
      }
      BindGoogleContactUI.a(this.faN, str);
      return true;
    }
    return super.onConsoleMessage(paramConsoleMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI.3
 * JD-Core Version:    0.7.0.1
 */