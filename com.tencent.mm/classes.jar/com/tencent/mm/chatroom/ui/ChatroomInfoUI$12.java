package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bf.a;

final class ChatroomInfoUI$12
  implements bf.a
{
  ChatroomInfoUI$12(ChatroomInfoUI paramChatroomInfoUI, ProgressDialog paramProgressDialog) {}
  
  public final boolean JS()
  {
    AppMethodBeat.i(103974);
    boolean bool = ChatroomInfoUI.JQ();
    AppMethodBeat.o(103974);
    return bool;
  }
  
  public final void JT()
  {
    AppMethodBeat.i(103975);
    if (this.efE != null) {
      this.efE.dismiss();
    }
    AppMethodBeat.o(103975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.12
 * JD-Core Version:    0.7.0.1
 */