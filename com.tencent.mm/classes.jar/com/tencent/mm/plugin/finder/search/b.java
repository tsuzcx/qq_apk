package com.tencent.mm.plugin.finder.search;

import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchContactHeaderHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "moreArrow", "moreTV", "Landroid/widget/TextView;", "onBindView", "", "needShowMore", "", "moreClickListener", "Landroid/view/View$OnClickListener;", "plugin-finder_release"})
public final class b
  extends RecyclerView.w
{
  TextView rAS;
  View rAT;
  
  public b(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(166798);
    View localView = paramView.findViewById(2131302483);
    k.g(localView, "itemView.findViewById(R.id.more_tv)");
    this.rAS = ((TextView)localView);
    paramView = paramView.findViewById(2131302455);
    k.g(paramView, "itemView.findViewById(R.id.more_arrow)");
    this.rAT = paramView;
    AppMethodBeat.o(166798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.b
 * JD-Core Version:    0.7.0.1
 */