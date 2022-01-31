package com.tencent.mm.app.plugin;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.platformtools.ab;

@URISpanHandlerSet.a
class URISpanHandlerSet$AppBrandLinkSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$AppBrandLinkSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 45 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15635);
    if (paramm.type == 45)
    {
      if (paramg != null)
      {
        ab.i("MicroMsg.URISpanHandlerSet", "AppBrandLinkSpanHandler click appbrandlink");
        paramg.b(paramm);
        AppMethodBeat.o(15635);
        return true;
      }
      ab.e("MicroMsg.URISpanHandlerSet", "clickCallback is null, return");
    }
    AppMethodBeat.o(15635);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    return false;
  }
  
  final m dN(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.AppBrandLinkSpanHandler
 * JD-Core Version:    0.7.0.1
 */