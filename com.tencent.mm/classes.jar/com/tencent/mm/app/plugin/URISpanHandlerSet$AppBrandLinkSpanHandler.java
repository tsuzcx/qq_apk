package com.tencent.mm.app.plugin;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.sdk.platformtools.Log;

@URISpanHandlerSet.a
class URISpanHandlerSet$AppBrandLinkSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$AppBrandLinkSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Xp()
  {
    return new int[] { 45 };
  }
  
  final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
  {
    AppMethodBeat.i(231418);
    if (paramu.type == 45)
    {
      if ((paramu.fromScene == 1) && (paramu.dTX != null)) {
        l.S(paramu.dTX);
      }
      if (parami != null)
      {
        Log.i("MicroMsg.URISpanHandlerSet", "AppBrandLinkSpanHandler click appbrandlink");
        parami.b(paramu);
        AppMethodBeat.o(231418);
        return true;
      }
      Log.e("MicroMsg.URISpanHandlerSet", "clickCallback is null, return");
    }
    AppMethodBeat.o(231418);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    return false;
  }
  
  final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.AppBrandLinkSpanHandler
 * JD-Core Version:    0.7.0.1
 */