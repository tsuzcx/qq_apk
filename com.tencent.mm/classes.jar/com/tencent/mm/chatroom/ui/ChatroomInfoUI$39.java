package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.f;

final class ChatroomInfoUI$39
  implements am.a
{
  int doy = 0;
  
  ChatroomInfoUI$39(ChatroomInfoUI paramChatroomInfoUI, String paramString) {}
  
  public final boolean tC()
  {
    if (ChatroomInfoUI.f(this.dod) == null) {}
    while (this.doy > 50) {
      return false;
    }
    int j = ChatroomInfoUI.f(this.dod).adf(this.doz);
    View localView = this.dod.lwE.getChildAt(j - this.dod.lwE.getFirstVisiblePosition());
    if (localView != null) {}
    for (int i = localView.getHeight();; i = 0)
    {
      if (i == 0)
      {
        this.doy += 1;
        return true;
      }
      y.d("MicroMsg.ChatroomInfoUI", "show cover view get y[%f] height [%d] index[%d] [%d %d]", new Object[] { Float.valueOf(localView.getY()), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.dod.lwE.getFirstVisiblePosition()), Integer.valueOf(this.dod.lwE.getLastVisiblePosition()) });
      int m = (int)localView.getY();
      int k = i;
      j = m;
      if (m < 0)
      {
        k = i + m;
        j = 0;
      }
      ChatroomInfoUI.a(this.dod, j, k);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.39
 * JD-Core Version:    0.7.0.1
 */