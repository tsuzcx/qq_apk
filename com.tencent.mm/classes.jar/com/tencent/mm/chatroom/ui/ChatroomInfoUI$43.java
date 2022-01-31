package com.tencent.mm.chatroom.ui;

import android.view.View;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.s;

final class ChatroomInfoUI$43
  implements Runnable
{
  ChatroomInfoUI$43(ChatroomInfoUI paramChatroomInfoUI, int paramInt) {}
  
  public final void run()
  {
    View localView = ((com.tencent.mm.ui.base.preference.a)ChatroomInfoUI.f(this.dod)).a(this.doB, this.dod.lwE);
    if (localView != null) {
      com.tencent.mm.ui.g.a.a(this.dod.mController.uMN, localView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.43
 * JD-Core Version:    0.7.0.1
 */