package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.roomsdk.a.c.a;

final class ChatroomInfoUI$27
  implements DialogInterface.OnCancelListener
{
  ChatroomInfoUI$27(ChatroomInfoUI paramChatroomInfoUI, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(103993);
    this.efL.cancel();
    AppMethodBeat.o(103993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.27
 * JD-Core Version:    0.7.0.1
 */