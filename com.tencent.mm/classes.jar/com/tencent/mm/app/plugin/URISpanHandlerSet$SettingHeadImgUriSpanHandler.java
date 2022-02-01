package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.span.i;
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
  
  final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
  {
    AppMethodBeat.i(209012);
    if (paramu.type == 6)
    {
      if (parami != null) {
        parami.a(paramu);
      }
      paramView = LauncherUI.getInstance();
      if (paramView != null) {
        paramView.VXk.getMainTabUI().byt("tab_settings");
      }
      if (parami != null) {
        parami.b(paramu);
      }
      AppMethodBeat.o(209012);
      return true;
    }
    AppMethodBeat.o(209012);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    AppMethodBeat.i(19744);
    if (paramString.equals("weixin://setting/setheadimage"))
    {
      paramString = new Intent();
      paramString.putExtra("Contact_User", z.bcZ());
      paramString.putExtra("Contact_Nick", z.bdb());
      paramString.putExtra("User_Avatar", true);
      if ((URISpanHandlerSet.a(this.fgB) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      c.b(URISpanHandlerSet.a(this.fgB), "profile", ".ui.ContactInfoUI", paramString);
      AppMethodBeat.o(19744);
      return true;
    }
    AppMethodBeat.o(19744);
    return false;
  }
  
  final int[] abR()
  {
    return new int[] { 6 };
  }
  
  final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
  {
    AppMethodBeat.i(19742);
    if (paramString.trim().startsWith("weixin://setting/setheadimage"))
    {
      paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 6, null);
      AppMethodBeat.o(19742);
      return paramString;
    }
    AppMethodBeat.o(19742);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.SettingHeadImgUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */