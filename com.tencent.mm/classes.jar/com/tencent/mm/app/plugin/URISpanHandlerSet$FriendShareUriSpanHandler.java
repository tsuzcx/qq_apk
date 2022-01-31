package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.br.d;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;

@URISpanHandlerSet.a
class URISpanHandlerSet$FriendShareUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$FriendShareUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    if (paramm.type == 18)
    {
      if (paramg != null) {
        paramg.a(paramm);
      }
      d.x(URISpanHandlerSet.a(this.byk), "setting", ".ui.qrcode.ShareMicroMsgChoiceUI");
      if (paramg != null) {
        paramg.b(paramm);
      }
      return true;
    }
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    if (paramString.equals("weixin://findfriend/share"))
    {
      paramString = new Intent();
      if ((URISpanHandlerSet.a(this.byk) instanceof Service)) {
        paramString.addFlags(268435456);
      }
      d.b(URISpanHandlerSet.a(this.byk), "setting", ".ui.qrcode.ShareMicroMsgChoiceUI", paramString);
      return true;
    }
    return false;
  }
  
  final m cA(String paramString)
  {
    if (paramString.trim().startsWith("weixin://findfriend/share")) {
      return new m(paramString, 18, null);
    }
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 18 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.FriendShareUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */