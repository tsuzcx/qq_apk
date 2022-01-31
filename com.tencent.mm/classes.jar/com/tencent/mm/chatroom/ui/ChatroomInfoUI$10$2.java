package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

final class ChatroomInfoUI$10$2
  implements DialogInterface.OnClickListener
{
  ChatroomInfoUI$10$2(ChatroomInfoUI.10 param10, ProgressDialog paramProgressDialog) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h.nFQ.f(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(3), ChatroomInfoUI.b(this.dog.dod) });
    this.doh.show();
    ChatroomInfoUI.a(this.dog.dod, false);
    ChatroomInfoUI.a(this.dog.dod, this.doh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.10.2
 * JD-Core Version:    0.7.0.1
 */