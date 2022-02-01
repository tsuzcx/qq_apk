package com.tencent.mm.plugin.finder.ui;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfFeedLikeListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "()V", "datalist", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "vh", "position", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "p1", "setLikedContactList", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends RecyclerView.a<j>
{
  public ArrayList<bco> FTR;
  
  public final int getItemCount()
  {
    AppMethodBeat.i(346535);
    if (this.FTR == null) {
      s.bIx("datalist");
    }
    ArrayList localArrayList2 = this.FTR;
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      s.bIx("datalist");
      localArrayList1 = null;
    }
    int i = localArrayList1.size();
    AppMethodBeat.o(346535);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.g
 * JD-Core Version:    0.7.0.1
 */