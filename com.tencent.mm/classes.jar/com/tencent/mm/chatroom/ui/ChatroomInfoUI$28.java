package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.roomsdk.a.b.c;
import java.util.ArrayList;
import java.util.List;

final class ChatroomInfoUI$28
  implements DialogInterface.OnClickListener
{
  ChatroomInfoUI$28(ChatroomInfoUI paramChatroomInfoUI, c paramc, List paramList1, List paramList2, List paramList3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(103994);
    if (t.nJ(ChatroomInfoUI.b(this.efA))) {
      ChatroomInfoUI.a(this.efA, this.efM.chatroomName, this.efN);
    }
    paramDialogInterface = new ArrayList();
    paramDialogInterface.addAll(this.efO);
    paramDialogInterface.addAll(this.efP);
    ChatroomInfoUI.a(this.efA, paramDialogInterface);
    AppMethodBeat.o(103994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.28
 * JD-Core Version:    0.7.0.1
 */