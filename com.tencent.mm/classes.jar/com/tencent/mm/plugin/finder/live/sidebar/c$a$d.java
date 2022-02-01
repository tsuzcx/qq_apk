package com.tencent.mm.plugin.finder.live.sidebar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar$FinderLiveSideBarConfig$buildSideBar$3", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$a$d
  extends RecyclerView.h
{
  c$a$d(c paramc) {}
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(351998);
    s.u(paramRect, "outRect");
    s.u(paramView, "view");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    paramRecyclerView = this.DGz.etB().by(paramView);
    int j = (int)paramView.getContext().getResources().getDimension(p.c.Edge_1_5_A) - a.fromDPToPix(paramView.getContext(), 2);
    if ((paramRecyclerView != null) && (paramRecyclerView.KJ() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramRect.left = j;
      paramRect.right = j;
      paramRect.bottom = 0;
      paramRect.top = 0;
      AppMethodBeat.o(351998);
      return;
    }
    paramRect.left = j;
    paramRect.right = j;
    paramRect.bottom = 0;
    paramRect.top = j;
    AppMethodBeat.o(351998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.sidebar.c.a.d
 * JD-Core Version:    0.7.0.1
 */