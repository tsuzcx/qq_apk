package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class ChatroomInfoUI$17
  implements DialogInterface.OnClickListener
{
  ChatroomInfoUI$17(ChatroomInfoUI paramChatroomInfoUI, ProgressDialog paramProgressDialog) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(103980);
    h.qsU.e(14553, new Object[] { Integer.valueOf(4), Integer.valueOf(3), ChatroomInfoUI.b(this.efA) });
    this.efE.show();
    ChatroomInfoUI.a(this.efA, false);
    ChatroomInfoUI.b(this.efA, this.efG);
    AppMethodBeat.o(103980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.17
 * JD-Core Version:    0.7.0.1
 */