package com.tencent.mm.plugin.livelist;

import androidx.recyclerview.widget.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livelist/MMLiveListDiffCallback;", "T", "Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "newList", "(Ljava/util/List;Ljava/util/List;)V", "getNewList", "()Ljava/util/List;", "getOldList", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getChangePayload", "", "getNewListSize", "getOldListSize", "plugin-livelist_release"})
public final class g<T extends b>
  extends h.a
{
  private final List<T> rgi;
  private final List<T> rgj;
  
  public g(List<? extends T> paramList1, List<? extends T> paramList2)
  {
    AppMethodBeat.i(218150);
    this.rgi = paramList1;
    this.rgj = paramList2;
    AppMethodBeat.o(218150);
  }
  
  public final Object Y(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218149);
    Object localObject1 = j.M(this.rgi, paramInt1);
    Object localObject2 = j.M(this.rgj, paramInt2);
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject1 = ((b)localObject2).a((b)localObject1);
      AppMethodBeat.o(218149);
      return localObject1;
    }
    AppMethodBeat.o(218149);
    return null;
  }
  
  public final boolean Z(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218138);
    Object localObject1 = j.M(this.rgi, paramInt1);
    Object localObject2 = j.M(this.rgj, paramInt2);
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject2 = (b)localObject2;
      boolean bool = ((b)localObject1).b((b)localObject2);
      AppMethodBeat.o(218138);
      return bool;
    }
    AppMethodBeat.o(218138);
    return false;
  }
  
  public final boolean ab(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218147);
    Object localObject1 = j.M(this.rgi, paramInt1);
    Object localObject2 = j.M(this.rgj, paramInt2);
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject2 = (b)localObject2;
      boolean bool = ((b)localObject1).c((b)localObject2);
      AppMethodBeat.o(218147);
      return bool;
    }
    AppMethodBeat.o(218147);
    return false;
  }
  
  public final int jL()
  {
    AppMethodBeat.i(218142);
    int i = this.rgi.size();
    AppMethodBeat.o(218142);
    return i;
  }
  
  public final int jM()
  {
    AppMethodBeat.i(218145);
    int i = this.rgj.size();
    AppMethodBeat.o(218145);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.livelist.g
 * JD-Core Version:    0.7.0.1
 */