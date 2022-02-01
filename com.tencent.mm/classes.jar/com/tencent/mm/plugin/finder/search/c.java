package com.tencent.mm.plugin.finder.search;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchContactHeaderHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "headerTips", "", "(Landroid/view/View;Ljava/lang/String;)V", "descTv", "Landroid/widget/TextView;", "moreArrow", "moreTV", "onBindView", "", "needShowMore", "", "moreClickListener", "Landroid/view/View$OnClickListener;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends RecyclerView.v
{
  final String FwI;
  TextView FwJ;
  View FwK;
  TextView descTv;
  
  public c(View paramView, String paramString)
  {
    super(paramView);
    AppMethodBeat.i(342727);
    this.FwI = paramString;
    paramString = paramView.findViewById(e.e.more_tv);
    s.s(paramString, "itemView.findViewById(R.id.more_tv)");
    this.FwJ = ((TextView)paramString);
    paramString = paramView.findViewById(e.e.more_arrow);
    s.s(paramString, "itemView.findViewById(R.id.more_arrow)");
    this.FwK = paramString;
    paramView = paramView.findViewById(e.e.desc_tv);
    s.s(paramView, "itemView.findViewById(R.id.desc_tv)");
    this.descTv = ((TextView)paramView);
    AppMethodBeat.o(342727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.c
 * JD-Core Version:    0.7.0.1
 */