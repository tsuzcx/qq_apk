package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;
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
  
  final int[] Cf()
  {
    return new int[] { 9 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15700);
    if (paramm.type == 9)
    {
      if (paramg != null) {
        paramg.a(paramm);
      }
      LauncherUI localLauncherUI = LauncherUI.getInstance();
      if (localLauncherUI != null) {
        localLauncherUI.yYT.getMainTabUI().atp("tab_settings");
      }
      d.H(URISpanHandlerSet.a(this.cam), "setting", ".ui.setting.SettingsNotificationUI");
      if (paramg != null) {
        paramg.b(paramm);
      }
      AppMethodBeat.o(15700);
      return true;
    }
    AppMethodBeat.o(15700);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    AppMethodBeat.i(15701);
    if (paramString.equals("weixin://setting/notify"))
    {
      paramString = LauncherUI.getInstance();
      if (paramString != null) {
        paramString.yYT.getMainTabUI().atp("tab_settings");
      }
      paramString = new Intent();
      paramString.addFlags(67108864);
      if ((URISpanHandlerSet.a(this.cam) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      d.b(URISpanHandlerSet.a(this.cam), "setting", ".ui.setting.SettingsNotificationUI", paramString);
      AppMethodBeat.o(15701);
      return true;
    }
    AppMethodBeat.o(15701);
    return false;
  }
  
  final m dN(String paramString)
  {
    AppMethodBeat.i(15699);
    if (paramString.trim().startsWith("weixin://setting/notify"))
    {
      paramString = new m(paramString, 9, null);
      AppMethodBeat.o(15699);
      return paramString;
    }
    AppMethodBeat.o(15699);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.SettingNotifyUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */