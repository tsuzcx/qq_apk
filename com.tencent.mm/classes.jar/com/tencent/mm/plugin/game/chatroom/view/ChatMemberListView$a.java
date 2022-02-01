package com.tencent.mm.plugin.game.chatroom.view;

import androidx.recyclerview.widget.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomUserData;
import com.tencent.mm.plugin.game.autogen.chatroom.OnlineUser;
import com.tencent.mm.plugin.game.autogen.chatroom.Slot;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class ChatMemberListView$a
  extends h.a
{
  private List<Slot> rgi;
  private List<Slot> rgj;
  
  public ChatMemberListView$a(List<Slot> paramList1, List<Slot> paramList2)
  {
    this.rgi = paramList2;
    Object localObject;
    this.rgj = localObject;
  }
  
  public final boolean Z(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211817);
    Object localObject2 = (Slot)this.rgi.get(paramInt1);
    Object localObject1 = (Slot)this.rgj.get(paramInt2);
    if ((((Slot)localObject2).online_user_status == null) || (Util.isNullOrNil(((Slot)localObject2).online_user_status.chat_user_data)) || (((Slot)localObject1).online_user_status == null) || (Util.isNullOrNil(((Slot)localObject1).online_user_status.chat_user_data)))
    {
      AppMethodBeat.o(211817);
      return false;
    }
    localObject2 = (ChatroomUserData)((Slot)localObject2).online_user_status.chat_user_data.get(0);
    localObject1 = (ChatroomUserData)((Slot)localObject1).online_user_status.chat_user_data.get(0);
    if (Util.nullAsNil(((ChatroomUserData)localObject2).nickname).equals(((ChatroomUserData)localObject1).username))
    {
      AppMethodBeat.o(211817);
      return true;
    }
    AppMethodBeat.o(211817);
    return false;
  }
  
  public final boolean ab(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211818);
    Slot localSlot1 = (Slot)this.rgi.get(paramInt1);
    Slot localSlot2 = (Slot)this.rgj.get(paramInt2);
    if ((localSlot1.online_user_status == null) || (localSlot2.online_user_status == null))
    {
      AppMethodBeat.o(211818);
      return false;
    }
    if ((localSlot1.slot_type == localSlot2.slot_type) && (localSlot1.online_user_status.status == localSlot2.online_user_status.status))
    {
      AppMethodBeat.o(211818);
      return true;
    }
    AppMethodBeat.o(211818);
    return false;
  }
  
  public final int jL()
  {
    AppMethodBeat.i(211815);
    int i = this.rgi.size();
    AppMethodBeat.o(211815);
    return i;
  }
  
  public final int jM()
  {
    AppMethodBeat.i(211816);
    int i = this.rgj.size();
    AppMethodBeat.o(211816);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.ChatMemberListView.a
 * JD-Core Version:    0.7.0.1
 */