package com.tencent.mm.chatroom.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class ChatroomInfoUI$1
  extends ak
{
  ChatroomInfoUI$1(ChatroomInfoUI paramChatroomInfoUI, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(103962);
    ChatroomInfoUI.a(this.efA);
    AppMethodBeat.o(103962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.1
 * JD-Core Version:    0.7.0.1
 */