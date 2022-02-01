package com.tencent.mm.plugin.finder.search;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchFeedHeaderHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "headerTips", "", "(Landroid/view/View;Ljava/lang/String;)V", "descTv", "Landroid/widget/TextView;", "divider", "onBindView", "", "needShowDivider", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends RecyclerView.v
{
  final String FwI;
  TextView descTv;
  View pKl;
  
  public e(View paramView, String paramString)
  {
    super(paramView);
    AppMethodBeat.i(342725);
    this.FwI = paramString;
    paramString = paramView.findViewById(e.e.divider_view);
    s.s(paramString, "itemView.findViewById(R.id.divider_view)");
    this.pKl = paramString;
    paramView = paramView.findViewById(e.e.desc_tv);
    s.s(paramView, "itemView.findViewById(R.id.desc_tv)");
    this.descTv = ((TextView)paramView);
    AppMethodBeat.o(342725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.e
 * JD-Core Version:    0.7.0.1
 */