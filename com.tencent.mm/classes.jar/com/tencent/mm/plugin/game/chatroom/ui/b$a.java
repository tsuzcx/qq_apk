package com.tencent.mm.plugin.game.chatroom.ui;

import androidx.recyclerview.widget.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.chatroom.d.c;
import com.tencent.mm.plugin.game.chatroom.d.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/ui/MentionUserAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/tencent/mm/plugin/game/chatroom/data/MentionUserWrapper;", "newList", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
final class b$a
  extends g.a
{
  private final List<c> uoj;
  private final List<c> uok;
  
  public b$a(List<c> paramList1, List<c> paramList2)
  {
    AppMethodBeat.i(276002);
    this.uoj = paramList1;
    this.uok = paramList2;
    AppMethodBeat.o(276002);
  }
  
  public final int If()
  {
    AppMethodBeat.i(276008);
    int i = this.uoj.size();
    AppMethodBeat.o(276008);
    return i;
  }
  
  public final int Ig()
  {
    AppMethodBeat.i(276012);
    int i = this.uok.size();
    AppMethodBeat.o(276012);
    return i;
  }
  
  public final boolean aU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(276018);
    boolean bool = s.p(((c)this.uoj.get(paramInt1)).Ikl.id, ((c)this.uok.get(paramInt2)).Ikl.id);
    AppMethodBeat.o(276018);
    return bool;
  }
  
  public final boolean aV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(276027);
    c localc1 = (c)this.uoj.get(paramInt1);
    c localc2 = (c)this.uok.get(paramInt2);
    if ((localc1.FYI == localc2.FYI) && (s.p(localc1.Ikk, localc2.Ikk)) && (s.p(localc1.Ikl.nickName, localc2.Ikl.nickName)) && (s.p(localc1.Ikl.avatar, localc2.Ikl.avatar)) && (localc1.mkb == localc2.mkb))
    {
      AppMethodBeat.o(276027);
      return true;
    }
    AppMethodBeat.o(276027);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.ui.b.a
 * JD-Core Version:    0.7.0.1
 */