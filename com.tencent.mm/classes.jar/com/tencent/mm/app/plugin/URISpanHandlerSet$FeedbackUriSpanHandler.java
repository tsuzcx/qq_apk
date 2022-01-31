package com.tencent.mm.app.plugin;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.setting.model.j;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.platformtools.ab;

@URISpanHandlerSet.a
class URISpanHandlerSet$FeedbackUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$FeedbackUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 34 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15658);
    if (paramm.type == 34)
    {
      paramg = paramm.url.trim().replace("weixin://feedback/next/", "");
      ab.d("MicroMsg.URISpanHandlerSet", "FeedbackUriSpanHandler, url:%s, content:%s", new Object[] { paramm.url, paramg });
      aw.Rc().a(new j(q.LO(), paramg, 8), 0);
      AppMethodBeat.o(15658);
      return true;
    }
    AppMethodBeat.o(15658);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    return false;
  }
  
  final m dN(String paramString)
  {
    AppMethodBeat.i(15657);
    if (paramString.trim().startsWith("weixin://feedback/next/"))
    {
      paramString = new m(paramString, 34, null);
      AppMethodBeat.o(15657);
      return paramString;
    }
    AppMethodBeat.o(15657);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.FeedbackUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */