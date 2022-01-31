package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.contact.SelectContactUI;

@URISpanHandlerSet.a
class URISpanHandlerSet$SettingBlacklistUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$SettingBlacklistUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 14 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15694);
    if (paramm.type == 14)
    {
      if (paramg != null) {
        paramg.a(paramm);
      }
      Object localObject = z.oS(URISpanHandlerSet.a(this.cam).getString(2131300540));
      Intent localIntent = new Intent();
      localIntent.setClass(URISpanHandlerSet.a(this.cam), SelectContactUI.class);
      localIntent.putExtra("Contact_GroupFilter_Type", ((y)localObject).getType());
      localIntent.putExtra("Contact_GroupFilter_DisplayName", ((y)localObject).Oe());
      localIntent.addFlags(67108864);
      localObject = LauncherUI.getInstance();
      if (localObject != null) {
        ((LauncherUI)localObject).yYT.getMainTabUI().atp("tab_settings");
      }
      URISpanHandlerSet.a(this.cam).startActivity(localIntent);
      if (paramg != null) {
        paramg.b(paramm);
      }
      AppMethodBeat.o(15694);
      return true;
    }
    AppMethodBeat.o(15694);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    AppMethodBeat.i(15695);
    if (paramString.equals("weixin://setting/blacklist"))
    {
      paramv = z.oS(URISpanHandlerSet.a(this.cam).getString(2131300540));
      paramString = new Intent();
      paramString.setClass(URISpanHandlerSet.a(this.cam), AddressUI.class);
      paramString.putExtra("Contact_GroupFilter_Type", paramv.getType());
      paramString.putExtra("Contact_GroupFilter_DisplayName", paramv.Oe());
      paramString.addFlags(67108864);
      if ((URISpanHandlerSet.a(this.cam) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      paramv = LauncherUI.getInstance();
      if (paramv != null) {
        paramv.yYT.getMainTabUI().atp("tab_settings");
      }
      URISpanHandlerSet.a(this.cam).startActivity(paramString);
      AppMethodBeat.o(15695);
      return true;
    }
    AppMethodBeat.o(15695);
    return false;
  }
  
  final m dN(String paramString)
  {
    AppMethodBeat.i(15693);
    if (paramString.trim().startsWith("weixin://setting/blacklist"))
    {
      paramString = new m(paramString, 14, null);
      AppMethodBeat.o(15693);
      return paramString;
    }
    AppMethodBeat.o(15693);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.SettingBlacklistUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */