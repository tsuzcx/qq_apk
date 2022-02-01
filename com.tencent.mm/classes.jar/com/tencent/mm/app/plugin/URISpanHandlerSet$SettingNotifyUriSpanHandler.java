package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;

@URISpanHandlerSet.a
class URISpanHandlerSet$SettingNotifyUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$SettingNotifyUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
  {
    AppMethodBeat.i(271916);
    if (paramu.type == 9)
    {
      if (parami != null) {
        parami.a(paramu);
      }
      paramView = LauncherUI.getInstance();
      if (paramView != null) {
        paramView.VXk.getMainTabUI().byt("tab_settings");
      }
      c.ad(URISpanHandlerSet.a(this.fgB), "setting", ".ui.setting.SettingsNotificationUI");
      if (parami != null) {
        parami.b(paramu);
      }
      AppMethodBeat.o(271916);
      return true;
    }
    AppMethodBeat.o(271916);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    AppMethodBeat.i(19747);
    if (paramString.equals("weixin://setting/notify"))
    {
      paramString = LauncherUI.getInstance();
      if (paramString != null) {
        paramString.VXk.getMainTabUI().byt("tab_settings");
      }
      paramString = new Intent();
      paramString.addFlags(67108864);
      if ((URISpanHandlerSet.a(this.fgB) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      c.b(URISpanHandlerSet.a(this.fgB), "setting", ".ui.setting.SettingsNotificationUI", paramString);
      AppMethodBeat.o(19747);
      return true;
    }
    AppMethodBeat.o(19747);
    return false;
  }
  
  final int[] abR()
  {
    return new int[] { 9 };
  }
  
  final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
  {
    AppMethodBeat.i(19745);
    if (paramString.trim().startsWith("weixin://setting/notify"))
    {
      paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 9, null);
      AppMethodBeat.o(19745);
      return paramString;
    }
    AppMethodBeat.o(19745);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.SettingNotifyUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */