package com.tencent.mm.chatroom.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChatroomInfoUI$43
  implements Runnable
{
  ChatroomInfoUI$43(ChatroomInfoUI paramChatroomInfoUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(104013);
    View localView = ((com.tencent.mm.ui.base.preference.a)ChatroomInfoUI.f(this.efA)).a(this.efX, this.efA.getListView());
    if (localView != null) {
      com.tencent.mm.ui.h.a.b(this.efA.getContext(), localView);
    }
    AppMethodBeat.o(104013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.43
 * JD-Core Version:    0.7.0.1
 */