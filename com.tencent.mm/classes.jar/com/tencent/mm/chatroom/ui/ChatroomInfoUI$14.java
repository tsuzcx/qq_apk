package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.a.ru;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;

final class ChatroomInfoUI$14
  implements DialogInterface.OnClickListener
{
  ChatroomInfoUI$14(ChatroomInfoUI paramChatroomInfoUI, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((ChatroomInfoUI.b(this.dod) == null) || (ChatroomInfoUI.b(this.dod).length() <= 0))
    {
      y.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : invalid args");
      return;
    }
    if (this.doi)
    {
      paramDialogInterface = new ru();
      paramDialogInterface.cbq.cbt = true;
      com.tencent.mm.sdk.b.a.udP.m(paramDialogInterface);
    }
    if (!((j)g.r(j.class)).Fw().abn(ChatroomInfoUI.b(this.dod)))
    {
      y.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : room[" + ChatroomInfoUI.b(this.dod) + "] is not exist");
      return;
    }
    ChatroomInfoUI.v(this.dod);
    ((com.tencent.mm.plugin.multitalk.a.a)g.r(com.tencent.mm.plugin.multitalk.a.a.class)).Is(ChatroomInfoUI.b(this.dod));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.14
 * JD-Core Version:    0.7.0.1
 */