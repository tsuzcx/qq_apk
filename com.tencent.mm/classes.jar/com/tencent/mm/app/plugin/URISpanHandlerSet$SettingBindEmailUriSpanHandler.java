package com.tencent.mm.app.plugin;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;

@URISpanHandlerSet.a
class URISpanHandlerSet$SettingBindEmailUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$SettingBindEmailUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 7 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15692);
    if (paramm.type == 7)
    {
      if (paramg != null) {
        paramg.a(paramm);
      }
      LauncherUI localLauncherUI = LauncherUI.getInstance();
      if (localLauncherUI != null) {
        localLauncherUI.yYT.getMainTabUI().atp("tab_settings");
      }
      if (paramg != null) {
        paramg.b(paramm);
      }
      AppMethodBeat.o(15692);
      return true;
    }
    AppMethodBeat.o(15692);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    return false;
  }
  
  final m dN(String paramString)
  {
    AppMethodBeat.i(15691);
    if (paramString.trim().startsWith("weixin://setting/bindemail"))
    {
      paramString = new m(paramString, 7, null);
      AppMethodBeat.o(15691);
      return paramString;
    }
    AppMethodBeat.o(15691);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.SettingBindEmailUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */