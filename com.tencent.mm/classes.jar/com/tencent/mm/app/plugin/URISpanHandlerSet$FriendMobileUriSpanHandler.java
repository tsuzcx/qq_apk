package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;

@URISpanHandlerSet.a
class URISpanHandlerSet$FriendMobileUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$FriendMobileUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    if (paramm.type == 20)
    {
      if (paramg != null) {
        paramg.a(paramm);
      }
      Intent localIntent = new Intent(URISpanHandlerSet.a(this.byk), MobileFriendUI.class);
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
    if (paramString.equals("weixin://findfriend/mobile"))
    {
      paramString = new Intent(URISpanHandlerSet.a(this.byk), MobileFriendUI.class);
      if ((URISpanHandlerSet.a(this.byk) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      URISpanHandlerSet.a(this.byk).startActivity(paramString);
      return true;
    }
    return false;
  }
  
  final m cA(String paramString)
  {
    if (paramString.trim().startsWith("weixin://findfriend/mobile")) {
      return new m(paramString, 20, null);
    }
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 20 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.FriendMobileUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */