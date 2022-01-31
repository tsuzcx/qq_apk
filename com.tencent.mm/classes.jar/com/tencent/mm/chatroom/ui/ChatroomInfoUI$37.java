package com.tencent.mm.chatroom.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.u;

final class ChatroomInfoUI$37
  implements Runnable
{
  ChatroomInfoUI$37(ChatroomInfoUI paramChatroomInfoUI) {}
  
  public final void run()
  {
    ChatroomInfoUI.a(this.dod, ((c)g.r(c.class)).FF().in(ChatroomInfoUI.b(this.dod)));
    if (ChatroomInfoUI.c(this.dod) == null)
    {
      y.e("MicroMsg.ChatroomInfoUI", "member is null");
      return;
    }
    if (bk.bl(ChatroomInfoUI.c(this.dod).field_roomowner))
    {
      y.e("MicroMsg.ChatroomInfoUI", "roomowner is null");
      return;
    }
    ChatroomInfoUI.A(this.dod).sendEmptyMessage(0);
    ChatroomInfoUI.c(this.dod, ChatroomInfoUI.c(this.dod).field_roomowner.equals(q.Gj()));
    ChatroomInfoUI.d(this.dod, ChatroomInfoUI.c(this.dod).aaM(q.Gj()));
    ChatroomInfoUI.m(this.dod).WI(ChatroomInfoUI.c(this.dod).field_roomowner);
  }
  
  public final String toString()
  {
    return super.toString() + "|onNotifyChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.37
 * JD-Core Version:    0.7.0.1
 */