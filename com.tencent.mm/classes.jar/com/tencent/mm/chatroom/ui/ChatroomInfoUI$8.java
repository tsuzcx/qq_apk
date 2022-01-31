package com.tencent.mm.chatroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;

final class ChatroomInfoUI$8
  implements h.b
{
  ChatroomInfoUI$8(ChatroomInfoUI paramChatroomInfoUI, String paramString) {}
  
  public final boolean onFinish(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(103969);
    if (paramCharSequence == null) {}
    for (paramCharSequence = "";; paramCharSequence = paramCharSequence.toString())
    {
      String str = b.MZ();
      if ((bo.isNullOrNil(str)) || (!paramCharSequence.matches(".*[" + str + "].*"))) {
        break;
      }
      h.bO(this.efA.getContext(), this.efA.getString(2131300749, new Object[] { str }));
      AppMethodBeat.o(103969);
      return false;
    }
    if ((paramCharSequence != null) && (!paramCharSequence.equals(this.efB))) {
      ChatroomInfoUI.a(this.efA, paramCharSequence);
    }
    AppMethodBeat.o(103969);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.8
 * JD-Core Version:    0.7.0.1
 */