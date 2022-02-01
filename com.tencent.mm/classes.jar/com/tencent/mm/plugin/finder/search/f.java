package com.tencent.mm.plugin.finder.search;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchSafetyHintHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "divider", "safetyText", "Landroid/widget/TextView;", "onBindView", "", "safetyHint", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends RecyclerView.v
{
  TextView Fxh;
  private View pKl;
  
  public f(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(342737);
    View localView = paramView.findViewById(e.e.divider_view);
    s.s(localView, "itemView.findViewById(R.id.divider_view)");
    this.pKl = localView;
    paramView = paramView.findViewById(e.e.finder_feed_search_safety_text);
    s.s(paramView, "itemView.findViewById(R.…_feed_search_safety_text)");
    this.Fxh = ((TextView)paramView);
    AppMethodBeat.o(342737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.f
 * JD-Core Version:    0.7.0.1
 */