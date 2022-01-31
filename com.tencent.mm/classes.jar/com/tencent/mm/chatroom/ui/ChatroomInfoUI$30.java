package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChatroomInfoUI$30
  implements DialogInterface.OnClickListener
{
  ChatroomInfoUI$30(ChatroomInfoUI paramChatroomInfoUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(103995);
    paramDialogInterface = this.efA;
    ChatroomInfoUI localChatroomInfoUI = this.efA;
    ChatroomInfoUI.b(this.efA);
    ChatroomInfoUI.a(paramDialogInterface, localChatroomInfoUI);
    AppMethodBeat.o(103995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.30
 * JD-Core Version:    0.7.0.1
 */