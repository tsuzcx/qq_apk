package com.tencent.mm.chatroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.u;

final class ChatroomInfoUI$37
  implements Runnable
{
  ChatroomInfoUI$37(ChatroomInfoUI paramChatroomInfoUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(104005);
    ChatroomInfoUI.a(this.efA, ((c)g.E(c.class)).YJ().oU(ChatroomInfoUI.b(this.efA)));
    if (ChatroomInfoUI.c(this.efA) == null)
    {
      ab.e("MicroMsg.ChatroomInfoUI", "member is null");
      AppMethodBeat.o(104005);
      return;
    }
    if (bo.isNullOrNil(ChatroomInfoUI.c(this.efA).field_roomowner))
    {
      ab.e("MicroMsg.ChatroomInfoUI", "roomowner is null");
      AppMethodBeat.o(104005);
      return;
    }
    ChatroomInfoUI.A(this.efA).sendEmptyMessage(0);
    ChatroomInfoUI.c(this.efA, ChatroomInfoUI.c(this.efA).field_roomowner.equals(r.Zn()));
    ChatroomInfoUI.d(this.efA, ChatroomInfoUI.c(this.efA).aqW(r.Zn()));
    ChatroomInfoUI.m(this.efA).amp(ChatroomInfoUI.c(this.efA).field_roomowner);
    AppMethodBeat.o(104005);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(104006);
    String str = super.toString() + "|onNotifyChange";
    AppMethodBeat.o(104006);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.37
 * JD-Core Version:    0.7.0.1
 */