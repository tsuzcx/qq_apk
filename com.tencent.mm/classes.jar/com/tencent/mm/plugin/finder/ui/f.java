package com.tencent.mm.plugin.finder.ui;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfFeedLikeListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "()V", "datalist", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "vh", "position", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "p1", "setLikedContactList", "plugin-finder_release"})
public final class f
  extends RecyclerView.a<i>
{
  public ArrayList<awr> AuL;
  
  public final int getItemCount()
  {
    AppMethodBeat.i(277330);
    ArrayList localArrayList = this.AuL;
    if (localArrayList == null) {
      p.bGy("datalist");
    }
    if (localArrayList == null)
    {
      AppMethodBeat.o(277330);
      return 0;
    }
    localArrayList = this.AuL;
    if (localArrayList == null) {
      p.bGy("datalist");
    }
    int i = localArrayList.size();
    AppMethodBeat.o(277330);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.f
 * JD-Core Version:    0.7.0.1
 */