package com.tencent.mm.app.plugin;

import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.d.z;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.c;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.f.a.oq;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

@URISpanHandlerSet.a
class URISpanHandlerSet$TodoSystemMsgUrlSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$TodoSystemMsgUrlSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
  {
    AppMethodBeat.i(290839);
    if (paramu.type == 54) {
      Log.i("MicroMsg.URISpanHandlerSet", "handleClickTodoSystemMsgUrl");
    }
    label390:
    label396:
    for (;;)
    {
      boolean bool1;
      try
      {
        localObject1 = Uri.parse(paramu.url);
        paramView = paramu.chatroomName;
        parami = ((Uri)localObject1).getQueryParameter("todoid");
        ((Uri)localObject1).getQueryParameter("related_msgid");
        str = ((Uri)localObject1).getQueryParameter("username");
        localObject2 = ((Uri)localObject1).getQueryParameter("path");
        localObject1 = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupTodoStorage().am(paramView, parami);
        if (!Util.isEqual("roomannouncement@app.origin", str)) {
          continue;
        }
        y.f(MMApplicationContext.getContext(), paramView, true);
        bool2 = y.e((c)localObject1);
        if (!bool2) {
          break label390;
        }
        bool1 = y.b((c)localObject1);
        if (!bool1) {
          break label396;
        }
        localObject2 = new oq();
        ((oq)localObject2).fNv.op = 3;
        ((oq)localObject2).fNv.fHp = ((c)localObject1).field_roomname;
        ((oq)localObject2).fNv.fNw = parami;
        EventCenter.instance.asyncPublish((IEvent)localObject2, Looper.getMainLooper());
      }
      catch (Exception paramView)
      {
        Object localObject1;
        String str;
        Object localObject2;
        boolean bool2;
        g localg;
        Log.e("MicroMsg.URISpanHandlerSet", "handle click link error: %s, url: %s", new Object[] { paramView.getMessage(), paramu.url });
        continue;
        int i = 0;
        continue;
      }
      if (Util.isEqual("roomannouncement@app.origin", str))
      {
        i = 1;
        z.a(paramView, i, 2, parami, str);
        Log.i("MicroMsg.URISpanHandlerSet", "handleClickTodoSystemMsgUrl stoTodo(%s %s %s) update finish(%s)", new Object[] { Boolean.valueOf(Util.isNullOrNil(parami)), Boolean.valueOf(Util.isNullOrNil(str)), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        AppMethodBeat.o(290839);
        return true;
        localg = new g();
        localg.username = str;
        localg.nBq = ((String)localObject2);
        localg.scene = 1160;
        localg.fWY = paramView;
        if (localObject1 != null)
        {
          localg.cwU = ((c)localObject1).field_shareKey;
          localg.cwT = ((c)localObject1).field_shareName;
        }
        ((r)h.ae(r.class)).a(URISpanHandlerSet.a(this.fgB), localg);
      }
      else
      {
        AppMethodBeat.o(290839);
        return false;
        bool1 = false;
      }
    }
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    return false;
  }
  
  final int[] abR()
  {
    return new int[] { 54 };
  }
  
  final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
  {
    AppMethodBeat.i(179563);
    if (paramString.trim().toLowerCase().startsWith("weixin://roomtoolstodo?"))
    {
      paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 54, null);
      AppMethodBeat.o(179563);
      return paramString;
    }
    AppMethodBeat.o(179563);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.TodoSystemMsgUrlSpanHandler
 * JD-Core Version:    0.7.0.1
 */