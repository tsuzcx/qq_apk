package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;

@URISpanHandlerSet.a
class URISpanHandlerSet$SettingPrivacyUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$SettingPrivacyUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Xp()
  {
    return new int[] { 15 };
  }
  
  final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
  {
    AppMethodBeat.i(231452);
    if (paramu.type == 15)
    {
      if (parami != null) {
        parami.a(paramu);
      }
      paramView = LauncherUI.getInstance();
      if (paramView != null) {
        paramView.ODR.getMainTabUI().blU("tab_settings");
      }
      c.V(URISpanHandlerSet.a(this.dnW), "setting", ".ui.setting.SettingsPrivacyUI");
      if (parami != null) {
        parami.b(paramu);
      }
      AppMethodBeat.o(231452);
      return true;
    }
    AppMethodBeat.o(231452);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    AppMethodBeat.i(19758);
    if (paramString.equals("weixin://setting/privacy"))
    {
      paramString = LauncherUI.getInstance();
      if (paramString != null) {
        paramString.ODR.getMainTabUI().blU("tab_settings");
      }
      paramString = new Intent();
      if ((URISpanHandlerSet.a(this.dnW) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      c.b(URISpanHandlerSet.a(this.dnW), "setting", ".ui.setting.SettingsPrivacyUI", paramString);
      AppMethodBeat.o(19758);
      return true;
    }
    AppMethodBeat.o(19758);
    return false;
  }
  
  final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
  {
    AppMethodBeat.i(19756);
    if (paramString.trim().startsWith("weixin://setting/privacy"))
    {
      paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 15, null);
      AppMethodBeat.o(19756);
      return paramString;
    }
    AppMethodBeat.o(19756);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.SettingPrivacyUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */