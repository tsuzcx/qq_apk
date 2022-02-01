package com.tencent.mm.app.plugin;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.i;
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
  
  final int[] Xp()
  {
    return new int[] { 16 };
  }
  
  final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
  {
    AppMethodBeat.i(231429);
    if (paramu.type == 16)
    {
      if (parami != null) {
        parami.a(paramu);
      }
      paramView = LauncherUI.getInstance();
      if (paramView != null) {
        paramView.ODR.getMainTabUI().blU("tab_settings");
      }
      if (parami != null) {
        parami.b(paramu);
      }
      AppMethodBeat.o(231429);
      return true;
    }
    AppMethodBeat.o(231429);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    AppMethodBeat.i(19707);
    if (paramString.equals("weixin://flowstat"))
    {
      paramString = LauncherUI.getInstance();
      if (paramString != null) {
        paramString.ODR.getMainTabUI().blU("tab_settings");
      }
      AppMethodBeat.o(19707);
      return true;
    }
    AppMethodBeat.o(19707);
    return false;
  }
  
  final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
  {
    AppMethodBeat.i(19705);
    if (paramString.trim().startsWith("weixin://flowstat"))
    {
      paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 16, null);
      AppMethodBeat.o(19705);
      return paramString;
    }
    AppMethodBeat.o(19705);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.FlowStatUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */