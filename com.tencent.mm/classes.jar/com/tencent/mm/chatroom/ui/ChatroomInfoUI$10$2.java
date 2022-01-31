package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class ChatroomInfoUI$10$2
  implements DialogInterface.OnClickListener
{
  ChatroomInfoUI$10$2(ChatroomInfoUI.10 param10, ProgressDialog paramProgressDialog) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(103972);
    h.qsU.e(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(3), ChatroomInfoUI.b(this.efD.efA) });
    this.efE.show();
    ChatroomInfoUI.a(this.efD.efA, false);
    ChatroomInfoUI.a(this.efD.efA, this.efE);
    AppMethodBeat.o(103972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.10.2
 * JD-Core Version:    0.7.0.1
 */