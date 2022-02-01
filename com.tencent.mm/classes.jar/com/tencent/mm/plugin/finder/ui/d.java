package com.tencent.mm.plugin.finder.ui;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfFeedLikeListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "()V", "datalist", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "vh", "position", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "p1", "setLikedContactList", "plugin-finder_release"})
public final class d
  extends RecyclerView.a<e>
{
  public ArrayList<apg> sRa;
  
  public final int getItemCount()
  {
    AppMethodBeat.i(204736);
    ArrayList localArrayList = this.sRa;
    if (localArrayList == null) {
      p.bdF("datalist");
    }
    if (localArrayList == null)
    {
      AppMethodBeat.o(204736);
      return 0;
    }
    localArrayList = this.sRa;
    if (localArrayList == null) {
      p.bdF("datalist");
    }
    int i = localArrayList.size();
    AppMethodBeat.o(204736);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.d
 * JD-Core Version:    0.7.0.1
 */