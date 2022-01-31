package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.model.x;
import com.tencent.mm.model.y;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.z;

@URISpanHandlerSet.a
class URISpanHandlerSet$SettingBlacklistUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$SettingBlacklistUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    if (paramm.type == 14)
    {
      if (paramg != null) {
        paramg.a(paramm);
      }
      Object localObject = y.il(URISpanHandlerSet.a(this.byk).getString(R.l.group_blacklist));
      Intent localIntent = new Intent();
      localIntent.setClass(URISpanHandlerSet.a(this.byk), SelectContactUI.class);
      localIntent.putExtra("Contact_GroupFilter_Type", ((x)localObject).getType());
      localIntent.putExtra("Contact_GroupFilter_DisplayName", ((x)localObject).Bp());
      localIntent.addFlags(67108864);
      localObject = LauncherUI.cyX();
      if (localObject != null) {
        ((LauncherUI)localObject).uKP.uKi.acW("tab_settings");
      }
      URISpanHandlerSet.a(this.byk).startActivity(localIntent);
      if (paramg != null) {
        paramg.b(paramm);
      }
      return true;
    }
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    if (paramString.equals("weixin://setting/blacklist"))
    {
      params = y.il(URISpanHandlerSet.a(this.byk).getString(R.l.group_blacklist));
      paramString = new Intent();
      paramString.setClass(URISpanHandlerSet.a(this.byk), AddressUI.class);
      paramString.putExtra("Contact_GroupFilter_Type", params.getType());
      paramString.putExtra("Contact_GroupFilter_DisplayName", params.Bp());
      paramString.addFlags(67108864);
      if ((URISpanHandlerSet.a(this.byk) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      params = LauncherUI.cyX();
      if (params != null) {
        params.uKP.uKi.acW("tab_settings");
      }
      URISpanHandlerSet.a(this.byk).startActivity(paramString);
      return true;
    }
    return false;
  }
  
  final m cA(String paramString)
  {
    if (paramString.trim().startsWith("weixin://setting/blacklist")) {
      return new m(paramString, 14, null);
    }
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 14 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.SettingBlacklistUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */