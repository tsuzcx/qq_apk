package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.report.service.h;

final class ChatroomInfoUI$16
  implements DialogInterface.OnClickListener
{
  ChatroomInfoUI$16(ChatroomInfoUI paramChatroomInfoUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h.nFQ.f(14553, new Object[] { Integer.valueOf(4), Integer.valueOf(4), ChatroomInfoUI.b(this.dod) });
    ChatroomInfoUI.a(this.dod, true);
    if (!ChatroomInfoUI.u(this.dod))
    {
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("Chat_User", ChatroomInfoUI.o(this.dod).field_username);
      paramDialogInterface.addFlags(67108864);
      d.e(this.dod, ".ui.chatting.ChattingUI", paramDialogInterface);
      return;
    }
    this.dod.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.16
 * JD-Core Version:    0.7.0.1
 */