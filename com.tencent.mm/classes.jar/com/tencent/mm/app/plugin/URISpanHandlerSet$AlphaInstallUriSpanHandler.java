package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.br.d;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;

@URISpanHandlerSet.a
class URISpanHandlerSet$AlphaInstallUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$AlphaInstallUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    if (paramm.type == 32)
    {
      paramm = paramm.url.replace("weixin://alphainstall?", "");
      paramg = Uri.parse(paramm).getQueryParameter("md5");
      paramg = com.tencent.mm.compatible.util.e.bkH + paramg + ".apk";
      if (com.tencent.mm.vfs.e.bK(paramg)) {
        bk.j(paramg, ae.getContext());
      }
      for (;;)
      {
        return true;
        paramg = new Intent();
        paramg.putExtra("rawUrl", paramm.toString());
        d.b(URISpanHandlerSet.a(this.byk), "webview", ".ui.tools.WebViewUI", paramg);
      }
    }
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    return false;
  }
  
  final m cA(String paramString)
  {
    if (paramString.trim().toLowerCase().startsWith("weixin://alphainstall?")) {
      return new m(paramString, 32, null);
    }
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 32 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.AlphaInstallUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */