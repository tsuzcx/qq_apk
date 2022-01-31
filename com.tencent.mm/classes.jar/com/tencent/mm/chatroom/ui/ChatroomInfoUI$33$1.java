package com.tencent.mm.chatroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

final class ChatroomInfoUI$33$1
  implements Runnable
{
  ChatroomInfoUI$33$1(ChatroomInfoUI.33 param33, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(103999);
    if (ChatroomInfoUI.e(this.efS.efA) <= 1)
    {
      ChatroomInfoUI.f(this.efS.efA).cl("del_selector_btn", true);
      ChatroomInfoUI.m(this.efS.efA).pf(true).pg(false).dnI();
    }
    for (;;)
    {
      ChatroomInfoUI.m(this.efS.efA).v(ChatroomInfoUI.b(this.efS.efA), this.efR);
      AppMethodBeat.o(103999);
      return;
      ChatroomInfoUI.m(this.efS.efA).pf(true).pg(ChatroomInfoUI.d(this.efS.efA)).dnI();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.33.1
 * JD-Core Version:    0.7.0.1
 */