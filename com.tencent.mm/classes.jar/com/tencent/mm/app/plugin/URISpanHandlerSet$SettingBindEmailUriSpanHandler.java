package com.tencent.mm.app.plugin;

import android.os.Bundle;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.z;

@URISpanHandlerSet.a
class URISpanHandlerSet$SettingBindEmailUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$SettingBindEmailUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    if (paramm.type == 7)
    {
      if (paramg != null) {
        paramg.a(paramm);
      }
      LauncherUI localLauncherUI = LauncherUI.cyX();
      if (localLauncherUI != null) {
        localLauncherUI.uKP.uKi.acW("tab_settings");
      }
      if (paramg != null) {
        paramg.b(paramm);
      }
      return true;
    }
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    return false;
  }
  
  final m cA(String paramString)
  {
    if (paramString.trim().startsWith("weixin://setting/bindemail")) {
      return new m(paramString, 7, null);
    }
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 7 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.SettingBindEmailUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */