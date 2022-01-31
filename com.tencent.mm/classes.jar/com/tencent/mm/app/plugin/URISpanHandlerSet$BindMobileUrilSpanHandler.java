package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.ui.MMWizardActivity;

@URISpanHandlerSet.a
class URISpanHandlerSet$BindMobileUrilSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$BindMobileUrilSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    if (paramm.type == 5)
    {
      if (paramg != null) {
        paramg.a(paramm);
      }
      MMWizardActivity.C(URISpanHandlerSet.a(this.byk), new Intent(URISpanHandlerSet.a(this.byk), BindMContactIntroUI.class));
      if (paramg != null) {
        paramg.b(paramm);
      }
      return true;
    }
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    if (paramString.equals("weixin://setting/bindphone"))
    {
      paramString = new Intent(URISpanHandlerSet.a(this.byk), BindMContactIntroUI.class);
      if ((URISpanHandlerSet.a(this.byk) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      MMWizardActivity.C(URISpanHandlerSet.a(this.byk), paramString);
      return true;
    }
    return false;
  }
  
  final m cA(String paramString)
  {
    if (paramString.trim().startsWith("weixin://setting/bindphone")) {
      return new m(paramString, 5, null);
    }
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 5 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.BindMobileUrilSpanHandler
 * JD-Core Version:    0.7.0.1
 */