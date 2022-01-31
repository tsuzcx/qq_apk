package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.br.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;

@URISpanHandlerSet.a
class URISpanHandlerSet$SetSafeDeviceUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$SetSafeDeviceUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    if (paramString.equals("weixin://setting/account/safedevice"))
    {
      au.Hx();
      paramString = (String)c.Dz().get(6, "");
      au.Hx();
      params = (String)c.Dz().get(4097, "");
      if (!bk.bl(paramString))
      {
        paramString = new Intent();
        if ((URISpanHandlerSet.a(this.byk) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        d.x(URISpanHandlerSet.a(this.byk), "account", ".security.ui.MySafeDeviceListUI");
      }
      for (;;)
      {
        return true;
        if (!bk.bl(params))
        {
          paramString = new Intent(URISpanHandlerSet.a(this.byk), BindMContactIntroUI.class);
          paramString.putExtra("is_bind_for_safe_device", true);
          if ((URISpanHandlerSet.a(this.byk) instanceof Service)) {
            paramString.addFlags(268435456);
          }
          MMWizardActivity.C(URISpanHandlerSet.a(this.byk), paramString);
        }
        else
        {
          paramString = new Intent();
          if ((URISpanHandlerSet.a(this.byk) instanceof Service)) {
            paramString.addFlags(268435456);
          }
          d.a(URISpanHandlerSet.a(this.byk), "account", ".security.ui.BindSafeDeviceUI", paramString);
        }
      }
    }
    return false;
  }
  
  final m cA(String paramString)
  {
    return null;
  }
  
  final int[] tA()
  {
    return new int[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.SetSafeDeviceUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */