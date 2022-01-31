package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.report.service.h;

final class ChatroomInfoUI$10$1
  implements DialogInterface.OnClickListener
{
  ChatroomInfoUI$10$1(ChatroomInfoUI.10 param10) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h.nFQ.f(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(4), ChatroomInfoUI.b(this.dog.dod) });
    ChatroomInfoUI.a(this.dog.dod, true);
    if (!ChatroomInfoUI.u(this.dog.dod))
    {
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("Chat_User", ChatroomInfoUI.o(this.dog.dod).field_username);
      paramDialogInterface.addFlags(67108864);
      d.e(this.dog.dod, ".ui.chatting.ChattingUI", paramDialogInterface);
      return;
    }
    this.dog.dod.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.10.1
 * JD-Core Version:    0.7.0.1
 */