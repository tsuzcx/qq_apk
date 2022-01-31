package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bf.a;

final class ChatroomInfoUI$18
  implements bf.a
{
  ChatroomInfoUI$18(ChatroomInfoUI paramChatroomInfoUI) {}
  
  public final boolean JS()
  {
    AppMethodBeat.i(103981);
    boolean bool = ChatroomInfoUI.w(this.efA);
    AppMethodBeat.o(103981);
    return bool;
  }
  
  public final void JT()
  {
    AppMethodBeat.i(103982);
    if (ChatroomInfoUI.x(this.efA) != null) {
      ChatroomInfoUI.x(this.efA).dismiss();
    }
    AppMethodBeat.o(103982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.18
 * JD-Core Version:    0.7.0.1
 */