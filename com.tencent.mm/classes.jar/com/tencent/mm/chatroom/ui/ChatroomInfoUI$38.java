package com.tencent.mm.chatroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChatroomInfoUI$38
  implements Runnable
{
  ChatroomInfoUI$38(ChatroomInfoUI paramChatroomInfoUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(104007);
    ChatroomInfoUI.c(this.efA, "room_notify_new_msg");
    ChatroomInfoUI.B(this.efA);
    AppMethodBeat.o(104007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.38
 * JD-Core Version:    0.7.0.1
 */