package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileUIHeaderViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bindHeader", "", "header", "plugin-finder_release"})
public final class x
  extends RecyclerView.v
{
  public x(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(165491);
    AppMethodBeat.o(165491);
  }
  
  public final void dS(View paramView)
  {
    AppMethodBeat.i(165490);
    k.h(paramView, "header");
    Object localObject = this.arI;
    if (localObject == null)
    {
      paramView = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(165490);
      throw paramView;
    }
    localObject = (ViewGroup)localObject;
    if (((ViewGroup)localObject).getChildCount() == 0)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent != null)
      {
        if (localViewParent == null)
        {
          paramView = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(165490);
          throw paramView;
        }
        ((ViewGroup)localViewParent).removeAllViews();
      }
      ((ViewGroup)localObject).addView(paramView);
    }
    AppMethodBeat.o(165490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.x
 * JD-Core Version:    0.7.0.1
 */