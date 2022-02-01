package com.tencent.mm.chatroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.sdk.platformtools.aq;

final class ChatroomInfoUI$20
  implements as.b.a
{
  ChatroomInfoUI$20(ChatroomInfoUI paramChatroomInfoUI) {}
  
  public final void p(final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(12534);
    if ((paramBoolean) && (ChatroomInfoUI.b(this.fNj).equals(paramString))) {
      g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(12532);
          ((c)g.ab(c.class)).azz().y(paramString, System.currentTimeMillis());
          AppMethodBeat.o(12532);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(12533);
          String str = super.toString() + "|getContactCallBack";
          AppMethodBeat.o(12533);
          return str;
        }
      });
    }
    AppMethodBeat.o(12534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.20
 * JD-Core Version:    0.7.0.1
 */