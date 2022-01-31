package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.p;

final class ChatroomInfoUI$10
  implements DialogInterface.OnClickListener
{
  ChatroomInfoUI$10(ChatroomInfoUI paramChatroomInfoUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(2), ChatroomInfoUI.b(this.dod) });
    ChatroomInfoUI.bk(false);
    paramDialogInterface = this.dod;
    this.dod.getString(a.i.app_tip);
    p localp = com.tencent.mm.ui.base.h.b(paramDialogInterface, this.dod.getString(a.i.app_waiting), true, new ChatroomInfoUI.a());
    if (!ChatroomInfoUI.xx()) {}
    for (paramDialogInterface = e.Xe(ChatroomInfoUI.o(this.dod).field_username);; paramDialogInterface = null)
    {
      if (!bk.bl(paramDialogInterface))
      {
        localp.dismiss();
        com.tencent.mm.ui.base.h.a(this.dod, false, this.dod.getString(a.i.wallet_clear_chatting_history_note, new Object[] { paramDialogInterface }), null, this.dod.getString(a.i.goto_conversation), this.dod.getString(a.i.clear_chat_history), new ChatroomInfoUI.10.1(this), new ChatroomInfoUI.10.2(this, localp), -1, a.b.alert_btn_color_warn);
        return;
      }
      ChatroomInfoUI.a(this.dod, localp);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.10
 * JD-Core Version:    0.7.0.1
 */