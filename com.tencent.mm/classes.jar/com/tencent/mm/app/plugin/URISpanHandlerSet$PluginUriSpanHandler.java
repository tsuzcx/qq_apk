package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.br.d;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;

@URISpanHandlerSet.a
class URISpanHandlerSet$PluginUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$PluginUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    if (paramString.equals("weixin://plugin"))
    {
      paramString = new Intent();
      if ((URISpanHandlerSet.a(this.byk) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      d.b(URISpanHandlerSet.a(this.byk), "setting", ".ui.setting.SettingsPluginsUI", paramString);
      return true;
    }
    return false;
  }
  
  final m cA(String paramString)
  {
    if (paramString.trim().startsWith("weixin://plugin")) {
      return new m(paramString, 26, null);
    }
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 26 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.PluginUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */