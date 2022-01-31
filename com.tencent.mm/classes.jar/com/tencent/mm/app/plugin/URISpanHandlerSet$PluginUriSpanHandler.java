package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;

@URISpanHandlerSet.a
class URISpanHandlerSet$PluginUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$PluginUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 26 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    AppMethodBeat.i(15685);
    if (paramString.equals("weixin://plugin"))
    {
      paramString = new Intent();
      if ((URISpanHandlerSet.a(this.cam) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      d.b(URISpanHandlerSet.a(this.cam), "setting", ".ui.setting.SettingsPluginsUI", paramString);
      AppMethodBeat.o(15685);
      return true;
    }
    AppMethodBeat.o(15685);
    return false;
  }
  
  final m dN(String paramString)
  {
    AppMethodBeat.i(15684);
    if (paramString.trim().startsWith("weixin://plugin"))
    {
      paramString = new m(paramString, 26, null);
      AppMethodBeat.o(15684);
      return paramString;
    }
    AppMethodBeat.o(15684);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.PluginUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */