package com.tencent.mm.chatroom.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitalk.a.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h.c;

final class ChatroomInfoUI$13
  implements h.c
{
  ChatroomInfoUI$13(ChatroomInfoUI paramChatroomInfoUI) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      y.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click cancel]");
      return;
    }
    y.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click room_owner_delete_direct]");
    ChatroomInfoUI.v(this.dod);
    ((a)g.r(a.class)).Is(ChatroomInfoUI.b(this.dod));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.13
 * JD-Core Version:    0.7.0.1
 */