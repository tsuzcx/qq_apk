package com.tencent.mm.plugin.game.chatroom.ui;

import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.chatroom.k.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/ui/MentionUserAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/game/chatroom/ui/MentionUserViewHolder;", "chatroomName", "", "ssid", "", "sourceId", "(Ljava/lang/String;JJ)V", "datas", "", "Lcom/tencent/mm/plugin/game/chatroom/data/MentionUserWrapper;", "listener", "Lcom/tencent/mm/plugin/game/chatroom/ui/MentionUserAdapter$OnItemClickListener;", "reportUserMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "reportExpose", "wrapper", "setData", "list", "", "setOnItemClickListener", "updateByDiff", "DiffCallback", "OnItemClickListener", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.a<c>
{
  private final long InY;
  b InZ;
  private final HashMap<String, Boolean> Ioa;
  private final String chatroomName;
  final List<com.tencent.mm.plugin.game.chatroom.d.c> lMl;
  private final long ssid;
  
  public b(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(276010);
    this.chatroomName = paramString;
    this.ssid = paramLong1;
    this.InY = paramLong2;
    this.lMl = ((List)new ArrayList());
    this.Ioa = new HashMap();
    AppMethodBeat.o(276010);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(276014);
    int i = this.lMl.size();
    AppMethodBeat.o(276014);
    return i;
  }
  
  public final void setData(List<com.tencent.mm.plugin.game.chatroom.d.c> paramList)
  {
    AppMethodBeat.i(276021);
    s.u(paramList, "list");
    a locala = a.Iod;
    paramList = a.ik(paramList);
    this.lMl.clear();
    this.lMl.addAll((Collection)paramList);
    this.Ioa.clear();
    this.bZE.notifyChanged();
    AppMethodBeat.o(276021);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/ui/MentionUserAdapter$OnItemClickListener;", "", "onItemClick", "", "userName", "", "nickName", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void iS(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.ui.b
 * JD-Core Version:    0.7.0.1
 */