package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.ChattingUI;

@URISpanHandlerSet.a
class URISpanHandlerSet$EnterRoomUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$EnterRoomUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.s params, Bundle paramBundle)
  {
    if (paramString.startsWith("weixin://jump/mainframe/"))
    {
      int i = paramString.trim().lastIndexOf("/");
      if ((i >= 0) && (i < paramString.trim().length() - 1))
      {
        paramString = paramString.trim().substring(i + 1);
        if (com.tencent.mm.model.s.fn(paramString))
        {
          au.Hx();
          params = c.Fw().abl(paramString);
          if ((params == null) || ((int)params.dBe == 0))
          {
            params = new ad();
            params.setUsername(paramString);
            au.Hx();
            c.Fw().V(params);
          }
        }
        paramString = new Intent(URISpanHandlerSet.a(this.byk), ChattingUI.class).putExtra("Chat_User", paramString).putExtra("Chat_Mode", 1);
        if ((URISpanHandlerSet.a(this.byk) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        URISpanHandlerSet.a(this.byk).startActivity(paramString);
        return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.EnterRoomUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */