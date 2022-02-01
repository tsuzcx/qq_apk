package com.tencent.mm.plugin.finder.ui;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aul;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfFeedLikeListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "()V", "datalist", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "vh", "position", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "p1", "setLikedContactList", "plugin-finder_release"})
public final class h
  extends RecyclerView.a<com.tencent.mm.view.recyclerview.h>
{
  public ArrayList<aul> vNT;
  
  public final int getItemCount()
  {
    AppMethodBeat.i(252655);
    ArrayList localArrayList = this.vNT;
    if (localArrayList == null) {
      p.btv("datalist");
    }
    if (localArrayList == null)
    {
      AppMethodBeat.o(252655);
      return 0;
    }
    localArrayList = this.vNT;
    if (localArrayList == null) {
      p.btv("datalist");
    }
    int i = localArrayList.size();
    AppMethodBeat.o(252655);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.h
 * JD-Core Version:    0.7.0.1
 */