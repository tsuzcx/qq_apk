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
class URISpanHandlerSet$FlowStatUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$FlowStatUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 16 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15660);
    if (paramm.type == 16)
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
      AppMethodBeat.o(15660);
      return true;
    }
    AppMethodBeat.o(15660);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    AppMethodBeat.i(15661);
    if (paramString.equals("weixin://flowstat"))
    {
      paramString = LauncherUI.getInstance();
      if (paramString != null) {
        paramString.yYT.getMainTabUI().atp("tab_settings");
      }
      AppMethodBeat.o(15661);
      return true;
    }
    AppMethodBeat.o(15661);
    return false;
  }
  
  final m dN(String paramString)
  {
    AppMethodBeat.i(15659);
    if (paramString.trim().startsWith("weixin://flowstat"))
    {
      paramString = new m(paramString, 16, null);
      AppMethodBeat.o(15659);
      return paramString;
    }
    AppMethodBeat.o(15659);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.FlowStatUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */