package com.tencent.mm.chatroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitalk.model.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h.c;

final class ChatroomInfoUI$13
  implements h.c
{
  ChatroomInfoUI$13(ChatroomInfoUI paramChatroomInfoUI) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(103976);
    switch (paramInt)
    {
    default: 
      ab.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click cancel]");
      AppMethodBeat.o(103976);
      return;
    }
    ab.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click room_owner_delete_direct]");
    ChatroomInfoUI.v(this.efA);
    ((a)g.E(a.class)).Uh(ChatroomInfoUI.b(this.efA));
    AppMethodBeat.o(103976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.13
 * JD-Core Version:    0.7.0.1
 */