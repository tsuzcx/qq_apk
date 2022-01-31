package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;

@URISpanHandlerSet.a
class URISpanHandlerSet$SettingHeadImgUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$SettingHeadImgUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 6 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15697);
    if (paramm.type == 6)
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
      AppMethodBeat.o(15697);
      return true;
    }
    AppMethodBeat.o(15697);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    AppMethodBeat.i(15698);
    if (paramString.equals("weixin://setting/setheadimage"))
    {
      paramString = new Intent();
      paramString.putExtra("Contact_User", r.Zn());
      paramString.putExtra("Contact_Nick", r.Zp());
      paramString.putExtra("User_Avatar", true);
      if ((URISpanHandlerSet.a(this.cam) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      d.b(URISpanHandlerSet.a(this.cam), "profile", ".ui.ContactInfoUI", paramString);
      AppMethodBeat.o(15698);
      return true;
    }
    AppMethodBeat.o(15698);
    return false;
  }
  
  final m dN(String paramString)
  {
    AppMethodBeat.i(15696);
    if (paramString.trim().startsWith("weixin://setting/setheadimage"))
    {
      paramString = new m(paramString, 6, null);
      AppMethodBeat.o(15696);
      return paramString;
    }
    AppMethodBeat.o(15696);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.SettingHeadImgUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */