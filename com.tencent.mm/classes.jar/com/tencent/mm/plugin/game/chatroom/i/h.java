package com.tencent.mm.plugin.game.chatroom.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgText;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgContent;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.plugin.game.chatroom.h.g;
import com.tencent.mm.plugin.game.chatroom.h.h;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class h
  extends k
{
  private MMNeat7extView DQt;
  
  public h(View paramView, int paramInt)
  {
    super(paramView, paramInt);
  }
  
  protected final View K(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(275930);
    paramViewGroup = LayoutInflater.from(this.mContext).inflate(h.f.IhW, null);
    this.DQt = ((MMNeat7extView)paramViewGroup.findViewById(h.e.IfN));
    AppMethodBeat.o(275930);
    return paramViewGroup;
  }
  
  protected final void Xi(int paramInt)
  {
    AppMethodBeat.i(275956);
    if (paramInt == 1001)
    {
      ClipboardHelper.setText(this.DQt.jPy());
      com.tencent.mm.ui.base.k.cY(this.mContext, this.mContext.getString(h.h.app_copy_ok));
    }
    AppMethodBeat.o(275956);
  }
  
  protected final void a(ChatroomMsgPack paramChatroomMsgPack)
  {
    AppMethodBeat.i(275940);
    if ((paramChatroomMsgPack == null) || (paramChatroomMsgPack.msg_content == null) || (paramChatroomMsgPack.msg_content.chatroom_text == null))
    {
      AppMethodBeat.o(275940);
      return;
    }
    this.DQt.aZ(p.b(this.mContext, paramChatroomMsgPack.msg_content.chatroom_text.content));
    AppMethodBeat.o(275940);
  }
  
  protected final void o(s params)
  {
    AppMethodBeat.i(275949);
    int i = params.aAW(9531);
    int j = params.aAW(9532);
    if (params.findItem(1001) == null)
    {
      if (i >= 0)
      {
        params.a(1001, i + 1, this.mContext.getString(h.h.app_copy), h.g.icons_filled_copy, false);
        AppMethodBeat.o(275949);
        return;
      }
      if (j >= 0)
      {
        params.a(1001, j + 1, this.mContext.getString(h.h.app_copy), h.g.icons_filled_copy, false);
        AppMethodBeat.o(275949);
        return;
      }
      params.a(1001, 0, this.mContext.getString(h.h.app_copy), h.g.icons_filled_copy, false);
    }
    AppMethodBeat.o(275949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.i.h
 * JD-Core Version:    0.7.0.1
 */