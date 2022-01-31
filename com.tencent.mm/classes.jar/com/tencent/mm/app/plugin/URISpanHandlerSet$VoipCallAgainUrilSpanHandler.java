package com.tencent.mm.app.plugin;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.b.a;

@URISpanHandlerSet.a
class URISpanHandlerSet$VoipCallAgainUrilSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$VoipCallAgainUrilSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 38 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15721);
    if (paramm.type == 38)
    {
      paramg = Uri.parse(paramm.url);
      paramm = paramg.getQueryParameter("username");
      paramg = paramg.getQueryParameter("isvideocall");
      ux localux = new ux();
      localux.cLs.cut = 5;
      localux.cLs.talker = paramm;
      localux.cLs.context = URISpanHandlerSet.a(this.cam);
      if ((paramm != null) && (!paramm.equals("")))
      {
        if ((paramg != null) && (paramg.equals("true"))) {}
        for (localux.cLs.cLm = 2;; localux.cLs.cLm = 4)
        {
          a.ymk.l(localux);
          AppMethodBeat.o(15721);
          return true;
        }
      }
    }
    AppMethodBeat.o(15721);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    return false;
  }
  
  final m dN(String paramString)
  {
    AppMethodBeat.i(15720);
    if (paramString.trim().startsWith("weixin://voip/callagain/"))
    {
      paramString = new m(paramString, 38, null);
      AppMethodBeat.o(15720);
      return paramString;
    }
    AppMethodBeat.o(15720);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.VoipCallAgainUrilSpanHandler
 * JD-Core Version:    0.7.0.1
 */