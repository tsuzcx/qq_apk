package com.tencent.mm.plugin.game.chatroom.view;

import androidx.recyclerview.widget.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class ChatMemberListView$b$1
  implements s
{
  public ChatMemberListView$b$1(ChatMemberListView.b paramb) {}
  
  public final void W(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211780);
    Log.d("GameChatRoom.ChatMemberListView", "onInserted, position:%d, count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.CwN.aG(paramInt1, paramInt2);
    AppMethodBeat.o(211780);
  }
  
  public final void ac(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211781);
    Log.d("GameChatRoom.ChatMemberListView", "onRemoved, position:%d, count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.CwN.aH(paramInt1, paramInt2);
    AppMethodBeat.o(211781);
  }
  
  public final void ad(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211782);
    Log.d("GameChatRoom.ChatMemberListView", "onMoved, fromPosition:%d, toPosition:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.CwN.aF(paramInt1, paramInt2);
    AppMethodBeat.o(211782);
  }
  
  public final void c(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(211783);
    Log.d("GameChatRoom.ChatMemberListView", "onChanged, position:%d, count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.CwN.aE(paramInt1, paramInt2);
    AppMethodBeat.o(211783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.ChatMemberListView.b.1
 * JD-Core Version:    0.7.0.1
 */