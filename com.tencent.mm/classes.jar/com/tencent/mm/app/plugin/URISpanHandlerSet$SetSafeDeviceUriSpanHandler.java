package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.platformtools.bo;
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
  
  final int[] Cf()
  {
    return new int[0];
  }
  
  final boolean a(m paramm, g paramg)
  {
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    AppMethodBeat.i(15690);
    if (paramString.equals("weixin://setting/account/safedevice"))
    {
      aw.aaz();
      paramString = (String)c.Ru().get(6, "");
      aw.aaz();
      paramv = (String)c.Ru().get(4097, "");
      if (!bo.isNullOrNil(paramString))
      {
        paramString = new Intent();
        if ((URISpanHandlerSet.a(this.cam) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        d.H(URISpanHandlerSet.a(this.cam), "account", ".security.ui.MySafeDeviceListUI");
      }
      for (;;)
      {
        AppMethodBeat.o(15690);
        return true;
        if (!bo.isNullOrNil(paramv))
        {
          paramString = new Intent(URISpanHandlerSet.a(this.cam), BindMContactIntroUI.class);
          paramString.putExtra("bind_scene", 1);
          if ((URISpanHandlerSet.a(this.cam) instanceof Service)) {
            paramString.addFlags(268435456);
          }
          MMWizardActivity.J(URISpanHandlerSet.a(this.cam), paramString);
        }
        else
        {
          paramString = new Intent();
          if ((URISpanHandlerSet.a(this.cam) instanceof Service)) {
            paramString.addFlags(268435456);
          }
          d.a(URISpanHandlerSet.a(this.cam), "account", ".security.ui.BindSafeDeviceUI", paramString);
        }
      }
    }
    AppMethodBeat.o(15690);
    return false;
  }
  
  final m dN(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.SetSafeDeviceUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */