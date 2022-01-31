package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;

final class RoomInfoDetailUI$2$2
  implements DialogInterface.OnClickListener
{
  RoomInfoDetailUI$2$2(RoomInfoDetailUI.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    RoomInfoDetailUI.a(this.dqg.dqf, true);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("Chat_User", RoomInfoDetailUI.b(this.dqg.dqf).field_username);
    paramDialogInterface.addFlags(67108864);
    d.e(this.dqg.dqf, ".ui.chatting.ChattingUI", paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomInfoDetailUI.2.2
 * JD-Core Version:    0.7.0.1
 */