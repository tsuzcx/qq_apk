package com.tencent.mm.app.plugin;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.h.a.td;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.b.a;

@URISpanHandlerSet.a
class URISpanHandlerSet$VoipCallAgainUrilSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$VoipCallAgainUrilSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    if (paramm.type == 38)
    {
      paramg = Uri.parse(paramm.url);
      paramm = paramg.getQueryParameter("username");
      paramg = paramg.getQueryParameter("isvideocall");
      td localtd = new td();
      localtd.ccJ.bNb = 5;
      localtd.ccJ.talker = paramm;
      localtd.ccJ.context = URISpanHandlerSet.a(this.byk);
      if ((paramm != null) && (!paramm.equals("")))
      {
        if ((paramg != null) && (paramg.equals("true"))) {}
        for (localtd.ccJ.ccE = 2;; localtd.ccJ.ccE = 4)
        {
          a.udP.m(localtd);
          return true;
        }
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
    if (paramString.trim().startsWith("weixin://voip/callagain/")) {
      return new m(paramString, 38, null);
    }
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 38 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.VoipCallAgainUrilSpanHandler
 * JD-Core Version:    0.7.0.1
 */