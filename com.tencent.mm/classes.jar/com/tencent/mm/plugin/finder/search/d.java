package com.tencent.mm.plugin.finder.search;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchFeedHeaderHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "divider", "onBindView", "", "needShowDivider", "", "plugin-finder_release"})
public final class d
  extends RecyclerView.v
{
  private View jWr;
  
  public d(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(166802);
    paramView = paramView.findViewById(2131299715);
    p.g(paramView, "itemView.findViewById(R.id.divider_view)");
    this.jWr = paramView;
    AppMethodBeat.o(166802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.d
 * JD-Core Version:    0.7.0.1
 */