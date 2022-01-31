package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.base.preference.f;

final class ChatroomInfoUI$39
  implements ap.a
{
  int efV = 0;
  
  ChatroomInfoUI$39(ChatroomInfoUI paramChatroomInfoUI, String paramString) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(104008);
    if (ChatroomInfoUI.f(this.efA) == null)
    {
      AppMethodBeat.o(104008);
      return false;
    }
    if (this.efV > 50)
    {
      AppMethodBeat.o(104008);
      return false;
    }
    int j = ChatroomInfoUI.f(this.efA).atz(this.val$key);
    View localView = this.efA.getListView().getChildAt(j - this.efA.getListView().getFirstVisiblePosition());
    if (localView != null) {}
    for (int i = localView.getHeight();; i = 0)
    {
      if (i == 0)
      {
        this.efV += 1;
        AppMethodBeat.o(104008);
        return true;
      }
      ab.d("MicroMsg.ChatroomInfoUI", "show cover view get y[%f] height [%d] index[%d] [%d %d]", new Object[] { Float.valueOf(localView.getY()), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.efA.getListView().getFirstVisiblePosition()), Integer.valueOf(this.efA.getListView().getLastVisiblePosition()) });
      int m = (int)localView.getY();
      int k = i;
      j = m;
      if (m < 0)
      {
        k = i + m;
        j = 0;
      }
      ChatroomInfoUI.a(this.efA, j, k);
      AppMethodBeat.o(104008);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.39
 * JD-Core Version:    0.7.0.1
 */