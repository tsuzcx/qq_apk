package com.tencent.mm.plugin.finder.ui;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.l;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfFeedLikeListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "()V", "datalist", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "vh", "position", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "p1", "setLikedContactList", "plugin-finder_release"})
public final class h
  extends RecyclerView.a<e>
{
  public ArrayList<alo> rLa;
  
  public final int getItemCount()
  {
    AppMethodBeat.i(203338);
    ArrayList localArrayList = this.rLa;
    if (localArrayList == null) {
      k.aVY("datalist");
    }
    if (localArrayList == null)
    {
      AppMethodBeat.o(203338);
      return 0;
    }
    localArrayList = this.rLa;
    if (localArrayList == null) {
      k.aVY("datalist");
    }
    int i = localArrayList.size();
    AppMethodBeat.o(203338);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.h
 * JD-Core Version:    0.7.0.1
 */