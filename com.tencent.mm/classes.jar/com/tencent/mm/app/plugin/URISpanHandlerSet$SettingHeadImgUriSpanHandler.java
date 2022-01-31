package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.br.d;
import com.tencent.mm.model.q;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.z;

@URISpanHandlerSet.a
class URISpanHandlerSet$SettingHeadImgUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$SettingHeadImgUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    if (paramm.type == 6)
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
    if (paramString.equals("weixin://setting/setheadimage"))
    {
      paramString = new Intent();
      paramString.putExtra("Contact_User", q.Gj());
      paramString.putExtra("Contact_Nick", q.Gl());
      paramString.putExtra("User_Avatar", true);
      if ((URISpanHandlerSet.a(this.byk) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      d.b(URISpanHandlerSet.a(this.byk), "profile", ".ui.ContactInfoUI", paramString);
      return true;
    }
    return false;
  }
  
  final m cA(String paramString)
  {
    if (paramString.trim().startsWith("weixin://setting/setheadimage")) {
      return new m(paramString, 6, null);
    }
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 6 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.SettingHeadImgUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */