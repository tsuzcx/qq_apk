package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.br.d;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.bk;

@URISpanHandlerSet.a
class URISpanHandlerSet$ExposeUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$ExposeUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    Intent localIntent;
    if (paramm.type == 31)
    {
      localIntent = new Intent();
      paramm = (String)paramg.a(paramm);
      localIntent.putExtra("k_username", paramm);
      if ((bk.bl(paramm)) || (!paramm.endsWith("@chatroom"))) {
        break label110;
      }
    }
    label110:
    for (int i = 36;; i = 39)
    {
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(i) }));
      d.b(URISpanHandlerSet.a(this.byk), "webview", ".ui.tools.WebViewUI", localIntent);
      return true;
      return false;
    }
  }
  
  final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    return false;
  }
  
  final m cA(String paramString)
  {
    if (paramString.trim().toLowerCase().equals("weixin://expose/")) {
      return new m(paramString, 31, null);
    }
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 31 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.ExposeUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */