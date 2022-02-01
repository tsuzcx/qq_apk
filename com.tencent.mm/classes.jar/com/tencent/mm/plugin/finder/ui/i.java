package com.tencent.mm.plugin.finder.ui;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.l;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfFeedLikeListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "()V", "datalist", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "vh", "position", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "p1", "setLikedContactList", "plugin-finder_release"})
public final class i
  extends RecyclerView.a<e>
{
  public ArrayList<dzd> KZv;
  
  public final int getItemCount()
  {
    AppMethodBeat.i(199367);
    ArrayList localArrayList = this.KZv;
    if (localArrayList == null) {
      k.aPZ("datalist");
    }
    if (localArrayList == null)
    {
      AppMethodBeat.o(199367);
      return 0;
    }
    localArrayList = this.KZv;
    if (localArrayList == null) {
      k.aPZ("datalist");
    }
    int i = localArrayList.size();
    AppMethodBeat.o(199367);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.i
 * JD-Core Version:    0.7.0.1
 */