package com.tencent.mm.chatroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.chatroom.a.b;

final class ChatroomInfoUI$11$1
  implements Runnable
{
  ChatroomInfoUI$11$1(ChatroomInfoUI.11 param11, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(241692);
    ((b)h.ax(b.class)).bzK().A(this.lzC, System.currentTimeMillis());
    AppMethodBeat.o(241692);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(241697);
    String str = super.toString() + "|getContactCallBack";
    AppMethodBeat.o(241697);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.11.1
 * JD-Core Version:    0.7.0.1
 */