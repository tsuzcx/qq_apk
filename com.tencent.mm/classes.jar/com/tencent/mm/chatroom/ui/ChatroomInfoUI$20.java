package com.tencent.mm.chatroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

final class ChatroomInfoUI$20
  implements ay.b.a
{
  ChatroomInfoUI$20(ChatroomInfoUI paramChatroomInfoUI) {}
  
  public final void p(final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(12534);
    if ((paramBoolean) && (ChatroomInfoUI.b(this.guB).equals(paramString))) {
      g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(12532);
          ((c)g.af(c.class)).aSX().z(paramString, System.currentTimeMillis());
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