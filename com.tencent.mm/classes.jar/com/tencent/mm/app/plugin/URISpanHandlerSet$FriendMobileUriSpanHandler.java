package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;

@URISpanHandlerSet.a
class URISpanHandlerSet$FriendMobileUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$FriendMobileUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 20 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15663);
    if (paramm.type == 20)
    {
      if (paramg != null) {
        paramg.a(paramm);
      }
      Intent localIntent = new Intent(URISpanHandlerSet.a(this.cam), MobileFriendUI.class);
      URISpanHandlerSet.a(this.cam).startActivity(localIntent);
      if (paramg != null) {
        paramg.b(paramm);
      }
      AppMethodBeat.o(15663);
      return true;
    }
    AppMethodBeat.o(15663);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    AppMethodBeat.i(15664);
    if (paramString.equals("weixin://findfriend/mobile"))
    {
      paramString = new Intent(URISpanHandlerSet.a(this.cam), MobileFriendUI.class);
      if ((URISpanHandlerSet.a(this.cam) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      URISpanHandlerSet.a(this.cam).startActivity(paramString);
      AppMethodBeat.o(15664);
      return true;
    }
    AppMethodBeat.o(15664);
    return false;
  }
  
  final m dN(String paramString)
  {
    AppMethodBeat.i(15662);
    if (paramString.trim().startsWith("weixin://findfriend/mobile"))
    {
      paramString = new m(paramString, 20, null);
      AppMethodBeat.o(15662);
      return paramString;
    }
    AppMethodBeat.o(15662);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.FriendMobileUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */