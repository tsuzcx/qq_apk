package com.tencent.mm.app.plugin;

import android.os.Bundle;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;

abstract class URISpanHandlerSet$BaseUriSpanHandler
{
  public URISpanHandlerSet$BaseUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet) {}
  
  abstract boolean a(m paramm, g paramg);
  
  abstract boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle);
  
  abstract m cA(String paramString);
  
  abstract int[] tA();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */