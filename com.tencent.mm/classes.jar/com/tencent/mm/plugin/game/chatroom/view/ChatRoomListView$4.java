package com.tencent.mm.plugin.game.chatroom.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.game.autogen.chatroom.Color;
import com.tencent.mm.plugin.game.autogen.chatroom.ContentBlock;
import com.tencent.mm.plugin.game.autogen.chatroom.GetFirstEnterInfoRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetFirstEnterInfoResponse;
import com.tencent.mm.plugin.game.chatroom.e;
import com.tencent.mm.plugin.game.chatroom.f.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import java.util.Iterator;
import java.util.LinkedList;

public final class ChatRoomListView$4
  implements aa.a
{
  public ChatRoomListView$4(ChatRoomListView paramChatRoomListView, GetFirstEnterInfoRequest paramGetFirstEnterInfoRequest) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
  {
    AppMethodBeat.i(212058);
    Log.i("MicroMsg.ChatRoomListView", "showFirstGuidance, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (GetFirstEnterInfoResponse)d.c.b(paramd.lBS);
      if ((this.Cxm != null) && (!Util.isNullOrNil(paramString.content_list)))
      {
        paramd = new SpannableStringBuilder();
        paramq = paramString.content_list.iterator();
        paramInt1 = 0;
        while (paramq.hasNext())
        {
          ContentBlock localContentBlock = (ContentBlock)paramq.next();
          if (!Util.isNullOrNil(localContentBlock.content))
          {
            paramString = localContentBlock.color;
            if (paramString == null) {
              paramString = null;
            }
            for (;;)
            {
              int i = e.aIQ(Util.nullAsNil(paramString));
              paramInt2 = i;
              if (i == -1) {
                paramInt2 = ChatRoomListView.g(this.Cxj).getResources().getColor(f.b.FG_2);
              }
              paramd.append(localContentBlock.content);
              paramd.setSpan(new ForegroundColorSpan(paramInt2), paramInt1, localContentBlock.content.length() + paramInt1, 33);
              paramInt1 = paramd.length();
              break;
              if (ar.isDarkMode()) {
                paramString = paramString.dark_color;
              } else {
                paramString = paramString.light_color;
              }
            }
          }
        }
        if (paramd.length() == 0)
        {
          AppMethodBeat.o(212058);
          return 0;
        }
        ChatRoomListView.a(this.Cxj, paramd);
      }
    }
    AppMethodBeat.o(212058);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.ChatRoomListView.4
 * JD-Core Version:    0.7.0.1
 */