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
class URISpanHandlerSet$SettingPrivacyUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$SettingPrivacyUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 15 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15711);
    if (paramm.type == 15)
    {
      if (paramg != null) {
        paramg.a(paramm);
      }
      LauncherUI localLauncherUI = LauncherUI.getInstance();
      if (localLauncherUI != null) {
        localLauncherUI.yYT.getMainTabUI().atp("tab_settings");
      }
      d.H(URISpanHandlerSet.a(this.cam), "setting", ".ui.setting.SettingsPrivacyUI");
      if (paramg != null) {
        paramg.b(paramm);
      }
      AppMethodBeat.o(15711);
      return true;
    }
    AppMethodBeat.o(15711);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    AppMethodBeat.i(15712);
    if (paramString.equals("weixin://setting/privacy"))
    {
      paramString = LauncherUI.getInstance();
      if (paramString != null) {
        paramString.yYT.getMainTabUI().atp("tab_settings");
      }
      paramString = new Intent();
      if ((URISpanHandlerSet.a(this.cam) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      d.b(URISpanHandlerSet.a(this.cam), "setting", ".ui.setting.SettingsPrivacyUI", paramString);
      AppMethodBeat.o(15712);
      return true;
    }
    AppMethodBeat.o(15712);
    return false;
  }
  
  final m dN(String paramString)
  {
    AppMethodBeat.i(15710);
    if (paramString.trim().startsWith("weixin://setting/privacy"))
    {
      paramString = new m(paramString, 15, null);
      AppMethodBeat.o(15710);
      return paramString;
    }
    AppMethodBeat.o(15710);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.SettingPrivacyUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */