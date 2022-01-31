package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.n.a;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;
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
    AppMethodBeat.i(15654);
    if (paramString.startsWith("weixin://jump/mainframe/"))
    {
      int i = paramString.trim().lastIndexOf("/");
      if ((i >= 0) && (i < paramString.trim().length() - 1))
      {
        paramString = paramString.trim().substring(i + 1);
        if (t.lA(paramString))
        {
          aw.aaz();
          paramv = c.YA().arw(paramString);
          if ((paramv == null) || ((int)paramv.euF == 0))
          {
            paramv = new ad();
            paramv.setUsername(paramString);
            aw.aaz();
            c.YA().Y(paramv);
          }
        }
        paramString = new Intent(URISpanHandlerSet.a(this.cam), ChattingUI.class).putExtra("Chat_User", paramString).putExtra("Chat_Mode", 1);
        if ((URISpanHandlerSet.a(this.cam) instanceof Service)) {
          paramString.addFlags(268435456);
        }
        URISpanHandlerSet.a(this.cam).startActivity(paramString);
        AppMethodBeat.o(15654);
        return true;
      }
    }
    AppMethodBeat.o(15654);
    return false;
  }
  
  final m dN(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.EnterRoomUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */