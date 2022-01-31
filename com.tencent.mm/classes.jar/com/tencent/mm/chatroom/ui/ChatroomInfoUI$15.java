package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChatroomInfoUI$15
  implements DialogInterface.OnCancelListener
{
  ChatroomInfoUI$15(ChatroomInfoUI paramChatroomInfoUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(103978);
    ChatroomInfoUI.a(this.efA, true);
    AppMethodBeat.o(103978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.15
 * JD-Core Version:    0.7.0.1
 */