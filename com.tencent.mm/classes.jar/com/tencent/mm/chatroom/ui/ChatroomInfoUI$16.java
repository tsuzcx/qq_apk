package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.report.service.h;

final class ChatroomInfoUI$16
  implements DialogInterface.OnClickListener
{
  ChatroomInfoUI$16(ChatroomInfoUI paramChatroomInfoUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(103979);
    h.qsU.e(14553, new Object[] { Integer.valueOf(4), Integer.valueOf(4), ChatroomInfoUI.b(this.efA) });
    ChatroomInfoUI.a(this.efA, true);
    if (!ChatroomInfoUI.u(this.efA))
    {
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("Chat_User", ChatroomInfoUI.o(this.efA).field_username);
      paramDialogInterface.addFlags(67108864);
      d.f(this.efA, ".ui.chatting.ChattingUI", paramDialogInterface);
      AppMethodBeat.o(103979);
      return;
    }
    this.efA.finish();
    AppMethodBeat.o(103979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.16
 * JD-Core Version:    0.7.0.1
 */