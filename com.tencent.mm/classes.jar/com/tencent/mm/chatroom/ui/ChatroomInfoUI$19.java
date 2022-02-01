package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.roomsdk.a.c.a;

final class ChatroomInfoUI$19
  implements DialogInterface.OnCancelListener
{
  ChatroomInfoUI$19(ChatroomInfoUI paramChatroomInfoUI, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(194083);
    this.guI.cancel();
    AppMethodBeat.o(194083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.19
 * JD-Core Version:    0.7.0.1
 */