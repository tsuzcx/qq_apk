package com.tencent.mm.plugin.game.chatroom.view;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class GameChatListView$3
  implements Runnable
{
  public GameChatListView$3(GameChatListView paramGameChatListView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(210717);
    View localView = GameChatListView.g(this.CyQ).findViewByPosition(this.CyR);
    if (localView != null)
    {
      int i = this.CyQ.getMeasuredHeight();
      int j = localView.getMeasuredHeight();
      GameChatListView.g(this.CyQ).au(this.CyR, i - j);
    }
    AppMethodBeat.o(210717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.GameChatListView.3
 * JD-Core Version:    0.7.0.1
 */