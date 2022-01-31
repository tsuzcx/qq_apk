package com.tencent.mm.chatroom.ui;

import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

final class ChatroomInfoUI$33$1
  implements Runnable
{
  ChatroomInfoUI$33$1(ChatroomInfoUI.33 param33, List paramList) {}
  
  public final void run()
  {
    if (ChatroomInfoUI.e(this.dov.dod) <= 1)
    {
      ChatroomInfoUI.f(this.dov.dod).bJ("del_selector_btn", true);
      ChatroomInfoUI.m(this.dov.dod).lS(true).lT(false).cmQ();
    }
    for (;;)
    {
      ChatroomInfoUI.m(this.dov.dod).s(ChatroomInfoUI.b(this.dov.dod), this.dou);
      return;
      ChatroomInfoUI.m(this.dov.dod).lS(true).lT(ChatroomInfoUI.d(this.dov.dod)).cmQ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.33.1
 * JD-Core Version:    0.7.0.1
 */