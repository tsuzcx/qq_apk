package com.tencent.mm.plugin.game.chatroom.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.plugin.game.chatroom.h.h;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class j
  extends k
{
  private MMNeat7extView DQt;
  
  public j(View paramView, int paramInt)
  {
    super(paramView, paramInt);
  }
  
  protected final View K(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(275932);
    paramViewGroup = LayoutInflater.from(this.mContext).inflate(h.f.IhW, null);
    this.DQt = ((MMNeat7extView)paramViewGroup.findViewById(h.e.IfN));
    AppMethodBeat.o(275932);
    return paramViewGroup;
  }
  
  protected final void a(ChatroomMsgPack paramChatroomMsgPack)
  {
    AppMethodBeat.i(275939);
    this.DQt.aZ(this.mContext.getString(h.h.IiH));
    AppMethodBeat.o(275939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.i.j
 * JD-Core Version:    0.7.0.1
 */