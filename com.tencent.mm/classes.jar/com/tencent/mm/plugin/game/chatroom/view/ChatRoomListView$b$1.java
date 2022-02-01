package com.tencent.mm.plugin.game.chatroom.view;

import androidx.recyclerview.widget.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class ChatRoomListView$b$1
  implements s
{
  ChatRoomListView$b$1(ChatRoomListView.b paramb) {}
  
  public final void W(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210878);
    Log.d("MicroMsg.ChatRoomListView", "onInserted");
    this.Cxq.aG(paramInt1, paramInt2);
    AppMethodBeat.o(210878);
  }
  
  public final void ac(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210880);
    Log.d("MicroMsg.ChatRoomListView", "onRemoved");
    this.Cxq.aH(paramInt1, paramInt2);
    AppMethodBeat.o(210880);
  }
  
  public final void ad(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210881);
    Log.d("MicroMsg.ChatRoomListView", "onMoved, fromPosition:%d, toPosition:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.Cxq.aF(paramInt1, paramInt2);
    AppMethodBeat.o(210881);
  }
  
  public final void c(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(210882);
    this.Cxq.aE(paramInt1, paramInt2);
    AppMethodBeat.o(210882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.ChatRoomListView.b.1
 * JD-Core Version:    0.7.0.1
 */