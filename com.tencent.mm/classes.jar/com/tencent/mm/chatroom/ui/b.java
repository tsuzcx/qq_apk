package com.tencent.mm.chatroom.ui;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/chatroom/ui/RoomFollowMemberAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/chatroom/ui/RoomFollowMemberViewHolder;", "memberList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/storage/Contact;", "member", "Lcom/tencent/mm/storage/ChatRoomMember;", "listener", "Lcom/tencent/mm/chatroom/ui/RoomFollowMemberViewHolder$IFollowMemberCallback;", "(Ljava/util/ArrayList;Lcom/tencent/mm/storage/ChatRoomMember;Lcom/tencent/mm/chatroom/ui/RoomFollowMemberViewHolder$IFollowMemberCallback;)V", "getListener", "()Lcom/tencent/mm/chatroom/ui/RoomFollowMemberViewHolder$IFollowMemberCallback;", "getMember", "()Lcom/tencent/mm/storage/ChatRoomMember;", "setMember", "(Lcom/tencent/mm/storage/ChatRoomMember;)V", "getMemberList", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "p1", "Companion", "ui-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.a<c>
{
  public static final b.a lKM;
  private final ArrayList<au> lKN;
  private final c.a lKO;
  private aj lzy;
  
  static
  {
    AppMethodBeat.i(241624);
    lKM = new b.a((byte)0);
    AppMethodBeat.o(241624);
  }
  
  public b(ArrayList<au> paramArrayList, aj paramaj, c.a parama)
  {
    AppMethodBeat.i(241623);
    this.lKN = paramArrayList;
    this.lzy = paramaj;
    this.lKO = parama;
    AppMethodBeat.o(241623);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(241627);
    int i = this.lKN.size();
    AppMethodBeat.o(241627);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.b
 * JD-Core Version:    0.7.0.1
 */