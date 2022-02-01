package com.tencent.mm.plugin.finder.search;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchContactHeaderHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "headerTips", "", "(Landroid/view/View;Ljava/lang/String;)V", "descTv", "Landroid/widget/TextView;", "moreArrow", "moreTV", "onBindView", "", "needShowMore", "", "moreClickListener", "Landroid/view/View$OnClickListener;", "plugin-finder_release"})
public final class b
  extends RecyclerView.v
{
  TextView Aba;
  View Abb;
  final String Abc;
  TextView kEs;
  
  public b(View paramView, String paramString)
  {
    super(paramView);
    AppMethodBeat.i(264506);
    this.Abc = paramString;
    paramString = paramView.findViewById(b.f.more_tv);
    p.j(paramString, "itemView.findViewById(R.id.more_tv)");
    this.Aba = ((TextView)paramString);
    paramString = paramView.findViewById(b.f.more_arrow);
    p.j(paramString, "itemView.findViewById(R.id.more_arrow)");
    this.Abb = paramString;
    paramView = paramView.findViewById(b.f.desc_tv);
    p.j(paramView, "itemView.findViewById(R.id.desc_tv)");
    this.kEs = ((TextView)paramView);
    AppMethodBeat.o(264506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.b
 * JD-Core Version:    0.7.0.1
 */