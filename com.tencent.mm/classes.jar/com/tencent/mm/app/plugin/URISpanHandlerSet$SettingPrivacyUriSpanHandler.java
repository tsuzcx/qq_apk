package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.br.d;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.z;

@URISpanHandlerSet.a
class URISpanHandlerSet$SettingPrivacyUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$SettingPrivacyUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    if (paramm.type == 15)
    {
      if (paramg != null) {
        paramg.a(paramm);
      }
      LauncherUI localLauncherUI = LauncherUI.cyX();
      if (localLauncherUI != null) {
        localLauncherUI.uKP.uKi.acW("tab_settings");
      }
      d.x(URISpanHandlerSet.a(this.byk), "setting", ".ui.setting.SettingsPrivacyUI");
      if (paramg != null) {
        paramg.b(paramm);
      }
      return true;
    }
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    if (paramString.equals("weixin://setting/privacy"))
    {
      paramString = LauncherUI.cyX();
      if (paramString != null) {
        paramString.uKP.uKi.acW("tab_settings");
      }
      paramString = new Intent();
      if ((URISpanHandlerSet.a(this.byk) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      d.b(URISpanHandlerSet.a(this.byk), "setting", ".ui.setting.SettingsPrivacyUI", paramString);
      return true;
    }
    return false;
  }
  
  final m cA(String paramString)
  {
    if (paramString.trim().startsWith("weixin://setting/privacy")) {
      return new m(paramString, 15, null);
    }
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 15 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.SettingPrivacyUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */