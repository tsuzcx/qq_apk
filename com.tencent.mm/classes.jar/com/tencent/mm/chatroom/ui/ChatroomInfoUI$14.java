package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bd;

final class ChatroomInfoUI$14
  implements DialogInterface.OnClickListener
{
  ChatroomInfoUI$14(ChatroomInfoUI paramChatroomInfoUI, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(103977);
    if ((ChatroomInfoUI.b(this.efA) == null) || (ChatroomInfoUI.b(this.efA).length() <= 0))
    {
      ab.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : invalid args");
      AppMethodBeat.o(103977);
      return;
    }
    if (this.efF)
    {
      paramDialogInterface = new tl();
      paramDialogInterface.cJT.cJW = true;
      com.tencent.mm.sdk.b.a.ymk.l(paramDialogInterface);
    }
    if (!((j)g.E(j.class)).YA().ary(ChatroomInfoUI.b(this.efA)))
    {
      ab.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : room[" + ChatroomInfoUI.b(this.efA) + "] is not exist");
      AppMethodBeat.o(103977);
      return;
    }
    ChatroomInfoUI.v(this.efA);
    ((com.tencent.mm.plugin.multitalk.model.a)g.E(com.tencent.mm.plugin.multitalk.model.a.class)).Uh(ChatroomInfoUI.b(this.efA));
    AppMethodBeat.o(103977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.14
 * JD-Core Version:    0.7.0.1
 */