package com.tencent.mm.plugin.account.bind.ui;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.w;

final class BindGoogleContactUI$2
  extends w
{
  BindGoogleContactUI$2(BindGoogleContactUI paramBindGoogleContactUI) {}
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(13349);
    ab.d("MicroMsg.GoogleContact.BindGoogleContactUI", "shouldOverrideUrlLoading, url = %s", new Object[] { paramString });
    if (paramString.toLowerCase().startsWith("weixin://private/googlegetcode"))
    {
      BindGoogleContactUI.a(this.gsF, paramString);
      AppMethodBeat.o(13349);
      return true;
    }
    boolean bool = super.a(paramWebView, paramString);
    AppMethodBeat.o(13349);
    return bool;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(13348);
    ab.d("MicroMsg.GoogleContact.BindGoogleContactUI", "onPageFinished URL:".concat(String.valueOf(paramString)));
    if ((BindGoogleContactUI.a(this.gsF) != null) && (BindGoogleContactUI.a(this.gsF).getVisibility() != 0))
    {
      BindGoogleContactUI.a(this.gsF).setVisibility(0);
      if (BindGoogleContactUI.b(this.gsF) != null) {
        BindGoogleContactUI.b(this.gsF).setVisibility(4);
      }
    }
    BindGoogleContactUI.c(this.gsF);
    if (paramWebView != null)
    {
      paramWebView = paramWebView.getTitle();
      ab.d("MicroMsg.GoogleContact.BindGoogleContactUI", "title:%s", new Object[] { paramWebView });
      if (!TextUtils.isEmpty(paramWebView))
      {
        if (paramWebView.toLowerCase().contains("success"))
        {
          if (BindGoogleContactUI.a(this.gsF) != null) {
            BindGoogleContactUI.a(this.gsF).setVisibility(4);
          }
          u.b(BindGoogleContactUI.a(this.gsF), "weixin://private/googlegetcode", "document.getElementById('code').value");
          AppMethodBeat.o(13348);
          return;
        }
        if (paramWebView.toLowerCase().contains("error")) {
          ab.w("MicroMsg.GoogleContact.BindGoogleContactUI", "failed." + paramWebView.substring(paramWebView.indexOf("=")));
        }
      }
    }
    AppMethodBeat.o(13348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI.2
 * JD-Core Version:    0.7.0.1
 */