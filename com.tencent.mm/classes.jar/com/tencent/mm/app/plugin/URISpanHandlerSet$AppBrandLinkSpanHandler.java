package com.tencent.mm.app.plugin;

import android.os.Bundle;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.y;

@URISpanHandlerSet.a
class URISpanHandlerSet$AppBrandLinkSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$AppBrandLinkSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    if (paramm.type == 45)
    {
      if (paramg != null)
      {
        y.i("MicroMsg.URISpanHandlerSet", "AppBrandLinkSpanHandler click appbrandlink");
        paramg.b(paramm);
        return true;
      }
      y.e("MicroMsg.URISpanHandlerSet", "clickCallback is null, return");
    }
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    return false;
  }
  
  final m cA(String paramString)
  {
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 45 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.AppBrandLinkSpanHandler
 * JD-Core Version:    0.7.0.1
 */