package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.platformtools.bo;

@URISpanHandlerSet.a
class URISpanHandlerSet$ExposeUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$ExposeUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 31 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15656);
    Intent localIntent;
    if (paramm.type == 31)
    {
      localIntent = new Intent();
      if (paramg == null)
      {
        AppMethodBeat.o(15656);
        return false;
      }
      paramm = (String)paramg.a(paramm);
      localIntent.putExtra("k_username", paramm);
      if ((bo.isNullOrNil(paramm)) || (!paramm.endsWith("@chatroom"))) {
        break label140;
      }
    }
    label140:
    for (int i = 36;; i = 39)
    {
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(i) }));
      d.b(URISpanHandlerSet.a(this.cam), "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(15656);
      return true;
      AppMethodBeat.o(15656);
      return false;
    }
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    return false;
  }
  
  final m dN(String paramString)
  {
    AppMethodBeat.i(15655);
    if (paramString.trim().toLowerCase().equals("weixin://expose/"))
    {
      paramString = new m(paramString, 31, null);
      AppMethodBeat.o(15655);
      return paramString;
    }
    AppMethodBeat.o(15655);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.ExposeUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */