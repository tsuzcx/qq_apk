package com.tencent.mm.chatroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.chatroom.a.c;

final class ChatroomInfoUI$22$1
  implements Runnable
{
  ChatroomInfoUI$22$1(ChatroomInfoUI.22 param22, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(103986);
    ((c)g.E(c.class)).YJ().u(this.efI, System.currentTimeMillis());
    AppMethodBeat.o(103986);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(103987);
    String str = super.toString() + "|getContactCallBack";
    AppMethodBeat.o(103987);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.22.1
 * JD-Core Version:    0.7.0.1
 */