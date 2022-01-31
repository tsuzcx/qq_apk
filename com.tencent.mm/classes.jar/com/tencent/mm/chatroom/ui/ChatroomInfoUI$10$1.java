package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.report.service.h;

final class ChatroomInfoUI$10$1
  implements DialogInterface.OnClickListener
{
  ChatroomInfoUI$10$1(ChatroomInfoUI.10 param10) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(103971);
    h.qsU.e(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(4), ChatroomInfoUI.b(this.efD.efA) });
    ChatroomInfoUI.a(this.efD.efA, true);
    if (!ChatroomInfoUI.u(this.efD.efA))
    {
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("Chat_User", ChatroomInfoUI.o(this.efD.efA).field_username);
      paramDialogInterface.addFlags(67108864);
      d.f(this.efD.efA, ".ui.chatting.ChattingUI", paramDialogInterface);
      AppMethodBeat.o(103971);
      return;
    }
    this.efD.efA.finish();
    AppMethodBeat.o(103971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.10.1
 * JD-Core Version:    0.7.0.1
 */