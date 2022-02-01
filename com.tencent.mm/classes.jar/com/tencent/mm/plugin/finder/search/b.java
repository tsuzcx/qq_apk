package com.tencent.mm.plugin.finder.search;

import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchContactHeaderHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "moreArrow", "moreTV", "Landroid/widget/TextView;", "onBindView", "", "needShowMore", "", "moreClickListener", "Landroid/view/View$OnClickListener;", "plugin-finder_release"})
public final class b
  extends RecyclerView.w
{
  TextView sDp;
  View sDq;
  
  public b(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(166798);
    View localView = paramView.findViewById(2131302483);
    p.g(localView, "itemView.findViewById(R.id.more_tv)");
    this.sDp = ((TextView)localView);
    paramView = paramView.findViewById(2131302455);
    p.g(paramView, "itemView.findViewById(R.id.more_arrow)");
    this.sDq = paramView;
    AppMethodBeat.o(166798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.b
 * JD-Core Version:    0.7.0.1
 */