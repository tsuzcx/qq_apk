package com.tencent.mm.chatroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class DelChatroomMemberUI$2$1
  implements Runnable
{
  DelChatroomMemberUI$2$1(DelChatroomMemberUI.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(104084);
    if (DelChatroomMemberUI.a(this.egk.egi).getCount() == 0) {
      this.egk.egi.finish();
    }
    AppMethodBeat.o(104084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DelChatroomMemberUI.2.1
 * JD-Core Version:    0.7.0.1
 */