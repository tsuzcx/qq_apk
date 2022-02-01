package com.tencent.mm.plugin.finder.search;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchSafetyHintHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "divider", "safetyText", "Landroid/widget/TextView;", "onBindView", "", "safetyHint", "", "plugin-finder_release"})
public final class e
  extends RecyclerView.v
{
  TextView Abs;
  private View mND;
  
  public e(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(265776);
    View localView = paramView.findViewById(b.f.divider_view);
    p.j(localView, "itemView.findViewById(R.id.divider_view)");
    this.mND = localView;
    paramView = paramView.findViewById(b.f.finder_feed_search_safety_text);
    p.j(paramView, "itemView.findViewById(R.…_feed_search_safety_text)");
    this.Abs = ((TextView)paramView);
    AppMethodBeat.o(265776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.e
 * JD-Core Version:    0.7.0.1
 */