package com.tencent.mm.emoji.c.b;

import androidx.recyclerview.widget.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/emoji/model/panel/PanelGroupModel$getDiff$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad$b
  extends g.a
{
  ad$b(List<? extends ae> paramList1, List<? extends ae> paramList2) {}
  
  public final int If()
  {
    AppMethodBeat.i(105563);
    int i = this.mjl.size();
    AppMethodBeat.o(105563);
    return i;
  }
  
  public final int Ig()
  {
    AppMethodBeat.i(105564);
    int i = this.mjm.size();
    AppMethodBeat.o(105564);
    return i;
  }
  
  public final boolean aU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105565);
    boolean bool = s.p(this.mjl.get(paramInt1), this.mjm.get(paramInt2));
    AppMethodBeat.o(105565);
    return bool;
  }
  
  public final boolean aV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105566);
    boolean bool = ((ae)this.mjl.get(paramInt1)).cv(this.mjm.get(paramInt2));
    AppMethodBeat.o(105566);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.ad.b
 * JD-Core Version:    0.7.0.1
 */