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
class URISpanHandlerSet$FriendShareUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$FriendShareUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 18 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15669);
    if (paramm.type == 18)
    {
      if (paramg != null) {
        paramg.a(paramm);
      }
      d.H(URISpanHandlerSet.a(this.cam), "setting", ".ui.qrcode.ShareMicroMsgChoiceUI");
      if (paramg != null) {
        paramg.b(paramm);
      }
      AppMethodBeat.o(15669);
      return true;
    }
    AppMethodBeat.o(15669);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    AppMethodBeat.i(15670);
    if (paramString.equals("weixin://findfriend/share"))
    {
      paramString = new Intent();
      if ((URISpanHandlerSet.a(this.cam) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      d.b(URISpanHandlerSet.a(this.cam), "setting", ".ui.qrcode.ShareMicroMsgChoiceUI", paramString);
      AppMethodBeat.o(15670);
      return true;
    }
    AppMethodBeat.o(15670);
    return false;
  }
  
  final m dN(String paramString)
  {
    AppMethodBeat.i(15668);
    if (paramString.trim().startsWith("weixin://findfriend/share"))
    {
      paramString = new m(paramString, 18, null);
      AppMethodBeat.o(15668);
      return paramString;
    }
    AppMethodBeat.o(15668);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.FriendShareUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */