package com.tencent.mm.plugin.finder.ui;

import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$HeaderViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
public final class FinderPostAtUI$c
  extends RecyclerView.w
{
  TextView titleTv;
  
  public FinderPostAtUI$c(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(203251);
    paramView = localObject.findViewById(2131305948);
    k.g(paramView, "itemView.findViewById(R.id.title_tv)");
    this.titleTv = ((TextView)paramView);
    AppMethodBeat.o(203251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostAtUI.c
 * JD-Core Version:    0.7.0.1
 */