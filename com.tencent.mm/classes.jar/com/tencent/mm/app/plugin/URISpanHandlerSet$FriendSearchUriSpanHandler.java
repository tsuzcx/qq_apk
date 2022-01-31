package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;

@URISpanHandlerSet.a
class URISpanHandlerSet$FriendSearchUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$FriendSearchUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 17 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15666);
    if (paramm.type == 17)
    {
      if (paramg != null) {
        paramg.a(paramm);
      }
      d.H(URISpanHandlerSet.a(this.cam), "subapp", ".ui.pluginapp.ContactSearchUI");
      if (paramg != null) {
        paramg.b(paramm);
      }
      AppMethodBeat.o(15666);
      return true;
    }
    AppMethodBeat.o(15666);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    AppMethodBeat.i(15667);
    if (paramString.equals("weixin://findfriend/search"))
    {
      paramString = new Intent();
      if ((URISpanHandlerSet.a(this.cam) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      d.b(URISpanHandlerSet.a(this.cam), "subapp", ".ui.pluginapp.ContactSearchUI", paramString);
      AppMethodBeat.o(15667);
      return true;
    }
    AppMethodBeat.o(15667);
    return false;
  }
  
  final m dN(String paramString)
  {
    AppMethodBeat.i(15665);
    if (paramString.trim().startsWith("weixin://findfriend/search"))
    {
      paramString = new m(paramString, 17, null);
      AppMethodBeat.o(15665);
      return paramString;
    }
    AppMethodBeat.o(15665);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.FriendSearchUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */