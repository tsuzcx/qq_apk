package com.tencent.mm.plugin.finder.search;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchFeedHeaderHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "headerTips", "", "(Landroid/view/View;Ljava/lang/String;)V", "descTv", "Landroid/widget/TextView;", "divider", "onBindView", "", "needShowDivider", "", "plugin-finder_release"})
public final class d
  extends RecyclerView.v
{
  final String Abc;
  TextView kEs;
  View mND;
  
  public d(View paramView, String paramString)
  {
    super(paramView);
    AppMethodBeat.i(278468);
    this.Abc = paramString;
    paramString = paramView.findViewById(b.f.divider_view);
    p.j(paramString, "itemView.findViewById(R.id.divider_view)");
    this.mND = paramString;
    paramView = paramView.findViewById(b.f.desc_tv);
    p.j(paramView, "itemView.findViewById(R.id.desc_tv)");
    this.kEs = ((TextView)paramView);
    AppMethodBeat.o(278468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.d
 * JD-Core Version:    0.7.0.1
 */