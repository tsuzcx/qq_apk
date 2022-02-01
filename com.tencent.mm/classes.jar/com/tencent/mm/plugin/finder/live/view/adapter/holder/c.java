package com.tencent.mm.plugin.finder.live.view.adapter.holder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.ui.widget.MMProcessBar;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingLoadingMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "loading", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "kotlin.jvm.PlatformType", "getLoading", "()Lcom/tencent/mm/ui/widget/MMProcessBar;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends RecyclerView.v
{
  public final MMProcessBar DUp;
  
  public c(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(359134);
    this.DUp = ((MMProcessBar)paramView.findViewById(p.e.loading_progress));
    this.DUp.oH(p.g.finder_live_icon_location_loading, -16777216);
    AppMethodBeat.o(359134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.holder.c
 * JD-Core Version:    0.7.0.1
 */