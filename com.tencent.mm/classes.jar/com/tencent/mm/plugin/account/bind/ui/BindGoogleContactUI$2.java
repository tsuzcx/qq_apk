package com.tencent.mm.plugin.account.bind.ui;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

final class BindGoogleContactUI$2
  extends p
{
  BindGoogleContactUI$2(BindGoogleContactUI paramBindGoogleContactUI) {}
  
  public final void a(WebView paramWebView, String paramString)
  {
    y.d("MicroMsg.GoogleContact.BindGoogleContactUI", "onPageFinished URL:" + paramString);
    if ((BindGoogleContactUI.a(this.faN) != null) && (BindGoogleContactUI.a(this.faN).getVisibility() != 0))
    {
      BindGoogleContactUI.a(this.faN).setVisibility(0);
      if (BindGoogleContactUI.b(this.faN) != null) {
        BindGoogleContactUI.b(this.faN).setVisibility(4);
      }
    }
    BindGoogleContactUI.c(this.faN);
    if (paramWebView != null)
    {
      paramWebView = paramWebView.getTitle();
      y.d("MicroMsg.GoogleContact.BindGoogleContactUI", "title:%s", new Object[] { paramWebView });
      if (!TextUtils.isEmpty(paramWebView))
      {
        if (!paramWebView.toLowerCase().contains("success")) {
          break label162;
        }
        if (BindGoogleContactUI.a(this.faN) != null) {
          BindGoogleContactUI.a(this.faN).setVisibility(4);
        }
        s.c(BindGoogleContactUI.a(this.faN), "weixin://private/googlegetcode", "document.getElementById('code').value");
      }
    }
    label162:
    while (!paramWebView.toLowerCase().contains("error")) {
      return;
    }
    y.w("MicroMsg.GoogleContact.BindGoogleContactUI", "failed." + paramWebView.substring(paramWebView.indexOf("=")));
  }
  
  public final boolean b(WebView paramWebView, String paramString)
  {
    y.d("MicroMsg.GoogleContact.BindGoogleContactUI", "shouldOverrideUrlLoading, url = %s", new Object[] { paramString });
    if (paramString.toLowerCase().startsWith("weixin://private/googlegetcode"))
    {
      BindGoogleContactUI.a(this.faN, paramString);
      return true;
    }
    return super.b(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI.2
 * JD-Core Version:    0.7.0.1
 */